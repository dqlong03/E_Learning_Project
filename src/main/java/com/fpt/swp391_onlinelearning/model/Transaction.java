/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.swp391_onlinelearning.model;

import java.util.Date;

/**
 *
 * @author tran Hoang Phuc
 */
public class Transaction {
    private String transactionId;
    private long amount;
    private Date createdTime;
    private boolean status;

    public Transaction(String transactionId, long amount, Date createdTime, boolean status) {
        this.transactionId = transactionId;
        this.amount = amount;
        this.createdTime = createdTime;
        this.status = status;
    }

    public Transaction() {
    }
    

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
}
