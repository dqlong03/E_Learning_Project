/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.swp391_onlinelearning.controller;

import com.fpt.swp391_onlinelearning.dal.AccountDAO;
import com.fpt.swp391_onlinelearning.dto.AccountDTO;
import com.fpt.swp391_onlinelearning.service.AccountService;
import com.fpt.swp391_onlinelearning.service.iservice.IAccountService;
import com.fpt.swp391_onlinelearning.service.iservice.IService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * @author Admin
 */
public class SetPasswordController extends HttpServlet {

    private IAccountService _iUserAccountService;
    private IService<AccountDTO> _iGenericAccountService;

    @Override
    public void init() throws ServletException {
        _iUserAccountService = AccountService.getInstance(new AccountDAO(), new AccountDAO());
        _iGenericAccountService = AccountService.getInstance(new AccountDAO(), new AccountDAO());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AccountDTO acc = (AccountDTO) req.getSession().getAttribute("session");
        if (acc != null) {
            resp.sendRedirect("view/home");
        } else {
            int id = Integer.parseInt(req.getParameter("id"));
            String otp = req.getParameter("otp");
            if (_iUserAccountService.verifyLink(id, otp)) {
                req.setAttribute("id", id);
                req.setAttribute("otp", otp);
                req.getRequestDispatcher("view/setPassword.jsp").forward(req, resp);
            } else {
                AccountDTO a = _iGenericAccountService.get(id);
                if (a == null) {
                    req.setAttribute("check", "idError");
                } else if (a.getIsActivated() == 1) {
                    resp.sendRedirect("login");
                } else if (a.getIsActivated() == 2) {
                    resp.sendRedirect("../view/policyViolation.jsp");
                } else if (!a.getOtp().equals(otp)) {
                    req.setAttribute("check", "errorOTP");
                } else {
                    req.setAttribute("check", "timeout");
                }
                req.setAttribute("id", id);
                req.getRequestDispatcher("view/verifyError.jsp").forward(req, resp);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String password = req.getParameter("password");
        String confrimpassword = req.getParameter("confirmPassword");
        int id = Integer.parseInt(req.getParameter("id"));
        if (!password.equals(confrimpassword)) {
            req.setAttribute("id", id);
            req.setAttribute("error", "Passwords do not match. Please try again");
            req.getRequestDispatcher("view/setPassword.jsp").forward(req, resp);
        } else {
            _iUserAccountService.updatePassword(id, password);
            _iUserAccountService.updateStatus(id, 1);
            req.getRequestDispatcher("view/setPasswordStatus.jsp").forward(req, resp);
        }
    }

}
