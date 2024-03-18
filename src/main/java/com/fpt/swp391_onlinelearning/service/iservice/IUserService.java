/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.fpt.swp391_onlinelearning.service.iservice;

import com.fpt.swp391_onlinelearning.dto.UserDTO;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author tran Hoang Phuc
 */
public interface IUserService {

    public UserDTO getUserByAccountId(int accId);

    public void updateUser(UserDTO udto);

    public List<UserDTO> getUserDTORegister(int pageSize, int pageIndex, Date from, Date to);

    public List<UserDTO> getUserDTORegister(Date from, Date to);

    public int userDTOCount(Date from, Date to);

    public List<Integer> userDTOCount();
    
        public List<UserDTO> getAllUser(int pageindex, int pagesize,String info,int roleid,int status);
    
    public UserDTO getUserById(int Id);
    
    public UserDTO getUserByPhone(String phone);
    
    public int getCount(String info ,int roleid,int status);
    
        public void blockAccountByRoleId(int roleid);
    public void blockRoleByRoleId(int roleid);

}
