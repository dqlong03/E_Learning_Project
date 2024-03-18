/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.swp391_onlinelearning.dal;

import com.fpt.swp391_onlinelearning.dal.idal.IDAO;
import com.fpt.swp391_onlinelearning.dal.idal.ILessonDAO;
import com.fpt.swp391_onlinelearning.model.Chapter;
import com.fpt.swp391_onlinelearning.model.Lesson;
import com.fpt.swp391_onlinelearning.model.LessonType;
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
public class LessonDAO implements IDAO<Lesson>, ILessonDAO {

    @Override
    public List<Lesson> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Lesson get(int id) {
        Connection connection = DBContext.getConnection();
        String sql = "SELECT  lessonId,  name,  chapterId,  typeId,  duration, content\n"
                + "FROM `swp391_onlinelearning`.`lesson` l \n"
                + "WHERE lessonId = ?";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                Lesson l = new Lesson();
                l.setLessonId(rs.getInt("lessonId"));
                l.setName(rs.getString("name"));

                Chapter c = new Chapter();
                c.setChapterId(rs.getInt("chapterId"));

                LessonType lt = new LessonType();
                lt.setTypeId(rs.getInt("typeId"));

                l.setChapter(c);
                l.setType(lt);
                l.setDuration(rs.getInt("duration"));
                l.setContent(rs.getString("content"));
                return l;
            }
        } catch (SQLException ex) {
            Logger.getLogger(LessonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public boolean update(Lesson t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean insert(Lesson t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Map<Chapter, List<Lesson>> getLessonByCourse(int courseId) {
        Connection connection = DBContext.getConnection();
        Map<Chapter, List<Lesson>> chapterMappingLessons = new LinkedHashMap<>();
        List<Chapter> chapters = new ArrayList<>();
        String chapterSql = "SELECT chapterId, name, courseId "
                + "FROM `swp391_onlinelearning`.`chapter`"
                + "WHERE courseId = ?";

        String sql = "SELECT  lessonId,  name,  chapterId,  typeId,  duration, content\n"
                + "FROM `swp391_onlinelearning`.`lesson` l \n"
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
                    List<Lesson> lessons = new ArrayList<>();
                    PreparedStatement lessonStm = connection.prepareStatement(sql);
                    lessonStm.setInt(1, chapter.getChapterId());
                    ResultSet rs = lessonStm.executeQuery();
                    while (rs.next()) {
                        Lesson l = new Lesson();
                        l.setLessonId(rs.getInt("lessonId"));
                        l.setChapter(chapter);
                        l.setName(rs.getString("name"));
                        LessonType lt = new LessonType();
                        lt.setTypeId(rs.getInt("typeId"));
                        l.setType(lt);
                        l.setDuration(rs.getInt("duration"));
                        l.setContent(rs.getString("content"));
                        lessons.add(l);
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
    public int getCurrentLesson(int courseId, int userId) {
        Connection connection = DBContext.getConnection();
        String sql = "SELECT MAX(ul.lessonId) AS current FROM swp391_onlinelearning.userlesson ul\n"
                + "JOIN swp391_onlinelearning.lesson l \n"
                + "ON ul.lessonId = l.lessonId\n"
                + "JOIN swp391_onlinelearning.chapter ch\n"
                + "ON l.chapterId = ch.chapterId\n"
                + "JOIN swp391_onlinelearning.course c \n"
                + "ON ch.courseId = c.courseId\n"
                + "WHERE ul.userId= ? AND c.courseId = ? AND ul.isFinished = 1";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, userId);
            stm.setInt(2, courseId);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                return rs.getInt("current");
            }
        } catch (SQLException ex) {
            Logger.getLogger(LessonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public int getNextLesson(int userId, int current) {
        Connection connection = DBContext.getConnection();
        String sql = "SELECT MIN(lessonId) AS nextLesson FROM swp391_onlinelearning.userlesson\n"
                + "WHERE lessonId > ? AND userId = ?";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, current);
            stm.setInt(2, userId);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                return rs.getInt("nextLesson");
            }
        } catch (SQLException ex) {
            Logger.getLogger(LessonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public int getFirstLessonId(int courseId) {
        Connection connection = DBContext.getConnection();
        String sql = "SELECT MIN(l.lessonId) AS firstLesson FROM swp391_onlinelearning.course c\n"
                + "JOIN swp391_onlinelearning.chapter ch\n"
                + "ON c.courseId = ch.courseId\n"
                + "JOIN swp391_onlinelearning.lesson l\n"
                + "ON ch.chapterId = l.chapterId";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                return rs.getInt("firstLesson");
            }

        } catch (SQLException ex) {
            Logger.getLogger(LessonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public int getLastLessonId(int courseId) {
        Connection connection = DBContext.getConnection();
        String sql = "SELECT MAX(l.lessonId) AS lastLesson FROM swp391_onlinelearning.course c\n"
                + "JOIN swp391_onlinelearning.chapter ch\n"
                + "ON c.courseId = ch.courseId\n"
                + "JOIN swp391_onlinelearning.lesson l\n"
                + "ON ch.chapterId = l.chapterId";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                return rs.getInt("lastLesson");
            }
        } catch (SQLException ex) {
            Logger.getLogger(LessonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public int getPreviousLesson(int userId, int current) {
        Connection connection = DBContext.getConnection();
        String sql = "SELECT MAX(lessonId) AS previousLesson FROM swp391_onlinelearning.userlesson\n"
                + "WHERE lessonId < ? AND userId = ?";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, current);
            stm.setInt(2, userId);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                return rs.getInt("previousLesson");
            }
        } catch (SQLException ex) {
            Logger.getLogger(LessonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public List<Lesson> getLessonsByCourse(int courseId) {
        List<Lesson> lessons = new ArrayList<>();
        Connection connection = DBContext.getConnection();
        String sql = "SELECT  l.`lessonId`,  l.`name`,  l.`chapterId`,  l.`typeId`,  l.`duration`,l.content \n"
                + "FROM `swp391_onlinelearning`.`lesson` l\n"
                + "JOIN swp391_onlinelearning.chapter ch \n"
                + "ON l.chapterId = ch.chapterId\n"
                + "JOIN swp391_onlinelearning.course c\n"
                + "ON ch.courseId = c.courseId\n"
                + "WHERE c.courseId = ?";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, courseId);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Lesson l = new Lesson();
                l.setLessonId(rs.getInt("lessonId"));
                Chapter chapter = new Chapter();
                chapter.setChapterId(rs.getInt("chapterId"));
                l.setChapter(chapter);
                l.setName(rs.getString("name"));
                LessonType lt = new LessonType();
                lt.setTypeId(rs.getInt("typeId"));
                l.setType(lt);
                l.setDuration(rs.getInt("duration"));
                l.setContent(rs.getString("content"));
                lessons.add(l);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LessonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lessons;
    }

}
