/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.swp391_onlinelearning.controller;

import com.fpt.swp391_onlinelearning.dal.AccountDAO;
import com.fpt.swp391_onlinelearning.dal.UserDAO;
import com.fpt.swp391_onlinelearning.dto.AccountDTO;
import com.fpt.swp391_onlinelearning.dto.UserDTO;
import com.fpt.swp391_onlinelearning.service.AccountService;
import com.fpt.swp391_onlinelearning.service.UserService;
import com.fpt.swp391_onlinelearning.service.iservice.IAccountService;
import com.fpt.swp391_onlinelearning.service.iservice.IService;
import com.fpt.swp391_onlinelearning.util.GenerateUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

/**
 *
 * @author Admin
 */
public class RegisterController extends HttpServlet {

    private IAccountService _iUserAccountService;
    private IService<AccountDTO> _iGenericAccountService;
    private IService<UserDTO> _iGenericUserService;

    @Override
    public void init() throws ServletException {
        _iUserAccountService = AccountService.getInstance(new AccountDAO(), new AccountDAO());
        _iGenericAccountService = AccountService.getInstance(new AccountDAO(), new AccountDAO());
        _iGenericUserService = UserService.getInstace(new UserDAO(), new UserDAO());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AccountDTO a = (AccountDTO) req.getSession().getAttribute("session");
        if (a != null) {
            resp.sendRedirect("view/home.jsp");
        } else {
            req.getRequestDispatcher("view/register.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("fullName");
        String email = req.getParameter("email");
        boolean gender = req.getParameter("gender").equals("male");
        Date dob = Date.valueOf(req.getParameter("dob"));
        String phone = req.getParameter("mobile");

        AccountDTO accDTO = new AccountDTO();
        accDTO.setEmail(email);
        accDTO.setOtp(GenerateUtil.generateOTP());
        boolean addStatus = _iGenericAccountService.insert(accDTO);
        if (addStatus) {
            UserDTO userDTO = new UserDTO();
            userDTO.setName(name);
            accDTO.setAccId(_iUserAccountService.getByEmail(email).getAccId());
            userDTO.setAccount(accDTO);
            userDTO.setGender(gender);
            userDTO.setPhone(phone);
            userDTO.setDob(dob);
            _iGenericUserService.insert(userDTO);
            if (_iUserAccountService.sendEmail(email)) {
                req.setAttribute("send", true);
            } else {
                req.setAttribute("send", false);
            }
            req.setAttribute("id", _iUserAccountService.getByEmail(email).getAccId());
            req.getRequestDispatcher("view/sendingEmailStatus.jsp").forward(req, resp);
        } else {
            req.setAttribute("error", "Account was registered");
            req.getRequestDispatcher("view/register.jsp").forward(req, resp);
        }
    }

}
