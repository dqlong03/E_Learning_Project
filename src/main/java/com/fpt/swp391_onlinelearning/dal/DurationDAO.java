/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.swp391_onlinelearning.dal;

import com.fpt.swp391_onlinelearning.dal.idal.IDAO;
import com.fpt.swp391_onlinelearning.dal.idal.IDurationDAO;
import com.fpt.swp391_onlinelearning.model.Duration;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class DurationDAO implements IDAO<Duration>, IDurationDAO {

    @Override
    public List<Duration> getAll() {
        Connection connection = DBContext.getConnection();
        ArrayList<Duration> level = new ArrayList<>();
        try {
            String sql = "SELECT durationId,name FROM `duration`";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Duration l = new Duration();
                l.setDurationId(rs.getInt("durationId"));
                l.setName(rs.getString("name"));
                level.add(l);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CourseDAO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } finally {
            DBContext.close(connection);
        }
        return level;
    }

    @Override
    public Duration get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean update(Duration t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean insert(Duration t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Duration> getAllDuration() {
        Connection connection = DBContext.getConnection();
        ArrayList<Duration> level = new ArrayList<>();
        try {
            String sql = "SELECT durationId,name FROM `duration` where isActivated=true";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Duration l = new Duration();
                l.setDurationId(rs.getInt("durationId"));
                l.setName(rs.getString("name"));
                level.add(l);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CourseDAO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } finally {
            DBContext.close(connection);
        }
        return level;
    }

}
