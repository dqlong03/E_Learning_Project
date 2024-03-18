/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.fpt.swp391_onlinelearning.dal.idal;

import com.fpt.swp391_onlinelearning.model.CourseRegistration;
import java.sql.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author tran Hoang Phuc
 */
public interface ICourseRegistrationDAO {

    public List<CourseRegistration> getRegisterdCourse(int id);

    public int countSearchRecord(String email, String courseName, int category, int duration, Date startTime, Date endTime);

    public List<CourseRegistration> searchCourseRegistrations(String email, String courseName, int category, int duration, Date startTime, Date endTime, int pageIndex);

    public int countRegisterCourseByDay(String date);

    public int totalIncomeByDay(String date);

    public boolean addNewEnrollments(int userId, String[] courses);

    public long getTotalIncome(String email, String courseName, int category, int duration, Date startTime, Date endTime);

    public List<CourseRegistration> getCourseRegistration(int pageIndex, int pageSize, Date from, Date to);

    public int getCourseRegistrationAmount(Date from, Date to);

    public int getTotalRegistrationRevenus(Date from, Date to);

    public int getCourseRegistrationAmount(Date date);

    public int getMonthRevenue(int month);

    public Map<CourseRegistration, Integer> getCoursesTrend(int periodOfDays);

    public List<CourseRegistration> getCourseRegistration(Date from, Date to);

    public boolean canJoin(int courseId, int userId);

    public List<CourseRegistration> getUserRecentlyCourse(int numberOfCourse, int userId);

    public CourseRegistration getRegistration(int userId, int courseId);

}
