/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.swp391_onlinelearning.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
}
