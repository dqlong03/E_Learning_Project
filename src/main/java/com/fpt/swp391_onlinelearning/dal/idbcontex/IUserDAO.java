/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.fpt.swp391_onlinelearning.dal.idbcontex;

import com.fpt.swp391_onlinelearning.model.User;

/**
 *
 * @author tran Hoang Phuc
 */
public interface IUserDAO {
    public User getUserByAccountId(int accId);
    
    public void updateBalance(User u);

    public void updateUser(User u);
}
