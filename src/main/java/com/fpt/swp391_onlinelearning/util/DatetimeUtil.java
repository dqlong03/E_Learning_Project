/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.swp391_onlinelearning.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tran Hoang Phuc
 */
public class DatetimeUtil {
    public static Date toDateTime(String s) {
          SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");

        try {
            Date date = dateFormat.parse(s);
            return date;
        } catch (ParseException e) {
        }
        return new Date();
    }
    
    public static java.sql.Date getFollowingDate(String current) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date currentDate = sdf.parse(current);

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(currentDate);
            calendar.add(Calendar.DAY_OF_MONTH, 1);

            java.sql.Date followingDate = new java.sql.Date(calendar.getTimeInMillis());
            return followingDate;
        } catch (ParseException e) {
            e.printStackTrace(); // Handle the exception according to your requirements
            return null;
        }
    }
    
    public static String getCurrentSqlDateString() {
        java.sql.Date currentDate = new java.sql.Date(System.currentTimeMillis());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = sdf.format(currentDate);
        return formattedDate;
    }
    
    
    public static java.sql.Date getMondayOfCurrentWeek() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        return new java.sql.Date(calendar.getTimeInMillis());
    }

    public static java.sql.Date getSundayOfCurrentWeek() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        calendar.add(Calendar.DAY_OF_MONTH, 7); // Di chuyển đến cuối tuần
        return new java.sql.Date(calendar.getTimeInMillis());
    }

    public static List<java.sql.Date> getSQLDatesBetween(String start, String end) throws ParseException {
        List<java.sql.Date> dates = new ArrayList<>();

        // Define a simple date format, e.g., "2023-01-01"
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        // Parse the start and end dates
        java.util.Date parsedStartDate = dateFormat.parse(start);
        java.util.Date parsedEndDate = dateFormat.parse(end);

        // Set the calendar to start date
        Calendar cal = Calendar.getInstance();
        cal.setTime(parsedStartDate);

        // Loop through the dates and add them to the list
        while (!cal.getTime().after(parsedEndDate)) {
            dates.add(new java.sql.Date(cal.getTime().getTime())); // Add the SQL date to the list
            cal.add(Calendar.DATE, 1); // Go to the next day
        }

        return dates;
    }
    
    public static List<java.sql.Date> getCurrentWeekDates(){
        java.sql.Date monday = DatetimeUtil.getMondayOfCurrentWeek();
        java.sql.Date sunday = DatetimeUtil.getSundayOfCurrentWeek();
        List<java.sql.Date> dates = new ArrayList<>();
        try {
            dates = DatetimeUtil.getSQLDatesBetween(monday.toString(), sunday.toString());
        } catch (ParseException ex) {
            Logger.getLogger(DatetimeUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dates;
    }

}
