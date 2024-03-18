/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.fpt.swp391_onlinelearning.service.iservice;

import com.fpt.swp391_onlinelearning.dto.CourseCategoryDTO;
import com.fpt.swp391_onlinelearning.dto.CourseDTO;
import java.util.List;

/**
 *
 * @author tran Hoang Phuc
 */
public interface ICourseService {

    public List<CourseDTO> getRecentlyCourses(int i);

    public int getCount(int ccid, String name, int levelid, int durationid, int languageid);

    public List<CourseDTO> getAllCourse(int pageindex, int pagesize, int sort, int ccid, String name, int levelid, int durationid, int languageid);

    public CourseDTO getCourseDetail(int courseId);

}
