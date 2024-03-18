/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.swp391_onlinelearning.dal;

import com.fpt.swp391_onlinelearning.dal.idal.IDAO;
import com.fpt.swp391_onlinelearning.dal.idal.ITransactionDAO;
import com.fpt.swp391_onlinelearning.model.Account;
import com.fpt.swp391_onlinelearning.model.Transaction;
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
 * @author tran Hoang Phuc
 */
public class TransactionDAO implements IDAO<Transaction>, ITransactionDAO {

    @Override
    public List<Transaction> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Transaction get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean update(Transaction t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean insert(Transaction t) {
        Connection connection = DBContext.getConnection();
        String sql = "INSERT INTO `swp391_onlinelearning`.`transaction` "
                + "(`transactionId`, `amount`, `createdTime`, `status`, `accId`) "
                + "VALUES (?, ?, NOW(), ? , ?);";      
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, t.getTransactionId());
            stm.setLong(2, t.getAmount());
            stm.setBoolean(3, t.isStatus());
            stm.setInt(4, t.getAccount().getAccId());
            stm.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(TransactionDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBContext.close(connection);
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Transaction> getTransactionByAccount(int accId , int pageIndex, Date from, Date to) {
        List<Transaction> transactions = new ArrayList<>();
        Connection connection = DBContext.getConnection();
        String sql = "SELECT `transactionId`, `amount` , `createdTime`, `status`, `accId` \n"
                + "FROM ( SELECT row_number() over (order by `createdTime`desc) as rownum, `transactionId`, `amount` , `createdTime`, `status`, `accId`\n"
                + "FROM swp391_onlinelearning.`transaction` ) t\n"
                + "where accId = ? and rownum >= (? - 1) * 5 + 1 and rownum <= ? * 5  "
                + "AND `createdTime` >= ? AND `createdTime` <= ?";            
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, accId);
            stm.setInt(2, pageIndex);
            stm.setInt(3, pageIndex);
            stm.setDate(4, from);
            stm.setDate(5, to);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Transaction transaction = new Transaction();
                transaction.setTransactionId(rs.getString("transactionId"));
                transaction.setAmount(rs.getLong("amount"));
                transaction.setCreatedTime(rs.getTimestamp("createdTime"));
                transaction.setStatus(rs.getBoolean("status"));
                Account a = new Account();
                a.setAccId(rs.getInt("accId"));
                transaction.setAccount(a);
                transactions.add(transaction);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TransactionDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBContext.close(connection);
        }
        return transactions;
    }

    @Override
    public int getNumOfTransaction(int accId, int pageIndex, Date from, Date to) {
        Connection connection = DBContext.getConnection();
        String sql = "SELECT COUNT(*) AS numOfRecord \n"
                + "FROM ( SELECT row_number() over (order by `createdTime`desc) as rownum, `transactionId`, `amount` , `createdTime`, `status`, `accId`\n"
                + "FROM swp391_onlinelearning.`transaction` ) t\n"
                + "where accId = ? "
                + "AND `createdTime` >= ? AND `createdTime` <= ?";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, accId);
           
            stm.setDate(2, from);
            stm.setDate(3, to);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                return rs.getInt("numOfRecord");
            }
        } catch (SQLException ex) {
            Logger.getLogger(TransactionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }


}
