/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.swp391_onlinelearning.service;

import com.fpt.swp391_onlinelearning.convert.Converter;
import com.fpt.swp391_onlinelearning.dal.idal.ITransactionDAO;
import com.fpt.swp391_onlinelearning.dto.AccountDTO;
import com.fpt.swp391_onlinelearning.dto.TransactionDTO;
import com.fpt.swp391_onlinelearning.model.Transaction;
import com.fpt.swp391_onlinelearning.service.iservice.ITransactionService;
import com.fpt.swp391_onlinelearning.util.DatetimeUtil;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tran Hoang Phuc
 */
public class TransactionService implements ITransactionService {

    private ITransactionDAO transaction;
    private static TransactionService transactionService;

    public TransactionService(ITransactionDAO transaction) {
        this.transaction = transaction;
    }

    public static TransactionService getInstance(ITransactionDAO transaction) {
        if (transactionService == null) {
            transactionService = new TransactionService(transaction);
        }
        return transactionService;
    }

    @Override
    public List<TransactionDTO> getTransactionByAccount(int accId, int pageIndex, String from, String to, AccountDTO user) {
        List<TransactionDTO> dtos = new ArrayList<>();
        Date fromDate = null;
        Date toDate = null;
        if (from == null || from.length() == 0) {
            fromDate = user.getRegisteredTime();
        } else {
            fromDate = Date.valueOf(from);
        }
        if (to == null || to.length() == 0) {
            toDate = DatetimeUtil.getFollowingDate(DatetimeUtil.getCurrentSqlDateString());
        } else {
            toDate = DatetimeUtil.getFollowingDate(to);
        }

        for (Transaction transaction : transaction.getTransactionByAccount(accId, pageIndex, fromDate, toDate)) {
            dtos.add(Converter.toDto(transaction));
        }
        return dtos;
    }

    @Override
    public int getNumOfTransaction(int accId, int pageIndex, String from, String to, AccountDTO user) {
        Date fromDate = null;
        Date toDate = null;
        if (from == null || from.length() == 0) {
            fromDate = user.getRegisteredTime();
        } else {
            fromDate = Date.valueOf(from);
        }
        if (to == null || to.length() == 0) {
            toDate = DatetimeUtil.getFollowingDate(DatetimeUtil.getCurrentSqlDateString());
        } else {
            toDate = DatetimeUtil.getFollowingDate(to);
        }
        return transaction.getNumOfTransaction(accId, pageIndex, fromDate, toDate);
    }

    
    
}
