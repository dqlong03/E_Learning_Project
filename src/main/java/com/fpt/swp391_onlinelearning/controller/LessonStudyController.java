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
import com.fpt.swp391_onlinelearning.dto.FeatureDTO;
import com.fpt.swp391_onlinelearning.dto.LessonDTO;
import com.fpt.swp391_onlinelearning.dto.UserDTO;
import com.fpt.swp391_onlinelearning.service.CourseService;
import com.fpt.swp391_onlinelearning.service.LessonService;
import com.fpt.swp391_onlinelearning.service.UserLessonService;
import com.fpt.swp391_onlinelearning.service.UserService;
import com.fpt.swp391_onlinelearning.service.iservice.ICourseService;
import com.fpt.swp391_onlinelearning.service.iservice.ILessonService;
import com.fpt.swp391_onlinelearning.service.iservice.IService;
import com.fpt.swp391_onlinelearning.service.iservice.IUserLessonService;
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
public class LessonStudyController extends BaseRequiredEnrollmentController {

    private ICourseService iCourseService;
    private ILessonService iLessonService;
    private IService<LessonDTO> iService;
    private IUserService iUserService;
    private IUserLessonService iUserLessonService;

    @Override
    public void init() throws ServletException {
        iCourseService = CourseService.getInstance(new CourseDAO(), new CourseDAO());
        iLessonService = LessonService.getInstance(new LessonDAO(), new LessonDAO());
        iService = LessonService.getInstance(new LessonDAO(), new LessonDAO());
        iUserService = UserService.getInstace(new UserDAO(), new UserDAO());
        iUserLessonService = UserLessonService.getInstance(new UserLessonDAO());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp, AccountDTO user, boolean isActivated, Set<FeatureDTO> features, boolean canJoin) throws ServletException, IOException {
        int courseId = Integer.parseInt(req.getParameter("courseId"));
        int lessonId = Integer.parseInt(req.getParameter("lessonId"));
        UserDTO userDTO = iUserService.getUserByAccountId(user.getAccId());
        LessonDTO lessonDTO = iService.get(lessonId);
        int nextLesson = iLessonService.getNextLesson(userDTO.getUserId(), lessonId);
        int firstLesson = iLessonService.getFirstLessonId(courseId);
        int lastLesson = iLessonService.getLastLessonId(courseId);
        int previousLesson = iLessonService.getPreviousLesson(userDTO.getUserId(), lessonId);
        Map<ChapterDTO, List<LessonDTO>> lessons = iLessonService.getLessonByCourse(courseId);
        req.setAttribute("previous", previousLesson);
        req.setAttribute("first", firstLesson);
        req.setAttribute("last", lastLesson);
        req.setAttribute("next", nextLesson);
        req.setAttribute("l", lessonDTO);
        req.setAttribute("lesson", lessons);
        if (lessonDTO.getType().getTypeId() == 1 || lessonDTO.getType().getTypeId() == 2) {
            req.getRequestDispatcher("view/lesson.jsp").forward(req, resp);
        } else {
            // chỗ này dispatcher sáng trang quizzes
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp, AccountDTO user, boolean isActivated, Set<FeatureDTO> features, boolean canJoin) throws ServletException, IOException {
        int courseId = Integer.parseInt(req.getParameter("courseId"));
        int lessonId = Integer.parseInt(req.getParameter("lessonId"));
        UserDTO userDTO = iUserService.getUserByAccountId(user.getAccId());
        iUserLessonService.markAsDone(userDTO.getUserId(), lessonId);
        resp.sendRedirect(req.getContextPath() + "/lesson?courseId=" + courseId + "&lessonId=" + lessonId);
    }

}
