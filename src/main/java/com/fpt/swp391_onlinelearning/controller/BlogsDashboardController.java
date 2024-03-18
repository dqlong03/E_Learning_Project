/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.swp391_onlinelearning.controller;

import com.fpt.swp391_onlinelearning.baseController.BaseRequiredAuthorizationController;
import com.fpt.swp391_onlinelearning.dal.BlogCategoryDAO;
import com.fpt.swp391_onlinelearning.dal.BlogDAO;
import com.fpt.swp391_onlinelearning.dal.BlogViewDAO;
import com.fpt.swp391_onlinelearning.dal.UserDAO;
import com.fpt.swp391_onlinelearning.dto.AccountDTO;
import com.fpt.swp391_onlinelearning.dto.BlogCategoryDTO;
import com.fpt.swp391_onlinelearning.dto.BlogDTO;
import com.fpt.swp391_onlinelearning.dto.FeatureDTO;
import com.fpt.swp391_onlinelearning.dto.UserDTO;
import com.fpt.swp391_onlinelearning.service.BlogCategoryService;
import com.fpt.swp391_onlinelearning.service.BlogService;
import com.fpt.swp391_onlinelearning.service.BlogViewService;
import com.fpt.swp391_onlinelearning.service.UserService;
import com.fpt.swp391_onlinelearning.service.iservice.IBlogCategoryService;
import com.fpt.swp391_onlinelearning.service.iservice.IBlogService;
import com.fpt.swp391_onlinelearning.service.iservice.IBlogViewService;
import com.fpt.swp391_onlinelearning.service.iservice.IUserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Base64;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Admin
 */
@MultipartConfig
public class BlogsDashboardController extends BaseRequiredAuthorizationController {

    private IBlogService iBlogService;
    private IBlogCategoryService blogCategoryService;
    private static IUserService userService;
    private static IBlogViewService iBlogViewService;

    public void init() throws ServletException {
        iBlogService = BlogService.getInstance(new BlogDAO());
        blogCategoryService = BlogCategoryService.getInstance(new BlogCategoryDAO());
        userService = UserService.getInstace(new UserDAO(), new UserDAO());
        iBlogViewService = BlogViewService.getInstance(new BlogViewDAO());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp, AccountDTO user, boolean isActivated, Set<FeatureDTO> features) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (null == action) {
            String title = req.getParameter("title");
            int categoryId = req.getParameter("blog_category") == null ? 0 : Integer.parseInt(req.getParameter("blog_category"));
            Date dateFrom = req.getParameter("date_from") == null ? Date.valueOf("2003-01-01") : Date.valueOf(req.getParameter("date_from"));
            Date dateTo = req.getParameter("date_to") == null ? new Date(System.currentTimeMillis()) : Date.valueOf(req.getParameter("date_to"));
            List<BlogCategoryDTO> blogCategoryList = blogCategoryService.getAllBlogCategory();
            int pageIndex = req.getParameter("page") != null ? Integer.parseInt(req.getParameter("page")) : 1;

            if (user.getRole().getRoleId() == 4) {
                String author = req.getParameter("author");
                int totalPage = iBlogService.countNumberOfPageSearch(title, categoryId, author, dateFrom, dateTo);
                List<BlogDTO> blogs = iBlogService.getSearchList(title, categoryId, pageIndex, author, dateFrom, dateTo);
                if (!blogs.isEmpty()) {
                    int blogId = req.getParameter("blogId") == null ? blogs.get(0).getBlogId() : Integer.parseInt(req.getParameter("blogId"));
                    BlogDTO blog = iBlogService.getDetail(blogId);
                    req.setAttribute("blog", blog);
                }
                req.setAttribute("blogs", blogs);
                req.setAttribute("totalPage", totalPage);
                req.setAttribute("author", author);
            } else {
                UserDTO author = userService.getUserByAccountId(user.getAccId());
                int totalPage = iBlogService.countNumberOfPageSearch(title, categoryId, author.getUserId(), dateFrom, dateTo);
                List<BlogDTO> blogs = iBlogService.getSearchList(title, categoryId, pageIndex, author.getUserId(), dateFrom, dateTo);
                if (!blogs.isEmpty()) {
                    int blogId = req.getParameter("blogId") == null ? blogs.get(0).getBlogId() : Integer.parseInt(req.getParameter("blogId"));
                    BlogDTO blog = iBlogService.getDetail(blogId);
                    req.setAttribute("blog", blog);
                }
                req.setAttribute("blogs", blogs);
                req.setAttribute("totalPage", totalPage);

            }
            req.setAttribute("pageIndex", pageIndex);
            req.setAttribute("blogCategoryList", blogCategoryList);
            req.setAttribute("roleId", user.getRole().getRoleId());
            req.setAttribute("title", title);
            req.setAttribute("blogCategory", categoryId);
            req.setAttribute("dateFrom", dateFrom);
            req.setAttribute("dateTo", dateTo);

            req.getRequestDispatcher("../view/blogsDashboard.jsp").forward(req, resp);
        } else if (action.equals("add")) {
            List<BlogCategoryDTO> blogCategoryList = blogCategoryService.getAllBlogCategory();
            req.setAttribute("blogCategoryList", blogCategoryList);
            req.getRequestDispatcher("../view/addBlogDashboard.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp, AccountDTO user, boolean isActivated, Set<FeatureDTO> features) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (null == action) {
            String title = req.getParameter("title");
            int categoryId = req.getParameter("blog_category") == null ? 0 : Integer.parseInt(req.getParameter("blog_category"));
            Date dateFrom = req.getParameter("date_from") == null ? Date.valueOf("2003-01-01") : Date.valueOf(req.getParameter("date_from"));
            Date dateTo = req.getParameter("date_to") == null ? new Date(System.currentTimeMillis()) : Date.valueOf(req.getParameter("date_to"));

            List<BlogCategoryDTO> blogCategoryList = blogCategoryService.getAllBlogCategory();
            iBlogService.changeStatus(req.getParameter("blogIdStatus"), req.getParameter("blogStatus"));
            int pageIndex = req.getParameter("page") != null ? Integer.parseInt(req.getParameter("page")) : 1;
            if (user.getRole().getRoleId() == 4) {
                String author = req.getParameter("author");
                int totalPage = iBlogService.countNumberOfPageSearch(title, categoryId, author, dateFrom, dateTo);
                List<BlogDTO> blogs = iBlogService.getSearchList(title, categoryId, pageIndex, author, dateFrom, dateTo);
                if (!blogs.isEmpty()) {
                    int blogId = req.getParameter("blogId") == null ? blogs.get(0).getBlogId() : Integer.parseInt(req.getParameter("blogId"));
                    BlogDTO blog = iBlogService.getDetail(blogId);
                    req.setAttribute("blog", blog);
                }
                req.setAttribute("blogs", blogs);
                req.setAttribute("totalPage", totalPage);
                req.setAttribute("author", author);
            } else {
                UserDTO author = userService.getUserByAccountId(user.getAccId());
                int totalPage = iBlogService.countNumberOfPageSearch(title, categoryId, author.getUserId(), dateFrom, dateTo);
                List<BlogDTO> blogs = iBlogService.getSearchList(title, categoryId, pageIndex, author.getUserId(), dateFrom, dateTo);
                if (!blogs.isEmpty()) {
                    int blogId = req.getParameter("blogId") == null ? blogs.get(0).getBlogId() : Integer.parseInt(req.getParameter("blogId"));
                    BlogDTO blog = iBlogService.getDetail(blogId);
                    req.setAttribute("blog", blog);
                }
                req.setAttribute("blogs", blogs);
                req.setAttribute("totalPage", totalPage);
            }
            req.setAttribute("pageIndex", pageIndex);
            req.setAttribute("blogCategoryList", blogCategoryList);
            req.setAttribute("title", title);
            req.setAttribute("blogCategory", categoryId);
            req.setAttribute("dateFrom", dateFrom);
            req.setAttribute("dateTo", dateTo);
            req.setAttribute("roleId", user.getRole().getRoleId());
            req.getRequestDispatcher("../view/blogsDashboard.jsp").forward(req, resp);
        } else if (action.equals("update")) {
            String title = req.getParameter("title");
            int categoryId = req.getParameter("blog_category") == null ? 0 : Integer.parseInt(req.getParameter("blog_category"));
            Date dateFrom = req.getParameter("date_from") == null ? Date.valueOf("2003-01-01") : Date.valueOf(req.getParameter("date_from"));
            Date dateTo = req.getParameter("date_to") == null ? new Date(System.currentTimeMillis()) : Date.valueOf(req.getParameter("date_to"));

            List<BlogCategoryDTO> blogCategoryList = blogCategoryService.getAllBlogCategory();
            int pageIndex = req.getParameter("page") != null ? Integer.parseInt(req.getParameter("page")) : 1;
            if (user.getRole().getRoleId() == 4) {
                String author = req.getParameter("author");
                int totalPage = iBlogService.countNumberOfPageSearch(title, categoryId, author, dateFrom, dateTo);
                List<BlogDTO> blogs = iBlogService.getSearchList(title, categoryId, pageIndex, author, dateFrom, dateTo);
                if (!blogs.isEmpty()) {
                    int blogId = req.getParameter("blogId") == null ? blogs.get(0).getBlogId() : Integer.parseInt(req.getParameter("blogId"));
                    BlogDTO blog = iBlogService.getDetail(blogId);
                    req.setAttribute("blog", blog);
                }
                req.setAttribute("blogs", blogs);
                req.setAttribute("totalPage", totalPage);
                req.setAttribute("author", author);
            } else {
                InputStream inputStream = req.getPart("imageFile").getInputStream();
                byte[] imageByte = inputStream.readAllBytes();
                String imageData;
                if (imageByte.length == 0) {
                    imageData = req.getParameter("data");
                } else {
                    imageData = "data:image/jpeg;base64," + Base64.getEncoder().encodeToString(imageByte);
                }
                String blogIdRaw = req.getParameter("blogId1");
                int blogId1 = Integer.parseInt(blogIdRaw);
                String title1 = req.getParameter("title1");
                String content = req.getParameter("content");
                String quickReview = req.getParameter("quickReview");
                String blogCIdRaw = req.getParameter("blogCategory1");
                int blogCId = Integer.parseInt(blogCIdRaw);
                BlogDTO bdto = new BlogDTO();
                bdto.setBlogId(blogId1);
                BlogCategoryDTO bcdto = new BlogCategoryDTO();
                bcdto.setBlogCategoryId(blogCId);
                bdto.setCategory(bcdto);
                bdto.setContent(content);
                bdto.setImg(imageData);
                bdto.setQuickReview(quickReview);
                bdto.setTitle(title1);
                iBlogService.update(bdto);

                UserDTO author = userService.getUserByAccountId(user.getAccId());
                int totalPage = iBlogService.countNumberOfPageSearch(title, categoryId, author.getUserId(), dateFrom, dateTo);
                List<BlogDTO> blogs = iBlogService.getSearchList(title, categoryId, pageIndex, author.getUserId(), dateFrom, dateTo);
                if (!blogs.isEmpty()) {
                    int blogId = req.getParameter("blogId") == null ? blogs.get(0).getBlogId() : Integer.parseInt(req.getParameter("blogId"));
                    BlogDTO blog = iBlogService.getDetail(blogId);
                    req.setAttribute("blog", blog);
                }
                req.setAttribute("blogs", blogs);
                req.setAttribute("totalPage", totalPage);
            }
            req.setAttribute("pageIndex", pageIndex);
            req.setAttribute("blogCategoryList", blogCategoryList);
            req.setAttribute("title", title);
            req.setAttribute("blogCategory", categoryId);
            req.setAttribute("dateFrom", dateFrom);
            req.setAttribute("dateTo", dateTo);
            req.setAttribute("roleId", user.getRole().getRoleId());
            req.getRequestDispatcher("../view/blogsDashboard.jsp").forward(req, resp);
        } else if (action.equals("delete")) {
            String title = req.getParameter("title");
            int categoryId = req.getParameter("blog_category") == null ? 0 : Integer.parseInt(req.getParameter("blog_category"));
            Date dateFrom = req.getParameter("date_from") == null ? Date.valueOf("2003-01-01") : Date.valueOf(req.getParameter("date_from"));
            Date dateTo = req.getParameter("date_to") == null ? new Date(System.currentTimeMillis()) : Date.valueOf(req.getParameter("date_to"));

            List<BlogCategoryDTO> blogCategoryList = blogCategoryService.getAllBlogCategory();
            int pageIndex = req.getParameter("page") != null ? Integer.parseInt(req.getParameter("page")) : 1;
            if (user.getRole().getRoleId() == 4) {
                String author = req.getParameter("author");
                int totalPage = iBlogService.countNumberOfPageSearch(title, categoryId, author, dateFrom, dateTo);
                List<BlogDTO> blogs = iBlogService.getSearchList(title, categoryId, pageIndex, author, dateFrom, dateTo);
                if (!blogs.isEmpty()) {
                    int blogId = req.getParameter("blogId") == null ? blogs.get(0).getBlogId() : Integer.parseInt(req.getParameter("blogId"));
                    BlogDTO blog = iBlogService.getDetail(blogId);
                    req.setAttribute("blog", blog);
                }
                req.setAttribute("blogs", blogs);
                req.setAttribute("totalPage", totalPage);
                req.setAttribute("author", author);
            } else {
                String blogIdRaw = req.getParameter("blogId1");
                int blogId1 = Integer.parseInt(blogIdRaw);
                iBlogViewService.delete(blogId1);
                iBlogService.delete(blogId1);
                UserDTO author = userService.getUserByAccountId(user.getAccId());
                int totalPage = iBlogService.countNumberOfPageSearch(title, categoryId, author.getUserId(), dateFrom, dateTo);
                List<BlogDTO> blogs = iBlogService.getSearchList(title, categoryId, pageIndex, author.getUserId(), dateFrom, dateTo);
                if (!blogs.isEmpty()) {
                    int blogId = req.getParameter("blogId") == null ? blogs.get(0).getBlogId() : Integer.parseInt(req.getParameter("blogId"));
                    BlogDTO blog = iBlogService.getDetail(blogId);
                    req.setAttribute("blog", blog);
                }
                req.setAttribute("blogs", blogs);
                req.setAttribute("totalPage", totalPage);
            }
            req.setAttribute("pageIndex", pageIndex);
            req.setAttribute("blogCategoryList", blogCategoryList);
            req.setAttribute("title", title);
            req.setAttribute("blogCategory", categoryId);
            req.setAttribute("dateFrom", dateFrom);
            req.setAttribute("dateTo", dateTo);
            req.setAttribute("roleId", user.getRole().getRoleId());
            req.getRequestDispatcher("../view/blogsDashboard.jsp").forward(req, resp);
        } else if (action.equals("add")) {
            String title = req.getParameter("title");
            int categoryId = req.getParameter("blog_category") == null ? 0 : Integer.parseInt(req.getParameter("blog_category"));
            Date dateFrom = req.getParameter("date_from") == null ? Date.valueOf("2003-01-01") : Date.valueOf(req.getParameter("date_from"));
            Date dateTo = req.getParameter("date_to") == null ? new Date(System.currentTimeMillis()) : Date.valueOf(req.getParameter("date_to"));
            UserDTO author = userService.getUserByAccountId(user.getAccId());
            List<BlogCategoryDTO> blogCategoryList = blogCategoryService.getAllBlogCategory();
            int pageIndex = req.getParameter("page") != null ? Integer.parseInt(req.getParameter("page")) : 1;

            LocalDate dateNow = LocalDate.now();
            Date timeToSQL = Date.valueOf(dateNow);
            InputStream inputStream = req.getPart("imageFile").getInputStream();
            byte[] imageByte = inputStream.readAllBytes();
            String imageData;
            if (imageByte.length == 0) {
                imageData = req.getParameter("data");
            } else {
                imageData = "data:image/jpeg;base64," + Base64.getEncoder().encodeToString(imageByte);
            }
            String title1 = req.getParameter("title1");
            String content = req.getParameter("content");
            String quickReview = req.getParameter("quickReview");
            String blogCIdRaw = req.getParameter("blogCategory1");
            int blogCId = Integer.parseInt(blogCIdRaw);
            BlogDTO bdto = new BlogDTO();
            BlogCategoryDTO bcdto = new BlogCategoryDTO();
            bcdto.setBlogCategoryId(blogCId);
            bdto.setCategory(bcdto);
            bdto.setContent(content);
            bdto.setImg(imageData);
            bdto.setQuickReview(quickReview);
            bdto.setTitle(title1);
            bdto.setCreatedTime(dateTo);
            bdto.setAuthor(author);
            iBlogService.insert(bdto);

            int totalPage = iBlogService.countNumberOfPageSearch(title, categoryId, author.getUserId(), dateFrom, dateTo);
            List<BlogDTO> blogs = iBlogService.getSearchList(title, categoryId, pageIndex, author.getUserId(), dateFrom, dateTo);
            if (!blogs.isEmpty()) {
                int blogId = req.getParameter("blogId") == null ? blogs.get(0).getBlogId() : Integer.parseInt(req.getParameter("blogId"));
                BlogDTO blog = iBlogService.getDetail(blogId);
                req.setAttribute("blog", blog);
            }
            req.setAttribute("blogs", blogs);
            req.setAttribute("totalPage", totalPage);

            req.setAttribute("pageIndex", pageIndex);
            req.setAttribute("blogCategoryList", blogCategoryList);
            req.setAttribute("title", title);
            req.setAttribute("blogCategory", categoryId);
            req.setAttribute("dateFrom", dateFrom);
            req.setAttribute("dateTo", dateTo);
            req.setAttribute("roleId", user.getRole().getRoleId());
            req.getRequestDispatcher("../view/blogsDashboard.jsp").forward(req, resp);
        }

    }

}
