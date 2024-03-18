/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.fpt.swp391_onlinelearning.service.iservice;

import com.fpt.swp391_onlinelearning.dto.UserDTO;

/**
 *
 * @author tran Hoang Phuc
 */
public interface IUserService {

    public UserDTO getUserByAccountId(int accId);

    public void updateUser(UserDTO udto);

}
