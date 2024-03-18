/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.swp391_onlinelearning.baseController;

import com.fpt.swp391_onlinelearning.dal.AccountDAO;
import com.fpt.swp391_onlinelearning.dto.AccountDTO;
import com.fpt.swp391_onlinelearning.service.AccountService;
import com.fpt.swp391_onlinelearning.service.iservice.IAccountService;
import com.fpt.swp391_onlinelearning.service.iservice.IService;
import com.fpt.swp391_onlinelearning.util.CookieUtils;
import com.fpt.swp391_onlinelearning.util.SessionUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * @author tran Hoang Phuc
 */
public abstract class BaseRequiredAuthenticationController extends HttpServlet {

    private IAccountService _iAccountService;
    //private IService _iService;


    public boolean isRequiredAuthenticated(HttpServletRequest req) {
        _iAccountService = AccountService.getInstance(new AccountDAO(), new AccountDAO());
      //  _iService = AccountService.getInstance(new AccountDAO(), new AccountDAO());

        AccountDTO account = (AccountDTO) req.getSession().getAttribute("session");
        if (account != null) {
            return true;
        } else {
            String email = null;
            String password = null;
            Cookie[] cookies = req.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (email != null && password != null) {
                        break;
                    }
                    if ("username".equals(cookie.getName())) {
                        email = cookie.getValue();
                    } else if ("password".equals(cookie.getName())) {
                        password = cookie.getValue();
                    }
                }
                if (email != null && password != null) {
                    return _iAccountService.getLogin(email, password) != null;
                }
            }
        }
        return false;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (isRequiredAuthenticated(req)) {
            doGet(req, resp, (AccountDTO) req.getSession().getAttribute("session"));
        } else {
            resp.sendRedirect(req.getContextPath() + "/login");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (isRequiredAuthenticated(req)) {
            doPost(req, resp, (AccountDTO) req.getSession().getAttribute("session"));
        } else {
            resp.sendRedirect(req.getContextPath() + "/login");
        }
    }

    protected abstract void doGet(HttpServletRequest request, HttpServletResponse response, AccountDTO user)
            throws ServletException, IOException;

    protected abstract void doPost(HttpServletRequest request, HttpServletResponse response, AccountDTO user)
            throws ServletException, IOException;

}
