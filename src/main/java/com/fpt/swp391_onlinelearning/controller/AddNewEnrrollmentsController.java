/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.swp391_onlinelearning.controller;

import com.fpt.swp391_onlinelearning.baseController.BaseRequiredAuthorizationController;
import com.fpt.swp391_onlinelearning.dal.AccountDAO;
import com.fpt.swp391_onlinelearning.dal.CourseCategoryDAO;
import com.fpt.swp391_onlinelearning.dal.CourseDAO;
import com.fpt.swp391_onlinelearning.dal.CourseRegistrationDAO;
import com.fpt.swp391_onlinelearning.dal.DurationDAO;
import com.fpt.swp391_onlinelearning.dal.LessonDAO;
import com.fpt.swp391_onlinelearning.dal.TempEnrollmentDAO;
import com.fpt.swp391_onlinelearning.dal.UserDAO;
import com.fpt.swp391_onlinelearning.dal.UserLessonDAO;
import com.fpt.swp391_onlinelearning.dto.AccountDTO;
import com.fpt.swp391_onlinelearning.dto.CourseCategoryDTO;
import com.fpt.swp391_onlinelearning.dto.CourseRegistrationDTO;
import com.fpt.swp391_onlinelearning.dto.DurationDTO;
import com.fpt.swp391_onlinelearning.dto.FeatureDTO;
import com.fpt.swp391_onlinelearning.dto.UserDTO;
import com.fpt.swp391_onlinelearning.model.Course;
import com.fpt.swp391_onlinelearning.service.AccountService;
import com.fpt.swp391_onlinelearning.service.CourseCategoryService;
import com.fpt.swp391_onlinelearning.service.CourseRegistrationService;
import com.fpt.swp391_onlinelearning.service.DurationService;
import com.fpt.swp391_onlinelearning.service.TempEnrollmentService;
import com.fpt.swp391_onlinelearning.service.UserService;
import com.fpt.swp391_onlinelearning.service.iservice.IAccountService;
import com.fpt.swp391_onlinelearning.service.iservice.ICourseRegistrationService;
import com.fpt.swp391_onlinelearning.service.iservice.IService;
import com.fpt.swp391_onlinelearning.service.iservice.ITempEnrollService;
import com.fpt.swp391_onlinelearning.service.iservice.IUserService;
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
public class AddNewEnrrollmentsController extends BaseRequiredAuthorizationController {

    private ICourseRegistrationService _iCourseRegisterationService;
    private IService<DurationDTO> _iDurationService;
    private IService<CourseCategoryDTO> _iCourseCategoryService;
    private IAccountService _iAccountService;
    private IUserService _iUserService;
    private ITempEnrollService _iTempEnrollemtService;

    @Override
    public void init() throws ServletException {
        _iCourseRegisterationService = CourseRegistrationService.getInstance(new CourseRegistrationDAO(), new CourseRegistrationDAO(), new LessonDAO(), new UserLessonDAO());
        _iDurationService = DurationService.getInstance(new DurationDAO(), new DurationDAO());
        _iDurationService = DurationService.getInstance(new DurationDAO(), new DurationDAO());
        _iCourseCategoryService = CourseCategoryService.getInstance(new CourseCategoryDAO());
        _iAccountService = AccountService.getInstance(new AccountDAO(), new AccountDAO());
        _iUserService = UserService.getInstace(new UserDAO(), new UserDAO());
        _iTempEnrollemtService = TempEnrollmentService.getInstance(new TempEnrollmentDAO(), new CourseRegistrationDAO());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp, AccountDTO user, boolean isActivated, Set<FeatureDTO> features) throws ServletException, IOException {
        String email = req.getParameter("email");
        String courseName = req.getParameter("course_name");
        int categoryId = req.getParameter("course_category") == null ? 0 : Integer.parseInt(req.getParameter("course_category"));
        int durationId = req.getParameter("course_duration") == null ? 0 : Integer.parseInt(req.getParameter("course_duration"));
        Date dateFrom = req.getParameter("date_from") == null ? Date.valueOf("2003-01-01") : Date.valueOf(req.getParameter("date_from"));
        Date dateTo = req.getParameter("date_to") == null ? new Date(System.currentTimeMillis()) : Date.valueOf(req.getParameter("date_to"));

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
        String coursename = req.getParameter("coursename") == null || req.getParameter("coursename").trim().length() == 0 ? "" : req.getParameter("coursename");
        CourseDAO courseDAO = new CourseDAO();
        List<Course> courses = courseDAO.searchCourse(coursename);
        req.setAttribute("emailAdd", emailAdd);
        req.setAttribute("coursename", coursename);
        req.setAttribute("courses", courses);
        req.getRequestDispatcher("../view/enrollmentsDashboard.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp, AccountDTO user, boolean isActivated, Set<FeatureDTO> features) throws ServletException, IOException {
        String email = req.getParameter("email");
        String courseName = req.getParameter("course_name");
        int categoryId = req.getParameter("course_category") == null ? 0 : Integer.parseInt(req.getParameter("course_category"));
        int durationId = req.getParameter("course_duration") == null ? 0 : Integer.parseInt(req.getParameter("course_duration"));
        Date dateFrom = req.getParameter("date_from") == null ? Date.valueOf("2003-01-01") : Date.valueOf(req.getParameter("date_from"));
        Date dateTo = req.getParameter("date_to") == null ? new Date(System.currentTimeMillis()) : Date.valueOf(req.getParameter("date_to"));

        List<DurationDTO> durationList = _iDurationService.getAll();
        List<CourseCategoryDTO> courseCategoryList = _iCourseCategoryService.getAll();

        int pageIndex = req.getParameter("page") != null ? Integer.parseInt(req.getParameter("page")) : 1;
        int totalPage = _iCourseRegisterationService.countNumberOfPageSearch(email, courseName, categoryId, durationId, dateFrom, dateTo);
        List<CourseRegistrationDTO> list;
        list = _iCourseRegisterationService.searchCourseRegistrations(email, courseName, categoryId, durationId, dateFrom, dateTo, pageIndex);

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

        String emailAdd = req.getParameter("emailAdd");
        String coursename = req.getParameter("coursename") == null || req.getParameter("coursename").trim().length() == 0 ? "" : req.getParameter("coursename");
        CourseDAO courseDAO = new CourseDAO();
        List<Course> courses = courseDAO.searchCourse(coursename);
        req.setAttribute("emailAdd", emailAdd);
        req.setAttribute("coursename", coursename);
        req.setAttribute("courses", courses);
        String[] courseIdStrings = req.getParameterValues("chosenCourses");
        AccountDTO accountDTO = _iAccountService.getByEmail(emailAdd);
        String mesString = "";
        if (accountDTO == null) {
            mesString = "Email does not exist";
        } else {
            UserDTO udto = _iUserService.getUserByAccountId(accountDTO.getAccId());
            UserDTO staff = _iUserService.getUserByAccountId(user.getAccId());
            if (accountDTO.getIsActivated() == 2) {
                mesString = "Account is blocked";
            } else {
                if (_iTempEnrollemtService.addTempEnrollment(udto.getUserId(), courseIdStrings,staff.getUserId())) {
                    mesString = "New enrollments added successfully";
                } else {
                    mesString = "This course was registerd by this user";
                }
            }
        }

        List<Integer> countRegList = _iCourseRegisterationService.getCountRegList();
        List<Integer> totalIncomeList = _iCourseRegisterationService.getTotalIncomeList();
        req.setAttribute("countRegList", countRegList);
        req.setAttribute("totalIncomeList", totalIncomeList);
        req.setAttribute("mesString", mesString);
        req.getRequestDispatcher("../view/enrollmentsDashboard.jsp").forward(req, resp);
    }

}
