/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.swp391_onlinelearning.util;

import jakarta.servlet.http.HttpServletRequest;

/**
 *
 * @author phuc2
 */
public class URLUtils {
    public static String getFirstURLPatternLevel(HttpServletRequest request)
    {
        String contextPath = request.getContextPath();
        String servletPath = request.getServletPath();
        String reqURI = request.getRequestURI();
        
        // Tách chuỗi bằng dấu "/"
        String[] parts = reqURI.split("/");
        
        // Lấy phần "level đầu tiên"
        String firstURLPattern = (parts.length > 2) ? parts[2] : "";
        
        return firstURLPattern;
    }
}
