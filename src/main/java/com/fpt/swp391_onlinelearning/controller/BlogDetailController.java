/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.swp391_onlinelearning.controller;

import com.fpt.swp391_onlinelearning.dal.BlogCategoryDAO;
import com.fpt.swp391_onlinelearning.dal.BlogDAO;
import com.fpt.swp391_onlinelearning.dto.BlogCategoryDTO;
import com.fpt.swp391_onlinelearning.dto.BlogDTO;
import com.fpt.swp391_onlinelearning.service.BlogCategoryService;
import com.fpt.swp391_onlinelearning.service.BlogService;
import com.fpt.swp391_onlinelearning.service.iservice.IBlogCategoryService;
import com.fpt.swp391_onlinelearning.service.iservice.IBlogService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author quang
 */
public class BlogDetailController extends HttpServlet {

    private IBlogService iBlogService;
    private IBlogCategoryService blogCategoryService;

    public void init() throws ServletException {
        iBlogService = BlogService.getInstance(new BlogDAO());
        blogCategoryService = BlogCategoryService.getInstance(new BlogCategoryDAO());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String blogIdString = req.getParameter("id");
        int blogId = Integer.parseInt(blogIdString);
        BlogDTO bdto = (BlogDTO) iBlogService.getBlogDetail(blogId);
        List<BlogDTO> bdtos = iBlogService.getRecentBlog();
        List<BlogCategoryDTO> bcdtos = blogCategoryService.getAllBlogCategory();
        req.setAttribute("bdto", bdto);
        req.setAttribute("bdtos", bdtos);
        req.setAttribute("bcdtos", bcdtos);
        req.getRequestDispatcher("view/blogdetail.jsp").forward(req, resp);

    }

}
