/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
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
import com.fpt.swp391_onlinelearning.service.iservice.IService;
import com.fpt.swp391_onlinelearning.service.iservice.IUserService;
import com.fpt.swp391_onlinelearning.util.GenerateUtil;
import com.fpt.swp391_onlinelearning.util.Sha1Util;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Admin
 */
public class UserListController extends BaseRequiredAuthorizationController {

    private IUserService _iUserService;
    private IService<RoleDTO> _iRoleService;
    private IService<AccountDTO> _iGenericAccountService;
    private IService<UserDTO> _iGenericUserService;
    private IAccountService _iUserAccountService;

    @Override
    public void init() throws ServletException {
        _iUserService = UserService.getInstace(new UserDAO(), new UserDAO());
        _iRoleService = RoleService.getInstance(new RoleDAO());
        _iGenericAccountService = AccountService.getInstance(new AccountDAO(), new AccountDAO());
        _iGenericUserService = UserService.getInstace(new UserDAO(), new UserDAO());
        _iUserAccountService = AccountService.getInstance(new AccountDAO(), new AccountDAO());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp, AccountDTO user, boolean isActivated, Set<FeatureDTO> features) throws ServletException, IOException {
        String infor = req.getParameter("infor");
        int pagesize = 5;
        String pageindex_raw = req.getParameter("page");
        if (pageindex_raw == null || pageindex_raw.trim().length() == 0) {
            pageindex_raw = "1";
        }
        int pageindex = Integer.parseInt(pageindex_raw);

        String role_raw = req.getParameter("role");
        if (role_raw == null || role_raw.trim().length() == 0) {
            role_raw = "0";
        }
        int role = Integer.parseInt(role_raw);

        String status_raw = req.getParameter("status");
        if (status_raw == null || status_raw.length() == 0) {
            status_raw = "3";
        }
        int status = Integer.parseInt(status_raw);

        int total = _iUserService.getCount(infor, role, status);
        int totalpage = (total % pagesize == 0) ? total / pagesize : total / pagesize + 1;

        List<UserDTO> u = _iUserService.getAllUser(pageindex, pagesize, infor, role, status);
        List<RoleDTO> roles = _iRoleService.getAll();
        req.setAttribute("totalpage", totalpage);
        req.setAttribute("total", total);
        req.setAttribute("pageindex", pageindex);
        req.setAttribute("users", u);
        req.setAttribute("info", infor);
        req.setAttribute("role", role);
        req.setAttribute("status", status);
        req.setAttribute("roles", roles);
        req.getRequestDispatcher("../view/userlist.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp, AccountDTO user, boolean isActivated, Set<FeatureDTO> features) throws ServletException, IOException {
        //Xử lý phân trang
        String info = req.getParameter("info");
        int pagesize = 2;
        String action = req.getParameter("action");
        String pageindex_raw = req.getParameter("page");
        if (pageindex_raw == null || pageindex_raw.trim().length() == 0) {
            pageindex_raw = "1";
        }
        int pageindex = Integer.parseInt(pageindex_raw);

        String role_raw = req.getParameter("role");
        if (role_raw == null || role_raw.trim().length() == 0) {
            role_raw = "0";
        }
        int rolept = Integer.parseInt(role_raw);

        String status_raw = req.getParameter("status");
        if (status_raw == null || status_raw.length() == 0) {
            status_raw = "0";
        }
        int status = Integer.parseInt(status_raw);

        int total = _iUserService.getCount(info, rolept, status);
        int totalpage = (total % pagesize == 0) ? total / pagesize : total / pagesize + 1;

        List<UserDTO> u = _iUserService.getAllUser(pageindex, pagesize, info, rolept, status);
        List<RoleDTO> roles = _iRoleService.getAll();
        req.setAttribute("users", u);
        req.setAttribute("role", roles);

        if (action != null && !action.isEmpty()) {
            if (action.equals("add")) {
                // thêm người dung mới
                String name = req.getParameter("fullname");
                String email = req.getParameter("email");
                boolean gender = req.getParameter("gender").equals("male");
                int role = Integer.parseInt(req.getParameter("role"));
                Date dob = Date.valueOf(req.getParameter("dob"));
                String phone = req.getParameter("phone");
                RoleDTO roleDTO = new RoleDTO();
                roleDTO.setRoleId(role);
                AccountDTO accDTO = new AccountDTO();
                accDTO.setEmail(email);
                accDTO.setRole(roleDTO);
                accDTO.setIsActivated(0);
                boolean addStatus = _iUserAccountService.insertByAdmin(accDTO);
                if (addStatus) {
                    UserDTO userDTO = new UserDTO();
                    userDTO.setName(name);
                    accDTO.setAccId(_iUserAccountService.getByEmail(email).getAccId());
                    userDTO.setAccount(accDTO);
                    userDTO.setGender(gender);
                    userDTO.setPhone(phone);
                    userDTO.setDob(dob);
                    _iGenericUserService.insert(userDTO);
                    _iUserAccountService.sendEmail(email);
                    resp.sendRedirect(req.getContextPath() + "/dashboard/userList");
                } else {
                    req.setAttribute("error", "Account was registered");
                    resp.sendRedirect(req.getContextPath() + "/dashboard/userList");
                }
            }
            else if (action.equals("block")) {
                String roleblock_raw = req.getParameter("roleblock");
                int roleblock = Integer.parseInt(roleblock_raw);         
                _iUserService.blockAccountByRoleId(roleblock);
                resp.sendRedirect(req.getContextPath() + "/dashboard/userList");
            }
        }

    }

}
