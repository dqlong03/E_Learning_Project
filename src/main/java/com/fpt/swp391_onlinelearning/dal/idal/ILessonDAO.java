/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.swp391_onlinelearning.dal.idal;

import com.fpt.swp391_onlinelearning.model.Chapter;
import com.fpt.swp391_onlinelearning.model.Lesson;
import java.util.List;
import java.util.Map;

/**
 *
 * @author tran Hoang Phuc
 */
public interface ILessonDAO {

    public Map<Chapter, List<Lesson>> getLessonByCourse(int courseId);
    
    public int getCurrentLesson(int courseId, int userId);

    public int getNextLesson(int userId, int current);
    
    public int getFirstLessonId(int courseId);
    
    public int getLastLessonId(int courseId);
    
    public int getPreviousLesson(int userId, int current);
    
    public List<Lesson> getLessonsByCourse(int courseId);
}
