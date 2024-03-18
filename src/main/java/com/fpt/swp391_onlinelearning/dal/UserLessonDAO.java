/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.swp391_onlinelearning.dal;

import com.fpt.swp391_onlinelearning.dal.idal.IUserLessonDAO;
import com.fpt.swp391_onlinelearning.model.Chapter;
import com.fpt.swp391_onlinelearning.model.Lesson;
import com.fpt.swp391_onlinelearning.model.LessonType;
import com.fpt.swp391_onlinelearning.model.User;
import com.fpt.swp391_onlinelearning.model.UserLesson;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tran Hoang Phuc
 */
public class UserLessonDAO implements IUserLessonDAO {

    @Override
    public void addUserLessons(int userId, List<Lesson> lessons) {
        Connection connection = DBContext.getConnection();
        try {
            connection = DBContext.getConnection();
            String sql = "INSERT INTO `swp391_onlinelearning`.`userlesson` (`userId`, `lessonId`, `isFinished`) VALUES (?, ?, 0)";
            PreparedStatement stm = connection.prepareStatement(sql);

            for (Lesson lesson : lessons) {
                stm.setInt(1, userId);
                stm.setInt(2, lesson.getLessonId());
                stm.addBatch();
            }
            stm.executeBatch();
        } catch (SQLException ex) {
            Logger.getLogger(UserLessonDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBContext.close(connection);
        }

    }

    @Override
    public Map<Chapter, List<UserLesson>> getLessonByUser(int courseId, int userId) {
        Connection connection = DBContext.getConnection();
        Map<Chapter, List<UserLesson>> chapterMappingLessons = new LinkedHashMap<>();
        List<Chapter> chapters = new ArrayList<>();
        String chapterSql = "SELECT chapterId, name, courseId "
                + "FROM `swp391_onlinelearning`.`chapter`"
                + "WHERE courseId = ?";

        String sql = "SELECT  l.lessonId,  l.name,  l.chapterId,  l.typeId,  l.duration, l.content, ul.userId, ul.isFinished\n"
                + "FROM `swp391_onlinelearning`.`lesson` l JOIN `swp391_onlinelearning`.`userlesson` ul\n"
                + "ON l.lessonId = ul.lessonId\n"
                + "WHERE chapterId = ?";
        try {
            PreparedStatement chapterStm = connection.prepareStatement(chapterSql);
            chapterStm.setInt(1, courseId);
            ResultSet chapterResultSet = chapterStm.executeQuery();
            while (chapterResultSet.next()) {
                Chapter c = new Chapter();
                c.setChapterId(chapterResultSet.getInt("chapterId"));
                c.setName(chapterResultSet.getString("name"));
                chapters.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LessonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (!chapters.isEmpty()) {
            for (Chapter chapter : chapters) {
                try {
                    List<UserLesson> lessons = new ArrayList<>();
                    PreparedStatement lessonStm = connection.prepareStatement(sql);
                    lessonStm.setInt(1, chapter.getChapterId());
                    ResultSet rs = lessonStm.executeQuery();
                    while (rs.next()) {
                        UserLesson ul = new UserLesson();
                        Lesson l = new Lesson();
                        l.setLessonId(rs.getInt("lessonId"));
                        l.setChapter(chapter);
                        l.setName(rs.getString("name"));
                        LessonType lt = new LessonType();
                        lt.setTypeId(rs.getInt("typeId"));
                        l.setType(lt);
                        l.setDuration(rs.getInt("duration"));
                        l.setContent(rs.getString("content"));
                        ul.setLesson(l);
                        User u = new User();
                        u.setUserId(rs.getInt("userId"));
                        ul.setUser(u);
                        ul.setFinish(rs.getBoolean("isFinished"));
                        lessons.add(ul);
                    }
                    chapterMappingLessons.put(chapter, lessons);
                } catch (SQLException ex) {
                    Logger.getLogger(LessonDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {
            DBContext.close(connection);
        }
        DBContext.close(connection);
        return chapterMappingLessons;
    }

    @Override
    public void markAsDone(int userId, int lessonId) {
        Connection connection = DBContext.getConnection();
        String sql = "UPDATE swp391_onlinelearning.userlesson \n"
                + "SET userlesson.isFinished = 1\n"
                + "WHERE userlesson.userId = ? AND userlesson.lessonId = ?";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, userId);
            stm.setInt(2, lessonId);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserLessonDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBContext.close(connection);
        }
    }
    
}
