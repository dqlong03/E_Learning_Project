/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.swp391_onlinelearning.controller;

import com.fpt.swp391_onlinelearning.baseController.BaseRequiredAuthorizationController;
import com.fpt.swp391_onlinelearning.dal.CourseDAO;
import com.fpt.swp391_onlinelearning.dal.CourseRegistrationDAO;
import com.fpt.swp391_onlinelearning.dal.TransactionDAO;
import com.fpt.swp391_onlinelearning.dal.UserDAO;
import com.fpt.swp391_onlinelearning.dal.UserLessonDAO;
import com.fpt.swp391_onlinelearning.dal.LessonDAO;
import com.fpt.swp391_onlinelearning.dto.AccountDTO;
import com.fpt.swp391_onlinelearning.dto.CourseDTO;
import com.fpt.swp391_onlinelearning.dto.CourseRegistrationDTO;
import com.fpt.swp391_onlinelearning.dto.FeatureDTO;
import com.fpt.swp391_onlinelearning.dto.UserDTO;
import com.fpt.swp391_onlinelearning.service.CourseRegistrationService;
import com.fpt.swp391_onlinelearning.service.CourseService;
import com.fpt.swp391_onlinelearning.service.PaymentService;
import com.fpt.swp391_onlinelearning.service.UserService;
import com.fpt.swp391_onlinelearning.service.iservice.ICourseRegistrationService;
import com.fpt.swp391_onlinelearning.service.iservice.IPaymentService;
import com.fpt.swp391_onlinelearning.service.iservice.IService;
import com.fpt.swp391_onlinelearning.service.iservice.IUserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
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
    private ICourseRegistrationService _iRegisterationService;

    @Override
    public void init() throws ServletException {
        _iCourseService = CourseService.getInstance(new CourseDAO(), new CourseDAO());
        _iPaymentService = PaymentService.getInstance(new UserDAO(), new CourseRegistrationDAO(), new TransactionDAO(), new UserLessonDAO(), new LessonDAO());
        _iUserService = UserService.getInstace(new UserDAO(), new UserDAO());
        _iRegisterationService = CourseRegistrationService.getInstance(new CourseRegistrationDAO(), new CourseRegistrationDAO(), new LessonDAO(), new UserLessonDAO());
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
            List<String> courseIds = new ArrayList<>();
            courseIds.add(String.valueOf(courseId));
            _iRegisterationService.sendEmail(user.getEmail(), "Enrollment added successfully", courseIds);
            resp.sendRedirect(req.getContextPath() + "/coursecontent?courseId=" + courseId);
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
                resp.sendRedirect(req.getContextPath() + "/coursecontent?courseId=" + courseId);
            } else {
                req.getSession().setAttribute("courseId", courseId);
                resp.sendRedirect(decision);
            }
        } else {
            resp.sendRedirect(req.getContextPath() + "/coursecontent?courseId=" + courseId);
        }

    }

    private boolean isRegisterd(int userId, int courseId) {
        List<CourseRegistrationDTO> registered = _iRegisterationService.getRegisterdCourse(userId);
        for (CourseRegistrationDTO courseRegisterationDTO : registered) {
            if (courseRegisterationDTO.getCourse().getCourseId() == courseId) {
                return true;
            }
        }
        return false;
    }
}
