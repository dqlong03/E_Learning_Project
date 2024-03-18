/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.swp391_onlinelearning.controller;

import com.fpt.swp391_onlinelearning.dal.CourseCategoryDAO;
import com.fpt.swp391_onlinelearning.dal.CourseDAO;
import com.fpt.swp391_onlinelearning.dal.DurationDAO;
import com.fpt.swp391_onlinelearning.dal.LanguageDAO;
import com.fpt.swp391_onlinelearning.dal.LevelDAO;
import com.fpt.swp391_onlinelearning.dto.CourseCategoryDTO;
import com.fpt.swp391_onlinelearning.dto.CourseDTO;
import com.fpt.swp391_onlinelearning.dto.DurationDTO;
import com.fpt.swp391_onlinelearning.dto.LanguageDTO;
import com.fpt.swp391_onlinelearning.dto.LevelDTO;
import com.fpt.swp391_onlinelearning.service.CourseCategoryService;
import com.fpt.swp391_onlinelearning.service.CourseService;
import com.fpt.swp391_onlinelearning.service.DurationService;
import com.fpt.swp391_onlinelearning.service.LanguageService;
import com.fpt.swp391_onlinelearning.service.LevelService;
import com.fpt.swp391_onlinelearning.service.iservice.ICourseService;
import com.fpt.swp391_onlinelearning.service.iservice.IDurationService;
import com.fpt.swp391_onlinelearning.service.iservice.ILanguageService;
import com.fpt.swp391_onlinelearning.service.iservice.ILevelService;
import com.fpt.swp391_onlinelearning.service.iservice.IService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author quang
 */
public class CourseDetailController extends HttpServlet {
    
    private ICourseService iCourseService;
    private IService<CourseCategoryDTO> iCategoryService;
    private static ILevelService levelService;
    private static IDurationService durationService;
    private static ILanguageService languageService;
    
    @Override
    public void init() throws ServletException {
        iCourseService = CourseService.getInstance(new CourseDAO(), new CourseDAO());
        iCategoryService = CourseCategoryService.getInstance(new CourseCategoryDAO());
        levelService = LevelService.getInstance(new LevelDAO(), new LevelDAO());
        durationService = DurationService.getInstance(new DurationDAO(), new DurationDAO());
        languageService = LanguageService.getInstance(new LanguageDAO(), new LanguageDAO());
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String courseIdString = req.getParameter("id");
        int courseId = Integer.parseInt(courseIdString);
        List<CourseCategoryDTO> categoryDTOs = iCategoryService.getAll();
        CourseDTO cdto = iCourseService.getCourseDetail(courseId);
        if (cdto != null) {
            List<LevelDTO> level = levelService.getAllLevel();
            
            List<DurationDTO> duration = durationService.getAllDuration();
            
            List<LanguageDTO> language = languageService.getAllLanguage();
            req.setAttribute("level", level);
            req.setAttribute("language", language);
            req.setAttribute("duration", duration);
            req.setAttribute("courseId", courseId);
            req.setAttribute("cdto", cdto);
            req.setAttribute("category", categoryDTOs);
            req.getRequestDispatcher("view/coursedetail.jsp").forward(req, resp);
        } else {
            resp.sendRedirect(req.getContextPath() + "/courselist");
        }
        
    }
    
}
