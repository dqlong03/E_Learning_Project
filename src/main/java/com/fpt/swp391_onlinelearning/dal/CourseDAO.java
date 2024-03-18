/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.swp391_onlinelearning.dal;

import com.fpt.swp391_onlinelearning.dal.idbcontex.ICourseDAO;

import com.fpt.swp391_onlinelearning.dal.idbcontex.IDAO;
import com.fpt.swp391_onlinelearning.model.Course;
import com.fpt.swp391_onlinelearning.model.CourseCategory;
import com.fpt.swp391_onlinelearning.model.Duration;
import com.fpt.swp391_onlinelearning.model.Language;
import com.fpt.swp391_onlinelearning.model.Level;
import com.fpt.swp391_onlinelearning.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author tran Hoang Phuc
 */
public class CourseDAO implements IDAO<Course>, ICourseDAO {

    @Override
    public List<Course> getAll() {
        Connection connection = DBContext.getConnection();
        List<Course> courses = new ArrayList<>();
        String sql = "SELECT  c.`courseId`,  c.`name`,  c.`courseCategoryId`, "
                + "cc.`name` AS `categoryName`,  c.`price`,  c.`levelId`, "
                + "l.`name` AS `levelName`, c.`durationId`,d.`name` AS `durationName`,  "
                + "c.`authorId`, c.`name` AS `authorName`,  c.`languageId`, "
                + "c.`name` AS `languageName`,  c.`description`, c.`img`, c.`createdTime` \n"
                + "FROM `swp391_onlinelearning`.`course` c "
                + "JOIN `swp391_onlinelearning`.`coursecategory` cc ON c.courseCategoryId = cc.courseCategoryId \n"
                + "JOIN `swp391_onlinelearning`.`level` l ON c.levelId = l.levelId \n"
                + "JOIN `swp391_onlinelearning`.`duration` d ON c.durationId = d.durationId \n"
                + "JOIN `swp391_onlinelearning`.`user` u ON c.authorId = u.userId \n"
                + "JOIN `swp391_onlinelearning`.`language` la ON c.languageId = la.languageId";

        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                Course course = new Course();
                course.setCourseId(rs.getInt("courseId"));
                course.setName(rs.getString("name"));
                CourseCategory category = new CourseCategory();
                category.setCourseCategoryId(rs.getInt("courseCategoryId"));
                category.setName(rs.getString("categoryName"));
                com.fpt.swp391_onlinelearning.model.Level level = new com.fpt.swp391_onlinelearning.model.Level();
                level.setLevelId(rs.getInt("levelId"));
                level.setName(rs.getString("levelName"));
                Duration duration = new Duration();
                duration.setDurationId(rs.getInt("durationId"));
                duration.setName(rs.getString("durationName"));
                User u = new User();
                u.setUserId(rs.getInt("authorId"));
                u.setName(rs.getString("authorName"));
                Language language = new Language();
                language.setLanguageId(rs.getInt("languageId"));
                language.setName(rs.getString("languageName"));
                course.setLevel(level);
                course.setAuthor(u);
                course.setLanguage(language);
                course.setDescription(rs.getString("description"));
                course.setImg(rs.getString("img"));
                course.setCreatedTime(rs.getDate("createdTime"));
                courses.add(course);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CourseDAO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } finally {
            DBContext.close(connection);
        }
        return courses;
    }

    public static void main(String[] args) {
        List<Course> c = new CourseDAO().getAllCourse(1, 10, 0, 0,"", 0, 0, 0);
        System.out.println(c.get(1).getImg());
    }

    @Override
    public Course get(int id) {
        Connection connection = DBContext.getConnection();
        String sql = "SELECT  c.`courseId`,  c.`name`,  c.`courseCategoryId`, "
                + "cc.`name` AS `categoryName`,  c.`price`,  c.`levelId`, "
                + "l.`name` AS `levelName`, c.`durationId`,d.`name` AS `durationName`,  "
                + "c.`authorId`, c.`name` AS `authorName`,  c.`languageId`, "
                + "c.`name` AS `languageName`,  c.`description`, c.`img`, c.`createdTime` \n"
                + "FROM `swp391_onlinelearning`.`course` c "
                + "JOIN `swp391_onlinelearning`.`coursecategory` cc ON c.courseCategoryId = cc.courseCategoryId\n"
                + "JOIN `swp391_onlinelearning`.`level` l ON c.levelId = l.levelId\n"
                + "JOIN `swp391_onlinelearning`.`duration` d ON c.durationId = d.durationId\n"
                + "JOIN `swp391_onlinelearning`.`user` u ON c.authorId = u.userId\n"
                + "JOIN `swp391_onlinelearning`.`language` la ON c.languageId = la.languageId\n"
                + "WHERE c.`courseId` = ?";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                Course course = new Course();
                course.setCourseId(rs.getInt("courseId"));
                course.setName(rs.getString("name"));
                course.setPrice(rs.getLong("price"));
                CourseCategory category = new CourseCategory();
                category.setCourseCategoryId(rs.getInt("courseCategoryId"));
                category.setName(rs.getString("categoryName"));
                com.fpt.swp391_onlinelearning.model.Level level = new com.fpt.swp391_onlinelearning.model.Level();
                level.setLevelId(rs.getInt("levelId"));
                level.setName(rs.getString("levelName"));
                Duration duration = new Duration();
                duration.setDurationId(rs.getInt("durationId"));
                duration.setName(rs.getString("durationName"));
                User u = new User();
                u.setUserId(rs.getInt("authorId"));
                u.setName(rs.getString("authorName"));
                Language language = new Language();
                language.setLanguageId(rs.getInt("languageId"));
                language.setName(rs.getString("languageName"));
                course.setDuration(duration);
                course.setCategory(category);
                course.setLevel(level);
                course.setAuthor(u);
                course.setLanguage(language);
                course.setDescription(rs.getString("description"));
                course.setImg(rs.getString("img"));
                course.setCreatedTime(rs.getDate("createdTime"));
                return course;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CourseDAO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } finally {
            DBContext.close(connection);
        }
        return null;
    }

    @Override
    public boolean update(Course t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean insert(Course t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Course> getRecentlyCourse(int numberOfCourses) {
        Connection connection = DBContext.getConnection();
        List<Course> courseList = new ArrayList<Course>();
        try {
            String sql = "SELECT c.courseId,c.name,c.courseCategoryId, cate.name AS CateName,c.price,c.description,c.createdTime,IFNULL(c.Img,0) AS Img,c.levelId,l.name AS levelName,c.authorId, c.durationId,c.languageId,d.name AS durationName, la.name AS languageName\n"
                    + "FROM course AS c, coursecategory AS cate, `level` AS l, `user` AS u, duration AS d, `language` AS la\n"
                    + "WHERE c.courseCategoryId=cate.courseCategoryId AND c.levelId=l.levelId AND c.authorId=u.userId AND d.durationId=c.durationId AND la.languageId=c.languageId\n"
                    + "ORDER BY createdTime DESC\n"
                    + "LIMIT ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, numberOfCourses);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Course c = new Course();
                c.setCourseId(rs.getInt("courseId"));
                c.setName(rs.getString("name"));

                CourseCategory cCategory = new CourseCategory();
                cCategory.setCourseCategoryId(rs.getInt("courseCategoryId"));
                cCategory.setName(rs.getString("CateName"));
                c.setCategory(cCategory);

                Level level = new Level();
                level.setLevelId(rs.getInt("levelId"));
                level.setName(rs.getString("levelName"));
                c.setLevel(level);

                c.setPrice(rs.getLong("price"));
                c.setDescription(rs.getString("description"));
                c.setCreatedTime(rs.getDate("createdTime"));
                c.setImg(rs.getString("Img"));
                User u = new User();
                u.setUserId(rs.getInt("authorId"));
                c.setAuthor(u);

                Duration d = new Duration();
                d.setDurationId(rs.getInt("durationId"));
                d.setName(rs.getString("durationName"));
                c.setDuration(d);

                Language l = new Language();
                l.setLanguageId(rs.getInt("languageId"));
                l.setName(rs.getString("languageName"));
                c.setLanguage(l);

                courseList.add(c);
            }
        } catch (SQLException ex) {

        } finally {
            DBContext.close(connection);
        }
        return courseList;
    }

    @Override
    public int getCount(int ccid, String name, int levelid, int durationid, int languageid) {
        Connection connection = DBContext.getConnection();

        try {
            int paramIndex = 0;
            StringBuilder bonus = new StringBuilder();
            List<Object> paramValues = new ArrayList<>();

            if (ccid != 0) {
                bonus.append(" AND c.courseCategoryId = ?");
                paramValues.add(ccid);
            }
            if (name != null && !"".equals(name)) {
                bonus.append(" AND c.coursename LIKE ?");
                paramValues.add("%" + name + "%");
            }
            if (levelid != 0) {
                bonus.append(" AND c.levelId = ?");
                paramValues.add(levelid);
            }
            if (durationid != 0) {
                bonus.append(" AND c.durationId = ?");
                paramValues.add(durationid);
            }
            if (languageid != 0) {
                bonus.append(" AND c.languageId = ?");
                paramValues.add(languageid);
            }
            String sql = "SELECT COUNT(*) AS total\n"
                    + "FROM (\n"
                    + "    SELECT courseId,coursename,courseCategoryId,price,levelId,levelname,durationId,durationname,authorId,username,languageId,languagename,description,createdTime,img,coursecategoyname\n"
                    + "FROM\n"
                    + "    (SELECT ROW_NUMBER() OVER (ORDER BY c.createdTime desc) AS rownum,c.courseId, c.name as coursename, c.courseCategoryId, c.price, c.levelId, l.name as levelname, c.durationId, d.name as durationname, c.authorId, u.name as username, c.languageId, lan.name as languagename, c.description, c.createdTime, c.img, cc.name as coursecategoyname\n"
                    + "        FROM course c\n"
                    + "        JOIN coursecategory cc ON c.courseCategoryId = cc.courseCategoryId\n"
                    + "        JOIN `level` l ON c.levelId = l.levelId\n"
                    + "        JOIN duration d  ON c.durationId = d.durationId\n"
                    + "        JOIN `user` u ON c.authorId = u.userId\n"
                    + "        JOIN `language` lan ON c.languageId = lan.languageId" + bonus + ") t\n"
                    + ") AS CountTable;";
            PreparedStatement stm = connection.prepareStatement(sql);
            for (Object paramValue : paramValues) {
                paramIndex++;
                if (paramValue instanceof Integer) {
                    stm.setInt(paramIndex, (Integer) paramValue);
                } else if (paramValue instanceof String) {
                    stm.setString(paramIndex, (String) paramValue);
                }
            }
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                return rs.getInt("total");
            }
        } catch (SQLException ex) {
            Logger.getLogger(CourseDAO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } finally {
            DBContext.close(connection);
        }
        return -1;
    }

    @Override
    public List<Course> getAllCourse(int pageindex, int pagesize, int sort, int ccid, String name, int levelid, int durationid, int languageid) {
        Connection connection = DBContext.getConnection();
        ArrayList<Course> course = new ArrayList<>();

        try {
            int paramIndex = 0;
            String order = (sort == 0) ? " DESC" : " ASC";
            StringBuilder bonus = new StringBuilder();
            List<Object> paramValues = new ArrayList<>();

            if (ccid != 0) {
                bonus.append(" AND c.courseCategoryId = ?");
                paramValues.add(ccid);
            }
            if (name != null && !"".equals(name)) {
                bonus.append(" AND c.name LIKE ?");
                paramValues.add("%" + name + "%");
            }
            if (levelid != 0) {
                bonus.append(" AND c.levelId = ?");
                paramValues.add(levelid);
            }
            if (durationid != 0) {
                bonus.append(" AND c.durationId = ?");
                paramValues.add(durationid);
            }
            if (languageid != 0) {
                bonus.append(" AND c.languageId = ?");
                paramValues.add(languageid);
            }

            String sql = "SELECT courseId, coursename, courseCategoryId, price, levelId, levelname, durationId, durationname, authorId, username, languageId, languagename, description, createdTime, img, coursecategoyname\n"
                    + "FROM (\n"
                    + "    SELECT ROW_NUMBER() OVER (ORDER BY c.createdTime " + order + ") AS rownum, c.courseId, c.name as coursename, c.courseCategoryId, c.price, c.levelId, l.name as levelname, c.durationId, d.name as durationname, c.authorId, u.name as username, c.languageId, lan.name as languagename, c.description, c.createdTime, c.img, cc.name as coursecategoyname\n"
                    + "    FROM course c\n"
                    + "    JOIN coursecategory cc ON c.courseCategoryId = cc.courseCategoryId\n"
                    + "    JOIN `level` l ON c.levelId = l.levelId\n"
                    + "    JOIN duration d  ON c.durationId = d.durationId\n"
                    + "    JOIN `user` u ON c.authorId = u.userId\n"
                    + "    JOIN `language` lan ON c.languageId = lan.languageId\n"
                    + "    WHERE 1=1" + bonus.toString() + "\n"
                    + ") t\n"
                    + "WHERE rownum BETWEEN (? - 1) * ? + 1 AND ? * ?";

            PreparedStatement stm = connection.prepareStatement(sql);

            for (Object paramValue : paramValues) {
                paramIndex++;
                if (paramValue instanceof Integer) {
                    stm.setInt(paramIndex, (Integer) paramValue);
                } else if (paramValue instanceof String) {
                    stm.setString(paramIndex, (String) paramValue);
                }
            }

            stm.setInt(paramIndex + 1, pageindex);
            stm.setInt(paramIndex + 2, pagesize);
            stm.setInt(paramIndex + 3, pageindex);
            stm.setInt(paramIndex + 4, pagesize);

            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Course c = new Course();
                c.setCourseId(rs.getInt("courseId"));
                c.setName(rs.getString("coursename"));
                c.setPrice(rs.getLong("price"));
                c.setImg(rs.getString("img"));
                Level cl = new Level();
                cl.setLevelId(rs.getInt("levelId"));
                cl.setName(rs.getString("levelname"));
                c.setLevel(cl);
                CourseCategory category = new CourseCategory();
                category.setCourseCategoryId(rs.getInt("courseCategoryId"));
                category.setName(rs.getString("coursecategoyname"));
                c.setCategory(category);
                course.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CourseDAO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } finally {
            DBContext.close(connection);
        }
        return course;
    }

    @Override
    public Course getCourseDetail(int courseId) {
        Connection connection = DBContext.getConnection();
        String sql = "SELECT c.courseId, c.name AS courseName, cc.name AS coursecategory,c.courseCategoryId, lv.name AS `level` ,c.levelId , c.price, d.name AS duration,\n"
                + "c.durationId, u.name AS authorname,c.authorId, u.img AS imgAuthor, l.name AS `language`,c.languageId, c.description, c.img\n"
                + "FROM course c\n"
                + "JOIN coursecategory cc ON c.courseCategoryId = cc.courseCategoryId\n"
                + "JOIN `user` u ON c.authorId = u.userId\n"
                + "JOIN `language` l ON c.languageId = l.languageId\n"
                + "JOIN `level` lv ON c.levelId = lv.levelId\n"
                + "JOIN duration d ON c.durationId = d.durationId\n"
                + "WHERE c.courseId=?";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, courseId);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {

                Course c = new Course();
                c.setCourseId(rs.getInt("courseId"));
                c.setName(rs.getString("courseName"));
                c.setDescription(rs.getString("description"));
                c.setImg(rs.getString("img"));
                c.setPrice(rs.getInt("price"));

                CourseCategory cc = new CourseCategory();
                cc.setName(rs.getString("coursecategory"));
                cc.setCourseCategoryId(rs.getInt("courseCategoryId"));
                c.setCategory(cc);

                User u = new User();
                u.setName(rs.getString("authorname"));
                u.setUserId(rs.getInt("authorId"));
                u.setImg(rs.getString("imgAuthor"));
                c.setAuthor(u);

                Level l = new Level();
                l.setName(rs.getString("level"));
                l.setLevelId(rs.getInt("levelId"));
                c.setLevel(l);

                Duration d = new Duration();
                d.setName(rs.getString("duration"));
                d.setDurationId(rs.getInt("durationId"));
                c.setDuration(d);

                Language lg = new Language();
                lg.setLanguageId(rs.getInt("languageId"));
                lg.setName(rs.getString("language"));
                c.setLanguage(lg);

                return c;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } finally {
            DBContext.close(connection);
        }
        return null;
    }

}
