/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.fpt.swp391_onlinelearning.dal.idbcontex;

import com.fpt.swp391_onlinelearning.dto.AccountDTO;
import com.fpt.swp391_onlinelearning.model.Account;
import com.fpt.swp391_onlinelearning.model.Feature;
import java.util.Set;

/**
 *
 * @author tran Hoang Phuc
 */
public interface IFeatureDAO {
    public Set<Feature> getFeatureByRole(Account a, String url);
}
