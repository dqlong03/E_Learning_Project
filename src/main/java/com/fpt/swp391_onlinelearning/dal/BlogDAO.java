/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.swp391_onlinelearning.dal;

import com.fpt.swp391_onlinelearning.dal.idal.IBlogDAO;
import com.fpt.swp391_onlinelearning.dal.idal.IDAO;
import com.fpt.swp391_onlinelearning.model.Blog;
import com.fpt.swp391_onlinelearning.model.BlogCategory;
import com.fpt.swp391_onlinelearning.model.User;
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
public class BlogDAO implements IBlogDAO, IDAO<Blog> {

    @Override
    public List<Blog> getRecentlyBlog(int numOfBlogs) {
        Connection connection = DBContext.getConnection();
        List<Blog> blogList = new ArrayList<Blog>();
        try {
            String sql = "SELECT b.blogId,b.title,b.quickReview,b.content,b.createdTime,b.blogCategoryId,b.img,bc.name AS BlogCategoryName, b.authorId,u.name AS authorName\n"
                    + "FROM blog AS b, blogcategory AS bc, `user` AS u\n"
                    + "WHERE b.blogCategoryId=bc.blogCategoryId AND b.authorId=u.userId and b.isActivated = true\n"
                    + "ORDER BY createdTime DESC\n"
                    + "LIMIT ?;";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, numOfBlogs);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Blog b = new Blog();
                b.setBlogId(rs.getInt("blogId"));
                b.setTitle(rs.getString("title"));
                b.setContent(rs.getString("content"));
                b.setQuickReview(rs.getString("quickReview"));
                b.setCreatedTime(rs.getDate("createdTime"));
                b.setImg(rs.getString("img"));

                BlogCategory bc = new BlogCategory();
                bc.setBlogCategoryId(rs.getInt("blogCategoryId"));
                bc.setName(rs.getString("BlogCategoryName"));
                b.setCategory(bc);

                User u = new User();
                u.setUserId(rs.getInt("authorId"));
                u.setName(rs.getString("authorName"));
                b.setAuthor(u);

                blogList.add(b);

            }
        } catch (SQLException ex) {
            Logger.getLogger(BlogDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBContext.close(connection);
        }
        return blogList;
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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Blog> searchBlog(String title, int blogCategoryId, int pageIndex, int order) {
        Connection connection = DBContext.getConnection();
        List<Blog> blogs = new ArrayList<>();
        if (title == null) {
            title = " ";
        }
        String sql = "SELECT ab.blogId, ab.title, ab.quickReview,ab.createdTime, ab.content, ab.blogCategoryId, ab.authorId, ab.img, ab.categoryName,ab.authorName FROM (\n"
                + "SELECT b.blogId, b.title, b.quickReview,b.createdTime, b.content, b.blogCategoryId, b.authorId, b.img, bc.name AS categoryName, \n"
                + "u.name AS authorName, ROW_NUMBER() OVER (ORDER BY blogId) AS RowNum\n"
                + "FROM blog b \n"
                + "JOIN blogcategory bc ON b.blogCategoryId = bc.blogCategoryId\n"
                + "jOIN user u ON b.authorId = u.userId\n"
                + "WHERE (1=1) and b.isActivated =true \n";
        sql += "AND b.title LIKE ?\n";
        int paramBlogCategoryId = 0;

        if (blogCategoryId != -1) {
            sql += "AND b.blogCategoryId=?\n";
            paramBlogCategoryId++;
        }
        sql += ") ab\n"
                + "WHERE RowNum >=(?-1)*5 +1 AND rownum <= ?*5 ";
        if (order == 1) {
            sql += "ORDER BY ab.createdTime DESC";
        } else {
            sql += "ORDER BY ab.createdTime ASC";
        }

        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            if (paramBlogCategoryId == 1) {
                stm.setString(1, "%" + title + "%");
                stm.setInt(2, blogCategoryId);
                stm.setInt(3, pageIndex);
                stm.setInt(4, pageIndex);
            } else {
                stm.setString(1, "%" + title + "%");
                stm.setInt(2, pageIndex);
                stm.setInt(3, pageIndex);
            }

            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Blog blog = new Blog();
                blog.setBlogId(rs.getInt("blogId"));
                blog.setTitle(rs.getString("title"));
                blog.setQuickReview(rs.getString("quickReview"));
                blog.setContent(rs.getString("content"));
                BlogCategory blogCategory = new BlogCategory();
                blogCategory.setBlogCategoryId(rs.getInt("blogCategoryId"));
                blogCategory.setName(rs.getString("categoryName"));
                blog.setCategory(blogCategory);
                blog.setImg(rs.getString("img"));
                blog.setCreatedTime(rs.getDate("createdTime"));
                User user = new User();
                user.setUserId(rs.getInt("authorId"));
                user.setName(rs.getString("authorName"));
                blog.setAuthor(user);
                blogs.add(blog);
            }
            return blogs;
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBContext.close(connection);
        }

        return null;
    }

    @Override
    public List<Blog> getRecentBlog() {
        Connection connection = DBContext.getConnection();
        List<Blog> blogs = new ArrayList<>();
        String sql = "SELECT  blogId, title, img,createdTime\n"
                + "FROM blog where isActivated = true \n"
                + "ORDER BY createdTime DESC\n"
                + "LIMIT 3;";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Blog blog = new Blog();
                blog.setBlogId(rs.getInt("blogId"));
                blog.setTitle(rs.getString("title"));
                blog.setImg(rs.getString("img"));
                blog.setCreatedTime(rs.getDate("createdTime"));
                blogs.add(blog);
            }
            return blogs;

        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class
                    .getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBContext.close(connection);
        }
        return null;
    }

    @Override
    public int countNumberOfPageSearchBlog(String title, int blogCategoryId) {
        Connection connection = DBContext.getConnection();
        String sql = "SELECT COUNT(*) AS numberOfBlog\n"
                + "FROM blog b\n"
                + "JOIN blogcategory bc ON b.blogCategoryId = bc.blogCategoryId\n"
                + "jOIN user u ON b.authorId = u.userId\n"
                + "WHERE (1=1) and b.isActivated=true\n";
        int paramTitle = 0;
        int paramBlogCategoryId = 0;

        if (title != null) {
            sql += "AND b.title LIKE ?\n";
            paramTitle++;
        }
        if (blogCategoryId != -1) {
            sql += "AND b.blogCategoryId=?\n";
            paramBlogCategoryId++;
        }
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            if (paramTitle == 1) {
                if (paramBlogCategoryId == 1) {
                    stm.setString(1, "%" + title + "%");
                    stm.setInt(2, blogCategoryId);
                } else {
                    stm.setString(1, "%" + title + "%");
                }
            } else {
                if (paramBlogCategoryId == 1) {
                    stm.setInt(1, blogCategoryId);
                } else {
                }
            }
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                int countPage = rs.getInt("numberOfBlog") % 5 == 0 ? rs.getInt("numberOfBlog") / 5
                        : (rs.getInt("numberOfBlog") / 5) + 1;
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
    public Blog getBlogDetail(int blogId) {
        Connection connection = DBContext.getConnection();
        String sql = "SELECT b.blogId, b.title, b.quickReview,b.createdTime, b.content, b.blogCategoryId, b.authorId, b.img,bc.name AS categoryName,u.name AS authorName\n"
                + "FROM blog b \n"
                + "JOIN blogcategory bc ON b.blogCategoryId = bc.blogCategoryId\n"
                + "JOIN user u ON b.authorId=u.userId\n"
                + "where b.blogId=? and b.isActivated=true;";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, blogId);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Blog blog = new Blog();
                blog.setBlogId(rs.getInt("blogId"));
                blog.setTitle(rs.getString("title"));
                blog.setQuickReview(rs.getString("quickReview"));
                blog.setContent(rs.getString("content"));
                BlogCategory blogCategory = new BlogCategory();
                blogCategory.setBlogCategoryId(rs.getInt("blogCategoryId"));
                blogCategory.setName(rs.getString("categoryName"));
                blog.setCategory(blogCategory);
                blog.setImg(rs.getString("img"));
                blog.setCreatedTime(rs.getDate("createdTime"));
                User user = new User();
                user.setUserId(rs.getInt("authorId"));
                user.setName(rs.getString("authorName"));
                blog.setAuthor(user);
                return blog;

            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class
                    .getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBContext.close(connection);
        }
        return null;
    }

    @Override
    public List<BlogCategory> getAllBlogCategory() {
        Connection connection = DBContext.getConnection();
        List<BlogCategory> blogCategorys = new ArrayList<>();
        String sql = "SELECT  blogCategoryId, name FROM blogcategory where isActivated = true";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                BlogCategory cc = new BlogCategory();
                cc.setName(rs.getString("name"));
                cc.setBlogCategoryId(rs.getInt("blogCategoryId"));
                blogCategorys.add(cc);
            }
            return blogCategorys;

        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class
                    .getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBContext.close(connection);
        }
        return null;
    }

    @Override
    public List<Blog> getSearchList(String title, int blogCategoryId, int pageIndex, String authorName, Date from, Date to) {
        Connection connection = DBContext.getConnection();
        List<Blog> blogs = new ArrayList<>();
        String sql = "SELECT * FROM(\n"
                + "SELECT ROW_NUMBER() OVER (ORDER BY b.blogId ASC) AS rownum, b.blogId, b.title, b.createdTime, b.isActivated, u.userId,u.name AS author,\n"
                + " bc.blogCategoryId,bc.name AS category FROM blog b\n"
                + "JOIN blogcategory bc ON b.blogCategoryId = bc.blogCategoryId\n"
                + "jOIN user u ON b.authorId = u.userId\n"
                + "WHERE 1 = 1 AND b.createdTime >= ? AND b.createdTime <=?\n";
        if (title != null) {
            sql += " AND b.title LIKE ? ";
        }
        if (blogCategoryId != 0) {
            sql += " AND bc.blogCategoryId = ? ";
        }
        if (authorName != null) {
            sql += " AND u.name LIKE ? ";
        }
        sql += ") t \n"
                + "WHERE rownum >= (? - 1) * 8 + 1 AND rownum <= ? * 8";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setDate(1, from);
            stm.setDate(2, to);
            int parameterIndex = 3; // Starting index for additional parameters
            if (title != null) {
                stm.setString(parameterIndex++, "%" + title + "%");
            }
            if (blogCategoryId != 0) {
                stm.setInt(parameterIndex++, blogCategoryId);
            }
            if (authorName != null) {
                stm.setString(parameterIndex++, "%" + authorName + "%");
            }
            stm.setInt(parameterIndex++, pageIndex);
            stm.setInt(parameterIndex++, pageIndex);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Blog b = new Blog();
                b.setBlogId(rs.getInt("blogId"));
                b.setCreatedTime(rs.getDate("createdTime"));
                b.setTitle(rs.getString("title"));
                BlogCategory bc = new BlogCategory();
                bc.setBlogCategoryId(rs.getInt("blogCategoryId"));
                bc.setName(rs.getString("category"));
                b.setCategory(bc);
                User author = new User();
                author.setUserId(rs.getInt("userId"));
                author.setName(rs.getString("author"));
                b.setAuthor(author);
                b.setIsActivated(rs.getBoolean("isActivated"));
                blogs.add(b);
            }

        } catch (SQLException ex) {
            Logger.getLogger(BlogDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBContext.close(connection);
        }
        return blogs;
    }

    @Override
    public int countRecordOfSearchList(String title, int blogCategoryId, String author, Date from, Date to) {
        Connection connection = DBContext.getConnection();
        String sql = "SELECT COUNT(*) AS num FROM blog b\n"
                + "JOIN blogcategory bc ON b.blogCategoryId = bc.blogCategoryId\n"
                + "jOIN user u ON b.authorId = u.userId\n"
                + "WHERE 1 = 1 AND b.createdTime >= ? AND b.createdTime <= ?";
        if (title != null) {
            sql += " AND b.title LIKE ? ";
        }
        if (blogCategoryId != 0) {
            sql += " AND bc.blogCategoryId = ? ";
        }
        if (author != null) {
            sql += " AND u.name LIKE ? ";
        }
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setDate(1, from);
            stm.setDate(2, to);
            int parameterIndex = 3; // Starting index for additional parameters
            if (title != null) {
                stm.setString(parameterIndex++, "%" + title + "%");
            }
            if (blogCategoryId != 0) {
                stm.setInt(parameterIndex++, blogCategoryId);
            }
            if (author != null) {
                stm.setString(parameterIndex++, "%" + author + "%");
            }
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                return rs.getInt("num");
            }
        } catch (SQLException ex) {
            Logger.getLogger(BlogDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBContext.close(connection);
        }
        return 0;
    }

    @Override
    public Blog getDetail(int blogId) {
        Connection connection = DBContext.getConnection();
        String sql = "SELECT b.blogId, b.title, b.quickReview,b.createdTime, b.content, b.blogCategoryId, b.authorId, b.img,bc.name AS categoryName,u.name AS authorName\n"
                + "FROM blog b \n"
                + "JOIN blogcategory bc ON b.blogCategoryId = bc.blogCategoryId\n"
                + "JOIN user u ON b.authorId=u.userId\n"
                + "where b.blogId=?";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, blogId);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Blog blog = new Blog();
                blog.setBlogId(rs.getInt("blogId"));
                blog.setTitle(rs.getString("title"));
                blog.setQuickReview(rs.getString("quickReview"));
                blog.setContent(rs.getString("content"));
                BlogCategory blogCategory = new BlogCategory();
                blogCategory.setBlogCategoryId(rs.getInt("blogCategoryId"));
                blogCategory.setName(rs.getString("categoryName"));
                blog.setCategory(blogCategory);
                blog.setImg(rs.getString("img"));
                blog.setCreatedTime(rs.getDate("createdTime"));
                User user = new User();
                user.setUserId(rs.getInt("authorId"));
                user.setName(rs.getString("authorName"));
                blog.setAuthor(user);
                return blog;

            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class
                    .getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBContext.close(connection);
        }
        return null;
    }

    @Override
    public void changeStatus(int blogId, boolean status) {
        Connection connection = DBContext.getConnection();
        String sql = "UPDATE blog SET isActivated = ? WHERE blogId = ?";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setBoolean(1, status);
            stm.setInt(2, blogId);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BlogDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    

}
