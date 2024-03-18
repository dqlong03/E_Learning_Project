/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.fpt.swp391_onlinelearning.controller;

import com.fpt.swp391_onlinelearning.baseController.BaseRequiredAuthorizationController;
import com.fpt.swp391_onlinelearning.dal.SettingListDAO;
import com.fpt.swp391_onlinelearning.dto.AccountDTO;
import com.fpt.swp391_onlinelearning.dto.FeatureDTO;
import com.fpt.swp391_onlinelearning.dto.SettingDTO;
import com.fpt.swp391_onlinelearning.dto.SettingTypeDTO;
import com.fpt.swp391_onlinelearning.service.SettingListService;
import com.fpt.swp391_onlinelearning.service.iservice.ISettingListService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Admin
 */
public class SettingListController extends BaseRequiredAuthorizationController {

    private static ISettingListService _iUserService;

    @Override
    public void init() {
        _iUserService = SettingListService.getInstance(new SettingListDAO(), new SettingListDAO());

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response, AccountDTO user, boolean isActivated, Set<FeatureDTO> features) throws ServletException, IOException {
//xử lý search
        String type_raw = request.getParameter("type");
        if (type_raw == null || type_raw.trim().length() == 0) {
            type_raw = "0";
        }
        int type = Integer.parseInt(type_raw);

        String name = request.getParameter("name");

        int pagesize = 8;

        String pageindex_raw = request.getParameter("page");
        if (pageindex_raw == null || pageindex_raw.trim().length() == 0) {
            pageindex_raw = "1";
        }
        int pageindex = Integer.parseInt(pageindex_raw);
        String order_raw = request.getParameter("order");
        if (order_raw == null || order_raw.trim().length() == 0) {
            order_raw = "0";
        }
        String status_raw = request.getParameter("status");
        if (status_raw == null || status_raw.length() == 0) {
            status_raw = "3";
        }
        int status = Integer.parseInt(status_raw);
        int order = Integer.parseInt(order_raw);
        int total = _iUserService.getCount(name, type, status);
        int totalpage = (total % pagesize == 0) ? total / pagesize : total / pagesize + 1;

        List<SettingDTO> s = _iUserService.getAll(pageindex, pagesize, name, type, status);
        List<SettingTypeDTO> st = _iUserService.getAllType();
        request.setAttribute("totalpage", totalpage);
        request.setAttribute("total", total);
        request.setAttribute("pageindex", pageindex);
        request.setAttribute("info", name);
        request.setAttribute("type", type);
        request.setAttribute("status", status);
        request.setAttribute("order", order);
        request.setAttribute("s", s);
        request.setAttribute("st", st);
        request.getRequestDispatcher("../view/settinglist.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response, AccountDTO user, boolean isActivated, Set<FeatureDTO> features) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action != null && !action.isEmpty()) {
            if (action.equals("add")) {
                // Xử lý add
                String typeAddRaw = request.getParameter("typeadd");
                int typeAdd = Integer.parseInt(typeAddRaw);
                int statusAdd = Integer.parseInt(request.getParameter("statusadd"));
                String nameAdd = request.getParameter("nameadd");
                _iUserService.insert(typeAdd, nameAdd, statusAdd);
            } else if (action.equals("edit")) {
                // Xử lý edit
                String typeEditRaw = request.getParameter("typeedit");
                int typeEdit = Integer.parseInt(typeEditRaw);
                int statusEdit = Integer.parseInt(request.getParameter("statusedit"));
                int orderEdit = Integer.parseInt(request.getParameter("order"));
                String nameEdit = request.getParameter("nameedit");
                _iUserService.update(typeEdit, orderEdit, nameEdit, statusEdit);
            }
            //chuyển tiếp
            response.sendRedirect(request.getContextPath() + "/dashboard/settingList");

        }
    }
}
