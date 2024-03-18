/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.swp391_onlinelearning.controller;

import com.fpt.swp391_onlinelearning.baseController.BaseRequiredAuthorizationController;
import com.fpt.swp391_onlinelearning.dto.AccountDTO;
import com.fpt.swp391_onlinelearning.dto.AnswerDTO;
import com.fpt.swp391_onlinelearning.dto.FeatureDTO;
import com.fpt.swp391_onlinelearning.dto.QuestionDTO;
import java.util.ArrayList;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

/**
 *
 * @author quang
 */
public class ReadFileController extends BaseRequiredAuthorizationController {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp, AccountDTO user, boolean isActivated, Set<FeatureDTO> features) throws ServletException, IOException {
        req.getRequestDispatcher("../view/newjsp.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp, AccountDTO user, boolean isActivated, Set<FeatureDTO> features) throws ServletException, IOException {
        ArrayList<QuestionDTO> questions = new ArrayList<>();
        int questionIndex = 0;
        ArrayList<AnswerDTO> answers = new ArrayList<>();
        while (null != req.getParameter("question_" + questionIndex)) {
            QuestionDTO questionDTO = new QuestionDTO();
            questionDTO.setContent(req.getParameter("question_" + questionIndex));
            questionDTO.setQuestionId(questionIndex);
            for (int answerIndex = 0; answerIndex < 6; answerIndex++) {
                String answerContent = req.getParameter("answer_" + questionIndex + "_" + answerIndex);
                if (answerContent != null) {
                    AnswerDTO answerDTO = new AnswerDTO();
                    answerDTO.setContent(answerContent);
                    answerDTO.setIsTrue("1".equals(req.getParameter("istrue_" + questionIndex + "_" + answerIndex)));
                    answerDTO.setQuestion(questionDTO);
                    answers.add(answerDTO);
                }
            }
            questions.add(questionDTO);
            questionIndex++;
        }
        req.setAttribute("answers", answers);
        req.setAttribute("questions", questions);
        req.getRequestDispatcher("../view/newjsp.jsp").forward(req, resp);
    }
}
