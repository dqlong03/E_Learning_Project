/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.swp391_onlinelearning.controller;

import com.fpt.swp391_onlinelearning.baseController.BaseRequiredAuthorizationController;
import com.fpt.swp391_onlinelearning.dal.CourseRegistrationDAO;
import com.fpt.swp391_onlinelearning.dal.LessonDAO;
import com.fpt.swp391_onlinelearning.dal.UserLessonDAO;
import com.fpt.swp391_onlinelearning.dto.AccountDTO;
import com.fpt.swp391_onlinelearning.dto.CourseRegistrationDTO;
import com.fpt.swp391_onlinelearning.dto.FeatureDTO;
import com.fpt.swp391_onlinelearning.service.CourseRegistrationService;
import com.fpt.swp391_onlinelearning.service.iservice.IService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

/**
 *
 * @author Admin
 */
public class EnrollmentsDetailDashboardController extends BaseRequiredAuthorizationController {

    private IService<CourseRegistrationDTO> _iCourseRegisterationService;

    @Override
   public void init() throws ServletException {
        _iCourseRegisterationService = CourseRegistrationService.getInstance(new CourseRegistrationDAO(), new CourseRegistrationDAO(), new LessonDAO(), new UserLessonDAO());
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp, AccountDTO user, boolean isActivated, Set<FeatureDTO> features) throws ServletException, IOException {
        int regId = Integer.parseInt(req.getParameter("regId"));
        CourseRegistrationDTO cr = _iCourseRegisterationService.get(regId);
        
        req.setAttribute("cr", cr);
        req.getRequestDispatcher("../view/enrollmentsDetailDashboard.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp, AccountDTO user, boolean isActivated, Set<FeatureDTO> features) throws ServletException, IOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
