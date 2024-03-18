/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.swp391_onlinelearning.dto;

import java.util.Set;

/**
 *
 * @author tran Hoang Phuc
 */
public class RoleDTO {

    private int roleId;
    private String name;
    private Set<FeatureDTO> features;

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<FeatureDTO> getFeatures() {
        return features;
    }

    public void setFeatures(Set<FeatureDTO> features) {
        this.features = features;
    }
    
}
