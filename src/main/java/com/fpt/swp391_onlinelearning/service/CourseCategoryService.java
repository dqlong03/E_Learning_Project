/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.swp391_onlinelearning.service;

import com.fpt.swp391_onlinelearning.convert.Converter;
import com.fpt.swp391_onlinelearning.dal.idbcontex.ICourseDAO;
import com.fpt.swp391_onlinelearning.model.CourseCategory;
import com.fpt.swp391_onlinelearning.service.iservice.ICourseCategoryService;
import java.util.ArrayList;
import com.fpt.swp391_onlinelearning.dal.idbcontex.ICourseCategoryDAO;
import com.fpt.swp391_onlinelearning.dto.CourseCategoryDTO;
import java.util.List;

/**
 *
 * @author Admin
 */
public class CourseCategoryService implements ICourseCategoryService{
    private static CourseCategoryService courseCategoryService;
    private ICourseCategoryDAO courseCategoryDAO;
    
        public static CourseCategoryService getInstance(ICourseCategoryDAO courseCategoryDAO) {
        if (courseCategoryService == null) {
            courseCategoryService = new CourseCategoryService(courseCategoryDAO);
        }
        return courseCategoryService;
    }

    public CourseCategoryService(ICourseCategoryDAO courseCategoryDAO) {
        this.courseCategoryDAO = courseCategoryDAO;
    }
    
    @Override
    public List<CourseCategoryDTO> getAllCategory() {
        ArrayList<CourseCategory> coursecategory = (ArrayList<CourseCategory>) courseCategoryDAO.getAllCategory();
        return Converter.toDTO(coursecategory);
    }
    
}
