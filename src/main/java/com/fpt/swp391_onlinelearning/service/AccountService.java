/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.swp391_onlinelearning.service;

import com.fpt.swp391_onlinelearning.convert.Converter;
import com.fpt.swp391_onlinelearning.dal.idal.IAccountDAO;
import com.fpt.swp391_onlinelearning.dal.idal.IDAO;
import com.fpt.swp391_onlinelearning.dto.AccountDTO;
import com.fpt.swp391_onlinelearning.model.Account;
import com.fpt.swp391_onlinelearning.service.iservice.IAccountService;
import com.fpt.swp391_onlinelearning.service.iservice.IService;
import com.fpt.swp391_onlinelearning.util.CookieUtils;
import com.fpt.swp391_onlinelearning.util.EmailUtil;
import com.fpt.swp391_onlinelearning.util.GenerateUtil;
import com.fpt.swp391_onlinelearning.util.Sha1Util;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

/**
 *
 * @author tran Hoang Phuc
 */
public class AccountService implements IService<AccountDTO>, IAccountService {

    private static AccountService accountService;
    private IAccountDAO accountDAO;
    private IDAO<Account> dao;

    public static AccountService getInstance(IAccountDAO accountDAO, IDAO<Account> dao) {
        if (accountService == null) {
            accountService = new AccountService(accountDAO, dao);
        }
        return accountService;
    }

    public AccountService(IAccountDAO accountDAO, IDAO<Account> dao) {
        this.accountDAO = accountDAO;
        this.dao = dao;
    }

    @Override
    public AccountDTO getLogin(String email, String password) {
        String encryptPassword = Sha1Util.toSHA1(password);
        Account account = accountDAO.getLogin(email, encryptPassword);
        if (account != null) {
            return Converter.toDTO(account);
        }
        return null;
    }

    @Override
    public void saveToCookie(HttpServletResponse resp, String email, String password, String remember) {
        if (remember != null) {
            CookieUtils cookieUtils = CookieUtils.getCookieUtils();
            cookieUtils.setCookieUtils("email", email, resp);
            cookieUtils.setCookieUtils("password", password, resp);
        }
    }

    @Override
    public List<AccountDTO> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public AccountDTO get(int id) {
        return Converter.toDTO(dao.get(id));
    }

    @Override
    public boolean update(AccountDTO t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean insert(AccountDTO t) {
        Account acc = Converter.toDomainRegister(t);
        acc.setOtp(GenerateUtil.generateOTP());
        return dao.insert(acc);
    }

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean sendEmail(String email) {
        EmailUtil emailUtil = EmailUtil.getMailUtils();
        String link = "http://localhost:8080/SWP391_OnlineLearning/setPassword?otp=" + accountDAO.getAccByEmail(email).getOtp() + "&id=" + accountDAO.getAccByEmail(email).getAccId();
        return emailUtil.sendMail(email, "Set password", "<a href=\" " + link + "\">Set password</a>");
    }

    @Override
    public boolean verifyLink(int id, String otp) {
        Account a = dao.get(id);
        if (a != null) {
            if (a.getIsActivated() == 1 || a.getIsActivated() == 2) {
                return false;
            } else {
                Date createdTime = a.getCreatedTime();
                Date currentTime = new Date();
                double differentTime = (double) (currentTime.getTime() - createdTime.getTime()) / (60000);
                if (differentTime > 1) {
                    return false;
                } else {
                    if (a.getOtp().equals(otp)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public void updateStatus(int id, int status) {
        accountDAO.updateStatus(id, status);
    }

    @Override
    public void updatePassword(int id, String password) {
        String passSHA1 = Sha1Util.toSHA1(password);
        accountDAO.updatePassword(id, passSHA1);
    }

    @Override
    public void updateOtp(int id) {
        String otp = GenerateUtil.generateOTP();
        accountDAO.updateOTP(id, otp);
    }

    @Override
    public boolean verifyAccount(String email) {
        Account acc = accountDAO.getAccByEmail(email);
        if (acc == null) {
            return false;
        } else {
            return !(acc.getIsActivated() == 0 || acc.getIsActivated() == 2);
        }
    }

    @Override
    public AccountDTO getByEmail(String email) {
        return Converter.toDTO(accountDAO.getAccByEmail(email));
    }

    @Override
    public String enterPasswordState(String oldPassword, String newPassword, String confirmedPassword, int accId) {
        String message;
        String hashed_pass= Sha1Util.toSHA1(oldPassword);
        if(getAccount(accId, hashed_pass)==null)
        {
            message="Old password is not corrected";
        }
        else
        {
            if(!newPassword.equals(confirmedPassword))
            {
                message="Re-enter wrong password";
            }
            else
            {
                AccountDTO adto= getAccount(accId, hashed_pass);
                String hashed_newPass= Sha1Util.toSHA1(newPassword);
                updatePassword(adto, hashed_newPass);
                message="Change password sucessfully";           
            }
        }    
        return message;
    }

    @Override
    public AccountDTO getAccount(int id, String pass) {
        Account a= dao.get(id);
        if(a.getPass().equals(pass))
        {
            return Converter.toDTO(a);
        }
        return null;
    }
    
    @Override
    public void updatePassword(AccountDTO adto, String newPassword) {
        Account a= Converter.toDomain(adto);
        accountDAO.updatePassword(a.getAccId(), newPassword);
        
    }
     @Override
    public void updateAccountById(AccountDTO a, int id) {
        Account ac = Converter.toDomain1(a);
        accountDAO.updateAccountById(ac, id);
    }

    @Override
    public boolean insertByAdmin(AccountDTO dto) {
        Account acc = Converter.toDomain2(dto);
        acc.setOtp(GenerateUtil.generateOTP());
        return accountDAO.insertByAdmin(acc);
        
    }

    @Override
    public boolean sendPasswordtoEmail(String email, String pass) {
        EmailUtil emailUtil = EmailUtil.getMailUtils();
        String emailContent = "Your password is: " + pass;
        return emailUtil.sendMail(email, "Your Password", emailContent);
    }
    
}
