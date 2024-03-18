/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.swp391_onlinelearning.dal;

import com.fpt.swp391_onlinelearning.dal.idbcontex.IDAO;
import com.fpt.swp391_onlinelearning.dal.idbcontex.IUserDAO;
import com.fpt.swp391_onlinelearning.model.Account;
import com.fpt.swp391_onlinelearning.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tran Hoang Phuc
 */
public class UserDAO extends DBContext implements IUserDAO, IDAO<User> {

//    public static void main(String[] args) {
//        User u = new User();
//        u.setBalance(100000);
//        u.setUserId(1);
//        new UserDAO().updateBalance(u);
//    }

    @Override
    public User getUserByAccountId(int accId) {
        Connection connection = DBContext.getConnection();
        String sql = "SELECT `userId`, `name`, `gender`, `dob`, `phone`, `img`, "
                + "`address`, `postCode`, `accId`, `balance` "
                + "FROM `swp391_onlinelearning`.`user`"
                + "WHERE `accId` = ?";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, accId);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                User user = new User();
                user.setUserId(rs.getInt("userId"));
                user.setName(rs.getString("name"));
                user.setGender(rs.getBoolean("gender"));
                user.setDob(rs.getDate("dob"));
                user.setPhone(rs.getString("phone"));
                user.setImg(rs.getString("img"));
                user.setAddress(rs.getString("address"));
                user.setPostCode(rs.getString("postCode"));
             
                Account account = new Account();
                account.setAccId(accId);
                user.setAccount(account);
                user.setBalance(rs.getLong("balance"));
                return user;

            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBContext.close(connection);
        }
        return null;
    }
    
    public static void main(String[] args) {
        System.out.println(new UserDAO().getUserByAccountId(74).getBalance());
    }

    @Override
    public List<User> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public User get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean update(User t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean insert(User user) {
        Connection connection = DBContext.getConnection();
        String sql = "INSERT INTO `swp391_onlinelearning`.`user` "
                + "(`name`, `gender`, `dob`, `phone`, `accId`) "
                + " VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, user.getName());
            stm.setBoolean(2, user.isGender());
            stm.setDate(3, user.getDob());
            stm.setString(4, user.getPhone());
            stm.setInt(5, user.getAccount().getAccId());
            stm.executeUpdate();
            return true;
        } catch (SQLException ex) {
            return false;
        } finally {
            DBContext.close(connection);
        }
    }

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void updateBalance(User u) {
        Connection connection = DBContext.getConnection();
        String sql = "UPDATE `swp391_onlinelearning`.`user` SET `balance`= ? WHERE  `userId`=?;";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setLong(1, u.getBalance());
            stm.setInt(2, u.getUserId());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBContext.close(connection);
        }

    }

    @Override
    public void updateUser(User model) {
        Connection connection= DBContext.getConnection();
        try {
            String sql = "UPDATE `user` AS u \n"
                    + "   SET u.name=?, u.gender=?,u.dob=?,u.phone=?,u.img=?,u.address=?,u.postCode=?\n" 
                    + "   WHERE u.accId=?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, model.getName());
            stm.setBoolean(2, model.isGender());
            stm.setDate(3, model.getDob());
            stm.setString(4, model.getPhone());
            stm.setString(5, model.getImg());
            stm.setString(6, model.getAddress());
            stm.setString(7, model.getPostCode());
            stm.setInt(8, model.getAccount().getAccId());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            DBContext.close(connection);
        }
    }

}
