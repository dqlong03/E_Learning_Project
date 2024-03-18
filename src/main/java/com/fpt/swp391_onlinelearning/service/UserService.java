/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.swp391_onlinelearning.service;

import com.fpt.swp391_onlinelearning.convert.Converter;
import com.fpt.swp391_onlinelearning.dal.idbcontex.IDAO;
import com.fpt.swp391_onlinelearning.dal.idbcontex.IUserDAO;
import com.fpt.swp391_onlinelearning.dto.UserDTO;
import com.fpt.swp391_onlinelearning.model.User;
import com.fpt.swp391_onlinelearning.service.iservice.IService;
import com.fpt.swp391_onlinelearning.service.iservice.IUserService;
import java.util.List;

/**
 *
 * @author Admin
 */
public class UserService implements IService<UserDTO>, IUserService {

    private static UserService userService;
    private IDAO<User> dao;
    private IUserDAO iUserDAO;

    public UserService(IDAO<User> dao, IUserDAO iUserDAO) {
        this.dao = dao;
        this.iUserDAO = iUserDAO;
    }

    public static UserService getInstace(IDAO<User> dao, IUserDAO iUserDAO) {
        if (userService == null) {
            userService = new UserService(dao, iUserDAO);
        }
        return userService;
    }

    @Override
    public List<UserDTO> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public UserDTO get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean update(UserDTO t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean insert(UserDTO t) {
        return dao.insert(Converter.toDomain(t));
    }

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public UserDTO getUserByAccountId(int accId) {
        return Converter.toDTO(iUserDAO.getUserByAccountId(accId));

    }

    @Override
    public void updateUser(UserDTO udto) {
        User u= Converter.toUserDomain(udto);
        iUserDAO.updateUser(u);
    }

}
