/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.swp391_onlinelearning.service;

import com.fpt.swp391_onlinelearning.convert.Converter;
import com.fpt.swp391_onlinelearning.dal.FeatureDAO;
import com.fpt.swp391_onlinelearning.dal.idal.IFeatureDAO;
import com.fpt.swp391_onlinelearning.dto.AccountDTO;
import com.fpt.swp391_onlinelearning.dto.FeatureDTO;
import com.fpt.swp391_onlinelearning.dto.RoleDTO;
import com.fpt.swp391_onlinelearning.model.Feature;
import com.fpt.swp391_onlinelearning.service.iservice.IFeatureService;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author tran Hoang Phuc
 */
public class FeatureService implements IFeatureService{
    private static FeatureService featureService;
    
    private IFeatureDAO _iFeatureDAO;

    public FeatureService(IFeatureDAO _iFeatureDAO) {
        this._iFeatureDAO = _iFeatureDAO;
    }
    
    public static FeatureService getInstance(IFeatureDAO _iFeatureDAO) {
        if (featureService == null) {
            featureService = new FeatureService(_iFeatureDAO);
        }
        return featureService;
    }
    
    @Override
    public Set<FeatureDTO> getFeatureByRole(AccountDTO a, String url) {
        Set<Feature> features =  _iFeatureDAO.getFeatureByRole(Converter.toDomain(a), url);
        Set<FeatureDTO> featureDTOs = new HashSet<>();
        for (Feature feature : features) {
            featureDTOs.add(Converter.toDTO(feature));
        }
        return featureDTOs;
    }
    
    
}
