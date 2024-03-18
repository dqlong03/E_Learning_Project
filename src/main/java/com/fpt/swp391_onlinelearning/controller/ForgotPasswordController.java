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
public class ForgotPasswordController extends HttpServlet {

    private IAccountService _iUserAccountService;
    private IService<AccountDTO> __iGenericAccountService;

    @Override
    public void init() throws ServletException {
        _iUserAccountService = AccountService.getInstance(new AccountDAO(), new AccountDAO());
        __iGenericAccountService = AccountService.getInstance(new AccountDAO(), new AccountDAO());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AccountDTO a = (AccountDTO) req.getSession().getAttribute("session");
        if (a != null) {
            resp.sendRedirect("view/home.jsp");
        } else {
            req.getRequestDispatcher("view/forgotPassword.jsp").forward(req, resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        AccountDTO acc = _iUserAccountService.getByEmail(email);
        if (!_iUserAccountService.verifyAccount(email)) {
            if (acc == null) {
                req.setAttribute("error", "Account is invalid");
                req.getRequestDispatcher("view/forgotPassword.jsp").forward(req, resp);
            } else if (acc.getIsActivated() == 0) {
                req.setAttribute("check", "notActivated");
                req.setAttribute("id", acc.getAccId());
                req.getRequestDispatcher("view/verifyError.jsp").forward(req, resp);
            } else {
                resp.sendRedirect("../view/policyViolation");
            }

        } else {
            _iUserAccountService.updateStatus(acc.getAccId(), 0);
            _iUserAccountService.updateOtp(acc.getAccId());
            if (_iUserAccountService.sendEmail(email)) {
                req.setAttribute("send", true);
            } else {
                req.setAttribute("send", false);
            }
            req.setAttribute("id", acc.getAccId());
            req.getRequestDispatcher("view/sendingEmailStatus.jsp").forward(req, resp);
        }

    }

}
