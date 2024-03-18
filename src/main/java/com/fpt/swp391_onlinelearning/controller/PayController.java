/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.swp391_onlinelearning.controller;

import com.fpt.swp391_onlinelearning.baseController.BaseRequiredAuthorizationController;
import com.fpt.swp391_onlinelearning.dal.CourseDAO;
import com.fpt.swp391_onlinelearning.dal.CourseRegisterationDAO;
import com.fpt.swp391_onlinelearning.dal.TransactionDAO;
import com.fpt.swp391_onlinelearning.dal.UserDAO;
import com.fpt.swp391_onlinelearning.dto.AccountDTO;
import com.fpt.swp391_onlinelearning.dto.CourseDTO;
import com.fpt.swp391_onlinelearning.dto.CourseRegisterationDTO;
import com.fpt.swp391_onlinelearning.dto.FeatureDTO;
import com.fpt.swp391_onlinelearning.dto.UserDTO;
import com.fpt.swp391_onlinelearning.service.CourseRegisterationService;
import com.fpt.swp391_onlinelearning.service.CourseService;
import com.fpt.swp391_onlinelearning.service.PaymentService;
import com.fpt.swp391_onlinelearning.service.UserService;
import com.fpt.swp391_onlinelearning.service.iservice.ICourseRegisterationService;
import com.fpt.swp391_onlinelearning.service.iservice.IPaymentService;
import com.fpt.swp391_onlinelearning.service.iservice.IService;
import com.fpt.swp391_onlinelearning.service.iservice.IUserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Set;

/**
 *
 * @author tran Hoang Phuc
 */
public class PayController extends BaseRequiredAuthorizationController {

    private IService<CourseDTO> _iCourseService;
    private IPaymentService _iPaymentService;
    private IUserService _iUserService;
    private ICourseRegisterationService _iRegisterationService;

    @Override
    public void init() throws ServletException {
        _iCourseService = CourseService.getInstance(new CourseDAO(), new CourseDAO());
        _iPaymentService = PaymentService.getInstance(new UserDAO(), new CourseRegisterationDAO(), new TransactionDAO());
        _iUserService = UserService.getInstace(new UserDAO(), new UserDAO());
        _iRegisterationService = CourseRegisterationService.getInstance(new CourseRegisterationDAO());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp, AccountDTO user, boolean isActivated, Set<FeatureDTO> features) throws ServletException, IOException {

        int courseId = Integer.parseInt(req.getParameter("courseId"));
        UserDTO userDto = _iUserService.getUserByAccountId(user.getAccId());
        CourseDTO course = _iCourseService.get(courseId);
        if (!isRegisterd(userDto.getUserId(), courseId)) {
            req.setAttribute("course", course);
            req.setAttribute("user", userDto);
            req.getRequestDispatcher("view/payment.jsp").forward(req, resp);
        } else {
            resp.getWriter().print("Registered");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp, AccountDTO user, boolean isActivated, Set<FeatureDTO> features) throws ServletException, IOException {
        int courseId = Integer.parseInt(req.getParameter("courseId"));
        long amount = Long.parseLong(req.getParameter("amount"));
        CourseDTO course = _iCourseService.get(courseId);
        String decision = _iPaymentService.payForCourse(req, amount, user, course);
        UserDTO userDto = _iUserService.getUserByAccountId(user.getAccId());
        if (!isRegisterd(userDto.getUserId(), courseId)) {
            if (decision.equals("true")) {
                _iPaymentService.pay(amount, course, userDto);
                resp.getWriter().print("Registered");
            } else {
                req.getSession().setAttribute("courseId", courseId);
                resp.sendRedirect(decision);
            }
        } else {
            resp.getWriter().print("Registered");
        }

    }

    private boolean isRegisterd(int userId, int courseId) {
        List<CourseRegisterationDTO> registered = _iRegisterationService.getRegisterdCourse(userId);
        for (CourseRegisterationDTO courseRegisterationDTO : registered) {
            if (courseRegisterationDTO.getCourse().getCourseId() == courseId) {
                return true;
            }
        }
        return false;
    }
}
