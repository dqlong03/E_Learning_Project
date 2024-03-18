/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.fpt.swp391_onlinelearning.dal.idal;

/**
 *
 * @author tran Hoang Phuc
 */
public interface ITempEnrollmentDAO {

    public void addTempEnrollment(int userId, String[] courseId, int staffId);

    public boolean canJoin(int userId, int courseId);

    public boolean deleteEnrollment(int userId, int courseId);
    
    public void deleteTimeoutEnrollment(int userId);
}
