/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.fpt.swp391_onlinelearning.service.iservice;

import com.fpt.swp391_onlinelearning.dto.BlogCategoryDTO;
import java.util.List;

/**
 *
 * @author quang
 */
public interface IBlogCategoryService {

    public List<BlogCategoryDTO> getAllBlogCategory();
}
