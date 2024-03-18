/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.fpt.swp391_onlinelearning.dal.idal;

import com.fpt.swp391_onlinelearning.model.Account;

/**
 *
 * @author tran Hoang Phuc
 */
public interface IAccountDAO {

    public Account getLogin(String email, String pass);

    public Account getAccByEmail(String email);

    public void updateStatus(int accId, int status);

    public void updatePassword(int id, String password);

    public void updateOTP(int id, String otp);
    
        public void updateAccountById(Account a, int id) ;
    
    public boolean insertByAdmin(Account acc) ;

}
