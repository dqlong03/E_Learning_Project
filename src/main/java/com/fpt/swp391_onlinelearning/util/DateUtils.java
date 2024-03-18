/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.swp391_onlinelearning.util;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.sql.Date;
import java.time.Month;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
/**
 *
 * @author phuc2
 */
public class DateUtils {
    public static Date getFirstDayOfCurrentWeek() {
        // Lấy ngày hiện tại
        LocalDate today = LocalDate.now();

        // Tính toán để lấy ngày đầu tiên của tuần hiện tại
        LocalDate firstDayOfCurrentWeek = today.with(DayOfWeek.MONDAY);
        Date firstDayOfWeek= Date.valueOf(firstDayOfCurrentWeek);

        return firstDayOfWeek;
    }
    public static Date getLastDayOfCurrentWeek() {
        // Lấy ngày hiện tại
        LocalDate today = LocalDate.now();

        // Tính toán để lấy ngày đầu tiên của tuần hiện tại
        LocalDate lastDayOfCurrentWeek = today.with(DayOfWeek.SUNDAY);
        Date lastDayOfWeek= Date.valueOf(lastDayOfCurrentWeek);

        return lastDayOfWeek;
    }
    public static List<Date> getDatesOfCurrentWeek() {
        List<Date> dates = new ArrayList<>();
        Calendar cal = Calendar.getInstance();  // gets the current date and time
        
        // Set the calendar to the start of today
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);

        // Determine the offset from the first day of the week (in this case, we consider Monday as the first day)
        int offset = cal.get(Calendar.DAY_OF_WEEK) - Calendar.MONDAY;
        // If it's negative, we are in a week which is 'split' by the month end (e.g., Sunday is in the new month)
        if (offset < 0) {
            offset += 7;
        }

        // Rewind the calendar to last Monday. It's the start of the week
        cal.add(Calendar.DATE, -offset);

        // Loop to construct the list of dates
        for (int i = 0; i < 7; i++) {  // 7 days in a week
            Date sqlDate = new Date(cal.getTimeInMillis()); // convert to java.sql.Date
            dates.add(sqlDate);
            cal.add(Calendar.DATE, 1);  // move to the next day
        }

        return dates;
    }
    public static Date getDaysAgo(int days) {
        // Lấy ngày hiện tại
        LocalDate currentDate = LocalDate.now();

        // Trừ 7 ngày để có được ngày cách đây 7 ngày
        LocalDate daysAgo = currentDate.minusDays(days);

        // Chuyển đổi từ java.time.LocalDate sang java.sql.Date
        Date daysAgoSql = Date.valueOf(daysAgo);

        return daysAgoSql;
    }
    
    public static Date getCurentDate() {
        // Lấy ngày hiện tại
        LocalDate currentDate = LocalDate.now();
        // Chuyển đổi từ java.time.LocalDate sang java.sql.Date
        Date date = Date.valueOf(currentDate);

        return date;
    }
    
    public static int getCurrentMonth()
    {
        LocalDate currentDate = LocalDate.now();

        // Lấy tháng từ ngày hiện tại
        Month currentMonth = currentDate.getMonth();

        // In ra tháng hiện tại (dưới dạng số và tên)
        int monthValue = currentMonth.getValue();
        return monthValue;
    }
    
    public static int getPreviousMonth()
    {
        LocalDate currentDate = LocalDate.now();
        
        LocalDate previousMonthDate = currentDate.minusMonths(1);

        // Lấy tháng từ ngày trước đó
        Month previousMonth = previousMonthDate.getMonth();

        // In ra tháng trước đó (dưới dạng số và tên)
        int previousMonthValue = previousMonth.getValue();
        
        return previousMonthValue;
    }
    public static Date getFirstDateOfLastWeek()
    {
        LocalDate currentDate = LocalDate.now();
        DayOfWeek currentDayOfWeek = currentDate.getDayOfWeek();

        // Tìm ngày thứ 2 của tuần trước
        LocalDate previousMonday = currentDate.minusDays(currentDayOfWeek.getValue() + 6);

        // Chuyển đổi thành java.sql.Date
        return Date.valueOf(previousMonday);
    }
    
    public static Date getLasDateOfLastWeek()
    {
        LocalDate currentDate = LocalDate.now();
        DayOfWeek currentDayOfWeek = currentDate.getDayOfWeek();

        // Tìm ngày Chủ nhật của tuần trước
        LocalDate previousSunday = currentDate.minusDays(currentDayOfWeek.getValue());

        // Chuyển đổi thành java.sql.Date
        return Date.valueOf(previousSunday);
    }
    
    public static Date getLastDateOfCurrentMonth()
    {
        java.util.Date currentDate = new java.util.Date();
        java.sql.Date sqlDate = new java.sql.Date(currentDate.getTime());

        // Sử dụng Calendar để thao tác với ngày
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(sqlDate);

        // Đặt ngày là ngày cuối cùng của tháng
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));

        // Lấy ngày cuối cùng của tháng
        java.sql.Date lastDayOfMonth = new java.sql.Date(calendar.getTimeInMillis());
        
        return lastDayOfMonth;
        
    }
    
    public static Date getFirstDateOfCurrentMonth()
    {
        java.util.Date currentDate = new java.util.Date();
        java.sql.Date sqlDate = new java.sql.Date(currentDate.getTime());

        // Sử dụng Calendar để thao tác với ngày
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(sqlDate);

        // Đặt ngày là ngày đầu tiên của tháng
        calendar.set(Calendar.DAY_OF_MONTH, 1);

        // Lấy ngày đầu tiên của tháng
        java.sql.Date firstDayOfMonth = new java.sql.Date(calendar.getTimeInMillis());
        
        return firstDayOfMonth;
    }
}
