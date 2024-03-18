/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.swp391_onlinelearning.controller;

import com.fpt.swp391_onlinelearning.baseController.BaseRequiredEnrollmentController;
import com.fpt.swp391_onlinelearning.dal.CourseDAO;
import com.fpt.swp391_onlinelearning.dal.LessonDAO;
import com.fpt.swp391_onlinelearning.dal.UserDAO;
import com.fpt.swp391_onlinelearning.dal.UserLessonDAO;
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
public class CourseContentController extends BaseRequiredEnrollmentController {

    private ICourseService iCourseService;
    private ILessonService iLessonService;
    private IUserService iUserService;

    @Override
    public void init() throws ServletException {
        iCourseService = CourseService.getInstance(new CourseDAO(), new CourseDAO());
        iLessonService = LessonService.getInstance(new LessonDAO(), new LessonDAO());
        iUserService = UserService.getInstace(new UserDAO(), new UserDAO());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp, AccountDTO user, boolean isActivated, Set<FeatureDTO> features, boolean canJoin) throws ServletException, IOException {
        int courseId = Integer.parseInt(req.getParameter("courseId"));
        CourseDTO cdto = iCourseService.getCourseDetail(courseId);
        Map<ChapterDTO, List<LessonDTO>> lessons = iLessonService.getLessonByCourse(courseId);
        UserDTO userDTO = iUserService.getUserByAccountId(user.getAccId());

        int numOfChapters = lessons.size();
        int currentLesson = iLessonService.getCurrentLesson(courseId, userDTO.getUserId());
        
        int numOfLessons = iLessonService.getNumberOfLesson(lessons);
        req.setAttribute("totalChapter", numOfChapters);
        req.setAttribute("current", currentLesson);
        req.setAttribute("totalLessons", numOfLessons);
        req.setAttribute("lesson", lessons);
        req.setAttribute("course", cdto);
        req.getRequestDispatcher("view/courseContent.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp, AccountDTO user, boolean isActivated, Set<FeatureDTO> features, boolean canJoin) throws ServletException, IOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
