/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.swp391_onlinelearning.dal;

import com.fpt.swp391_onlinelearning.dal.idbcontex.ISliderDAO;
import com.fpt.swp391_onlinelearning.model.Slider;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author phuc2
 */
public class SliderDAO implements ISliderDAO {

    @Override
    public List<Slider> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Slider get(int id) {
        Connection connection= DBContext.getConnection();
        try {
            String sql = "SELECT sliderId,img, title, linkDetail, description, `status` FROM slider\n"
                    + "WHERE sliderId=?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                Slider slider = new Slider();
                slider.setSliderID(rs.getInt("sliderId"));
                slider.setImg(rs.getString("img"));
                slider.setTitle(rs.getString("title"));
                slider.setLinkDetail(rs.getString("linkDetail"));
                slider.setDescription(rs.getString("description"));
                slider.setStatus(rs.getInt("status"));

                return slider;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            DBContext.close(connection);
        }
        return null;

    }

    @Override
    public boolean update(Slider t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean insert(Slider t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Slider> getListOfSlider(String link) {
        Connection connection= DBContext.getConnection();
        List<Slider> sliderList = new ArrayList<Slider>();
        try {
            String sql = "SELECT sliderId,img, title, linkDetail, description, `status` FROM slider\n"
                    + "WHERE linkDetail=?;";
            PreparedStatement stm= connection.prepareStatement(sql);
            stm.setString(1, link);
            ResultSet rs= stm.executeQuery();
            while(rs.next())
            {
                Slider s= new Slider();
                s.setSliderID(rs.getInt("sliderId"));
                s.setImg(rs.getString("img"));
                s.setTitle(rs.getString("title"));
                s.setLinkDetail(rs.getString("linkDetail"));
                s.setDescription(rs.getString("description"));
                s.setStatus(rs.getInt("status"));
                sliderList.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SliderDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            DBContext.close(connection);
        }
        return sliderList;
    }

}
