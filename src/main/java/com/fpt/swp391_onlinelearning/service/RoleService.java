/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.swp391_onlinelearning.service;

import com.fpt.swp391_onlinelearning.convert.Converter;
import com.fpt.swp391_onlinelearning.dal.idal.IDAO;
import com.fpt.swp391_onlinelearning.dal.idal.IRoleDAO;
import com.fpt.swp391_onlinelearning.dto.RoleDTO;
import com.fpt.swp391_onlinelearning.model.Role;
import com.fpt.swp391_onlinelearning.service.iservice.IRoleService;
import com.fpt.swp391_onlinelearning.service.iservice.IService;
import java.util.List;

/**
 *
 * @author Admin
 */
public class RoleService implements IService<RoleDTO> {

    private IDAO<Role> roleDAO;
    private static RoleService roleService;

    public static RoleService getInstance(IDAO<Role> roleDAO) {
        if (roleService == null) {
            roleService = new RoleService(roleDAO);
        }
        return roleService;
    }

    public RoleService(IDAO<Role> roleDAO) {
        this.roleDAO = roleDAO;
    }

    @Override
    public List<RoleDTO> getAll() {

        return Converter.toRoleDTO(roleDAO.getAll());
    }

    @Override
    public RoleDTO get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean update(RoleDTO t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean insert(RoleDTO t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


}
