/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.swp391_onlinelearning.controller;

import com.fpt.swp391_onlinelearning.baseController.BaseRequiredAuthorizationController;
import com.fpt.swp391_onlinelearning.dal.BlogViewDAO;
import com.fpt.swp391_onlinelearning.dal.CourseRegistrationDAO;
import com.fpt.swp391_onlinelearning.dal.LessonDAO;
import com.fpt.swp391_onlinelearning.dal.UserDAO;
import com.fpt.swp391_onlinelearning.dal.UserLessonDAO;
import com.fpt.swp391_onlinelearning.dto.AccountDTO;
import com.fpt.swp391_onlinelearning.dto.BlogViewDTO;
import com.fpt.swp391_onlinelearning.dto.CourseRegistrationDTO;
import com.fpt.swp391_onlinelearning.dto.FeatureDTO;
import com.fpt.swp391_onlinelearning.service.BlogViewService;
import com.fpt.swp391_onlinelearning.service.CourseRegistrationService;
import com.fpt.swp391_onlinelearning.service.UserService;
import com.fpt.swp391_onlinelearning.service.iservice.IBlogViewService;
import com.fpt.swp391_onlinelearning.service.iservice.ICourseRegistrationService;
import com.fpt.swp391_onlinelearning.service.iservice.IUserService;
import com.fpt.swp391_onlinelearning.util.DateUtils;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author phuc2
 */
public class DashboardController extends BaseRequiredAuthorizationController {

    public IUserService _IUserService;
    public ICourseRegistrationService _ICourseRegistrationService;
    public IBlogViewService _IBlogViewService;
    
    public void init()
    {
        _IUserService= UserService.getInstace(new UserDAO(), new UserDAO());
        _ICourseRegistrationService = CourseRegistrationService.getInstance(new CourseRegistrationDAO(), new CourseRegistrationDAO(), new LessonDAO(), new UserLessonDAO());
        _IBlogViewService= BlogViewService.getInstance(new BlogViewDAO());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp, AccountDTO user, boolean isActivated, Set<FeatureDTO> features) throws ServletException, IOException {
        String s_daysOfCourseTrend= req.getParameter("cdays");
        s_daysOfCourseTrend= (s_daysOfCourseTrend==null||s_daysOfCourseTrend.length()==0)?"7":s_daysOfCourseTrend;
        int daysOfCourseTrend= Integer.parseInt(s_daysOfCourseTrend);
        String s_daysOfBlogTrend= req.getParameter("bdays");
        s_daysOfBlogTrend= (s_daysOfBlogTrend==null||s_daysOfBlogTrend.length()==0)?"7":s_daysOfBlogTrend;
        int daysOfBlogTrend= Integer.parseInt(s_daysOfBlogTrend);
        
        List<Integer> userRegistersInCurrentWeek = _IUserService.userDTOCount();
        List<Integer> courseRegistrationInCurrentWeek = _ICourseRegistrationService.getCourseRegistrationAmount();
        List<Integer> monthlyRevenue= _ICourseRegistrationService.getMonthlyRevenueList();
        Map<CourseRegistrationDTO, Integer> courseTrend= _ICourseRegistrationService.getCoursesTrend(daysOfCourseTrend);
        int numberOfRemainingCourse= _ICourseRegistrationService.getNumberOfRemainningCourse(courseTrend, daysOfCourseTrend);
        int currentMonthRevenue= _ICourseRegistrationService.getMonthRevenue(DateUtils.getCurrentMonth());
        int previousMonthRevenue= _ICourseRegistrationService.getMonthRevenue(DateUtils.getPreviousMonth());
        int currentWeekUserRegister= _IUserService.userDTOCount(DateUtils.getFirstDayOfCurrentWeek(), DateUtils.getLastDayOfCurrentWeek());
        int previousWeekUserRegister= _IUserService.userDTOCount(DateUtils.getFirstDateOfLastWeek(), DateUtils.getLasDateOfLastWeek());
        int currentWeekCourseRegistration= _ICourseRegistrationService.getCourseRegistrationAmount(DateUtils.getFirstDayOfCurrentWeek(), DateUtils.getLastDayOfCurrentWeek());
        int lastWeekCourseRegistration=_ICourseRegistrationService.getCourseRegistrationAmount(DateUtils.getFirstDateOfLastWeek(), DateUtils.getLasDateOfLastWeek());
        Map<BlogViewDTO, Integer> blogViewTrend= _IBlogViewService.getBlogViewTrend(daysOfBlogTrend);
        int remainningView= _IBlogViewService.getRemainingBlogView(blogViewTrend, daysOfBlogTrend);
        
        req.setAttribute("daysOfCourseTrend", daysOfCourseTrend);
        req.setAttribute("daysOfBlogTrend", daysOfBlogTrend);
        req.setAttribute("uregisterList", userRegistersInCurrentWeek);
        req.setAttribute("cregisterList", courseRegistrationInCurrentWeek);
        req.setAttribute("revenueList", monthlyRevenue);
        req.setAttribute("courseTrend", courseTrend);
        req.setAttribute("remainCourses", numberOfRemainingCourse);
        req.setAttribute("currentMonthRevenue", currentMonthRevenue);
        req.setAttribute("previousMonthRevenue", previousMonthRevenue);
        req.setAttribute("currentWeekUserRegister", currentWeekUserRegister);
        req.setAttribute("previousWeekUserRegister", previousWeekUserRegister);
        req.setAttribute("currentWeekCourseRegistration", currentWeekCourseRegistration);
        req.setAttribute("lastWeekCourseRegistration", lastWeekCourseRegistration);
        req.setAttribute("blogViewTrend", blogViewTrend);
        req.setAttribute("remainningView", remainningView);
        req.getRequestDispatcher("../view/dashboard.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp, AccountDTO user, boolean isActivated, Set<FeatureDTO> features) throws ServletException, IOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
