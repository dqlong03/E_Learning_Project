/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.swp391_onlinelearning.service;

import com.fpt.swp391_onlinelearning.convert.Converter;
import com.fpt.swp391_onlinelearning.dal.idal.IDAO;
import com.fpt.swp391_onlinelearning.dal.idal.ISettingListDAO;
import com.fpt.swp391_onlinelearning.dto.SettingDTO;
import com.fpt.swp391_onlinelearning.dto.SettingTypeDTO;
import com.fpt.swp391_onlinelearning.model.Setting;
import com.fpt.swp391_onlinelearning.service.iservice.IService;
import com.fpt.swp391_onlinelearning.service.iservice.ISettingListService;
import java.util.List;

/**
 *
 * @author Admin
 */
public class SettingListService implements IService<SettingDTO>, ISettingListService {

    private static SettingListService settingService;
    private ISettingListDAO _iCourseDAO;
    private IDAO<Setting> _iDao;

    public static SettingListService getInstance(IDAO<Setting> _iDao, ISettingListDAO _iCourseDAO) {
        if (settingService == null) {
            settingService = new SettingListService(_iDao, _iCourseDAO);
        }
        return settingService;
    }

    public SettingListService(IDAO<Setting> _iDao, ISettingListDAO _iCourseDAO) {
        this._iDao = _iDao;
        this._iCourseDAO = _iCourseDAO;
    }

    @Override
    public List<SettingDTO> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

    }

    @Override
    public SettingDTO get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean update(SettingDTO t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean insert(SettingDTO t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<SettingDTO> getAll(int pageindex, int pagesize, String info, int typeid, int status) {
        return Converter.toSettingDTO(_iCourseDAO.getAll(pageindex, pagesize, info, typeid, status));
    }

    @Override
    public List<SettingTypeDTO> getAllType() {
        return Converter.toSettingTypeDTO(_iCourseDAO.getAllType());
    }

    @Override
    public int getCount(String info, int typeid, int status) {
        return _iCourseDAO.getCount(info, typeid, status);
    }

    @Override
    public void update(int typeid, int id, String name, int status) {

        _iCourseDAO.update(typeid, id, name, status);
    }

    @Override
    public void insert(int typeid, String name, int status) {
        _iCourseDAO.insert(typeid, name, status);
    }

}
