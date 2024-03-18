package com.fpt.swp391_onlinelearning.controller;

import com.fpt.swp391_onlinelearning.baseController.BaseRequiredVerifyController;
import com.fpt.swp391_onlinelearning.dal.CourseCategoryDAO;
import com.fpt.swp391_onlinelearning.dal.CourseDAO;
import com.fpt.swp391_onlinelearning.dal.UserDAO;
import com.fpt.swp391_onlinelearning.dto.AccountDTO;
import com.fpt.swp391_onlinelearning.dto.CourseCategoryDTO;
import com.fpt.swp391_onlinelearning.dto.CourseDTO;
import com.fpt.swp391_onlinelearning.dto.UserDTO;
import com.fpt.swp391_onlinelearning.service.CourseCategoryService;
import com.fpt.swp391_onlinelearning.service.CourseService;
import com.fpt.swp391_onlinelearning.service.UserService;
import com.fpt.swp391_onlinelearning.service.iservice.ICourseService;
import com.fpt.swp391_onlinelearning.service.iservice.IService;
import com.fpt.swp391_onlinelearning.service.iservice.IUserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author tran Hoang Phuc
 */
public class RegisteredCourseController extends BaseRequiredVerifyController {

    private IUserService _iUserService;
    private IService<CourseCategoryDTO> _iCourseCategoryService;
    private ICourseService _iCourseService;

    @Override
    public void init() throws ServletException {
        _iUserService = UserService.getInstace(new UserDAO(), new UserDAO());
        _iCourseCategoryService = CourseCategoryService.getInstance(new CourseCategoryDAO());
        _iCourseService = CourseService.getInstance(new CourseDAO(), new CourseDAO());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response, AccountDTO user, boolean isActivated) throws ServletException, IOException {
        UserDTO userDTO = _iUserService.getUserByAccountId(user.getAccId());
        String searchValue = request.getParameter("dataSearch");
        String category = request.getParameter("category");
        String from = request.getParameter("from");
        String to = request.getParameter("to");
        int pageIndex = request.getParameter("page") == null ? 1: Integer.parseInt(request.getParameter("page"));
        int numOfRecord = _iCourseService.getNumRegisteredCourseByUserId(userDTO, user, searchValue, category, from, to);
        int totalPage = (numOfRecord % 6 == 0) ? (numOfRecord / 6) : ((numOfRecord / 6) + 1);
        request.setAttribute("totalPage", totalPage);
        request.setAttribute("pageIndex", pageIndex);
        request.setAttribute("user", userDTO);
        request.setAttribute("imageData", userDTO.getImg());
        List<CourseCategoryDTO> categories = _iCourseCategoryService.getAll();
        List<CourseDTO> courses = _iCourseService.getRegisteredCourseByUserId(userDTO, user, searchValue, category, from, to, Integer.toString(pageIndex));
        System.out.println(courses.size());
        request.setAttribute("searchValue", searchValue);
        request.setAttribute("categoryId", category);
        request.setAttribute("from", from);
        request.setAttribute("to", to);
        request.setAttribute("course", courses);
        request.setAttribute("category", categories);
        request.getRequestDispatcher("view/registeredCourse.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response, AccountDTO user, boolean isActivated) throws ServletException, IOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
