/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.swp391_onlinelearning.controller;

import com.fpt.swp391_onlinelearning.baseController.BaseRequiredAuthorizationController;
import com.fpt.swp391_onlinelearning.dal.BlogCategoryDAO;
import com.fpt.swp391_onlinelearning.dal.BlogDAO;
import com.fpt.swp391_onlinelearning.dto.AccountDTO;
import com.fpt.swp391_onlinelearning.dto.BlogCategoryDTO;
import com.fpt.swp391_onlinelearning.dto.BlogDTO;
import com.fpt.swp391_onlinelearning.dto.FeatureDTO;
import com.fpt.swp391_onlinelearning.service.BlogCategoryService;
import com.fpt.swp391_onlinelearning.service.BlogService;
import com.fpt.swp391_onlinelearning.service.iservice.IBlogCategoryService;
import com.fpt.swp391_onlinelearning.service.iservice.IBlogService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Admin
 */
public class BlogsDashboardController extends BaseRequiredAuthorizationController {

    private IBlogService iBlogService;
    private IBlogCategoryService blogCategoryService;

    public void init() throws ServletException {
        iBlogService = BlogService.getInstance(new BlogDAO());
        blogCategoryService = BlogCategoryService.getInstance(new BlogCategoryDAO());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp, AccountDTO user, boolean isActivated, Set<FeatureDTO> features) throws ServletException, IOException {
        String title = req.getParameter("title");
        String author = req.getParameter("author");
        int categoryId = req.getParameter("blog_category") == null ? 0 : Integer.parseInt(req.getParameter("blog_category"));
        Date dateFrom = req.getParameter("date_from") == null ? Date.valueOf("2003-01-01") : Date.valueOf(req.getParameter("date_from"));
        Date dateTo = req.getParameter("date_to") == null ? new Date(System.currentTimeMillis()) : Date.valueOf(req.getParameter("date_to"));

        List<BlogCategoryDTO> blogCategoryList = blogCategoryService.getAllBlogCategory();

        int pageIndex = req.getParameter("page") != null ? Integer.parseInt(req.getParameter("page")) : 1;
        int totalPage = iBlogService.countNumberOfPageSearch(title, categoryId, author, dateFrom, dateTo);

        List<BlogDTO> blogs = iBlogService.getSearchList(title, categoryId, pageIndex, author, dateFrom, dateTo);

        int blogId = req.getParameter("blogId") == null ? blogs.get(0).getBlogId() : Integer.parseInt(req.getParameter("blogId"));
        BlogDTO blog = iBlogService.getDetail(blogId);

        req.setAttribute("blogs", blogs);
        req.setAttribute("pageIndex", pageIndex);
        req.setAttribute("totalPage", totalPage);
        req.setAttribute("blogCategoryList", blogCategoryList);
        req.setAttribute("title", title);
        req.setAttribute("author", author);
        req.setAttribute("blogCategory", categoryId);
        req.setAttribute("dateFrom", dateFrom);
        req.setAttribute("dateTo", dateTo);
        req.setAttribute("blog", blog);
        req.getRequestDispatcher("../view/blogsDashboard.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp, AccountDTO user, boolean isActivated, Set<FeatureDTO> features) throws ServletException, IOException {
        String title = req.getParameter("title");
        String author = req.getParameter("author");
        int categoryId = req.getParameter("blog_category") == null ? 0 : Integer.parseInt(req.getParameter("blog_category"));
        Date dateFrom = req.getParameter("date_from") == null ? Date.valueOf("2003-01-01") : Date.valueOf(req.getParameter("date_from"));
        Date dateTo = req.getParameter("date_to") == null ? new Date(System.currentTimeMillis()) : Date.valueOf(req.getParameter("date_to"));

        List<BlogCategoryDTO> blogCategoryList = blogCategoryService.getAllBlogCategory();

        int pageIndex = req.getParameter("page") != null ? Integer.parseInt(req.getParameter("page")) : 1;
        int totalPage = iBlogService.countNumberOfPageSearch(title, categoryId, author, dateFrom, dateTo);

        iBlogService.changeStatus(req.getParameter("blogIdStatus"), req.getParameter("blogStatus"));
        List<BlogDTO> blogs = iBlogService.getSearchList(title, categoryId, pageIndex, author, dateFrom, dateTo);

        int blogId = req.getParameter("blogId") == null ? blogs.get(0).getBlogId() : Integer.parseInt(req.getParameter("blogId"));
        BlogDTO blog = iBlogService.getDetail(blogId);

        req.setAttribute("blogs", blogs);
        req.setAttribute("pageIndex", pageIndex);
        req.setAttribute("totalPage", totalPage);
        req.setAttribute("blogCategoryList", blogCategoryList);

        req.setAttribute("title", title);
        req.setAttribute("author", author);
        req.setAttribute("blogCategory", categoryId);
        req.setAttribute("dateFrom", dateFrom);
        req.setAttribute("dateTo", dateTo);

        req.setAttribute("blog", blog);


        req.getRequestDispatcher("../view/blogsDashboard.jsp").forward(req, resp);
    }

}
