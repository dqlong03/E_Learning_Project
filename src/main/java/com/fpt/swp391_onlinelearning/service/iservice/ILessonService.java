/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.swp391_onlinelearning.service.iservice;

import com.fpt.swp391_onlinelearning.dto.ChapterDTO;
import com.fpt.swp391_onlinelearning.dto.LessonDTO;
import java.util.List;
import java.util.Map;

/**
 *
 * @author tran Hoang Phuc
 */
public interface ILessonService {

    public Map<ChapterDTO, List<LessonDTO>> getLessonByCourse(int courseId);

    public int getNumberOfLesson(Map<ChapterDTO, List<LessonDTO>> map);

    public Map<ChapterDTO, List<LessonDTO>> getLessonByUser(int courseId, int id);

    public int getCurrentLesson(int courseId, int userId);

    public int getNextLesson(int userId, int current);

    public int getFirstLessonId(int courseId);

    public int getLastLessonId(int courseId);

    public int getPreviousLesson(int userId, int current);

}
