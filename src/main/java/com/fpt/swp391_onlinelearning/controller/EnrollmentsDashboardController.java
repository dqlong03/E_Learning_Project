/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.swp391_onlinelearning.controller;

import com.fpt.swp391_onlinelearning.baseController.BaseRequiredAuthorizationController;
import com.fpt.swp391_onlinelearning.dal.CourseCategoryDAO;
import com.fpt.swp391_onlinelearning.dal.CourseRegistrationDAO;
import com.fpt.swp391_onlinelearning.dal.DurationDAO;
import com.fpt.swp391_onlinelearning.dal.LessonDAO;
import com.fpt.swp391_onlinelearning.dal.UserLessonDAO;
import com.fpt.swp391_onlinelearning.dto.AccountDTO;
import com.fpt.swp391_onlinelearning.dto.CourseCategoryDTO;
import com.fpt.swp391_onlinelearning.dto.CourseRegistrationDTO;
import com.fpt.swp391_onlinelearning.dto.DurationDTO;
import com.fpt.swp391_onlinelearning.dto.FeatureDTO;
import com.fpt.swp391_onlinelearning.service.CourseCategoryService;
import com.fpt.swp391_onlinelearning.service.CourseRegistrationService;
import com.fpt.swp391_onlinelearning.service.DurationService;
import com.fpt.swp391_onlinelearning.service.iservice.ICourseRegistrationService;
import com.fpt.swp391_onlinelearning.service.iservice.IService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Admin
 */
public class EnrollmentsDashboardController extends BaseRequiredAuthorizationController {

    private ICourseRegistrationService _iCourseRegisterationService;
    private IService<DurationDTO> _iDurationService;
    private IService<CourseCategoryDTO> _iCourseCategoryService;

    @Override
    public void init() throws ServletException {
        _iCourseRegisterationService = CourseRegistrationService.getInstance(new CourseRegistrationDAO(), new CourseRegistrationDAO(), new LessonDAO(), new UserLessonDAO());
        _iDurationService = DurationService.getInstance(new DurationDAO(), new DurationDAO());
        _iDurationService = DurationService.getInstance(new DurationDAO(), new DurationDAO());
        _iCourseCategoryService = CourseCategoryService.getInstance(new CourseCategoryDAO());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp, AccountDTO user, boolean isActivated, Set<FeatureDTO> features) throws ServletException, IOException {
        String email = req.getParameter("email");
        String courseName = req.getParameter("course_name");
        int categoryId = req.getParameter("course_category") == null ? 0 : Integer.parseInt(req.getParameter("course_category"));
        int durationId = req.getParameter("course_duration") == null ? 0 : Integer.parseInt(req.getParameter("course_duration"));
        Date dateFrom = req.getParameter("date_from") == null ? Date.valueOf("2003-01-01") : Date.valueOf(req.getParameter("date_from"));
        Date dateTo = req.getParameter("date_to") == null ? new Date(System.currentTimeMillis()) : Date.valueOf(req.getParameter("date_to"));
        String check = req.getParameter("check");

        List<DurationDTO> durationList = _iDurationService.getAll();
        List<CourseCategoryDTO> courseCategoryList = _iCourseCategoryService.getAll();

        int pageIndex = req.getParameter("page") != null ? Integer.parseInt(req.getParameter("page")) : 1;
        int totalPage = _iCourseRegisterationService.countNumberOfPageSearch(email, courseName, categoryId, durationId, dateFrom, dateTo);
        List<CourseRegistrationDTO> list;
        list = _iCourseRegisterationService.searchCourseRegistrations(email, courseName, categoryId, durationId, dateFrom, dateTo, pageIndex);

        List<Integer> countRegList = _iCourseRegisterationService.getCountRegList();
        List<Integer> totalIncomeList = _iCourseRegisterationService.getTotalIncomeList();

        req.setAttribute("list", list);
        req.setAttribute("pageIndex", pageIndex);
        req.setAttribute("totalPage", totalPage);

        req.setAttribute("durationList", durationList);
        req.setAttribute("courseCategoryList", courseCategoryList);

        req.setAttribute("email", email);
        req.setAttribute("courseName", courseName);
        req.setAttribute("courseCategory", categoryId);
        req.setAttribute("courseDuration", durationId);
        req.setAttribute("dateFrom", dateFrom);
        req.setAttribute("dateTo", dateTo);

        req.setAttribute("countRegList", countRegList);
        req.setAttribute("totalIncomeList", totalIncomeList);

        String emailAdd = req.getParameter("emailAdd");
        String courseNameAdd = req.getParameter("courseNameAdd") == null || req.getParameter("courseNameAdd").trim().length() == 0 ? "" : req.getParameter("courseNameAdd");

        long totalIncome = _iCourseRegisterationService.getTotalIncome(email, courseName, categoryId, durationId, dateFrom, dateTo);
        if (check != null) {
            if (!"true".equals(check)) {
                req.setAttribute("check", "check");
                req.setAttribute("total", totalIncome);
            }
        }
        req.setAttribute("emailAdd", emailAdd);
        req.setAttribute("courseNameAdd", courseNameAdd);
        req.getRequestDispatcher("../view/enrollmentsDashboard.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp, AccountDTO user, boolean isActivated, Set<FeatureDTO> features) throws ServletException, IOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
