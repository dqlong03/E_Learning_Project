/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.fpt.swp391_onlinelearning.controller;

import com.fpt.swp391_onlinelearning.baseController.BaseRequiredVerifyController;
import com.fpt.swp391_onlinelearning.dal.UserDAO;
import com.fpt.swp391_onlinelearning.dto.AccountDTO;
import com.fpt.swp391_onlinelearning.dto.UserDTO;
import com.fpt.swp391_onlinelearning.service.UserService;
import com.fpt.swp391_onlinelearning.service.iservice.IUserService;
import com.fpt.swp391_onlinelearning.util.URLUtils;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.sql.Date;
import java.util.Base64;

/**
 *
 * @author phuc2
 */
@MultipartConfig
public class EditProfileController extends BaseRequiredVerifyController {

    private IUserService iUserService;

    public void init() throws ServletException {
        iUserService = UserService.getInstace(new UserDAO(), new UserDAO());
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response, AccountDTO user, boolean isActivated) throws ServletException, IOException {

        UserDTO userDTO = iUserService.getUserByAccountId(user.getAccId());
        //response.getWriter().print(userDTO.getAddress()+userDTO.getName()+userDTO.getImg()+userDTO.getPhone()+userDTO.getPostCode());
        request.setAttribute("user", userDTO);
        request.setAttribute("imageData", userDTO.getImg());
//        response.getWriter().print(userDTO.getName());
        //response.sendRedirect("../view/user/profile.jsp");
        request.getRequestDispatcher("view/editProfile.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response, AccountDTO user, boolean isActivated) throws ServletException, IOException {
        // Lấy dữ liệu file từ request
        String name = request.getParameter("name");
        boolean gender = request.getParameter("gender").equals("Male");
        Date dob = Date.valueOf(request.getParameter("dob"));
        String phoneNumber = request.getParameter("phoneNumber");

        InputStream inputStream = request.getPart("imageFile").getInputStream();
        byte[] imageByte = inputStream.readAllBytes();
        String imageData;
        if (imageByte.length == 0) {
            imageData = request.getParameter("data");
            //response.getWriter().print(0);
        } else {
            imageData = "data:image/jpeg;base64," + Base64.getEncoder().encodeToString(imageByte);
            //response.getWriter().print(1);
        }
        String address = request.getParameter("address");
        String postCode = request.getParameter("postcode");
        // Đọc dữ liệu file thành mảng byte[]
        UserDTO userDTO = iUserService.getUserByAccountId(user.getAccId());
        UserDTO udto = new UserDTO();
        AccountDTO a = new AccountDTO();
        a.setAccId(user.getAccId());
        a.setEmail(user.getEmail());
        udto.setAccount(a);
        udto.setName(name);
        udto.setGender(gender);
        udto.setDob(dob);
        udto.setPhone(phoneNumber);
        udto.setImg(imageData);
        udto.setAddress(address);
        udto.setPostCode(postCode);
        udto.setBalance(userDTO.getBalance());

        iUserService.updateUser(udto);
        String firstURLPattern = URLUtils.getFirstURLPatternLevel(request);
        request.setAttribute("urlPattern", firstURLPattern);
        request.setAttribute("imageData", imageData);
        request.setAttribute("user", udto);
        //response.getWriter().print(imageData);
        request.getRequestDispatcher("view/editProfile.jsp").forward(request, response);
        // Cần đóng luồng
        inputStream.close();
    }

}
