/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.fpt.swp391_onlinelearning.service.iservice;

/**
 *
 * @author tran Hoang Phuc
 */
public interface ITempEnrollService {
     public boolean addTempEnrollment(int userId, String[] courseIds, int staffId);
     public void deleteTimeoutEnrollment(int userId);
}
