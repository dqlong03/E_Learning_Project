/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.swp391_onlinelearning.baseController;

import com.fpt.swp391_onlinelearning.dal.CourseRegistrationDAO;
import com.fpt.swp391_onlinelearning.dal.LessonDAO;
import com.fpt.swp391_onlinelearning.dal.UserDAO;
import com.fpt.swp391_onlinelearning.dal.UserLessonDAO;
import com.fpt.swp391_onlinelearning.dto.AccountDTO;
import com.fpt.swp391_onlinelearning.dto.FeatureDTO;
import com.fpt.swp391_onlinelearning.dto.UserDTO;
import com.fpt.swp391_onlinelearning.service.CourseRegistrationService;
import com.fpt.swp391_onlinelearning.service.UserService;
import com.fpt.swp391_onlinelearning.service.iservice.ICourseRegistrationService;
import com.fpt.swp391_onlinelearning.service.iservice.IUserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

/**
 *
 * @author tran Hoang Phuc
 */
public abstract class BaseRequiredEnrollmentController extends BaseRequiredAuthorizationController {

    private ICourseRegistrationService _iCourseRegisterationService;
    private IUserService _iUserSerivce;

    private boolean canJoin(int courseId, int userId) {
        _iCourseRegisterationService = CourseRegistrationService.getInstance(new CourseRegistrationDAO(), new CourseRegistrationDAO(), new LessonDAO(), new UserLessonDAO());
        return _iCourseRegisterationService.canJoin(courseId, userId);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp, AccountDTO user, boolean isActivated, Set<FeatureDTO> features) throws ServletException, IOException {
        int courseId = Integer.parseInt(req.getParameter("courseId"));
        _iUserSerivce = UserService.getInstace(new UserDAO(), new UserDAO());
        UserDTO u = _iUserSerivce.getUserByAccountId(user.getAccId());
        if (canJoin(courseId, u.getUserId())) {
            doGet(req, resp, user, isActivated, features, true);
        } else {
            resp.sendRedirect(req.getContextPath() + "/coursedetail?id=" + courseId);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp, AccountDTO user, boolean isActivated, Set<FeatureDTO> features) throws ServletException, IOException {
        int courseId = Integer.parseInt(req.getParameter("courseId"));
        _iUserSerivce = UserService.getInstace(new UserDAO(), new UserDAO());
        UserDTO u = _iUserSerivce.getUserByAccountId(user.getAccId());
        if (canJoin(courseId, u.getUserId())) {
            doPost(req, resp, user, isActivated, features, true);
        } else {
            resp.sendRedirect(req.getContextPath() + "/coursedetail?id=" + courseId);
        }
    }

    protected abstract void doGet(HttpServletRequest req, HttpServletResponse resp, AccountDTO user, boolean isActivated, Set<FeatureDTO> features, boolean canJoin) throws ServletException, IOException;

    protected abstract void doPost(HttpServletRequest req, HttpServletResponse resp, AccountDTO user, boolean isActivated, Set<FeatureDTO> features, boolean canJoin) throws ServletException, IOException;
}
