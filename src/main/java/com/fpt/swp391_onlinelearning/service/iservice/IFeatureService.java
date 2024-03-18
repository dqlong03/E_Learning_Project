/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.fpt.swp391_onlinelearning.service.iservice;

import com.fpt.swp391_onlinelearning.dto.AccountDTO;
import com.fpt.swp391_onlinelearning.dto.FeatureDTO;
import java.util.Set;

/**
 *
 * @author tran Hoang Phuc
 */
public interface IFeatureService {
    public Set<FeatureDTO> getFeatureByRole(AccountDTO a, String url);
}
