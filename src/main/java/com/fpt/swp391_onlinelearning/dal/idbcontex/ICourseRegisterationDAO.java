/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.fpt.swp391_onlinelearning.dal.idbcontex;

import com.fpt.swp391_onlinelearning.model.CourseRegisteration;
import java.util.List;

/**
 *
 * @author tran Hoang Phuc
 */
public interface ICourseRegisterationDAO {
    public List<CourseRegisteration> getRegisterdCourse(int id);
}
