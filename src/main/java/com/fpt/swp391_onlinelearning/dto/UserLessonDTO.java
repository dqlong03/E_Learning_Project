/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.swp391_onlinelearning.dto;

/**
 *
 * @author tran Hoang Phuc
 */
public class UserLessonDTO {
     private int userLessonId;
    private UserDTO user;
    private LessonDTO lesson;
    private boolean finish;

    public int getUserLessonId() {
        return userLessonId;
    }

    public void setUserLessonId(int userLessonId) {
        this.userLessonId = userLessonId;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public LessonDTO getLesson() {
        return lesson;
    }

    public void setLesson(LessonDTO lesson) {
        this.lesson = lesson;
    }

    public boolean isFinish() {
        return finish;
    }

    public void setFinish(boolean finish) {
        this.finish = finish;
    }

    
}
