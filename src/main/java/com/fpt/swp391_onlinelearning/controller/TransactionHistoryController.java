/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.swp391_onlinelearning.controller;

import com.fpt.swp391_onlinelearning.baseController.BaseRequiredVerifyController;
import com.fpt.swp391_onlinelearning.dal.TransactionDAO;
import com.fpt.swp391_onlinelearning.dal.UserDAO;
import com.fpt.swp391_onlinelearning.dto.AccountDTO;
import com.fpt.swp391_onlinelearning.dto.TransactionDTO;
import com.fpt.swp391_onlinelearning.dto.UserDTO;
import com.fpt.swp391_onlinelearning.service.TransactionService;
import com.fpt.swp391_onlinelearning.service.UserService;
import com.fpt.swp391_onlinelearning.service.iservice.ITransactionService;
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
public class TransactionHistoryController extends BaseRequiredVerifyController {

    private IUserService _iUserService;
    private ITransactionService _iTransactionService;

    @Override
    public void init() throws ServletException {
        _iUserService = UserService.getInstace(new UserDAO(), new UserDAO());
        _iTransactionService = TransactionService.getInstance(new TransactionDAO());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response, AccountDTO user, boolean isActivated) throws ServletException, IOException {
        UserDTO userDTO = _iUserService.getUserByAccountId(user.getAccId());
        int pageIndex = request.getParameter("page") == null ? 1: Integer.parseInt(request.getParameter("page"));
        String from = request.getParameter("from");
        String to = request.getParameter("to");
        request.setAttribute("user", userDTO);
        request.setAttribute("imageData", userDTO.getImg());
        List<TransactionDTO> transactionDto = _iTransactionService.getTransactionByAccount(user.getAccId(), pageIndex, from, to, user);
        int numOfRecord = _iTransactionService.getNumOfTransaction(user.getAccId(), pageIndex, from, to, user);
        int totalPage = (numOfRecord % 5 ==0)?(numOfRecord/5):((numOfRecord/5) + 1);
        request.setAttribute("transaction", transactionDto);
        request.setAttribute("totalPage", totalPage);
        request.setAttribute("pageIndex", pageIndex);
        request.setAttribute("from", from);
        request.setAttribute("to", to);
        request.getRequestDispatcher("view/transactionHistory.jsp").forward(request, response);
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response, AccountDTO user, boolean isActivated) throws ServletException, IOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
