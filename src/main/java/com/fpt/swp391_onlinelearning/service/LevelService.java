/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.swp391_onlinelearning.service;

import com.fpt.swp391_onlinelearning.convert.Converter;
import com.fpt.swp391_onlinelearning.dal.idbcontex.IDAO;
import com.fpt.swp391_onlinelearning.dal.idbcontex.ILevelDAO;
import com.fpt.swp391_onlinelearning.dto.LevelDTO;
import com.fpt.swp391_onlinelearning.model.Level;
import com.fpt.swp391_onlinelearning.service.iservice.ILevelService;
import com.fpt.swp391_onlinelearning.service.iservice.IService;
import java.util.List;

/**
 *
 * @author Admin
 */
public class LevelService implements IService<LevelDTO>, ILevelService{
    private IDAO<Level> _iDao;
    private ILevelDAO _iLevelDAO;
    private static LevelService levelService;

    public LevelService(IDAO<Level> _iDao, ILevelDAO _iLevelDAO) {
        this._iDao = _iDao;
        this._iLevelDAO = _iLevelDAO;
    }

    public static LevelService getInstance(IDAO levelDAO, ILevelDAO _iLevelDAO) {
        if (levelService == null) {
            levelService = new LevelService(levelDAO, _iLevelDAO);
        }
        return levelService;
    }
    
    @Override
    public List<LevelDTO> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public LevelDTO get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean update(LevelDTO t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean insert(LevelDTO t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<LevelDTO> getAllLevel() {
        List<Level> level = _iLevelDAO.getAllLevel();
        return Converter.toLevelDTO(level);
    }
    
}
