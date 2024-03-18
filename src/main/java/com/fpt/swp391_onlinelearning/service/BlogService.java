/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.swp391_onlinelearning.service;

import com.fpt.swp391_onlinelearning.convert.Converter;
import com.fpt.swp391_onlinelearning.dal.idal.IBlogDAO;
import com.fpt.swp391_onlinelearning.dto.BlogDTO;
import com.fpt.swp391_onlinelearning.model.Blog;
import com.fpt.swp391_onlinelearning.service.iservice.IBlogService;
import com.fpt.swp391_onlinelearning.service.iservice.IService;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author phuc2
 */
public class BlogService implements IService<BlogDTO>, IBlogService {
    
    private static BlogService blogService;
    private IBlogDAO iblogdao;
    
    public static BlogService getInstance(IBlogDAO blogDAO) {
        if (blogService == null) {
            blogService = new BlogService(blogDAO);
        }
        return blogService;
    }
    
    public BlogService(IBlogDAO blogDAO) {
        this.iblogdao = blogDAO;
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
        Blog blog = Converter.toBlogDomain(t);
        iblogdao.update(blog);
        return false;
    }
    
    @Override
    public boolean insert(BlogDTO t) {
        Blog blog = Converter.toBlogDomain1(t);
        iblogdao.insert(blog);
        return true;
    }
    
    @Override
    public boolean delete(int id) {
        iblogdao.delete(id);
        return true;
    }
    
    @Override
    public List<BlogDTO> getRecentlyBlog(int numOfBlogs) {
        List<Blog> blogList = iblogdao.getRecentlyBlog(numOfBlogs);
        List<BlogDTO> bdtos = new ArrayList<BlogDTO>();
        for (Blog b : blogList) {
            BlogDTO bdto = Converter.toDTO(b);
            bdtos.add(bdto);
        }
        return bdtos;
    }
    
    @Override
    public List<BlogDTO> searchBlog(String title, int blogCategoryId, int pageIndex, int order) {
        List<Blog> blogs = (List<Blog>) iblogdao.searchBlog(title, blogCategoryId, pageIndex, order);
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
        if (blog != null) {
            return Converter.toBlogDTO(blog);
        }
        return null;
    }
    
    @Override
    public List<BlogDTO> getSearchList(String title, int blogCategoryId, int pageIndex, String author, Date from, Date to) {
        List<Blog> blogs = (List<Blog>) iblogdao.getSearchList(title, blogCategoryId, pageIndex, author, from, to);
        return Converter.toBlogDTO(blogs);
    }
    
    @Override
    public BlogDTO getDetail(int blogId) {
        Blog blog = (Blog) iblogdao.getDetail(blogId);
        return Converter.toBlogDTO(blog);
    }
    
    @Override
    public int countNumberOfPageSearch(String title, int blogCategoryId, String author, Date from, Date to) {
        int totalRecord = iblogdao.countRecordOfSearchList(title, blogCategoryId, author, from, to);
        int totalPage = (totalRecord % 8 == 0) ? (totalRecord / 8) : ((totalRecord / 8) + 1);
        return totalPage;
    }
    
    @Override
    public void changeStatus(String blogId, String status) {
        int blogIdInt = Integer.parseInt(blogId);
        boolean statusBoolean = !(status == null);
        System.out.println(status + " " + blogIdInt);
        iblogdao.changeStatus(blogIdInt, statusBoolean);
    }
    
    @Override
    public List<BlogDTO> getSearchList(String title, int blogCategoryId, int pageIndex, int authorId, Date from, Date to) {
        List<Blog> blogs = (List<Blog>) iblogdao.getSearchList(title, blogCategoryId, pageIndex, authorId, from, to);
        return Converter.toBlogDTO(blogs);
    }
    
    @Override
    public int countNumberOfPageSearch(String title, int blogCategoryId, int authorId, Date from, Date to) {
        int totalRecord = iblogdao.countRecordOfSearchList(title, blogCategoryId, authorId, from, to);
        int totalPage = (totalRecord % 8 == 0) ? (totalRecord / 8) : ((totalRecord / 8) + 1);
        return totalPage;
    }
}
