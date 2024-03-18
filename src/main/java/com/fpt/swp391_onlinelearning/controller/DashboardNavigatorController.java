/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.swp391_onlinelearning.controller;

import com.fpt.swp391_onlinelearning.baseController.BaseRequiredAuthorizationController;
import com.fpt.swp391_onlinelearning.dto.AccountDTO;
import com.fpt.swp391_onlinelearning.dto.FeatureDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

/**
 *
 * @author tran Hoang Phuc
 */
public class DashboardNavigatorController extends BaseRequiredAuthorizationController {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp, AccountDTO user, boolean isActivated, Set<FeatureDTO> features) throws ServletException, IOException {
        AccountDTO acc = (AccountDTO) req.getSession().getAttribute("session");
        if (acc != null) {
            if (acc.getRole().getRoleId() == 2) {
                resp.sendRedirect(req.getContextPath() + "/dashboard/course");
                return;
            }
            if (acc.getRole().getRoleId() == 3) {
                resp.sendRedirect(req.getContextPath() + "/dashboard/report");
                return;
            }
            if (acc.getRole().getRoleId() == 4) {
                resp.sendRedirect(req.getContextPath() + "/dashboard/course");
                return;
            }
            if (acc.getRole().getRoleId() == 5) {
                resp.sendRedirect(req.getContextPath() + "/dashboard/userList");
                return;
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp, AccountDTO user, boolean isActivated, Set<FeatureDTO> features) throws ServletException, IOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
