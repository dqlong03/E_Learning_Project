/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.swp391_onlinelearning.model;

import java.util.Date;

/**
 *
 * @author tran Hoang Phuc
 */
public class Account {
    private int accId;
    private String email;
    private String pass;
    private int isActivated;
    private Date createdTime;
    private Role role;
    private String otp;
    private java.sql.Date registeredTime;
    public String getOtp() {
        return otp;
    }

    public java.sql.Date getRegisteredTime() {
        return registeredTime;
    }

    public void setRegisteredTime(java.sql.Date registeredTime) {
        this.registeredTime = registeredTime;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }
    

    public int getAccId() {
        return accId;
    }

    public void setAccId(int accId) {
        this.accId = accId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getIsActivated() {
        return isActivated;
    }

    public void setIsActivated(int isActivated) {
        this.isActivated = isActivated;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
    
    
}
