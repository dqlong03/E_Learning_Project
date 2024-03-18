/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.swp391_onlinelearning.service;

import com.fpt.swp391_onlinelearning.convert.Converter;
import com.fpt.swp391_onlinelearning.dal.idal.IBLogCategoryDAO;
import com.fpt.swp391_onlinelearning.dto.BlogCategoryDTO;
import com.fpt.swp391_onlinelearning.model.BlogCategory;
import com.fpt.swp391_onlinelearning.service.iservice.IBlogCategoryService;
import java.util.List;

/**
 *
 * @author quang
 */
public class BlogCategoryService implements IBlogCategoryService {

    private static BlogCategoryService blogCategoryService;
    private IBLogCategoryDAO blogCategoryDAO;

    public static BlogCategoryService getInstance(IBLogCategoryDAO blogCategoryDAO) {
        if (blogCategoryService == null) {
            blogCategoryService = new BlogCategoryService(blogCategoryDAO);
        }
        return blogCategoryService;
    }

    public BlogCategoryService(IBLogCategoryDAO blogCategoryDAO) {
        this.blogCategoryDAO = blogCategoryDAO;
    }

    @Override
    public List<BlogCategoryDTO> getAllBlogCategory() {
        List<BlogCategory> blogCategory = blogCategoryDAO.getAllBlogCategory();
        return Converter.toBlogCategoryDTO(blogCategory);
    }
}
