/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.swp391_onlinelearning.dal;

import com.fpt.swp391_onlinelearning.dal.idal.IBlogViewDAO;
import com.fpt.swp391_onlinelearning.model.Blog;
import com.fpt.swp391_onlinelearning.model.BlogView;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author phuc2
 */
public class BlogViewDAO implements IBlogViewDAO {

    @Override
    public Map<BlogView, Integer> getBlogTrendView(int periodOfDays) {
        Connection connection = DBContext.getConnection();
        Map<BlogView, Integer> blogTrendView = new HashMap<>();
        try {

            String sql = "SELECT COUNT(b.title) AS totalView,b.blogId,b.title\n"
                    + "FROM blogview AS bv, blog AS b, `user` AS u\n"
                    + "WHERE bv.blogId=b.blogId AND bv.userId=u.userId AND bv.viewTime >= DATE_SUB(NOW(), INTERVAL ? DAY) AND bv.viewTime <= NOW()\n"
                    + "GROUP BY b.blogId\n"
                    + "ORDER BY totalView DESC\n"
                    + "LIMIT 5";

            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, periodOfDays);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Blog b = new Blog();
                b.setBlogId(rs.getInt("blogId"));
                b.setTitle(rs.getString("title"));
                BlogView bv = new BlogView();
                bv.setBlog(b);
                blogTrendView.put(bv, rs.getInt("totalView"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(BlogViewDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBContext.close(connection);
        }
        return blogTrendView;
    }

    @Override
    public int getTotalBlogView(int periodOfDays) {
        Connection connection = DBContext.getConnection();
        try {
            String sql = "SELECT COUNT(*) AS total From(\n"
                    + "SELECT b.blogId,b.title\n"
                    + "FROM blogview AS bv, blog AS b, `user` AS u\n"
                    + "WHERE bv.blogId=b.blogId AND bv.userId=u.userId AND bv.viewTime >= DATE_SUB(NOW(), INTERVAL ? DAY) AND bv.viewTime <= NOW()) AS t";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, periodOfDays);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                return rs.getInt("total");
            }
            return 0;
        } catch (SQLException ex) {
            return 0;
        } finally {
            DBContext.close(connection);
        }

    }

    @Override
    public void addNewBlogView(BlogView b) {
        Connection connection = DBContext.getConnection();
        try {         
            String sql = "INSERT INTO `swp391_onlinelearning`.blogview\n"
                    + "(blogId, userId, viewTime) \n"
                    + "VALUES (?, ?, NOW())";
            
            PreparedStatement stm= connection.prepareStatement(sql);
            stm.setInt(1, b.getBlog().getBlogId());
            stm.setInt(2, b.getUser().getUserId());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BlogViewDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void addPublicBlogView(BlogView b) {
        Connection connection = DBContext.getConnection();
        try {         
            String sql = "INSERT INTO `swp391_onlinelearning`.blogview\n"
                    + "(blogId, viewTime) \n"
                    + "VALUES (?, NOW())";
            
            PreparedStatement stm= connection.prepareStatement(sql);
            stm.setInt(1, b.getBlog().getBlogId());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BlogViewDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Blog> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Blog get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean update(Blog t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean insert(Blog t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(int id) {
        Connection connection = DBContext.getConnection();
        try {
            String sql = "delete from blogView WHERE blogId=?";
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

}
