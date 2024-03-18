/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.fpt.swp391_onlinelearning.service.iservice;

import com.fpt.swp391_onlinelearning.dto.ChapterDTO;
import com.fpt.swp391_onlinelearning.dto.UserLessonDTO;
import java.util.List;
import java.util.Map;

/**
 *
 * @author tran Hoang Phuc
 */
public interface IUserLessonService {

    public Map<ChapterDTO, List<UserLessonDTO>> getLessonByUser(int courseId, int userId);

    public void markAsDone(int userId, int lessonId);

}
