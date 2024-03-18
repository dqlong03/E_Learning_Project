/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.fpt.swp391_onlinelearning.service.iservice;

import com.fpt.swp391_onlinelearning.dto.PostCategoryDTO;
import com.fpt.swp391_onlinelearning.model.PostCategory;
import java.util.List;

/**
 *
 * @author quang
 */
public interface IPostCategoryService extends IService<PostCategory>{
    public List<PostCategoryDTO> getListOfShowPostCategory(); 
}
