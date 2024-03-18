/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.swp391_onlinelearning.controller;

import com.fpt.swp391_onlinelearning.baseController.BaseRequiredAuthorizationController;
import com.fpt.swp391_onlinelearning.dal.UserDAO;
import com.fpt.swp391_onlinelearning.dto.AccountDTO;
import com.fpt.swp391_onlinelearning.dto.FeatureDTO;
import com.fpt.swp391_onlinelearning.dto.UserDTO;
import com.fpt.swp391_onlinelearning.service.UserService;
import com.fpt.swp391_onlinelearning.service.iservice.IUserService;
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
public class UserRegistrationStatisticsController extends BaseRequiredAuthorizationController{

    public IUserService _IUserService;
    
    public void init()
    {
        _IUserService= UserService.getInstace(new UserDAO(), new UserDAO());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response, AccountDTO user, boolean isActivated, Set<FeatureDTO> features) throws ServletException, IOException {
        String s_from= request.getParameter("from");
        String s_to= request.getParameter("to");
        Date from;
        Date to;
        if(s_from==null||s_from.length()==0)
        {
            from = DateUtils.getFirstDayOfCurrentWeek();
            to = DateUtils.getLastDayOfCurrentWeek();
        }
        else
        {
            from = Date.valueOf(s_from);
            to = Date.valueOf(s_to);
        }
        String s_pageIndex= request.getParameter("pageIndex");
        s_pageIndex= (s_pageIndex==null||s_pageIndex.length()==0)?"1":s_pageIndex;
        int pageIndex= Integer.parseInt(s_pageIndex);
        int pageSize=10;
        List<UserDTO> userRegistrationList = _IUserService.getUserDTORegister(pageSize, pageIndex, from, to);
        List<UserDTO> allUserRegistrationList = _IUserService.getUserDTORegister(from, to);
        
        int totalRegistration= _IUserService.userDTOCount(from,to);
        int totalPage= (totalRegistration%pageSize==0)? totalRegistration/pageSize : totalRegistration/pageSize+1;
        request.setAttribute("from", from);
        request.setAttribute("to", to);
        request.setAttribute("pageSize", pageSize);
        request.setAttribute("pageIndex", pageIndex);
        request.setAttribute("userList", userRegistrationList);
        request.setAttribute("allUserList", allUserRegistrationList);
        request.setAttribute("totalRegistration", totalRegistration);
        request.setAttribute("totalPage", totalPage);
        
        request.getRequestDispatcher("../view/userRegisterStatistics.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp, AccountDTO user, boolean isActivated, Set<FeatureDTO> features) throws ServletException, IOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
