/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.fpt.swp391_onlinelearning.controller;

import com.fpt.swp391_onlinelearning.baseController.BaseRequiredVerifyController;
import com.fpt.swp391_onlinelearning.dal.AccountDAO;
import com.fpt.swp391_onlinelearning.dal.UserDAO;
import com.fpt.swp391_onlinelearning.dto.AccountDTO;
import com.fpt.swp391_onlinelearning.dto.UserDTO;
import com.fpt.swp391_onlinelearning.service.AccountService;
import com.fpt.swp391_onlinelearning.service.UserService;
import com.fpt.swp391_onlinelearning.service.iservice.IAccountService;
import com.fpt.swp391_onlinelearning.service.iservice.IUserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
/**
 *
 * @author phuc2
 */

public class ChangePasswordController extends BaseRequiredVerifyController {

    private static IAccountService iaccountService;
    private static IUserService iuserService;
    
    public void init() throws ServletException
    {
        iaccountService= AccountService.getInstance(new AccountDAO(), new AccountDAO());
        iuserService= UserService.getInstace(new UserDAO(), new UserDAO());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response, AccountDTO user, boolean isActivated) throws ServletException, IOException {       
        //pass: 123
        UserDTO userDTO= iuserService.getUserByAccountId(user.getAccId());
        request.setAttribute("user", userDTO);
        request.getRequestDispatcher("view/changePassword.jsp").forward(request, response);    

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response, AccountDTO user, boolean isActivated) throws ServletException, IOException {
        String oldPassword= request.getParameter("oldPassword");
        String newPassword= request.getParameter("newPassword");
        String confirmedPassword= request.getParameter("confirmedPassword");
        String passwordState= iaccountService.enterPasswordState(oldPassword, newPassword, confirmedPassword, user.getAccId());
        
        UserDTO userDTO= iuserService.getUserByAccountId(user.getAccId());
        request.setAttribute("user", userDTO);    
        //response.getWriter().print(adto.getEmail());
        request.setAttribute("message", passwordState);
        request.getRequestDispatcher("view/changePassword.jsp").forward(request, response);
    }
    

    
}
