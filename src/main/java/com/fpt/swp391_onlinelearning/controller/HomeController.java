/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.swp391_onlinelearning.controller;

import com.fpt.swp391_onlinelearning.dal.BlogDAO;
import com.fpt.swp391_onlinelearning.dal.CourseDAO;
import com.fpt.swp391_onlinelearning.dal.SliderDAO;
import com.fpt.swp391_onlinelearning.dto.BlogDTO;
import com.fpt.swp391_onlinelearning.dto.CourseDTO;
import com.fpt.swp391_onlinelearning.dto.SliderDTO;
import com.fpt.swp391_onlinelearning.service.BlogService;
import com.fpt.swp391_onlinelearning.service.CourseService;
import com.fpt.swp391_onlinelearning.service.SliderService;
import com.fpt.swp391_onlinelearning.service.iservice.IBlogService;
import com.fpt.swp391_onlinelearning.service.iservice.ICourseService;
import com.fpt.swp391_onlinelearning.service.iservice.ISliderService;
import com.fpt.swp391_onlinelearning.util.URLUtils;
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

    private static ISliderService sliderService;
    private static ICourseService courseService;
    private static IBlogService blogservice;
    public void init() throws ServletException
    {
        sliderService= SliderService.getInstance(new SliderDAO());
        courseService= CourseService.getInstance(new CourseDAO(), new CourseDAO());
        blogservice = BlogService.getInstance(new BlogDAO());
        super.init();
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        List<SliderDTO> homeSliders= sliderService.getListOfSliderDTO("home");
        List<CourseDTO> courseDTOList= courseService.getRecentlyCourses(5);
        List<BlogDTO> blogDTOList= blogservice.getRecentlyBlog(5);
//        String firstURLPattern= URLUtils.getFirstURLPatternLevel(req);
        //resp.getWriter().println(homeSliders.get(0).getTitle()+" "+homeSliders.get(1).getTitle());
        //resp.getWriter().print(courseDTOList.get(0).getLevel().getName()+" "+courseDTOList.get(4).getLevel().getName());
        req.setAttribute("homeSliders", homeSliders);
        req.setAttribute("courseList", courseDTOList);
        req.setAttribute("blogList", blogDTOList);
//        req.setAttribute("urlPattern", firstURLPattern);
        req.getRequestDispatcher("view/home.jsp").forward(req, resp); 
        
        
        // Lấy "cấp bậc" từ URL pattern
        

    }
    
}
