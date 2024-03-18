/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.swp391_onlinelearning.service;

import com.fpt.swp391_onlinelearning.convert.Converter;
import com.fpt.swp391_onlinelearning.dal.idal.IUserLessonDAO;
import com.fpt.swp391_onlinelearning.dto.ChapterDTO;
import com.fpt.swp391_onlinelearning.dto.UserLessonDTO;
import com.fpt.swp391_onlinelearning.model.Chapter;
import com.fpt.swp391_onlinelearning.model.UserLesson;
import com.fpt.swp391_onlinelearning.service.iservice.IUserLessonService;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author tran Hoang Phuc
 */
public class UserLessonService implements IUserLessonService {

    private static UserLessonService userLessonService;

    private IUserLessonDAO _iUserLessonDAO;

    public UserLessonService(IUserLessonDAO _iUserLessonDAO) {
        this._iUserLessonDAO = _iUserLessonDAO;
    }

    public static UserLessonService getInstance(IUserLessonDAO _iUserLessonDAO) {
        if (userLessonService == null) {
            userLessonService = new UserLessonService(_iUserLessonDAO);
        }
        return userLessonService;
    }

    @Override
    public Map<ChapterDTO, List<UserLessonDTO>> getLessonByUser(int courseId, int userId) {
        Map<Chapter, List<UserLesson>> chapterMap = _iUserLessonDAO.getLessonByUser(courseId, userId);
        Map<ChapterDTO, List<UserLessonDTO>> linkMap = new LinkedHashMap<>();
        for (Map.Entry<Chapter, List<UserLesson>> entry : chapterMap.entrySet()) {
            ChapterDTO key = Converter.toDto(entry.getKey());
            List<UserLesson> values = entry.getValue();
            List<UserLessonDTO> dtos = new ArrayList<>();
            for (UserLesson value : values) {
                dtos.add(Converter.toDto(value));
            }
            linkMap.put(key, dtos);
        }
        return linkMap;
    }

    @Override
    public void markAsDone(int userId, int lessonId) {
        _iUserLessonDAO.markAsDone(userId, lessonId);   
    }

}
