/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.swp391_onlinelearning.model;

import java.util.Set;

/**
 *
 * @author tran Hoang Phuc
 */
public class Role {

    private int roleId;
    private String name;
    private Set<Feature> features;
    private SettingType type;

    public SettingType getType() {
        return type;
    }

    public void setType(SettingType type) {
        this.type = type;
    }
    public Set<Feature> getFeatures() {
        return features;
    }

    public void setFeatures(Set<Feature> features) {
        this.features = features;
    }

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

}
