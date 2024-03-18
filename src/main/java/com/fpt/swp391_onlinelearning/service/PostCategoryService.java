/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.swp391_onlinelearning.service;

import com.fpt.swp391_onlinelearning.convert.Converter;
import com.fpt.swp391_onlinelearning.dal.PostCategoryDAO;
import com.fpt.swp391_onlinelearning.dal.idal.IPostCategoryDAO;
import com.fpt.swp391_onlinelearning.dto.PostCategoryDTO;
import com.fpt.swp391_onlinelearning.model.PostCategory;
import com.fpt.swp391_onlinelearning.service.iservice.IPostCategoryService;
import java.util.List;

/**
 *
 * @author quang
 */
public class PostCategoryService implements IPostCategoryService {

    private static PostCategoryService postCategoryService;
    private IPostCategoryDAO postCategoryDAO;

    public static PostCategoryService getInstance(PostCategoryDAO postCategoryDAO) {
        if (postCategoryService == null) {
            postCategoryService = new PostCategoryService(postCategoryDAO);
        }
        return postCategoryService;
    }

    public PostCategoryService(PostCategoryDAO postCategoryDAO) {
        this.postCategoryDAO = postCategoryDAO;
    }

    @Override
    public List<PostCategoryDTO> getListOfShowPostCategory() {
    List<PostCategory> categorys = postCategoryDAO.getListOfShowPostCategory();
        return Converter.toPostCategoryDto3(categorys);
    }

    @Override
    public List<PostCategory> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public PostCategory get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean update(PostCategory t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean insert(PostCategory t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
