/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.fpt.swp391_onlinelearning.service.iservice;

import com.fpt.swp391_onlinelearning.dto.CourseRegistrationDTO;
import java.sql.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author tran Hoang Phuc
 */
public interface ICourseRegistrationService {

    public List<CourseRegistrationDTO> getRegisterdCourse(int id);

    public int countNumberOfPageSearch(String email, String courseName, int category, int duration, Date startTime, Date endTime);

    public List<CourseRegistrationDTO> searchCourseRegistrations(String email, String courseName, int category, int duration, Date startTime, Date endTime, int pageIndex);

    public List<Integer> getCountRegList();

    public List<Integer> getTotalIncomeList();

    public boolean addNewEnrollments(int userId, String[] courses);

    public long getTotalIncome(String email, String courseName, int category, int duration, Date startTime, Date endTime);

    public List<CourseRegistrationDTO> getCourseRegistrationDTO(int pageIndex, int pageSize, Date from, Date to);

    public List<CourseRegistrationDTO> getCourseRegistrationDTO(Date from, Date to);

    public int getCourseRegistrationAmount(Date from, Date to);

    public List<Integer> getCourseRegistrationAmount();

    public List<Integer> getMonthlyRevenueList();

    public Map<CourseRegistrationDTO, Integer> getCoursesTrend(int daysOfCourseTrend);

    public int getNumberOfRemainningCourse(Map<CourseRegistrationDTO, Integer> courseTrend, int daysOfCourseTrend);

    public int getMonthRevenue(int currentMonth);

    public int getTotalRegistrationRevenus(Date from, Date to);

    public boolean canJoin(int courseId, int userId);

    public List<CourseRegistrationDTO> getUserRecentlyCourse(int numOfCourse, int userID);

    public void sendEmail(String mailTo, String titleMail, List<String> bodies);

    public List<String> getEnrollmentLink(int userId, String[] courses);

}
