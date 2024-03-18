/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.swp391_onlinelearning.controller;

import com.fpt.swp391_onlinelearning.dal.BlogCategoryDAO;
import com.fpt.swp391_onlinelearning.dal.BlogDAO;
import com.fpt.swp391_onlinelearning.dal.CourseDAO;
import com.fpt.swp391_onlinelearning.dto.BlogCategoryDTO;
import com.fpt.swp391_onlinelearning.dto.BlogDTO;
import com.fpt.swp391_onlinelearning.dto.CourseDTO;
import com.fpt.swp391_onlinelearning.dto.UserDTO;
import com.fpt.swp391_onlinelearning.service.BlogCategoryService;
import com.fpt.swp391_onlinelearning.service.BlogService;
import com.fpt.swp391_onlinelearning.service.CourseService;
import com.fpt.swp391_onlinelearning.service.iservice.IBlogCategoryService;
import com.fpt.swp391_onlinelearning.service.iservice.IBlogService;
import com.fpt.swp391_onlinelearning.service.iservice.ICourseService;
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
public class BlogListController extends HttpServlet {

    private IBlogService iBlogService;
    private IBlogCategoryService blogCategoryService;
    private ICourseService iCourseService;

    public void init() throws ServletException {
        iBlogService = BlogService.getInstance(new BlogDAO());
        blogCategoryService = BlogCategoryService.getInstance(new BlogCategoryDAO());
        iCourseService = CourseService.getInstance(new CourseDAO(), new CourseDAO());

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pageIndexString = req.getParameter("pageIndex");
        if (pageIndexString == null || pageIndexString.trim().length() == 0) {
            pageIndexString = "1";
        }
        int pageIndex = Integer.parseInt(pageIndexString);

        String orderTimeString = req.getParameter("orderTime");
        if (orderTimeString == null || orderTimeString.trim().length() == 0) {
            orderTimeString = "1";
        }
        int orderTime = Integer.parseInt(orderTimeString);

        String categoryIdString = req.getParameter("category");
        if (categoryIdString == null || categoryIdString.trim().length() == 0) {
            categoryIdString = "-1";
        }
        int categoryId = Integer.parseInt(categoryIdString);

        String title = req.getParameter("title");
        if (title == null) {
            title = "";
        }

        if (req.getSession().getAttribute("user") != null) {
            UserDTO udto = (UserDTO) req.getSession().getAttribute("user");
            List<CourseDTO> dtos = iCourseService.getTempCourseEnrollmemt(udto.getUserId());
            if (!dtos.isEmpty()) {
                req.getSession().setAttribute("dtos", dtos);
            } else {
                req.getSession().setAttribute("dtos", null);
            }
        }
        List<BlogDTO> blogDTOs = iBlogService.searchBlog(title, categoryId, pageIndex, orderTime);
        List<BlogDTO> bdtos = iBlogService.getRecentBlog();
        List<BlogCategoryDTO> bcdtos = blogCategoryService.getAllBlogCategory();
        int numberOfPageBlog = iBlogService.countNumberOfPageSearchBlog(title, categoryId);

        req.setAttribute("title", title);
        req.setAttribute("categoryId", categoryId);
        req.setAttribute("orderTime", orderTime);
        req.setAttribute("pageIndex", pageIndex);
        req.setAttribute("numberOfPageBlog", numberOfPageBlog);
        req.setAttribute("bdtos", bdtos);
        req.setAttribute("bcdtos", bcdtos);
        req.setAttribute("blogDTOs", blogDTOs);
        req.getRequestDispatcher("view/bloglist.jsp").forward(req, resp);
    }

}
