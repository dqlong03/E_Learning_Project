/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.swp391_onlinelearning.controller;

import com.fpt.swp391_onlinelearning.baseController.BaseRequiredAuthorizationController;
import com.fpt.swp391_onlinelearning.dal.PostCategoryDAO;
import com.fpt.swp391_onlinelearning.dal.PostDAO;
import com.fpt.swp391_onlinelearning.dal.SliderDAO;
import com.fpt.swp391_onlinelearning.dto.AccountDTO;
import com.fpt.swp391_onlinelearning.dto.FeatureDTO;
import com.fpt.swp391_onlinelearning.dto.PostCategoryDTO;
import com.fpt.swp391_onlinelearning.dto.PostDTO;
import com.fpt.swp391_onlinelearning.service.PostCategoryService;
import com.fpt.swp391_onlinelearning.service.PostService;
import com.fpt.swp391_onlinelearning.service.SliderService;
import com.fpt.swp391_onlinelearning.service.iservice.IPostCategoryService;
import com.fpt.swp391_onlinelearning.service.iservice.IPostService;
import com.fpt.swp391_onlinelearning.service.iservice.ISliderService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

/**
 *
 * @author quang
 */
@MultipartConfig
public class PostController extends BaseRequiredAuthorizationController {

    private static IPostCategoryService postCategoryService;
    private static IPostService postService;
    private static ISliderService sliderService;

    public void init() throws ServletException {
        postCategoryService = PostCategoryService.getInstance(new PostCategoryDAO());
        postService = PostService.getInstance(new PostDAO());
        sliderService = SliderService.getInstance(new SliderDAO());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp, AccountDTO user, boolean isActivated, Set<FeatureDTO> features) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (null == action) {
            String searchInput;
            String postCategoryIdRaw;
            Date timeToSQL = null;
            Date timeFromSQL = null;
            if (null == req.getParameter("searchInput")) {
                searchInput = "";
            } else {
                searchInput = req.getParameter("searchInput");
            }
            if (null == req.getParameter("postCategoryId")) {
                postCategoryIdRaw = "-1";
            } else {
                postCategoryIdRaw = req.getParameter("postCategoryId");
            }
            int postCategoryId = Integer.parseInt(postCategoryIdRaw);
            String timeFrom = req.getParameter("timeFrom");
            if (null == timeFrom || timeFrom.trim().length() == 0) {
                LocalDate dateNow = LocalDate.now();
                LocalDate dateBefore30days = dateNow.minusDays(30);
                timeFromSQL = Date.valueOf(dateBefore30days);
            } else {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                try {
                    java.util.Date ngayUtil = sdf.parse(timeFrom);
                    timeFromSQL = new Date(ngayUtil.getTime());
                } catch (ParseException e) {
                }
            }
            String timeTo = req.getParameter("timeTo");
            if (null == timeTo || timeTo.trim().length() == 0) {
                LocalDate dateNow = LocalDate.now();
                timeToSQL = Date.valueOf(dateNow);
            } else {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                try {
                    java.util.Date ngayUtil = sdf.parse(timeTo);
                    timeToSQL = new Date(ngayUtil.getTime());
                } catch (ParseException e) {
                }
            }
            String pageIndexString = req.getParameter("pageIndex");
            if (pageIndexString == null || pageIndexString.trim().length() == 0) {
                pageIndexString = "1";
            }
            int pageIndex = Integer.parseInt(pageIndexString);
            List<PostCategoryDTO> categoryDTOs = postCategoryService.getListOfShowPostCategory();
            List<PostDTO> postDTOs = postService.searchListPost(searchInput, timeFromSQL, timeToSQL, pageIndex, postCategoryId);
            int numberOfPagePost = postService.countNumberOfPageSearchPost(searchInput, timeFromSQL, timeToSQL, postCategoryId);
            req.setAttribute("action", action);
            req.setAttribute("numberOfPagePost", numberOfPagePost);
            req.setAttribute("postDTOs", postDTOs);
            req.setAttribute("categoryDTOs", categoryDTOs);
            req.setAttribute("pageIndex", pageIndex);
            req.setAttribute("timeFrom", timeFromSQL);
            req.setAttribute("timeTo", timeToSQL);
            req.setAttribute("searchInput", searchInput);
            req.setAttribute("postCategoryId", postCategoryId);
            req.getRequestDispatcher("../view/postListDashboard.jsp").forward(req, resp);

        } else if (action.equals("edit")) {
            String postIdRaw = req.getParameter("id");
            int postId = Integer.parseInt(postIdRaw);
            PostDTO postDTO = postService.get(postId);
            String searchInput;
            String postCategoryIdRaw;
            Date timeToSQL = null;
            Date timeFromSQL = null;
            if (null == req.getParameter("searchInput")) {
                searchInput = "";
            } else {
                searchInput = req.getParameter("searchInput");
            }
            if (null == req.getParameter("postCategoryId") || req.getParameter("postCategoryId").trim().length() == 0) {
                postCategoryIdRaw = "-1";
            } else {
                postCategoryIdRaw = req.getParameter("postCategoryId");
            }
            int postCategoryId = Integer.parseInt(postCategoryIdRaw);
            String timeFrom = req.getParameter("timeFrom");
            if (null == timeFrom || timeFrom.trim().length() == 0) {
                LocalDate dateNow = LocalDate.now();
                LocalDate dateBefore30days = dateNow.minusDays(30);
                timeFromSQL = Date.valueOf(dateBefore30days);
            } else {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                try {
                    java.util.Date ngayUtil = sdf.parse(timeFrom);
                    timeFromSQL = new Date(ngayUtil.getTime());
                } catch (ParseException e) {
                }
            }
            String timeTo = req.getParameter("timeTo");
            if (null == timeTo || timeTo.trim().length() == 0) {
                LocalDate dateNow = LocalDate.now();
                timeToSQL = Date.valueOf(dateNow);
            } else {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                try {
                    java.util.Date ngayUtil = sdf.parse(timeTo);
                    timeToSQL = new Date(ngayUtil.getTime());
                } catch (ParseException e) {
                }
            }
            String pageIndexString = req.getParameter("pageIndex");
            if (null == pageIndexString || pageIndexString.trim().length() == 0) {
                pageIndexString = "1";
            }
            int pageIndex = Integer.parseInt(pageIndexString);
            List<PostCategoryDTO> categoryDTOs = postCategoryService.getListOfShowPostCategory();
            List<PostDTO> postDTOs = postService.searchListPost(searchInput, timeFromSQL, timeToSQL, pageIndex, postCategoryId);
            int numberOfPagePost = postService.countNumberOfPageSearchPost(searchInput, timeFromSQL, timeToSQL, postCategoryId);
            req.setAttribute("numberOfPagePost", numberOfPagePost);
            req.setAttribute("postDTOs", postDTOs);
            req.setAttribute("postDTO", postDTO);
            req.setAttribute("categoryDTOs", categoryDTOs);
            req.setAttribute("pageIndex", pageIndex);
            req.setAttribute("timeFrom", timeFromSQL);
            req.setAttribute("timeTo", timeToSQL);
            req.setAttribute("searchInput", searchInput);
            req.setAttribute("postCategoryId", postCategoryId);
            req.setAttribute("action", action);
            req.getRequestDispatcher("../view/addPostDashboard.jsp").forward(req, resp);
        } else if (action.equals("add")) {
            List<PostCategoryDTO> categoryDTOs = postCategoryService.getListOfShowPostCategory();
            req.setAttribute("categoryDTOs", categoryDTOs);
            req.setAttribute("action", action);
            req.getRequestDispatcher("../view/addPostDashboard.jsp").forward(req, resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp, AccountDTO user, boolean isActivated, Set<FeatureDTO> features) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action.equals("delete")) {
            String searchInput;
            String postCategoryIdRaw;
            Date timeToSQL = null;
            Date timeFromSQL = null;
            if (null == req.getParameter("searchInput")) {
                searchInput = "";
            } else {
                searchInput = req.getParameter("searchInput");
            }
            if (null == req.getParameter("postCategoryId")) {
                postCategoryIdRaw = "-1";
            } else {
                postCategoryIdRaw = req.getParameter("postCategoryId");
            }
            int postCategoryId = Integer.parseInt(postCategoryIdRaw);
            String timeFrom = req.getParameter("timeFrom");
            if (null == timeFrom || timeFrom.trim().length() == 0) {
                LocalDate dateNow = LocalDate.now();
                LocalDate dateBefore30days = dateNow.minusDays(30);
                timeFromSQL = Date.valueOf(dateBefore30days);
            } else {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                try {
                    java.util.Date ngayUtil = sdf.parse(timeFrom);
                    timeFromSQL = new Date(ngayUtil.getTime());
                } catch (ParseException e) {
                }
            }
            String timeTo = req.getParameter("timeTo");
            if (null == timeTo || timeTo.trim().length() == 0) {
                LocalDate dateNow = LocalDate.now();
                timeToSQL = Date.valueOf(dateNow);
            } else {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                try {
                    java.util.Date ngayUtil = sdf.parse(timeTo);
                    timeToSQL = new Date(ngayUtil.getTime());
                } catch (ParseException e) {
                }
            }
            String pageIndexString = req.getParameter("pageIndex");
            if (null == pageIndexString || pageIndexString.trim().length() == 0) {
                pageIndexString = "1";
            }
            int pageIndex = Integer.parseInt(pageIndexString);
            String postIdRaw = req.getParameter("id");
            int postId = Integer.parseInt(postIdRaw);
            sliderService.updatePostId(postId);
            postService.delete(postId);
            List<PostCategoryDTO> categoryDTOs = postCategoryService.getListOfShowPostCategory();
            List<PostDTO> postDTOs = postService.searchListPost(searchInput, timeFromSQL, timeToSQL, pageIndex, postCategoryId);
            int numberOfPagePost = postService.countNumberOfPageSearchPost(searchInput, timeFromSQL, timeToSQL, postCategoryId);
            req.setAttribute("numberOfPagePost", numberOfPagePost);
            req.setAttribute("postDTOs", postDTOs);
            req.setAttribute("categoryDTOs", categoryDTOs);
            req.setAttribute("pageIndex", pageIndex);
            req.setAttribute("timeFrom", timeFromSQL);
            req.setAttribute("timeTo", timeToSQL);
            req.setAttribute("searchInput", searchInput);
            req.setAttribute("postCategoryId", postCategoryId);
            req.setAttribute("mess", "Delete successfully");
            req.getRequestDispatcher("../view/postListDashboard.jsp").forward(req, resp);
        } else if (action.equals("edit")) {
            String postIdRaw = req.getParameter("postId");
            int postId = Integer.parseInt(postIdRaw);
            String title = req.getParameter("title");
            String content = req.getParameter("content");
            String postCIdRaw = req.getParameter("postCId");
            int postCId = Integer.parseInt(postCIdRaw);
            String statusRaw = req.getParameter("status");
            int status = Integer.parseInt(statusRaw);
            PostDTO dTO = new PostDTO();
            dTO.setPostId(postId);
            dTO.setContent(content);
            dTO.setStatus(status);
            dTO.setTitle(title);
            PostCategoryDTO categoryDTO = new PostCategoryDTO();
            categoryDTO.setPostCategoryId(postCId);
            dTO.setPostCategory(categoryDTO);
            postService.update(dTO);

            String searchInput = "";
            LocalDate dateNow = LocalDate.now();
            Date timeToSQL = Date.valueOf(dateNow);
            LocalDate dateBefore30days = dateNow.minusDays(30);
            Date timeFromSQL = Date.valueOf(dateBefore30days);
            int postCategoryId = -1;
            int pageIndex = 1;
            List<PostCategoryDTO> categoryDTOs = postCategoryService.getListOfShowPostCategory();
            List<PostDTO> postDTOs = postService.searchListPost(searchInput, timeFromSQL, timeToSQL, pageIndex, postCategoryId);
            int numberOfPagePost = postService.countNumberOfPageSearchPost(searchInput, timeFromSQL, timeToSQL, postCategoryId);
            req.setAttribute("numberOfPagePost", numberOfPagePost);
            req.setAttribute("postDTOs", postDTOs);
            req.setAttribute("categoryDTOs", categoryDTOs);
            req.setAttribute("pageIndex", pageIndex);
            req.setAttribute("timeFrom", timeFromSQL);
            req.setAttribute("timeTo", timeToSQL);
            req.setAttribute("searchInput", searchInput);
            req.setAttribute("postCategoryId", -1);
            req.getRequestDispatcher("../view/postListDashboard.jsp").forward(req, resp);
        } else if (action.equals("add")) {
            
            LocalDate dateNow = LocalDate.now();
            Date timeToSQL = Date.valueOf(dateNow);
            LocalDate dateBefore30days = dateNow.minusDays(30);
            Date timeFromSQL = Date.valueOf(dateBefore30days);
            String title = req.getParameter("title");
            String content = req.getParameter("content");
            String postCIdRaw = req.getParameter("postCId");
            int postCId = Integer.parseInt(postCIdRaw);
            String statusRaw = req.getParameter("status");
            int status = Integer.parseInt(statusRaw);
            PostDTO dTO = new PostDTO();
            dTO.setContent(content);
            dTO.setStatus(status);
            dTO.setTitle(title);
            dTO.setCreatedTime(timeToSQL);
            PostCategoryDTO categoryDTO = new PostCategoryDTO();
            categoryDTO.setPostCategoryId(postCId);
            dTO.setPostCategory(categoryDTO);
            postService.insert(dTO);
            String searchInput = "";
            int postCategoryId = -1;
            int pageIndex = 1;
            List<PostCategoryDTO> categoryDTOs = postCategoryService.getListOfShowPostCategory();
            List<PostDTO> postDTOs = postService.searchListPost(searchInput, timeFromSQL, timeToSQL, pageIndex, postCategoryId);
            int numberOfPagePost = postService.countNumberOfPageSearchPost(searchInput, timeFromSQL, timeToSQL, postCategoryId);
            req.setAttribute("numberOfPagePost", numberOfPagePost);
            req.setAttribute("postDTOs", postDTOs);
            req.setAttribute("categoryDTOs", categoryDTOs);
            req.setAttribute("pageIndex", pageIndex);
            req.setAttribute("timeFrom", timeFromSQL);
            req.setAttribute("timeTo", timeToSQL);
            req.setAttribute("searchInput", searchInput);
            req.setAttribute("postCategoryId", -1);
            req.setAttribute("mess", "Added successfull!");
            req.getRequestDispatcher("../view/postListDashboard.jsp").forward(req, resp);
        }
    }

}
