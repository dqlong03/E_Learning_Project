/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.swp391_onlinelearning.service;

import com.fpt.swp391_onlinelearning.convert.Converter;
import com.fpt.swp391_onlinelearning.model.CourseCategory;
import com.fpt.swp391_onlinelearning.dal.idal.IDAO;
import com.fpt.swp391_onlinelearning.dto.CourseCategoryDTO;
import com.fpt.swp391_onlinelearning.service.iservice.IService;
import java.util.List;

/**
 *
 * @author Admin
 */
public class CourseCategoryService implements IService<CourseCategoryDTO> {

    private static CourseCategoryService courseCategoryService;
    private IDAO<CourseCategory> courseCategoryDAO;

    public static CourseCategoryService getInstance(IDAO<CourseCategory> courseCategoryDAO) {
        if (courseCategoryService == null) {
            courseCategoryService = new CourseCategoryService(courseCategoryDAO);
        }
        return courseCategoryService;
    }

    public CourseCategoryService(IDAO<CourseCategory> courseCategoryDAO) {
        this.courseCategoryDAO = courseCategoryDAO;
    }

    @Override
    public List<CourseCategoryDTO> getAll() {
        return Converter.toDto(courseCategoryDAO.getAll());
    }

    @Override
    public CourseCategoryDTO get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean update(CourseCategoryDTO t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean insert(CourseCategoryDTO t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
