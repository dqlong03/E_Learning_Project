/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
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
import com.fpt.swp391_onlinelearning.dto.UserDTO;
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
 * @author Admin
 */
public class CourseController extends HttpServlet {

    private static ICourseService courseService;
    private static IService<CourseCategoryDTO> courseCategoryService;
    private static ILevelService levelService;
    private static IDurationService durationService;
    private static ILanguageService languageService;

    @Override
    public void init() {
        courseService = CourseService.getInstance(new CourseDAO(), new CourseDAO());
        courseCategoryService = CourseCategoryService.getInstance(new CourseCategoryDAO());
        levelService = LevelService.getInstance(new LevelDAO(), new LevelDAO());
        durationService = DurationService.getInstance(new DurationDAO(), new DurationDAO());
        languageService = LanguageService.getInstance(new LanguageDAO(), new LanguageDAO());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String ccid_raw = request.getParameter("ccid");
        if (ccid_raw == null || ccid_raw.trim().length() == 0) {
            ccid_raw = "0"; 
        }
        int ccid = Integer.parseInt(ccid_raw);

        
        String name = request.getParameter("name");

        
        int pagesize = 9; 

        String pageindex_raw = request.getParameter("page");
        if (pageindex_raw == null || pageindex_raw.trim().length() == 0) {
            pageindex_raw = "1"; 
        }

        
        String sort_raw = request.getParameter("sort");
        if (sort_raw == null || sort_raw.trim().length() == 0) {
            sort_raw = "0"; 
        } else {
            sort_raw = request.getParameter("sort");
        }
        int sort = Integer.parseInt(sort_raw);

        
        int pageindex = Integer.parseInt(pageindex_raw);

        String levelid_raw = request.getParameter("levelid");
        if (levelid_raw == null || levelid_raw.length() == 0) {
            levelid_raw = "0";
        }
        int levelid = Integer.parseInt(levelid_raw);

        String durationid_raw = request.getParameter("durationid");
        if (durationid_raw == null || durationid_raw.length() == 0) {
            durationid_raw = "0";
        }
        int durationid = Integer.parseInt(durationid_raw);

        String languageid_raw = request.getParameter("languageid");
        if (languageid_raw == null || languageid_raw.length() == 0) {
            languageid_raw = "0";
        }
        int languageid = Integer.parseInt(languageid_raw);
        
        int total = courseService.getCount(ccid, name,levelid,durationid,languageid);
        
        int totalpage = (total % pagesize == 0) ? total / pagesize : total / pagesize + 1;
        
        List<CourseDTO> course = courseService.getAllCourse(pageindex, pagesize, sort, ccid, name, levelid, durationid, languageid);
        
        List<CourseCategoryDTO> cate = courseCategoryService.getAll();

        List<LevelDTO> level = levelService.getAllLevel();

        List<DurationDTO> duration = durationService.getAllDuration();

        List<LanguageDTO> language = languageService.getAllLanguage();

        if (request.getSession().getAttribute("user") != null) {
            UserDTO udto = (UserDTO) request.getSession().getAttribute("user");
            List<CourseDTO> dtos = courseService.getTempCourseEnrollmemt(udto.getUserId());
            if (!dtos.isEmpty()) {
                request.getSession().setAttribute("dtos", dtos);
            } else {
                request.getSession().setAttribute("dtos", null);
            }
        }
        // Setting attributes to be used in JSP
        request.setAttribute("course", course);
        request.setAttribute("totalpage", totalpage);
        request.setAttribute("pageindex", pageindex);
        request.setAttribute("category", cate);
        request.setAttribute("ccid", ccid);
        request.setAttribute("name", name);
        request.setAttribute("total", total);
        request.setAttribute("sort", sort);
        request.setAttribute("level", level);
        request.setAttribute("language", language);
        request.setAttribute("duration", duration);
        request.setAttribute("levelid", levelid);
        request.setAttribute("languageid", languageid);
        request.setAttribute("durationid", durationid);

        // Forwarding the request and response to the JSP page
        request.getRequestDispatcher("view/courselist.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
