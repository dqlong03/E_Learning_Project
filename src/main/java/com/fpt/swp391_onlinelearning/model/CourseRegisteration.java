/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.swp391_onlinelearning.model;

import java.sql.Date;

/**
 *
 * @author tran Hoang Phuc
 */
public class CourseRegisteration {
    private int courseRegisterationId;
    private User user;
    private Course course;
    private Date createdTime;

    public int getCourseRegisterationId() {
        return courseRegisterationId;
    }

    public void setCourseRegisterationId(int courseRegisterationId) {
        this.courseRegisterationId = courseRegisterationId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }
    
    
}
