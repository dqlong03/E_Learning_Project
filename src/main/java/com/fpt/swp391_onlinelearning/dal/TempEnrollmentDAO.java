/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.swp391_onlinelearning.dal;

import com.fpt.swp391_onlinelearning.dal.idal.ITempEnrollmentDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tran Hoang Phuc
 */
public class TempEnrollmentDAO implements ITempEnrollmentDAO {

    @Override
    
    public void addTempEnrollment(int userId, String[] courseIds, int staffId) {
        Connection connection = DBContext.getConnection();
        String sql = "INSERT INTO `swp391_onlinelearning`.`tempenrollment` (`userId`, `courseId`, `createdBy`, `createdTime`) VALUES ";
        for (int i = 0; i < courseIds.length; i++) {
            sql += "(?, ?, ?, NOW()),";
        }
        // Remove the last comma
        sql = sql.substring(0, sql.length() - 1);
        
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            int index = 1;
            for (String courseId : courseIds) {
                stm.setInt(index++, userId);
                stm.setInt(index++, Integer.parseInt(courseId));
                stm.setInt(index++, staffId);
            }
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TempEnrollmentDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBContext.close(connection);
        }    
    }

    @Override
    public boolean canJoin(int userId, int courseId) {
        Connection connection = DBContext.getConnection();
        int num = 0;
        String sql = "SELECT COUNT(*) AS `num` FROM `swp391_onlinelearning`.`tempenrollment`\n"
                + "WHERE `userId` = ? AND `courseId` = ?;";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, userId);
            stm.setInt(2, courseId);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                num = rs.getInt("num");
            }
        } catch (SQLException ex) {
            Logger.getLogger(TempEnrollmentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return num == 0;
    }
    
    @Override
    public boolean deleteEnrollment(int userId, int courseId) {
        Connection connection = DBContext.getConnection();
        String sql = "DELETE FROM tempenrollment where userId = ? AND courseId = ?";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, userId);
            stm.setInt(2, courseId);
            stm.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(TempEnrollmentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public void deleteTimeoutEnrollment(int userId) {
        Connection connection = DBContext.getConnection();
        String sql = "DELETE FROM tempenrollment WHERE userId = ? AND createdTime <= NOW() - INTERVAL 3 DAY;";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, userId);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TempEnrollmentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }       
}
