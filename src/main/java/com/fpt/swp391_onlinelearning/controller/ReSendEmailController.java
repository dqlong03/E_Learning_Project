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
public class ReSendEmailController extends HttpServlet {

    private IAccountService _iUserAccountService;
    private IService<AccountDTO> __iGenericAccountService;

    @Override
    public void init() throws ServletException {
        _iUserAccountService = AccountService.getInstance(new AccountDAO(), new AccountDAO());
        __iGenericAccountService = AccountService.getInstance(new AccountDAO(), new AccountDAO());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        _iUserAccountService.updateOtp(id);
        AccountDTO acc = __iGenericAccountService.get(id);
        if (_iUserAccountService.sendEmail(acc.getEmail())) {
            req.setAttribute("send", true);
        } else {
            req.setAttribute("send", false);
        }
        req.setAttribute("id", id);
        req.getRequestDispatcher("view/sendingEmailStatus.jsp").forward(req, resp);
    }
}