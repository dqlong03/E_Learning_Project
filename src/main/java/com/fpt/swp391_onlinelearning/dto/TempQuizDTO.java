/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.swp391_onlinelearning.dto;

import java.util.List;

/**
 *
 * @author phuc2
 */
public class TempQuizDTO {
    private int tempId;
    private UserDTO user;
    private LessonDTO lesson;
    private float result;
    private List<QuestionDTO> questionList;
    private List<AnswerDTO> answerList;

    public int getTempId() {
        return tempId;
    }

    public void setTempId(int tempId) {
        this.tempId = tempId;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public LessonDTO getLesson() {
        return lesson;
    }

    public void setLesson(LessonDTO lesson) {
        this.lesson = lesson;
    }

    public float getResult() {
        return result;
    }

    public void setResult(float result) {
        this.result = result;
    }

    public List<QuestionDTO> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<QuestionDTO> questionList) {
        this.questionList = questionList;
    }

    public List<AnswerDTO> getAnswerList() {
        return answerList;
    }

    public void setAnswerList(List<AnswerDTO> answerList) {
        this.answerList = answerList;
    }
}
