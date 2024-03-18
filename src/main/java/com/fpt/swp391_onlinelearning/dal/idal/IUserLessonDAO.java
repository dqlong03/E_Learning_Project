/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.swp391_onlinelearning.dal.idal;

import com.fpt.swp391_onlinelearning.model.Chapter;
import com.fpt.swp391_onlinelearning.model.Lesson;
import com.fpt.swp391_onlinelearning.model.UserLesson;
import java.util.List;
import java.util.Map;

/**
 *
 * @author tran Hoang Phuc
 */
public interface IUserLessonDAO {

    public void addUserLessons(int userId, List<Lesson> lesson);

    public Map<Chapter, List<UserLesson>> getLessonByUser(int courseId, int userId);
    
    public void markAsDone(int userId, int lessonId);

}
