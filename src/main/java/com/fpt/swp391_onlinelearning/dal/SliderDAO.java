/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.swp391_onlinelearning.dal;

import com.fpt.swp391_onlinelearning.dal.idal.ISliderDAO;
import com.fpt.swp391_onlinelearning.model.Post;
import com.fpt.swp391_onlinelearning.model.Slider;
import java.sql.Connection;
import java.sql.Date;
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
            String sql = "SELECT sliderId,img, title, postId, description, `status` FROM slider\n"
                    + "WHERE sliderId=?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                Slider slider = new Slider();
                slider.setSliderId(rs.getInt("sliderId"));
                slider.setImg(rs.getString("img"));
                slider.setTitle(rs.getString("title"));
                Post s = new Post();
                s.setPostId(rs.getInt("postId"));
                slider.setPost(s);
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
    public boolean update(Slider slider) {
        Connection connection = DBContext.getConnection();
        try {
            String sql = "UPDATE slider s SET s.img = ?, s.title = ?, s.`status` = ?,s.`description` = ?, s.postId = ?\n"
                    + "WHERE sliderId=?;";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, slider.getImg());
            stm.setString(2, slider.getTitle());
            stm.setString(4, slider.getDescription());
            stm.setInt(3, slider.getStatus());
            stm.setInt(5, slider.getPost().getPostId());
            stm.setInt(6, slider.getSliderId());
            stm.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(SliderDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBContext.close(connection);
        }
        return false;
    }

    @Override
    public boolean insert(Slider slider) {
        Connection connection = DBContext.getConnection();
        try {
            String sql = "INSERT INTO slider (img,title, description, status, postId, createdTime) \n"
                    + "VALUES (?,?, ?, ?, ?,?);";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, slider.getImg());
            stm.setString(2, slider.getTitle());
            stm.setString(3, slider.getDescription());
            stm.setInt(4, slider.getStatus());
            stm.setInt(5, slider.getPost().getPostId());
            stm.setDate(6, slider.getCreatedTime());
            stm.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(SliderDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBContext.close(connection);
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        Connection connection = DBContext.getConnection();
        try {
            String sql = "delete from slider where sliderId= ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            stm.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(SliderDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBContext.close(connection);
        }
        return false;
    }

    @Override
    public List<Slider> getListOfSlider() {
        Connection connection= DBContext.getConnection();
        List<Slider> sliderList = new ArrayList<>();
        try {
            String sql = "SELECT sliderId,img, title, postId, description, `status` FROM slider\n"
                    + "WHERE status = 1;";
            PreparedStatement stm= connection.prepareStatement(sql);
            ResultSet rs= stm.executeQuery();
            while(rs.next())
            {
                Slider s= new Slider();
                s.setSliderId(rs.getInt("sliderId"));
                s.setImg(rs.getString("img"));
                s.setTitle(rs.getString("title"));
                Post p = new Post();
                p.setPostId(rs.getInt("postId"));
                s.setPost(p);
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
@Override
    public List<Slider> searchListSlider(String searchInput, Date timeFrom, Date timeTo, int pageIndex) {
        Connection connection = DBContext.getConnection();
        List<Slider> sliderList = new ArrayList<>();
        try {
            String sql = "SELECT p.sliderId, p.title, p.`description`, p.`status`, p.createdTime from\n"
                    + "(SELECT sliderId,title, `description`, `status` ,createdTime , ROW_NUMBER() OVER (ORDER BY createdTime DESC) AS RowNum FROM slider\n"
                    + "WHERE (title LIKE ? or `description` LIKE ?) AND createdTime >=? AND createdTime <= ? ) p WHERE RowNum >=(?-1)*6 +1 AND rownum <= ?*6 ;";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, "%" + searchInput + "%");
            stm.setString(2, "%" + searchInput + "%");
            stm.setDate(3, timeFrom);
            stm.setDate(4, timeTo);
            stm.setInt(5, pageIndex);
            stm.setInt(6, pageIndex);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Slider s = new Slider();
                s.setSliderId(rs.getInt("sliderId"));
                s.setCreatedTime(rs.getDate("createdTime"));
                s.setTitle(rs.getString("title"));
                s.setDescription(rs.getString("description"));
                s.setStatus(rs.getInt("status"));
                sliderList.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SliderDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBContext.close(connection);
        }
        return sliderList;
    }

    @Override
    public int countNumberOfPageSearchSlider(String searchInput, Date timeFrom, Date timeTo) {
        Connection connection = DBContext.getConnection();
        String sql = "SELECT COUNT(*) AS numberOfSlider\n"
                + "FROM slider\n"
                + "WHERE (title LIKE ? or `description` LIKE ?) AND createdTime >=? AND createdTime <= ?";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, "%" + searchInput + "%");
            stm.setString(2, "%" + searchInput + "%");
            stm.setDate(3, timeFrom);
            stm.setDate(4, timeTo);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                int countPage = rs.getInt("numberOfSlider") % 6 == 0 ? rs.getInt("numberOfSlider") / 6
                        : (rs.getInt("numberOfSlider") / 6) + 1;
                return countPage;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class
                    .getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBContext.close(connection);
        }
        return -1;
    }

    @Override
    public boolean updatePostId(int postId) {
    
    Connection connection = DBContext.getConnection();
        try {
            String sql = "UPDATE slider s SET  s.`status` = 0"
                    + "WHERE postId=?;";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, postId);
            stm.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(SliderDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBContext.close(connection);
        }
        return false;
    }

}
