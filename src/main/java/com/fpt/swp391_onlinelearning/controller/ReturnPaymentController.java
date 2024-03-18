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
import com.fpt.swp391_onlinelearning.dal.TempEnrollmentDAO;
import com.fpt.swp391_onlinelearning.dto.AccountDTO;
import com.fpt.swp391_onlinelearning.dto.CourseDTO;
import com.fpt.swp391_onlinelearning.dto.FeatureDTO;
import com.fpt.swp391_onlinelearning.dto.UserDTO;
import com.fpt.swp391_onlinelearning.service.CourseService;
import com.fpt.swp391_onlinelearning.service.PaymentService;
import com.fpt.swp391_onlinelearning.service.UserService;
import com.fpt.swp391_onlinelearning.service.iservice.IPaymentService;
import com.fpt.swp391_onlinelearning.service.iservice.IService;
import com.fpt.swp391_onlinelearning.service.iservice.IUserService;
import com.fpt.swp391_onlinelearning.util.DatetimeUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 *
 * @author tran Hoang Phuc
 */
public class ReturnPaymentController extends BaseRequiredAuthorizationController {

    private IService<CourseDTO> _iCourseService;
    private IPaymentService _iPaymentService;
    private IUserService _iUserService;

    @Override
    public void init() throws ServletException {
        _iCourseService = CourseService.getInstance(new CourseDAO(), new CourseDAO());
        _iPaymentService = PaymentService.getInstance(new UserDAO(), new CourseRegistrationDAO(), new TransactionDAO(), new UserLessonDAO(), new LessonDAO(), new TempEnrollmentDAO());
        _iUserService = UserService.getInstace(new UserDAO(), new UserDAO());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp, AccountDTO user, boolean isActivated, Set<FeatureDTO> features) throws ServletException, IOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp, AccountDTO user, boolean isActivated, Set<FeatureDTO> features) throws ServletException, IOException {
        String transactionId = req.getParameter("transactionId");
        long amount = Long.parseLong(req.getParameter("amount")) / 100;
        Date createdTime = DatetimeUtil.toDateTime(req.getParameter("createdTime"));
        boolean status = req.getParameter("status").equals("00");
        Object courseIdObject = req.getSession().getAttribute("courseId");
        if (courseIdObject != null) {
            int courseId = (int) courseIdObject;
            req.getSession().setAttribute("courseId", null);
            UserDTO userDto = _iUserService.getUserByAccountId(user.getAccId());
            _iPaymentService.paymentReturn(transactionId, amount, createdTime, status, userDto, user.getAccId());
            CourseDTO course = _iCourseService.get(courseId);
            req.setAttribute("course", course);
            req.setAttribute("user", userDto);
            resp.sendRedirect("pay?courseId=" + courseId);
        } else {
            if (status) {
                UserDTO userDto = _iUserService.getUserByAccountId(user.getAccId());
                _iPaymentService.paymentReturn(transactionId, amount, createdTime, status, userDto, user.getAccId());
                List<CourseDTO> dtos = (List<CourseDTO>) req.getSession().getAttribute("dtos");
                userDto = _iUserService.getUserByAccountId(user.getAccId());
                _iPaymentService.pay(userDto.getBalance() - amount, dtos, userDto);
                resp.sendRedirect(req.getContextPath() + "/enroll");
            }
        }
    }
}
