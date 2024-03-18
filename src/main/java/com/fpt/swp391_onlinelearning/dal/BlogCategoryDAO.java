/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.swp391_onlinelearning.dal;

import com.fpt.swp391_onlinelearning.dal.idbcontex.IBLogCategoryDAO;
import com.fpt.swp391_onlinelearning.model.BlogCategory;
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
 * @author quang
 */
public class BlogCategoryDAO implements IBLogCategoryDAO {

    @Override
    public List<BlogCategory> getAllBlogCategory() {
        Connection connection = DBContext.getConnection();
        List<BlogCategory> blogCategorys = new ArrayList<>();
        String sql = "SELECT  blogCategoryId, name FROM blogcategory";
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

}
