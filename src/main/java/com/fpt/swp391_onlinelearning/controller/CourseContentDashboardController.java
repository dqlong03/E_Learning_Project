/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.swp391_onlinelearning.controller;

import com.fpt.swp391_onlinelearning.baseController.BaseRequiredAuthorizationController;
import com.fpt.swp391_onlinelearning.dal.CourseDAO;
import com.fpt.swp391_onlinelearning.dal.LessonDAO;
import com.fpt.swp391_onlinelearning.dal.UserDAO;
import com.fpt.swp391_onlinelearning.dto.AccountDTO;
import com.fpt.swp391_onlinelearning.dto.ChapterDTO;
import com.fpt.swp391_onlinelearning.dto.CourseDTO;
import com.fpt.swp391_onlinelearning.dto.FeatureDTO;
import com.fpt.swp391_onlinelearning.dto.LessonDTO;
import com.fpt.swp391_onlinelearning.dto.UserDTO;
import com.fpt.swp391_onlinelearning.service.CourseService;
import com.fpt.swp391_onlinelearning.service.LessonService;
import com.fpt.swp391_onlinelearning.service.UserService;
import com.fpt.swp391_onlinelearning.service.iservice.ICourseService;
import com.fpt.swp391_onlinelearning.service.iservice.ILessonService;
import com.fpt.swp391_onlinelearning.service.iservice.IService;
import com.fpt.swp391_onlinelearning.service.iservice.IUserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author tran Hoang Phuc
 */
public class CourseContentDashboardController extends BaseRequiredAuthorizationController {

    private ICourseService iCourseService;
    private ILessonService iLessonService;
    private IUserService iUserService;
    private IService<LessonDTO> iService;

    @Override
    public void init() throws ServletException {
        iCourseService = CourseService.getInstance(new CourseDAO(), new CourseDAO());
        iLessonService = LessonService.getInstance(new LessonDAO(), new LessonDAO());
        iUserService = UserService.getInstace(new UserDAO(), new UserDAO());
        iService = LessonService.getInstance(new LessonDAO(), new LessonDAO());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp, AccountDTO user, boolean isActivated, Set<FeatureDTO> features) throws ServletException, IOException {
        int courseId = Integer.parseInt(req.getParameter("courseId"));
        Map<ChapterDTO, List<LessonDTO>> lessons = iLessonService.getLessonByCourse(courseId);
        LessonDTO lessonDTO = null;
        if (req.getParameter("lessonId") == null) {
            for (Map.Entry<ChapterDTO, List<LessonDTO>> entry : lessons.entrySet()) {
                ChapterDTO key = entry.getKey();
                List<LessonDTO> value = entry.getValue();
                lessonDTO = value.get(0);
                break;
            }
            req.setAttribute("l", lessonDTO);
        } else {
            int lessonId = Integer.parseInt(req.getParameter("lessonId"));
            lessonDTO = iService.get(lessonId);
            req.setAttribute("l", lessonDTO);
        }
        CourseDTO cdto = iCourseService.getCourseDetail(courseId);
        req.setAttribute("lesson", lessons);
        req.setAttribute("course", cdto);
        req.getRequestDispatcher("../view/courseContentDashboard.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp, AccountDTO user, boolean isActivated, Set<FeatureDTO> features) throws ServletException, IOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
