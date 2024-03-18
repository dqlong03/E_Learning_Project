/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.fpt.swp391_onlinelearning.service.iservice;

import com.fpt.swp391_onlinelearning.dto.AccountDTO;
import com.fpt.swp391_onlinelearning.dto.CourseDTO;
import com.fpt.swp391_onlinelearning.dto.UserDTO;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author tran Hoang Phuc
 */
public interface ICourseService {

    public List<CourseDTO> getRecentlyCourses(int i);

    public int getCount(int ccid, String name, int levelid, int durationid, int languageid);

    public List<CourseDTO> getAllCourse(int pageindex, int pagesize, int sort,
            int ccid, String name, int levelid, int durationid, int languageid);

    public CourseDTO getCourseDetail(int courseId);

    public List<CourseDTO> getRegisteredCourseByUserId(UserDTO user, AccountDTO acc,
            String searchValue, String categoryId, String from, String to, String pageIndex);

    public int getNumRegisteredCourseByUserId(UserDTO user, AccountDTO acc,
            String searchValue, String categoryId, String from, String to);

    public List<CourseDTO> getAllCoursesPagger(String pageIndex, String searchInfor, String level, String category, String duration, String language);

    public int getTotalRecord(String searchInfor, String level, String category, String duration, String language);

    public void changeCourseStatus(String courseId, String status);

    public CourseDTO getCourseDetailAll(int courseId);

    public List<CourseDTO> getCourseByAuthor(String pageIndex ,String searchInfor, String level, String category, String duration, String language, int userId);

    public int getTotalRecordByAuthor(String pageIndex, String searchInfor, String level, String category, String duration, String language, int userId);

    public List<CourseDTO> getTempCourseEnrollmemt(int userId); 
}
