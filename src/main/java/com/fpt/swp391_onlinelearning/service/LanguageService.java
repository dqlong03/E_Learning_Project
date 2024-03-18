/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.swp391_onlinelearning.service;

import com.fpt.swp391_onlinelearning.convert.Converter;
import com.fpt.swp391_onlinelearning.dal.idal.IDAO;
import com.fpt.swp391_onlinelearning.dal.idal.ILanguageDAO;
import com.fpt.swp391_onlinelearning.dto.LanguageDTO;
import com.fpt.swp391_onlinelearning.model.Language;
import com.fpt.swp391_onlinelearning.service.iservice.ILanguageService;
import com.fpt.swp391_onlinelearning.service.iservice.IService;
import java.util.List;

/**
 *
 * @author Admin
 */
public class LanguageService implements IService<LanguageDTO>,ILanguageService{
    private IDAO<Language> _iDao;
    private ILanguageDAO _iLanguageDAO;
    private static LanguageService languageService;
    
    public LanguageService(IDAO<Language> _iDao, ILanguageDAO _iLanguageDAO) {
        this._iDao = _iDao;
        this._iLanguageDAO = _iLanguageDAO;
    }

    public static LanguageService getInstance(IDAO languageDAO, ILanguageDAO _iLanguageDAO) {
        if (languageService == null) {
            languageService = new LanguageService(languageDAO, _iLanguageDAO);
        }
        return languageService;
    }
    @Override
    public List<LanguageDTO> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public LanguageDTO get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean update(LanguageDTO t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean insert(LanguageDTO t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<LanguageDTO> getAllLanguage() {
        List<Language> language = _iLanguageDAO.getAllLanguage();
        return Converter.toDTO2(language);
    }
    
}
