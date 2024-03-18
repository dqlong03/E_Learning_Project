/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.swp391_onlinelearning.controller;

import com.fpt.swp391_onlinelearning.dal.PostCategoryDAO;
import com.fpt.swp391_onlinelearning.dal.PostDAO;
import com.fpt.swp391_onlinelearning.dto.PostDTO;
import com.fpt.swp391_onlinelearning.service.PostCategoryService;
import com.fpt.swp391_onlinelearning.service.PostService;
import com.fpt.swp391_onlinelearning.service.iservice.IPostCategoryService;
import com.fpt.swp391_onlinelearning.service.iservice.IPostService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * @author quang
 */
public class PostDetailController extends HttpServlet {

    private static IPostCategoryService postCategoryService;
    private static IPostService postService;

    public void init() throws ServletException {
        postCategoryService = PostCategoryService.getInstance(new PostCategoryDAO());
        postService = PostService.getInstance(new PostDAO());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String postIdString = req.getParameter("postId");
        if (postIdString.equals("0")) {
        } else {
            int postId = Integer.parseInt(postIdString);
            PostDTO dTO = postService.get(postId);
            req.setAttribute("dTO", dTO);
            req.getRequestDispatcher("view/postDetail.jsp").forward(req, resp);
        }
    }

}
