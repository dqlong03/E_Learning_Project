/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.swp391_onlinelearning.controller;

import com.fpt.swp391_onlinelearning.baseController.BaseRequiredAuthorizationController;
import com.fpt.swp391_onlinelearning.dal.PostDAO;
import com.fpt.swp391_onlinelearning.dal.SliderDAO;
import com.fpt.swp391_onlinelearning.dto.AccountDTO;
import com.fpt.swp391_onlinelearning.dto.FeatureDTO;
import com.fpt.swp391_onlinelearning.dto.PostDTO;
import com.fpt.swp391_onlinelearning.dto.SliderDTO;
import com.fpt.swp391_onlinelearning.service.PostService;
import com.fpt.swp391_onlinelearning.service.SliderService;
import com.fpt.swp391_onlinelearning.service.iservice.IPostService;
import com.fpt.swp391_onlinelearning.service.iservice.ISliderService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Base64;
import java.util.List;
import java.util.Set;

/**
 *
 * @author quang
 */
@MultipartConfig

public class SliderController extends BaseRequiredAuthorizationController {

    private static ISliderService sliderService;
    private static IPostService postService;

    public void init() throws ServletException {
        sliderService = SliderService.getInstance(new SliderDAO());
        postService = PostService.getInstance(new PostDAO());

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp, AccountDTO user, boolean isActivated, Set<FeatureDTO> features) throws ServletException, IOException {

        String action = req.getParameter("action");
        if (null == action) {
            String searchInput;
            Date timeToSQL = null;
            Date timeFromSQL = null;
            if (null == req.getParameter("searchInput")) {
                searchInput = "";
            } else {
                searchInput = req.getParameter("searchInput");
            }
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
            List<SliderDTO> sliderDtos = sliderService.searchListSlider(searchInput, timeFromSQL, timeToSQL, pageIndex);
            int numberOfPageSlider = sliderService.countNumberOfPageSearchSlider(searchInput, timeFromSQL, timeToSQL);

            req.setAttribute("numberOfPageSlider", numberOfPageSlider);
            req.setAttribute("sliderDtos", sliderDtos);
            req.setAttribute("pageIndex", pageIndex);
            req.setAttribute("timeFrom", timeFromSQL);
            req.setAttribute("timeTo", timeToSQL);
            req.setAttribute("searchInput", searchInput);
            req.getRequestDispatcher("../view/sliderListDashboard.jsp").forward(req, resp);

        } else if (action.equals("edit")) {
            String sliderIdString = req.getParameter("id");
            int sliderId = Integer.parseInt(sliderIdString);
            String pageIndexString = req.getParameter("pageIndex");
            if (pageIndexString == null || pageIndexString.trim().length() == 0) {
                pageIndexString = "1";
            }
            int pageIndex = Integer.parseInt(pageIndexString);
            String searchInput;
            Date timeToSQL = null;
            Date timeFromSQL = null;
            if (null == req.getParameter("searchInput")) {
                searchInput = "";
            } else {
                searchInput = req.getParameter("searchInput");
            }
            String timeFrom = req.getParameter("timeFrom");
            if (null == timeFrom || timeFrom.length() == 0) {
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
            if (null == timeTo || timeTo.length() == 0) {
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
            SliderDTO sliderDTO = sliderService.get(sliderId);
            List<SliderDTO> sliderDtos = sliderService.searchListSlider(searchInput, timeFromSQL, timeToSQL, pageIndex);
            List<PostDTO> postDTOs = postService.getAllShowPost();
            int numberOfPageSlider = sliderService.countNumberOfPageSearchSlider(searchInput, timeFromSQL, timeToSQL);
            req.setAttribute("numberOfPageSlider", numberOfPageSlider);
            req.setAttribute("postDTOs", postDTOs);
            req.setAttribute("sliderDtos", sliderDtos);
            req.setAttribute("sliderDTO", sliderDTO);
            req.setAttribute("pageIndex", pageIndex);
            req.setAttribute("timeFromSQL", timeFromSQL);
            req.setAttribute("timeToSQL", timeToSQL);
            req.setAttribute("searchInput", searchInput);
            req.getRequestDispatcher("../view/sliderListDashboard.jsp").forward(req, resp);
        } else if (action.equals("add")) {
            List<PostDTO> postDTOs = postService.getAllShowPost();
            req.setAttribute("postDTOs", postDTOs);
            req.getRequestDispatcher("../view/addSliderDashboard.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp, AccountDTO user, boolean isActivated, Set<FeatureDTO> features) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action.equals("delete")) {
            String sliderIdString = req.getParameter("id");
            int sliderId = Integer.parseInt(sliderIdString);
            sliderService.delete(sliderId);
            String pageIndexString = req.getParameter("pageIndex");
            if (null == pageIndexString || pageIndexString.trim().length() == 0) {
                pageIndexString = "1";
            }
            int pageIndex = Integer.parseInt(pageIndexString);
            String searchInput;
            Date timeToSQL = null;
            Date timeFromSQL = null;
            if (req.getParameter("searchInput") == null) {
                searchInput = "";
            } else {
                searchInput = req.getParameter("searchInput");
            }
            String timeFrom = req.getParameter("timeFrom");
            if (timeFrom == null || timeFrom.length() == 0) {
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
            if (timeTo == null || timeTo.length() == 0) {
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
            List<SliderDTO> sliderDtos = sliderService.searchListSlider(searchInput, timeFromSQL, timeToSQL, pageIndex);
            int numberOfPageSlider = sliderService.countNumberOfPageSearchSlider(searchInput, timeFromSQL, timeToSQL);
            req.setAttribute("numberOfPageSlider", numberOfPageSlider);
            req.setAttribute("sliderDtos", sliderDtos);
            req.setAttribute("pageIndex", pageIndex);
            req.setAttribute("timeFromSQL", timeFromSQL);
            req.setAttribute("timeToSQL", timeToSQL);
            req.setAttribute("searchInput", searchInput);
            req.setAttribute("mess", "Delete successfully");
            req.getRequestDispatcher("../view/sliderListDashboard.jsp").forward(req, resp);
        } else if (action.equals("edit")) {
            String pageIndexString = req.getParameter("pageIndex");
            if (pageIndexString == null || pageIndexString.trim().length() == 0) {
                pageIndexString = "1";
            }
            int pageIndex = Integer.parseInt(pageIndexString);
            String title = req.getParameter("title");
            String description = req.getParameter("description");
            String postIdString = req.getParameter("postId");
            int postId = Integer.parseInt(postIdString);
            String sliderIdString = req.getParameter("sliderId");
            int sliderId = Integer.parseInt(sliderIdString);
            String statusString = req.getParameter("status");
            int status = Integer.parseInt(statusString);
            InputStream inputStream = req.getPart("imageFile").getInputStream();
            byte[] imageByte = inputStream.readAllBytes();
            String imageData;
            if (imageByte.length == 0) {
                imageData = req.getParameter("data");
            } else {
                imageData = "data:image/jpeg;base64," + Base64.getEncoder().encodeToString(imageByte);
            }
            SliderDTO sliderDTO = new SliderDTO();
            sliderDTO.setImg(imageData);
            sliderDTO.setSliderId(sliderId);
            sliderDTO.setTitle(title);
            sliderDTO.setDescription(description);
            sliderDTO.setStatus(status);
            PostDTO postDTO = new PostDTO();
            postDTO.setPostId(postId);
            sliderDTO.setPost(postDTO);
            sliderService.update(sliderDTO);
            inputStream.close();

            String searchInput;
            Date timeToSQL = null;
            Date timeFromSQL = null;

            if (req.getParameter("searchInput") == null) {
                searchInput = "";
            } else {
                searchInput = req.getParameter("searchInput");
            }
            String timeFrom = req.getParameter("timeFrom");
            if (timeFrom == null || timeFrom.length() == 0) {
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
            if (timeTo == null || timeTo.length() == 0) {
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

            List<SliderDTO> sliderDtos = sliderService.searchListSlider(searchInput, timeFromSQL, timeToSQL, pageIndex);
            req.setAttribute("sliderDtos", sliderDtos);
            int numberOfPageSlider = sliderService.countNumberOfPageSearchSlider(searchInput, timeFromSQL, timeToSQL);
            req.setAttribute("numberOfPageSlider", numberOfPageSlider);
            req.setAttribute("pageIndex", pageIndex);
            req.setAttribute("timeFromSQL", timeFromSQL);
            req.setAttribute("timeToSQL", timeToSQL);
            req.setAttribute("searchInput", searchInput);
            req.getRequestDispatcher("../view/sliderListDashboard.jsp").forward(req, resp);
        } else if (action.equals("add")) {
            String searchInput = "";
            LocalDate dateNow = LocalDate.now();
            LocalDate dateBefore30days = dateNow.minusDays(30);
            Date timeFromSQL = Date.valueOf(dateBefore30days);
            Date timeToSQL = Date.valueOf(dateNow);
            int pageIndex = 1;
            String title = req.getParameter("title");
            String description = req.getParameter("description");
            String postIdString = req.getParameter("postId");
            int postId = Integer.parseInt(postIdString);
            String statusString = req.getParameter("status");
            int status = Integer.parseInt(statusString);
            InputStream inputStream = req.getPart("imageFile").getInputStream();
            byte[] imageByte = inputStream.readAllBytes();
            String imageData;
            if (imageByte.length == 0) {
                imageData = req.getParameter("data");
            } else {
                imageData = "data:image/jpeg;base64," + Base64.getEncoder().encodeToString(imageByte);
            }
            SliderDTO sliderDTO = new SliderDTO();
            sliderDTO.setImg(imageData);
            sliderDTO.setCreatedTime(timeToSQL);
            sliderDTO.setTitle(title);
            sliderDTO.setDescription(description);
            sliderDTO.setStatus(status);
            PostDTO postDTO = new PostDTO();
            postDTO.setPostId(postId);
            sliderDTO.setPost(postDTO);
            sliderService.insert(sliderDTO);
            inputStream.close();

            List<SliderDTO> sliderDtos = sliderService.searchListSlider(searchInput, timeFromSQL, timeToSQL, pageIndex);
            req.setAttribute("sliderDtos", sliderDtos);
            int numberOfPageSlider = sliderService.countNumberOfPageSearchSlider(searchInput, timeFromSQL, timeToSQL);
            req.setAttribute("numberOfPageSlider", numberOfPageSlider);
            req.setAttribute("pageIndex", pageIndex);
            req.setAttribute("timeFromSQL", timeFromSQL);
            req.setAttribute("timeToSQL", timeToSQL);
            req.setAttribute("searchInput", searchInput);
            req.setAttribute("mess", "Added successfull!");
            req.getRequestDispatcher("../view/sliderListDashboard.jsp").forward(req, resp);
        }
    }

}
