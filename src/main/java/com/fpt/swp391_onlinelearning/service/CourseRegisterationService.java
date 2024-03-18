/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.swp391_onlinelearning.service;

import com.fpt.swp391_onlinelearning.convert.Converter;
import com.fpt.swp391_onlinelearning.dal.CourseCategoryDAO;
import com.fpt.swp391_onlinelearning.dal.CourseRegisterationDAO;
import com.fpt.swp391_onlinelearning.dal.idbcontex.ICourseCategoryDAO;
import com.fpt.swp391_onlinelearning.dal.idbcontex.ICourseRegisterationDAO;
import com.fpt.swp391_onlinelearning.dto.CourseRegisterationDTO;
import com.fpt.swp391_onlinelearning.model.CourseRegisteration;
import com.fpt.swp391_onlinelearning.service.iservice.ICourseRegisterationService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tran Hoang Phuc
 */
public class CourseRegisterationService implements ICourseRegisterationService{
    private static CourseRegisterationService courseRegisterationService;
    private ICourseRegisterationDAO _iCourseRegisterationDAO;

    public CourseRegisterationService(ICourseRegisterationDAO _iCourseRegisterationDAO) {
        this._iCourseRegisterationDAO = _iCourseRegisterationDAO;
    }
    
    public static CourseRegisterationService getInstance(ICourseRegisterationDAO _iCourseRegisteration) {
        if (courseRegisterationService == null) {
            courseRegisterationService = new CourseRegisterationService(_iCourseRegisteration);
        }
        return courseRegisterationService;
    }
    @Override
    public List<CourseRegisterationDTO> getRegisterdCourse(int id) {
        List<CourseRegisterationDTO> registerationDTOs = new ArrayList<>();
        for (CourseRegisteration registeration : _iCourseRegisterationDAO.getRegisterdCourse(id)) {
            registerationDTOs.add(Converter.toDto(registeration));
        }
        return registerationDTOs;
    }
    
   
}
