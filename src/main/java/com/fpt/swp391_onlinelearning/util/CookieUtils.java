/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.swp391_onlinelearning.util;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author tran Hoang Phuc
 */
public class CookieUtils {

    private static CookieUtils cookieUtils;

    public String getCookieUtils(String name, HttpServletRequest request) {
        Cookie[] cookie = request.getCookies();
        if (cookie != null) {
            for (Cookie x : cookie) {
                if (x.getName().equalsIgnoreCase(name.toUpperCase())) {
                    return x.getValue();
                }
            }
        }
        return null;
    }

    public void setCookieUtils(String name, String value, HttpServletResponse response) {
        Cookie cookie = new Cookie(name.toUpperCase(), value);
        cookie.setMaxAge(60 * 60 * 24 * 30);
        cookie.setPath("/");
        response.addCookie(cookie);
    }

    public static CookieUtils getCookieUtils() {
        if (cookieUtils == null) {
            cookieUtils = new CookieUtils();
        }
        return cookieUtils;
    }
}
