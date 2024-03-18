/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.swp391_onlinelearning.dal;

import com.fpt.swp391_onlinelearning.dal.idbcontex.IAccountDAO;
import com.fpt.swp391_onlinelearning.dal.idbcontex.IDAO;
import com.fpt.swp391_onlinelearning.model.Account;
import com.fpt.swp391_onlinelearning.model.Role;
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
public class AccountDAO implements IDAO<Account>, IAccountDAO {

    @Override
    public List<Account> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Account get(int id) {
        Connection connection = DBContext.getConnection();
        String sql = "SELECT * FROM ACCOUNT a WHERE a.accId = ?";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                Account acc = new Account();
                acc.setAccId(rs.getInt("accId"));
                acc.setEmail(rs.getString("email"));
                acc.setPass(rs.getString("pass"));
                acc.setOtp(rs.getString("otp"));
                acc.setIsActivated(rs.getInt("isActivated"));
                acc.setCreatedTime(rs.getTimestamp("createdTime"));
                Role r= new Role();
                r.setRoleId(rs.getInt("roleId"));
                acc.setRole(r);
                return acc;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBContext.close(connection);
        }
        return null;
    }
    public static void main(String[] args) {
        System.out.println(new AccountDAO().get(1).getPass());
    }
    @Override
    public boolean update(Account t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean insert(Account acc) {
        Connection connection = DBContext.getConnection();
        String sql = "INSERT INTO `swp391_onlinelearning`.`account` (`email`, `pass`, `otp`, `createdTime`,`isActivated`, `roleId`) VALUES (?,?,?,NOW(), ?, 1);";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, acc.getEmail());
            stm.setString(2, acc.getPass());
            stm.setString(3, acc.getOtp());
            stm.setInt(4, 0);
            stm.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
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
    public Account getLogin(String email, String pass) {
        Connection connection = DBContext.getConnection();
        String sql = "SELECT `accId`, `email`, `isActivated`, `createdTime`, "
                + "a.`roleId`, r.`name` FROM `swp391_onlinelearning`.`account` a JOIN `role` r ON a.`roleId` = r.`roleId` "
                + "WHERE `email` = ? AND `pass` = ?";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, email);
            stm.setString(2, pass);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                Account account = new Account();
                account.setAccId(rs.getInt("accId"));
                account.setEmail(rs.getString("email"));
                account.setIsActivated(rs.getInt("isActivated"));
                account.setCreatedTime(rs.getTimestamp("createdTime"));
                Role role = new Role();
                role.setRoleId(rs.getInt("roleId"));
                role.setName(rs.getString("name"));
                account.setRole(role);
                return account;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBContext.close(connection);
        }
        return null;
    }

    @Override
    public Account getAccByEmail(String email) {
        Connection connection = DBContext.getConnection();
        String sql = "SELECT * FROM ACCOUNT a WHERE a.email = ?";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, email);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                Account acc = new Account();
                acc.setAccId(rs.getInt("accId"));
                acc.setEmail(rs.getString("email"));
                acc.setPass(rs.getString("pass"));
                acc.setOtp(rs.getString("otp"));
                acc.setIsActivated(rs.getInt("isActivated"));
                acc.setCreatedTime(rs.getTimestamp("createdTime"));
                Role role = new Role();
                role.setRoleId(rs.getInt("roleId"));
                acc.setRole(role);
                return acc;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBContext.close(connection);
        }
        return null;
    }

    @Override
    public void updateStatus(int accId, int status) {
        Connection connection = DBContext.getConnection();
        String sql = "UPDATE `swp391_onlinelearning`.`account` SET  `isActivated` = ? WHERE `accId` = ?;";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, status);
            stm.setInt(2, accId);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBContext.close(connection);
        }
    }

    @Override
    public void updatePassword(int id, String password) {
        Connection connection = DBContext.getConnection();
        String sql = "UPDATE `swp391_onlinelearning`.`account` SET `pass` = ?, `isActivated` = 1 WHERE `accId` = ?;";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, password);
            stm.setInt(2, id);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBContext.close(connection);
        }
    }

    @Override
    public void updateOTP(int id, String otp) {
        Connection connection = DBContext.getConnection();
        String sql = "UPDATE `swp391_onlinelearning`.`account` SET `otp` = ?, `createdTime` = NOW() WHERE `accId` = ?;";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, otp);
            stm.setInt(2, id);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBContext.close(connection);
        }
    }

}
