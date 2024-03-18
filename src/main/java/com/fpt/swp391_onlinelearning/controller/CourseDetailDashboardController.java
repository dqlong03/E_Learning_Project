/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.swp391_onlinelearning.controller;

import com.fpt.swp391_onlinelearning.baseController.BaseRequiredAuthorizationController;
import com.fpt.swp391_onlinelearning.dal.CourseCategoryDAO;
import com.fpt.swp391_onlinelearning.dal.CourseDAO;
import com.fpt.swp391_onlinelearning.dal.DurationDAO;
import com.fpt.swp391_onlinelearning.dal.LanguageDAO;
import com.fpt.swp391_onlinelearning.dal.LevelDAO;
import com.fpt.swp391_onlinelearning.dal.UserDAO;
import com.fpt.swp391_onlinelearning.dto.AccountDTO;
import com.fpt.swp391_onlinelearning.dto.CourseCategoryDTO;
import com.fpt.swp391_onlinelearning.dto.CourseDTO;
import com.fpt.swp391_onlinelearning.dto.DurationDTO;
import com.fpt.swp391_onlinelearning.dto.FeatureDTO;
import com.fpt.swp391_onlinelearning.dto.LanguageDTO;
import com.fpt.swp391_onlinelearning.dto.LevelDTO;
import com.fpt.swp391_onlinelearning.dto.UserDTO;
import com.fpt.swp391_onlinelearning.service.CourseCategoryService;
import com.fpt.swp391_onlinelearning.service.CourseService;
import com.fpt.swp391_onlinelearning.service.DurationService;
import com.fpt.swp391_onlinelearning.service.LanguageService;
import com.fpt.swp391_onlinelearning.service.LevelService;
import com.fpt.swp391_onlinelearning.service.UserService;
import com.fpt.swp391_onlinelearning.service.iservice.ICourseService;
import com.fpt.swp391_onlinelearning.service.iservice.IDurationService;
import com.fpt.swp391_onlinelearning.service.iservice.ILanguageService;
import com.fpt.swp391_onlinelearning.service.iservice.ILevelService;
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
public class CourseDetailDashboardController extends BaseRequiredAuthorizationController {

    private static ICourseService courseService;
    private static IService<CourseCategoryDTO> courseCategoryService;
    private static ILevelService levelService;
    private static IDurationService durationService;
    private static ILanguageService languageService;
    private static IService<CourseDTO> iService;
    private static IUserService userService;

    @Override
    public void init() throws ServletException {
        courseService = CourseService.getInstance(new CourseDAO(), new CourseDAO());
        courseCategoryService = CourseCategoryService.getInstance(new CourseCategoryDAO());
        levelService = LevelService.getInstance(new LevelDAO(), new LevelDAO());
        durationService = DurationService.getInstance(new DurationDAO(), new DurationDAO());
        languageService = LanguageService.getInstance(new LanguageDAO(), new LanguageDAO());
        iService = CourseService.getInstance(new CourseDAO(), new CourseDAO());
        userService = UserService.getInstace(new UserDAO(), new UserDAO());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp, AccountDTO user, boolean isActivated, Set<FeatureDTO> features) throws ServletException, IOException {
        int courseId = Integer.parseInt(req.getParameter("courseId"));
        String searchInfor = req.getParameter("info");
        String levelString = req.getParameter("level");
        String durationString = req.getParameter("duration");
        String categoryString = req.getParameter("category");
        String languageId = req.getParameter("language");
        String pageIndex = req.getParameter("page");
        int page = pageIndex == null || pageIndex.trim().length() == 0 ? 1 : Integer.parseInt(pageIndex);
        int totalRecord = 0;
        int totalPage = 0;
        List<CourseDTO> course = new ArrayList<>();
        if (user.getRole().getRoleId() == 4) {
            totalRecord = courseService.getTotalRecord(searchInfor, levelString, categoryString, durationString, languageId);
            course = courseService.getAllCoursesPagger(pageIndex, searchInfor, levelString, categoryString, durationString, languageId);
        } else {
            UserDTO author = userService.getUserByAccountId(user.getAccId());
            totalRecord = courseService.getTotalRecordByAuthor(pageIndex, searchInfor, levelString, categoryString, durationString, languageId, author.getUserId());
            course = courseService.getCourseByAuthor(pageIndex, searchInfor, levelString, categoryString, durationString, languageId, author.getUserId());
        }
        List<CourseCategoryDTO> cate = courseCategoryService.getAll();
        List<LevelDTO> level = levelService.getAllLevel();
        List<DurationDTO> duration = durationService.getAllDuration();
        List<LanguageDTO> language = languageService.getAllLanguage();
        CourseDTO c = courseService.getCourseDetailAll(courseId);
        req.setAttribute("chosenCourse", c);
        req.setAttribute("totalPage", totalPage);
        req.setAttribute("course", course);
        req.setAttribute("cate", cate);
        req.setAttribute("levelList", level);
        req.setAttribute("durationList", duration);
        req.setAttribute("languageList", language);
        req.setAttribute("info", searchInfor);
        req.setAttribute("level", levelString);
        req.setAttribute("duration", durationString);
        req.setAttribute("category", categoryString);
        req.setAttribute("language", languageId);
        req.setAttribute("page", page);
        req.getRequestDispatcher("../view/courseDashboard.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp, AccountDTO user, boolean isActivated, Set<FeatureDTO> features) throws ServletException, IOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
