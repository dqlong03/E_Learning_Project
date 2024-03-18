/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.swp391_onlinelearning.controller;

import com.fpt.swp391_onlinelearning.dal.BlogCategoryDAO;
import com.fpt.swp391_onlinelearning.dal.BlogDAO;
import com.fpt.swp391_onlinelearning.dal.BlogViewDAO;
import com.fpt.swp391_onlinelearning.dto.BlogCategoryDTO;
import com.fpt.swp391_onlinelearning.dto.BlogDTO;
import com.fpt.swp391_onlinelearning.dto.BlogViewDTO;
import com.fpt.swp391_onlinelearning.dto.UserDTO;
import com.fpt.swp391_onlinelearning.service.BlogCategoryService;
import com.fpt.swp391_onlinelearning.service.BlogService;
import com.fpt.swp391_onlinelearning.service.BlogViewService;
import com.fpt.swp391_onlinelearning.service.iservice.IBlogCategoryService;
import com.fpt.swp391_onlinelearning.service.iservice.IBlogService;
import com.fpt.swp391_onlinelearning.service.iservice.IBlogViewService;
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
    private IBlogViewService _IBlogViewService;

    public void init() throws ServletException {
        iBlogService = BlogService.getInstance(new BlogDAO());
        blogCategoryService = BlogCategoryService.getInstance(new BlogCategoryDAO());
        _IBlogViewService = BlogViewService.getInstance(new BlogViewDAO());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String blogIdString = req.getParameter("id");
        int blogId = Integer.parseInt(blogIdString);
        BlogDTO bdto = (BlogDTO) iBlogService.getBlogDetail(blogId);
        if (bdto != null) {

            List<BlogDTO> bdtos = iBlogService.getRecentBlog();
            List<BlogCategoryDTO> bcdtos = blogCategoryService.getAllBlogCategory();
            BlogViewDTO bvdto = new BlogViewDTO();
            BlogDTO b = new BlogDTO();
            b.setBlogId(blogId);
            bvdto.setBlog(b);
            if (req.getSession().getAttribute("user") != null) {
                UserDTO udto = (UserDTO) req.getSession().getAttribute("user");
                bvdto.setUser(udto);
            }
            _IBlogViewService.addNewBlogView(bvdto);

            req.setAttribute("bdto", bdto);
            req.setAttribute("bdtos", bdtos);
            req.setAttribute("bcdtos", bcdtos);
            req.getRequestDispatcher("view/blogdetail.jsp").forward(req, resp);
        } else {
            resp.sendRedirect(req.getContextPath() + "/bloglist");
        }
    }

}
