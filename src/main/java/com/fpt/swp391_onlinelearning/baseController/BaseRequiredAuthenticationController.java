/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.swp391_onlinelearning.baseController;

import com.fpt.swp391_onlinelearning.dal.AccountDAO;
import com.fpt.swp391_onlinelearning.dal.CourseDAO;
import com.fpt.swp391_onlinelearning.dal.CourseRegistrationDAO;
import com.fpt.swp391_onlinelearning.dal.TempEnrollmentDAO;
import com.fpt.swp391_onlinelearning.dal.UserDAO;
import com.fpt.swp391_onlinelearning.dto.AccountDTO;
import com.fpt.swp391_onlinelearning.dto.CourseDTO;
import com.fpt.swp391_onlinelearning.dto.UserDTO;
import com.fpt.swp391_onlinelearning.service.AccountService;
import com.fpt.swp391_onlinelearning.service.CourseService;
import com.fpt.swp391_onlinelearning.service.TempEnrollmentService;
import com.fpt.swp391_onlinelearning.service.UserService;
import com.fpt.swp391_onlinelearning.service.iservice.IAccountService;
import com.fpt.swp391_onlinelearning.service.iservice.ICourseService;
import com.fpt.swp391_onlinelearning.service.iservice.ITempEnrollService;
import com.fpt.swp391_onlinelearning.service.iservice.IUserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author tran Hoang Phuc
 */
public abstract class BaseRequiredAuthenticationController extends HttpServlet {

    private IAccountService _iAccountService;
    //private IService _iService;
    private ICourseService _iCourseService;
    private IUserService _iUserService;

    public boolean isRequiredAuthenticated(HttpServletRequest req) {
        _iAccountService = AccountService.getInstance(new AccountDAO(), new AccountDAO());
        _iCourseService = CourseService.getInstance(new CourseDAO(), new CourseDAO());
        _iUserService = UserService.getInstace(new UserDAO(), new UserDAO());

        AccountDTO account = (AccountDTO) req.getSession().getAttribute("session");
        if (account != null) {
            UserDTO udto = _iUserService.getUserByAccountId(account.getAccId());
            List<CourseDTO> dtos = _iCourseService.getTempCourseEnrollmemt(udto.getUserId());
            if (!dtos.isEmpty()) {
                req.getSession().setAttribute("dtos", dtos);
            } else {
                req.getSession().setAttribute("dtos", null);
            }
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
                    UserDTO udto = _iUserService.getUserByAccountId(account.getAccId());
                    List<CourseDTO> dtos = _iCourseService.getTempCourseEnrollmemt(udto.getUserId());
                    if (!dtos.isEmpty()) {
                        req.getSession().setAttribute("dtos", dtos);
                    } else {
                        req.getSession().setAttribute("dtos", null);
                    }
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
