/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.swp391_onlinelearning.dto;

import java.util.Date;

/**
 *
 * @author tran Hoang Phuc
 */
public class TempEnrollmentDTO {
    private UserDTO user;
    private CourseDTO course;
    private UserDTO staff;
    private Date createdTime;

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public CourseDTO getCourse() {
        return course;
    }

    public void setCourse(CourseDTO course) {
        this.course = course;
    }

    public UserDTO getStaff() {
        return staff;
    }

    public void setStaff(UserDTO staff) {
        this.staff = staff;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }
    
}
