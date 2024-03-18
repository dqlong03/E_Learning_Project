/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.fpt.swp391_onlinelearning.dal.idal;

import com.fpt.swp391_onlinelearning.model.User;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author tran Hoang Phuc
 */
public interface IUserDAO {
    public User getUserByAccountId(int accId);
    
    public void updateBalance(User u);

    public void updateUser(User u);

    public List<User> getUserRegistrationInfo(int pageSize, int pageIndex, Date startDate, Date endDate);

    public int userCount(Date startDate, Date endDate);

    public int userCount(Date date);

    public List<User> getUserRegistrationInfo(Date startDate, Date endDate);
    
     
    public List<User> getAllUser(int pageindex, int pagesize,String info,int roleid,int status);
    
    public User getUserById(int Id);
    
    public User getUserByPhone(String phone);
    
    public int getCount(String info ,int roleid,int status);
        
    public void blockAccountByRoleId(int roleid);
    public void blockRoleByRoleId(int roleid);
}
