/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.swp391_onlinelearning.service;

import com.fpt.swp391_onlinelearning.convert.Converter;
import com.fpt.swp391_onlinelearning.dal.PostDAO;
import com.fpt.swp391_onlinelearning.dal.idal.IPostDAO;
import com.fpt.swp391_onlinelearning.dto.PostDTO;
import com.fpt.swp391_onlinelearning.model.Post;
import com.fpt.swp391_onlinelearning.service.iservice.IPostService;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author quang
 */
public class PostService implements IPostService {

    private static PostService postService;
    private static IPostDAO iPostDAO;

    public static PostService getInstance(PostDAO postDAO) {
        if (postService == null) {
            postService = new PostService(postDAO);
        }
        return postService;
    }

    public PostService(PostDAO postDAO) {
        this.iPostDAO = postDAO;
    }

    @Override
    public List<PostDTO> getAllShowPost() {
        List<Post> posts = iPostDAO.getAllShowPost();
        return Converter.toPostDto3(posts);
    }

    @Override
    public List<PostDTO> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public PostDTO get(int id) {
        Post post = iPostDAO.get(id);
        return Converter.toDto5(post);
    }

    @Override
    public boolean update(PostDTO t) {
        Post post = Converter.toPostUpdateDomain(t);
        iPostDAO.update(post);
        return true;
    }

    @Override
    public boolean insert(PostDTO t) {
        Post post = Converter.toPostInserteDomain(t);
        iPostDAO.insert(post);
        return true;
    }

    @Override
    public boolean delete(int id) {
        iPostDAO.delete(id);
        return true;
    }

    @Override
    public List<PostDTO> searchListPost(String searchInput, Date timeFrom, Date timeTo, int pageIndex, int postCategoryId) {
        List<Post> posts = iPostDAO.searchListPost(searchInput, timeFrom, timeTo, pageIndex, postCategoryId);
        return Converter.toPostDto4(posts);
    }

    @Override
    public int countNumberOfPageSearchPost(String searchInput, Date timeFrom, Date timeTo, int postCategoryId) {
        int count = iPostDAO.countNumberOfPageSearchPost(searchInput, timeFrom, timeTo, postCategoryId);
        return count;
    }

}
