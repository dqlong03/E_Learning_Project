/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.fpt.swp391_onlinelearning.dal.idal;

import com.fpt.swp391_onlinelearning.model.Course;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author tran Hoang Phuc
 */
public interface ICourseDAO {

    public List<Course> getRecentlyCourse(int numberOfCourses);

    public int getCount(int ccid, String name, int levelid, int durationid, int languageid);

    public List<Course> getAllCourse(int pageindex, int pagesize, int sort, int ccid, String name, int levelid, int durationid, int languageid);

    public Course getCourseDetail(int courseId);

    public List<Course> getUserRegisterdCourse(int userId, String searchValue, int categoryId, Date from, Date to, int pageIndex);

    public int getNumOfUserRegisterdCourse(int userId, String searchValue, int categoryId, Date from, Date to);

    public List<Course> searchCourse(String infor);

    public int countSearchRecord(String infor);
       
    public List<Course> getAllCoursesPagger(int pageIndex, String searchInfor, int level, int category, int duration, int language);
    
    public int getTotalRecord(String searchInfor, int level, int category, int duration, int language);
    
    public void changeCourseStatus(int courseId, boolean status);
    
    public Course getCourseDetailAll(int courseId);

    public List<Course> getCourseByAuthor(int pageIndex, String searchInfor, int level, int category, int duration, int language, int userId);

    public int getTotalRecordByAuthor(String searchInfor, int level, int category, int duration, int language, int userId);

}
