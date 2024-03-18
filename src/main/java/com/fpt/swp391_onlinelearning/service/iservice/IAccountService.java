/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.fpt.swp391_onlinelearning.service.iservice;

import com.fpt.swp391_onlinelearning.dto.AccountDTO;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author tran Hoang Phuc
 */
public interface IAccountService {

    public AccountDTO getLogin(String email, String password);

    public void saveToCookie(HttpServletResponse resp, String email, String password, String remember);

    public boolean sendEmail(String email);

    public boolean verifyLink(int id, String otp);

    public void updateStatus(int id, int status);

    public void updatePassword(int id, String password);

    public void updateOtp(int id);

    public boolean verifyAccount(String email);

    public AccountDTO getByEmail(String email);

    public String enterPasswordState(String oldPassword, String newPassword, String confirmedPassword, int accId);
    
    public AccountDTO getAccount(int id, String pass);
    
    public void updatePassword(AccountDTO adto, String newPassword);
}
