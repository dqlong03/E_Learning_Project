/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.swp391_onlinelearning.service.iservice;

import com.fpt.swp391_onlinelearning.dto.AccountDTO;
import com.fpt.swp391_onlinelearning.dto.TransactionDTO;
import java.util.List;

/**
 *
 * @author tran Hoang Phuc
 */
public interface ITransactionService {
    public List<TransactionDTO> getTransactionByAccount(int accId, int pageIndex, String from, String to, AccountDTO user);
    public int getNumOfTransaction(int accId, int pageIndex, String from, String to, AccountDTO user);
}
