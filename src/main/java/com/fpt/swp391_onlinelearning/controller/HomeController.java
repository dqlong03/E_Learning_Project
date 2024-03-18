/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.swp391_onlinelearning.controller;

import com.fpt.swp391_onlinelearning.dal.BlogDAO;
import com.fpt.swp391_onlinelearning.dal.CourseDAO;
import com.fpt.swp391_onlinelearning.dal.CourseRegistrationDAO;
import com.fpt.swp391_onlinelearning.dal.LessonDAO;
import com.fpt.swp391_onlinelearning.dal.SliderDAO;
import com.fpt.swp391_onlinelearning.dal.UserLessonDAO;
import com.fpt.swp391_onlinelearning.dto.BlogDTO;
import com.fpt.swp391_onlinelearning.dto.CourseDTO;
import com.fpt.swp391_onlinelearning.dto.CourseRegistrationDTO;
import com.fpt.swp391_onlinelearning.dto.SliderDTO;
import com.fpt.swp391_onlinelearning.dto.UserDTO;
import com.fpt.swp391_onlinelearning.service.BlogService;
import com.fpt.swp391_onlinelearning.service.CourseRegistrationService;
import com.fpt.swp391_onlinelearning.service.CourseService;
import com.fpt.swp391_onlinelearning.service.SliderService;
import com.fpt.swp391_onlinelearning.service.iservice.IBlogService;
import com.fpt.swp391_onlinelearning.service.iservice.ICourseRegistrationService;
import com.fpt.swp391_onlinelearning.service.iservice.ICourseService;
import com.fpt.swp391_onlinelearning.service.iservice.ISliderService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author tran Hoang Phuc
 */

public class HomeController extends HttpServlet{

    private ISliderService sliderService;
    private ICourseService courseService;
    private IBlogService blogservice;
    private ICourseRegistrationService iCourseRegistrationService;
    
    @Override
    public void init() throws ServletException
    {
        sliderService= SliderService.getInstance(new SliderDAO());
        courseService= CourseService.getInstance(new CourseDAO(), new CourseDAO());
        blogservice = BlogService.getInstance(new BlogDAO());
        iCourseRegistrationService= CourseRegistrationService.getInstance(new CourseRegistrationDAO(), new CourseRegistrationDAO(), new LessonDAO(), new UserLessonDAO());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        List<SliderDTO> homeSliders= sliderService.getListOfSliderDTO();
        List<CourseDTO> courseDTOList= courseService.getRecentlyCourses(5);
        List<BlogDTO> blogDTOList= blogservice.getRecentlyBlog(5);
        if(req.getSession().getAttribute("user")!=null)
        {
            UserDTO user= (UserDTO) req.getSession().getAttribute("user");
            List<CourseRegistrationDTO> userRecentlyCourse= iCourseRegistrationService.getUserRecentlyCourse(4, user.getUserId());
            req.setAttribute("userRecentlyCourse", userRecentlyCourse);
        }
        
        req.setAttribute("homeSliders", homeSliders);
        req.setAttribute("courseList", courseDTOList);
        req.setAttribute("blogList", blogDTOList);
        
        
        req.getRequestDispatcher("view/home.jsp").forward(req, resp); 
        

    }
    
}
