/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.swp391_onlinelearning.util;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author tran Hoang Phuc
 */
public class SessionUtil<T> {

    private static SessionUtil sessionUtils;

    public static SessionUtil getSessionUtils() {
        if (sessionUtils == null) {
            sessionUtils = new SessionUtil<>();
        }
        return sessionUtils;
    }

    public void saveSession(String name, String value, HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute(name.toUpperCase(), value);
        session.setMaxInactiveInterval(60 * 60 * 24);
    }

    public String getSessionString(String name, HttpServletRequest request) {
        HttpSession session = request.getSession();
        return (String) session.getAttribute(name.toUpperCase());
    }

    public void removeSession(String name, HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.removeAttribute(name.toUpperCase());
    }

    public void saveSessionModel(String name, T value, HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute(name.toUpperCase(), value);
        session.setMaxInactiveInterval(60 * 60 * 24);
    }

    public T getSessionModel(String name, HttpServletRequest request) {
        HttpSession session = request.getSession();
        return (T) session.getAttribute(name.toUpperCase());
    }
}
