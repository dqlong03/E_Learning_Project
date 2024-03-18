/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.swp391_onlinelearning.dal.idal;

import com.fpt.swp391_onlinelearning.model.Transaction;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author tran Hoang Phuc
 */
public interface ITransactionDAO {
    public List<Transaction> getTransactionByAccount(int accId, int pageIndex, Date from, Date to);
    public int getNumOfTransaction(int accId, int pageIndex, Date from, Date to);
}
