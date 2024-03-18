/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.fpt.swp391_onlinelearning.dal.idal;

import com.fpt.swp391_onlinelearning.model.PostCategory;
import java.util.List;

/**
 *
 * @author quang
 */
public interface IPostCategoryDAO extends IDAO<PostCategory>{
    public List<PostCategory> getListOfShowPostCategory(); 
}
