/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.swp391_onlinelearning.baseController;

import com.fpt.swp391_onlinelearning.dto.AccountDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * @author tran Hoang Phuc
 */
public abstract class BaseRequiredVerifyController extends BaseRequiredAuthenticationController{
    public boolean isRequiredVerified(AccountDTO accountDTO) {
        if (accountDTO.getIsActivated() == 1) {
            return true;
        }
        return false;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response, AccountDTO user) throws ServletException, IOException {
        if (isRequiredVerified(user)) {
            doGet(request, response, user, true);
        } else {
            request.setAttribute("id", user.getAccId());
            request.setAttribute("check", "notActivated");
            request.getRequestDispatcher("view/verifyError.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response, AccountDTO user) throws ServletException, IOException {
        if (isRequiredVerified(user)) {
            doPost(request, response, user, true);
        } else {
            request.setAttribute("id", user.getAccId());
            request.setAttribute("check", "notActivated");
            request.getRequestDispatcher("view/verifyError.jsp");
        }
    }
    
    protected abstract void doGet(HttpServletRequest request, HttpServletResponse response, AccountDTO user, boolean isActivated) throws ServletException, IOException;
    protected abstract void doPost(HttpServletRequest request, HttpServletResponse response, AccountDTO user, boolean isActivated) throws ServletException, IOException;
}
