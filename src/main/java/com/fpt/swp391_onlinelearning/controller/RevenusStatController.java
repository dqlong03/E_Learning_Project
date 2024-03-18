/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.swp391_onlinelearning.controller;


import com.fpt.swp391_onlinelearning.baseController.BaseRequiredAuthorizationController;
import com.fpt.swp391_onlinelearning.dal.CourseRegistrationDAO;
import com.fpt.swp391_onlinelearning.dal.LessonDAO;
import com.fpt.swp391_onlinelearning.dal.UserLessonDAO;
import com.fpt.swp391_onlinelearning.dto.AccountDTO;
import com.fpt.swp391_onlinelearning.dto.CourseRegistrationDTO;
import com.fpt.swp391_onlinelearning.dto.FeatureDTO;
import com.fpt.swp391_onlinelearning.service.CourseRegistrationService;
import com.fpt.swp391_onlinelearning.service.iservice.ICourseRegistrationService;
import com.fpt.swp391_onlinelearning.util.DateUtils;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.List;
import java.util.Set;

/**
 *
 * @author phuc2
 */
public class RevenusStatController extends BaseRequiredAuthorizationController {

    public ICourseRegistrationService _iCourseRegistrationService;
    
    public void init()
    {
        _iCourseRegistrationService= CourseRegistrationService.getInstance(new CourseRegistrationDAO(), new CourseRegistrationDAO(), new LessonDAO(), new UserLessonDAO());
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp, AccountDTO user, boolean isActivated, Set<FeatureDTO> features) throws ServletException, IOException {
        String s_from= req.getParameter("from");
        String s_to= req.getParameter("to");
        Date from;
        Date to;
        if(s_from==null||s_from.length()==0)
        {
            from = DateUtils.getFirstDateOfCurrentMonth();
            to = DateUtils.getLastDateOfCurrentMonth();
        }
        else
        {
            from = Date.valueOf(s_from);
            to = Date.valueOf(s_to);
        }
        String s_pageIndex= req.getParameter("pageIndex");
        s_pageIndex= (s_pageIndex==null||s_pageIndex.length()==0)?"1":s_pageIndex;
        int pageIndex= Integer.parseInt(s_pageIndex);
        int pageSize=10;
        
        List<CourseRegistrationDTO> courseRegistrationList= _iCourseRegistrationService.getCourseRegistrationDTO(pageIndex, pageSize, from, to);
        List<CourseRegistrationDTO> allCourseRegistrationList= _iCourseRegistrationService.getCourseRegistrationDTO(from, to);
        
        int totalRegistration= _iCourseRegistrationService.getCourseRegistrationAmount(from, to);
        int totalRevenus= _iCourseRegistrationService.getTotalRegistrationRevenus(from, to);
        int totalPage= (totalRegistration%pageSize==0)? totalRegistration/pageSize : totalRegistration/pageSize+1;
        req.setAttribute("from", from);
        req.setAttribute("to", to);
        req.setAttribute("pageSize", pageSize);
        req.setAttribute("pageIndex", pageIndex);
        req.setAttribute("registrationList", courseRegistrationList);
        req.setAttribute("allCourseRegistrationList", allCourseRegistrationList);
        req.setAttribute("totalRevenus", totalRevenus);
        req.setAttribute("totalPage", totalPage);
        
        req.getRequestDispatcher("../view/revenusStats.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp, AccountDTO user, boolean isActivated, Set<FeatureDTO> features) throws ServletException, IOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    

    
    
}
