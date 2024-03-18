/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.swp391_onlinelearning.service;

import com.fpt.swp391_onlinelearning.convert.Converter;
import com.fpt.swp391_onlinelearning.dal.idbcontex.IBlogDAO;
import com.fpt.swp391_onlinelearning.dto.BlogCategoryDTO;
import com.fpt.swp391_onlinelearning.dto.BlogDTO;
import com.fpt.swp391_onlinelearning.model.Blog;
import com.fpt.swp391_onlinelearning.model.BlogCategory;
import com.fpt.swp391_onlinelearning.service.iservice.IBlogService;
import com.fpt.swp391_onlinelearning.service.iservice.IService;
import jakarta.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author phuc2
 */
public class BlogService implements IService<BlogDTO>, IBlogService{

    private static BlogService blogService;
    private IBlogDAO iblogdao;
    
    public static BlogService getInstance(IBlogDAO blogDAO)
    {
        if(blogService== null)
        {
            blogService= new BlogService(blogDAO);
        }
        return blogService;
    }
    
    public BlogService(IBlogDAO blogDAO)
    {
        this.iblogdao= blogDAO;
    }
    
    @Override
    public List<BlogDTO> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public BlogDTO get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean update(BlogDTO t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean insert(BlogDTO t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<BlogDTO> getRecentlyBlog(int numOfBlogs) {
        List<Blog> blogList= iblogdao.getRecentlyBlog(numOfBlogs);
        List<BlogDTO> bdtos= new ArrayList<BlogDTO>();
        for(Blog b: blogList)
        {
            BlogDTO bdto= Converter.toDTO(b);
            bdtos.add(bdto);
        }
        return bdtos;
    }

    @Override
    public List<BlogDTO> searchBlog(String title, int blogCategoryId, int pageIndex,int order) {
        List<Blog> blogs = (List<Blog>) iblogdao.searchBlog(title, blogCategoryId, pageIndex,order);
        return Converter.toBlogDTO(blogs);
    }

    @Override
    public List<BlogDTO> getRecentBlog() {
        List<Blog> blogs = (List<Blog>) iblogdao.getRecentBlog();
        return Converter.toBlogDTO(blogs);
    }


    @Override
    public int countNumberOfPageSearchBlog(String title, int blogCategoryId) {
    int count = iblogdao.countNumberOfPageSearchBlog(title, blogCategoryId);
    return count;
    }

    @Override
    public BlogDTO getBlogDetail(int blogId) {
        Blog blog = (Blog) iblogdao.getBlogDetail(blogId);
        return Converter.toBlogDTO(blog);
    }

    
}
