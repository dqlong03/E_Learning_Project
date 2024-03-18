/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.swp391_onlinelearning.dal;

import com.fpt.swp391_onlinelearning.dal.idal.IPostDAO;
import com.fpt.swp391_onlinelearning.model.Post;
import com.fpt.swp391_onlinelearning.model.PostCategory;
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
 * @author quang
 */
public class PostDAO implements IPostDAO {

    @Override
    public List<Post> getAllShowPost() {
        Connection connection = DBContext.getConnection();
        List<Post> posts = new ArrayList<>();
        try {
            String sql = "SELECT postId, title FROM post WHERE `status` = 1";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Post p = new Post();
                p.setPostId(rs.getInt("postId"));
                p.setTitle(rs.getString("title"));
                posts.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SliderDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBContext.close(connection);
        }
        return posts;
    }

    @Override
    public List<Post> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Post get(int id) {
        Connection connection = DBContext.getConnection();
        try {
            String sql = "SELECT p.postId,p.title,p.`status` , p.content, pc.name, p.postCategoryId FROM post p \n"
                    + "JOIN postcategory pc ON pc.postCategoryId=p.postCategoryId\n"
                    + "WHERE postId=?;";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                Post post = new Post();
                post.setPostId(rs.getInt("postId"));
                post.setStatus(rs.getInt("status"));
                post.setTitle(rs.getString("title"));
                post.setContent(rs.getString("content"));
                PostCategory postCategory = new PostCategory();
                postCategory.setPostCategoryId(rs.getInt("postCategoryId"));
                postCategory.setName(rs.getString("name"));
                post.setPostCategory(postCategory);
                return post;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBContext.close(connection);
        }
        return null;
    }

    @Override
    public boolean update(Post post) {
        Connection connection = DBContext.getConnection();
        try {
            String sql = "UPDATE post p SET p.title=?, p.postCategoryId=?, p.`status`=?, p.content=?\n"
                    + "WHERE p.postId=?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, post.getTitle());
            stm.setString(4, post.getContent());
            stm.setInt(2, post.getPostCategory().getPostCategoryId());
            stm.setInt(3, post.getStatus());
            stm.setInt(5, post.getPostId());
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
    public boolean insert(Post post) {
        Connection connection = DBContext.getConnection();
        try {
            String sql = "INSERT INTO post (title, content, `status`, postCategoryId, createdTime)\n" +
            "VALUES (?,?, ?, ?, ?);";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, post.getTitle());
            stm.setString(2, post.getContent());
            stm.setInt(4, post.getPostCategory().getPostCategoryId());
            stm.setInt(3, post.getStatus());
            stm.setDate(5,post.getCreatedTime());
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
            String sql = "delete from post WHERE postId=?";
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
    public List<Post> searchListPost(String searchInput, Date timeFrom, Date timeTo, int pageIndex, int postCategoryId) {
        Connection connection = DBContext.getConnection();
        List<Post> posts = new ArrayList<>();
        try {
            String sql = "SELECT a.postId, a.title, a.postCategoryId, a.`status`, a.createdTime,a.`name` from\n"
                    + "        (SELECT p.postId,p.title, p.postCategoryId,pc.`name`, p.`status` ,p.createdTime , \n"
                    + "		  ROW_NUMBER() OVER (ORDER BY p.createdTime DESC) AS RowNum FROM post p\n"
                    + "        JOIN postcategory pc ON pc.postCategoryId= p.postCategoryId\n"
                    + "        WHERE p.title LIKE ? AND p.createdTime >=? AND p.createdTime <= ?";
            if (postCategoryId != -1) {
                sql += "AND p.postCategoryId=? ";
            }
            sql += " )a WHERE RowNum >=(?-1)*8 +1 AND rownum <= ?*8 ;";
            PreparedStatement stm = connection.prepareStatement(sql);
            if (postCategoryId != -1) {
                stm.setString(1, "%" + searchInput + "%");
                stm.setDate(2, timeFrom);
                stm.setDate(3, timeTo);
                stm.setInt(4, postCategoryId);
                stm.setInt(5, pageIndex);
                stm.setInt(6, pageIndex);
            } else {
                stm.setString(1, "%" + searchInput + "%");
                stm.setDate(2, timeFrom);
                stm.setDate(3, timeTo);
                stm.setInt(4, pageIndex);
                stm.setInt(5, pageIndex);
            }
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Post p = new Post();
                p.setCreatedTime(rs.getDate("createdTime"));
                PostCategory category = new PostCategory();
                category.setPostCategoryId(rs.getInt("postCategoryId"));
                category.setName(rs.getString("name"));
                p.setPostCategory(category);
                p.setPostId(rs.getInt("postId"));
                p.setStatus(rs.getInt("status"));
                p.setTitle(rs.getString("title"));
                posts.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SliderDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBContext.close(connection);
        }
        return posts;
    }

    @Override
    public int countNumberOfPageSearchPost(String searchInput, Date timeFrom, Date timeTo, int postCategoryId) {
        Connection connection = DBContext.getConnection();
        String sql = "SELECT COUNT(*) AS numberOfPost\n"
                + "FROM post\n"
                + "WHERE title LIKE? AND createdTime >=? AND createdTime <=?";
        if (postCategoryId != -1) {
            sql += "AND postCategoryId=? ";
        }
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            if (postCategoryId != -1) {
                stm.setString(1, "%" + searchInput + "%");
                stm.setDate(2, timeFrom);
                stm.setDate(3, timeTo);
                stm.setInt(4, postCategoryId);
            } else {
                stm.setString(1, "%" + searchInput + "%");
                stm.setDate(2, timeFrom);
                stm.setDate(3, timeTo);
            }

            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                int countPage = rs.getInt("numberOfPost") % 8 == 0 ? rs.getInt("numberOfPost") / 8
                        : (rs.getInt("numberOfPost") / 8) + 1;
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

}
