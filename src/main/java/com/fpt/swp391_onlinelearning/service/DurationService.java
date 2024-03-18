/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.swp391_onlinelearning.service;

import com.fpt.swp391_onlinelearning.convert.Converter;
import com.fpt.swp391_onlinelearning.dal.idbcontex.IDAO;
import com.fpt.swp391_onlinelearning.dal.idbcontex.IDurationDAO;
import com.fpt.swp391_onlinelearning.dto.DurationDTO;
import com.fpt.swp391_onlinelearning.model.Duration;
import com.fpt.swp391_onlinelearning.service.iservice.IDurationService;
import com.fpt.swp391_onlinelearning.service.iservice.IService;
import java.util.List;

/**
 *
 * @author Admin
 */
public class DurationService implements IService<DurationDTO>, IDurationService{
        private IDAO<Duration> _iDao;
    private IDurationDAO _iDurationDAO;
    private static DurationService durationService;

    public DurationService(IDAO<Duration> _iDao, IDurationDAO _iDurationDAO) {
        this._iDao = _iDao;
        this._iDurationDAO = _iDurationDAO;
    }

    public static DurationService getInstance(IDAO durationDAO, IDurationDAO _iDurationDAO) {
        if (durationService == null) {
            durationService = new DurationService(durationDAO, _iDurationDAO);
        }
        return durationService;
    }
    @Override
    public List<DurationDTO> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public DurationDTO get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean update(DurationDTO t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean insert(DurationDTO t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<DurationDTO> getAllDuration() {
        List<Duration> duration = _iDurationDAO.getAllDuration();
        return Converter.toDTO1(duration);
    }
    
}
