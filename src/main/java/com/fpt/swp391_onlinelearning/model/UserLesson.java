/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.swp391_onlinelearning.model;

/**
 *
 * @author tran Hoang Phuc
 */
public class UserLesson {
    private int userLessonId;
    private User user;
    private Lesson lesson;
    private boolean finish;

    public int getUserLessonId() {
        return userLessonId;
    }

    public void setUserLessonId(int userLessonId) {
        this.userLessonId = userLessonId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }

    public boolean isFinish() {
        return finish;
    }

    public void setFinish(boolean finish) {
        this.finish = finish;
    }
    
    
}
