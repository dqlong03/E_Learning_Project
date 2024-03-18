/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.swp391_onlinelearning.baseController;

import com.fpt.swp391_onlinelearning.dal.FeatureDAO;
import com.fpt.swp391_onlinelearning.dto.AccountDTO;
import com.fpt.swp391_onlinelearning.dto.FeatureDTO;
import com.fpt.swp391_onlinelearning.service.FeatureService;
import com.fpt.swp391_onlinelearning.service.iservice.IFeatureService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

/**
 *
 * @author tran Hoang Phuc
 */
public abstract class BaseRequiredAuthorizationController extends BaseRequiredVerifyController {

    private IFeatureService _iFeatureService;

    public boolean isAuthorized(AccountDTO account, String url) {
        _iFeatureService = FeatureService.getInstance(new FeatureDAO());
        Set<FeatureDTO> featureDtos = _iFeatureService.getFeatureByRole(account, url);
        account.getRole().setFeatures(featureDtos);
        return !featureDtos.isEmpty();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response, AccountDTO user, boolean isActivated) throws ServletException, IOException {
        if (isAuthorized(user, request.getServletPath())) {
            doGet(request, response, user, isActivated, user.getRole().getFeatures());
        } else {
            String path = request.getServletPath();
            if (path.contains("dashboard/")) {
                response.sendRedirect(request.getContextPath() + "/dashboard");
            } else {
                response.sendRedirect(request.getContextPath() + "/home");
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response, AccountDTO user, boolean isActivated) throws ServletException, IOException {
        if (isAuthorized(user, request.getServletPath())) {
            doPost(request, response, user, isActivated, user.getRole().getFeatures());
        } else {
            String path = request.getServletPath();
            if (path.contains("dashboard/")) {
                response.sendRedirect(request.getContextPath() + "/dashboard");
            } else {
                response.sendRedirect(request.getContextPath() + "/home");
            }
        }
    }

    protected abstract void doGet(HttpServletRequest req, HttpServletResponse resp, AccountDTO user, boolean isActivated, Set<FeatureDTO> features) throws ServletException, IOException;

    protected abstract void doPost(HttpServletRequest req, HttpServletResponse resp, AccountDTO user, boolean isActivated, Set<FeatureDTO> features) throws ServletException, IOException;

}
