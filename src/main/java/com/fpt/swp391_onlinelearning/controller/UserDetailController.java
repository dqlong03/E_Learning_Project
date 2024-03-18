/*
 * Click nbfs:nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs:nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.fpt.swp391_onlinelearning.controller;

import com.fpt.swp391_onlinelearning.baseController.BaseRequiredAuthorizationController;
import com.fpt.swp391_onlinelearning.dal.AccountDAO;
import com.fpt.swp391_onlinelearning.dal.RoleDAO;
import com.fpt.swp391_onlinelearning.dal.UserDAO;
import com.fpt.swp391_onlinelearning.dto.AccountDTO;
import com.fpt.swp391_onlinelearning.dto.FeatureDTO;
import com.fpt.swp391_onlinelearning.dto.RoleDTO;
import com.fpt.swp391_onlinelearning.dto.UserDTO;
import com.fpt.swp391_onlinelearning.service.AccountService;
import com.fpt.swp391_onlinelearning.service.RoleService;
import com.fpt.swp391_onlinelearning.service.UserService;
import com.fpt.swp391_onlinelearning.service.iservice.IAccountService;
import com.fpt.swp391_onlinelearning.service.iservice.IRoleService;
import com.fpt.swp391_onlinelearning.service.iservice.IService;
import com.fpt.swp391_onlinelearning.service.iservice.IUserService;
import com.fpt.swp391_onlinelearning.util.URLUtils;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Admin
 */
@MultipartConfig
public class UserDetailController extends BaseRequiredAuthorizationController {

    private static IUserService _iUserService;
    private static IService<RoleDTO> _iRoleService;
    private IAccountService _iAccountService;

    @Override
    public void init() {
        _iUserService = UserService.getInstace(new UserDAO(), new UserDAO());
        _iRoleService = RoleService.getInstance(new RoleDAO());
        _iAccountService = AccountService.getInstance(new AccountDAO(), new AccountDAO());

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp, AccountDTO user, boolean isActivated, Set<FeatureDTO> features) throws ServletException, IOException {
        int accountID = Integer.parseInt(req.getParameter("accountID"));

        UserDTO users = _iUserService.getUserById(accountID);
        List<RoleDTO> roles = _iRoleService.getAll();

        req.setAttribute("role", roles);
        req.setAttribute("user", users);
        req.setAttribute("imageData", users.getImg());
        req.getRequestDispatcher("../view/userdetail.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp, AccountDTO user, boolean isActivated, Set<FeatureDTO> features) throws ServletException, IOException {
        String accountid_raw = req.getParameter("accountid");
        int accountid = Integer.parseInt(accountid_raw);
        int status = Integer.parseInt(req.getParameter("status"));
        int role = Integer.parseInt(req.getParameter("roleid"));
        RoleDTO r = new RoleDTO();
        r.setRoleId(role);
        AccountDTO a = new AccountDTO();
        a.setIsActivated(status);
        a.setRole(r);
        String actionS = req.getParameter("actionS");
        String roleS = req.getParameter("roleS");
        String statusS = req.getParameter("statusS");
        String pageS = req.getParameter("pageS");
       System.out.println(actionS + " " +roleS + " " +statusS + " " +pageS);
        _iAccountService.updateAccountById(a, accountid);
        UserDTO updatedUser = _iUserService.getUserByAccountId(accountid);
        List<RoleDTO> roles = _iRoleService.getAll();

        req.setAttribute("role", roles);
        req.setAttribute("user", updatedUser);
        req.setAttribute("message", "Changed successfully");
        resp.sendRedirect(req.getContextPath() + "/dashboard/userDetail?accountID=" 
                + accountid +"&action="+actionS+ "&role="+roleS+"&status="+statusS+"&page="+pageS);
              
    }

}
