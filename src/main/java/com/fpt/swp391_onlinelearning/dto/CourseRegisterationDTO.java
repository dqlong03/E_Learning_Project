/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.swp391_onlinelearning.dto;

import java.sql.Date;

/**
 *
 * @author tran Hoang Phuc
 */
public class CourseRegisterationDTO {
    private int courseRegisterationId;
    private UserDTO user;
    private CourseDTO course;
    private Date createdTime;

    public int getCourseRegisterationId() {
        return courseRegisterationId;
    }

    public void setCourseRegisterationId(int courseRegisterationId) {
        this.courseRegisterationId = courseRegisterationId;
    }

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

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }
    
}
