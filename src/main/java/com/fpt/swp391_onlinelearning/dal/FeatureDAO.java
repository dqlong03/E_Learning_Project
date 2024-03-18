/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.swp391_onlinelearning.dal;

import com.fpt.swp391_onlinelearning.dal.idal.IDAO;
import com.fpt.swp391_onlinelearning.dal.idal.IFeatureDAO;
import com.fpt.swp391_onlinelearning.model.Account;
import com.fpt.swp391_onlinelearning.model.Feature;
import com.fpt.swp391_onlinelearning.model.Role;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tran Hoang Phuc
 */
public class FeatureDAO extends DBContext implements IDAO<Feature>, IFeatureDAO {

    @Override
    public List<Feature> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Feature get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean update(Feature t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean insert(Feature t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Set<Feature> getFeatureByRole(Account a, String url) {
        Connection connection = DBContext.getConnection();
        Set<Feature> features = new HashSet<>();
        String sql = "SELECT rf.`roleId` , rf.`featureId`, f.`name` \n"
                + "FROM `swp391_onlinelearning`.`rolefeature` rf \n"
                + "JOIN `swp391_onlinelearning`.`feature` f \n"
                + "ON rf.`featureId` = f.`featureId` \n"
                + "WHERE rf.`roleId` = ? AND f.`name` = ?";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, a.getRole().getRoleId());
            stm.setString(2, url);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Feature feature = new Feature();
                feature.setFeatureId(rs.getInt("featureId"));
                feature.setName(rs.getString("name"));
                features.add(feature);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FeatureDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBContext.close(connection);
        }
        return features;
    }
}
