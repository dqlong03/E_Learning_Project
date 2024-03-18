/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.swp391_onlinelearning.controller;

import com.fpt.swp391_onlinelearning.baseController.BaseRequiredVerifyController;
import com.fpt.swp391_onlinelearning.dto.AccountDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * @author Admin
 */
public class LogoutController extends BaseRequiredVerifyController {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response, AccountDTO user, boolean isActivated) throws ServletException, IOException {
        request.getSession().setAttribute("session", null);
        request.getSession().setAttribute("user", null);
        request.getSession().invalidate();
        response.sendRedirect(request.getContextPath() + "/home");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response, AccountDTO user, boolean isActivated) throws ServletException, IOException {
        request.getSession().setAttribute("session", null);
        request.getSession().setAttribute("user", null);
        request.getSession().invalidate();
        response.sendRedirect(request.getContextPath() + "/home");
    }

}
