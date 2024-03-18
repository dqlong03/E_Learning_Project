/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.fpt.swp391_onlinelearning.service.iservice;

import com.fpt.swp391_onlinelearning.dto.AccountDTO;
import com.fpt.swp391_onlinelearning.dto.CourseDTO;
import com.fpt.swp391_onlinelearning.dto.UserDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 *
 * @author tran Hoang Phuc
 */
public interface IPaymentService {

    public String payForCourse(HttpServletRequest req, long price, AccountDTO dtos, int total) throws ServletException, IOException;

    public void paymentReturn(String transactionId, long amount, Date createdTime, boolean status, UserDTO user, int accId);

    public void pay(long amount, List<CourseDTO> course, UserDTO userDto);
    
    
}
