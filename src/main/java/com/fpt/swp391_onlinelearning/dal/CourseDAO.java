/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.swp391_onlinelearning.dal;

import com.fpt.swp391_onlinelearning.dal.idal.ICourseDAO;
import com.fpt.swp391_onlinelearning.dal.idal.IDAO;
import com.fpt.swp391_onlinelearning.model.Course;
import com.fpt.swp391_onlinelearning.model.CourseCategory;
import com.fpt.swp391_onlinelearning.model.Duration;
import com.fpt.swp391_onlinelearning.model.Language;
import com.fpt.swp391_onlinelearning.model.Level;
import com.fpt.swp391_onlinelearning.model.User;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
                + "JOIN `swp391_onlinelearning`.`language` la ON c.languageId = la.languageId where c.isActivated=true";

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
                + "WHERE c.`courseId` = ? and c.isActivated=true";
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
                    + "WHERE c.courseCategoryId=cate.courseCategoryId AND c.levelId=l.levelId AND c.authorId=u.userId AND d.durationId=c.durationId AND la.languageId=c.languageId and c.isActivated=true\n"
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
                    + "        JOIN `language` lan ON c.languageId = lan.languageId" + bonus + " AND c.isActivated=true) t\n"
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
                    + "    WHERE 1=1" + bonus.toString() + " AND c.isActivated=true\n"
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
        String sql = "SELECT c.courseId, c.name AS courseName, cc.name AS coursecategory, "
                + "c.courseCategoryId, lv.name AS `level` ,c.levelId , c.price, d.name AS duration,\n"
                + "c.durationId, u.name AS authorname,c.authorId, u.img AS imgAuthor, "
                + "l.name AS `language`,c.languageId, c.description, c.img\n"
                + "FROM course c\n"
                + "JOIN coursecategory cc ON c.courseCategoryId = cc.courseCategoryId\n"
                + "JOIN `user` u ON c.authorId = u.userId\n"
                + "JOIN `language` l ON c.languageId = l.languageId\n"
                + "JOIN `level` lv ON c.levelId = lv.levelId\n"
                + "JOIN duration d ON c.durationId = d.durationId\n"
                + "WHERE c.courseId=? and c.isActivated=true";
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

    

    @Override
    public List<Course> getUserRegisterdCourse(int userId, String searchValue, int categoryId, Date from, Date to, int pageIndex) {
        Connection connection = DBContext.getConnection();
        ArrayList<Course> course = new ArrayList<>();

        String sql = "SELECT * FROM ( "
                + "SELECT ROW_NUMBER() OVER (ORDER BY ct.createdTime desc) AS rownum, \n"
                + "c.courseId, c.`name` AS `courseName`, cc.`name` AS `coursecategory`, \n"
                + "c.`courseCategoryId`, lv.`name` AS `level` ,c.`levelId` , c.`price`, d.`name` AS `duration`,\n"
                + " c.`durationId`, u.`name` AS `authorname`,c.`authorId`, \n"
                + "u.`img` AS `imgAuthor`, l.`name` AS `language`,c.`languageId`, c.`description`, c.`img`\n"
                + "FROM `course` c\n"
                + "JOIN `coursecategory` cc ON c.`courseCategoryId` = cc.`courseCategoryId`\n"
                + "JOIN `user` u ON c.`authorId` = u.`userId`\n"
                + "JOIN `language` l ON c.`languageId` = l.`languageId`\n"
                + "JOIN `level` lv ON c.`levelId` = lv.`levelId`\n"
                + "JOIN `duration` d ON c.`durationId` = d.`durationId`\n"
                + "JOIN `courseregistration` ct ON c.`courseId` = ct.`courseId`\n"
                + "WHERE ct.`userId` = ? AND (c.`name` LIKE ? OR u.`name` LIKE ? ) \n"
                + "AND ct.createdTime >= ? AND ct.createdTime <= ?) t \n"
                + "WHERE  rownum >=(?-1)* 6+1 AND rownum <= ?*6";
        if (categoryId != 0) {
            sql += " AND t.courseCategoryId = ?";
        }
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, userId);
            stm.setString(2, "%" + searchValue + "%");
            stm.setString(3, "%" + searchValue + "%");
            stm.setDate(4, from);
            stm.setDate(5, to);
            stm.setInt(6, pageIndex);
            stm.setInt(7, pageIndex);
            if (categoryId != 0) {
                stm.setInt(8, categoryId);
            }
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
                course.add(c);
            }

        } catch (SQLException ex) {
            Logger.getLogger(CourseDAO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        return course;
    }

    @Override
    public int getNumOfUserRegisterdCourse(int userId, String searchValue, int categoryId, Date from, Date to) {
        Connection connection = DBContext.getConnection();
        String sql = "SELECT COUNT(*) AS `num` FROM `course` c\n"
                + "JOIN `coursecategory` cc ON c.`courseCategoryId` = cc.`courseCategoryId`\n"
                + "JOIN `user` u ON c.`authorId` = u.`userId`\n"
                + "JOIN `language` l ON c.`languageId` = l.`languageId`\n"
                + "JOIN `level` lv ON c.`levelId` = lv.`levelId`\n"
                + "JOIN `duration` d ON c.`durationId` = d.`durationId`\n"
                + "JOIN `courseregistration` ct ON c.`courseId` = ct.`courseId`\n"
                + "WHERE ct.`userId` = ? AND (c.`name` LIKE ? OR u.`name` LIKE ?) \n"
                + "AND ct.createdTime >= ? AND ct.createdTime <= ?";
        if (categoryId != 0) {
            sql += " AND cc.courseCategoryId = ?";
        }
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, userId);
            stm.setString(2, "%" + searchValue + "%");
            stm.setString(3, "%" + searchValue + "%");
            stm.setDate(4, from);
            stm.setDate(5, to);
            if (categoryId != 0) {
                stm.setInt(6, categoryId);
            }
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                return rs.getInt("num");
            }
        } catch (SQLException ex) {
            Logger.getLogger(CourseDAO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } finally {
            DBContext.close(connection);
        }
        return 0;
    }

    @Override
    public List<Course> searchCourse(String infor) {
        Connection connection = DBContext.getConnection();
        ArrayList<Course> courselist = new ArrayList<>();
        String sql = "SELECT * FROM (\n"
                + "SELECT c.courseId, c.name, cc.name AS category,\n"
                + "l.name AS level, la.name AS language, c.price AS cost, u.name AS author FROM course c\n"
                + "JOIN user u ON u.userId = c.authorId\n"
                + "JOIN coursecategory cc ON cc.courseCategoryId = c.courseCategoryId\n"
                + "JOIN level l ON l.levelId = c.levelId\n"
                + "JOIN language la ON la.languageId = c.languageId\n"
                + "WHERE c.name LIKE ? \n"
                + ") t\n";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, "%" + infor + "%");

            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Course course = new Course();
                course.setCourseId(rs.getInt("courseId"));
                course.setName(rs.getString("name"));
                CourseCategory courseCategory = new CourseCategory();
                courseCategory.setName(rs.getString("category"));
                course.setCategory(courseCategory);
                Level level = new Level();
                level.setName(rs.getString("level"));
                course.setLevel(level);
                Language language = new Language();
                language.setName(rs.getString("language"));
                course.setLanguage(language);
                course.setPrice(rs.getLong("cost"));
                User author = new User();
                author.setName(rs.getString("author"));
                course.setAuthor(author);
                courselist.add(course);
            }
            return courselist;

        } catch (SQLException ex) {
            Logger.getLogger(CourseDAO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } finally {
            DBContext.close(connection);
        }
        return null;
    }

    @Override
    public int countSearchRecord(String infor) {
        Connection connection = DBContext.getConnection();
        String sql = "SELECT COUNT(*) AS numOfRecord FROM (\n"
                + "SELECT c.courseId, c.name, cc.name AS category,\n"
                + "l.name AS level, la.name AS language, c.price AS cost, u.name AS author FROM course c\n"
                + "JOIN user u ON u.userId = c.authorId\n"
                + "JOIN coursecategory cc ON cc.courseCategoryId = c.courseCategoryId\n"
                + "JOIN level l ON l.levelId = c.levelId\n"
                + "JOIN language la ON la.languageId = c.languageId\n"
                + "WHERE c.name LIKE ? ) t";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, "%" + infor + "%");
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                return rs.getInt("numOfRecord");
            }
        } catch (SQLException ex) {
            Logger.getLogger(CourseDAO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } finally {
            DBContext.close(connection);
        }
        return 0;
    }

    @Override
    public List<Course> getAllCoursesPagger(int pageIndex, String searchInfor, int level, int category, int duration, int language) {
        List<Course> course = new ArrayList<>();
        Connection connection = DBContext.getConnection();
        String sql = "SELECT t.courseId, t.coursename, t.courseCategoryId, t.price, t.levelId, \n"
                + "       t.levelname, t.durationId, t.durationname, t.authorId, t.username, \n"
                + "       t.languageId, t.languagename, t.description, t.createdTime, t.img, t.isActivated, \n"
                + "       t.coursecategoyname \n"
                + "FROM (\n"
                + "    SELECT ROW_NUMBER() OVER (ORDER BY c.createdTime DESC) AS rownum, c.isActivated,\n"
                + "           c.courseId, c.name as coursename, c.courseCategoryId, c.price, \n"
                + "           c.levelId, l.name as levelname, c.durationId, d.name as durationname, \n"
                + "           c.authorId, u.name as username, c.languageId, lan.name as languagename, \n"
                + "           c.description, c.createdTime, c.img, cc.name as coursecategoyname\n"
                + "    FROM course c\n"
                + "    JOIN coursecategory cc ON c.courseCategoryId = cc.courseCategoryId\n"
                + "    JOIN `level` l ON c.levelId = l.levelId\n"
                + "    JOIN duration d  ON c.durationId = d.durationId\n"
                + "    JOIN `user` u ON c.authorId = u.userId\n"
                + "    JOIN `language` lan ON c.languageId = lan.languageId\n"
                + "    WHERE (c.name LIKE ? OR u.name LIKE ?) ";
        if (level != 0) {
            sql += "AND c.levelId = ? ";
        }
        if (category != 0) {
            sql += "AND c.courseCategoryId = ? ";
        }
        if (duration != 0) {
            sql += "AND c.durationId = ? ";
        }
        if (language != 0) {
            sql += "AND c.languageId = ? ";
        }
        sql += ") t WHERE t.rownum >= (?-1)*8+1 AND t.rownum <= ?*8;";

        try {
            int paramIndex = 1;
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(paramIndex++, "%" + searchInfor + "%");
            stm.setString(paramIndex++, "%" + searchInfor + "%");
            if (level != 0) {
                stm.setInt(paramIndex++, level);
            }
            if (category != 0) {
                stm.setInt(paramIndex++, category);
            }
            if (duration != 0) {
                stm.setInt(paramIndex++, duration);
            }
            if (language != 0) {
                stm.setInt(paramIndex++, language);
            }
            stm.setInt(paramIndex++, pageIndex);
            stm.setInt(paramIndex, pageIndex);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Course c = new Course();
                c.setIsActivated(rs.getBoolean("isActivated"));
                c.setCourseId(rs.getInt("courseId"));
                c.setName(rs.getString("coursename"));
                c.setPrice(rs.getLong("price"));
                c.setImg(rs.getString("img"));
                Level cl = new Level();
                cl.setLevelId(rs.getInt("levelId"));
                cl.setName(rs.getString("levelname"));
                c.setLevel(cl);
                CourseCategory courseCategory = new CourseCategory();
                courseCategory.setCourseCategoryId(rs.getInt("courseCategoryId"));
                courseCategory.setName(rs.getString("coursecategoyname"));
                c.setCategory(courseCategory);
                course.add(c);
                Duration durationC = new Duration();
                durationC.setDurationId(rs.getInt("durationId"));
                durationC.setName(rs.getString("durationname"));
                c.setDuration(durationC);

                Language language1 = new Language();
                language1.setLanguageId(rs.getInt("languageId"));
                language1.setName(rs.getString("languagename"));
                c.setLanguage(language1);

                User author = new User();
                author.setName(rs.getString("username"));
                c.setAuthor(author);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CourseDAO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } finally {
            DBContext.close(connection);
        }
        return course;
    }

    @Override
    public int getTotalRecord(String searchInfor, int level, int category, int duration, int language) {
        Connection connection = DBContext.getConnection();
        String sql = "SELECT COUNT(*) AS numOfRecord\n"
                + "   FROM course c\n"
                + "    JOIN coursecategory cc ON c.courseCategoryId = cc.courseCategoryId\n"
                + "    JOIN `level` l ON c.levelId = l.levelId\n"
                + "    JOIN duration d  ON c.durationId = d.durationId\n"
                + "    JOIN `user` u ON c.authorId = u.userId\n"
                + "    JOIN `language` lan ON c.languageId = lan.languageId\n"
                + "    WHERE (c.name LIKE ? OR u.name LIKE ?) ";
        if (level != 0) {
            sql += "AND c.levelId = ? ";
        }
        if (category != 0) {
            sql += "AND c.courseCategoryId = ? ";
        }
        if (duration != 0) {
            sql += "AND c.durationId = ? ";
        }
        if (language != 0) {
            sql += "AND c.languageId = ? ";
        }
        try {
            int paramIndex = 1;
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(paramIndex++, "%" + searchInfor + "%");
            stm.setString(paramIndex++, "%" + searchInfor + "%");
            if (level != 0) {
                stm.setInt(paramIndex++, level);
            }
            if (category != 0) {
                stm.setInt(paramIndex++, category);
            }
            if (duration != 0) {
                stm.setInt(paramIndex++, duration);
            }
            if (language != 0) {
                stm.setInt(paramIndex, language);
            }
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                return rs.getInt("numOfRecord");
            }
        } catch (SQLException ex) {
            Logger.getLogger(CourseDAO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } finally {
            DBContext.close(connection);
        }
        return 0;
    }

    @Override
    public void changeCourseStatus(int courseId, boolean status) {
        Connection connecion = DBContext.getConnection();
        String sql = "UPDATE `swp391_onlinelearning`.`course` \n"
                + "SET isActivated = ? WHERE  `courseId`= ?;";
        try {
            PreparedStatement stm = connecion.prepareStatement(sql);
            stm.setBoolean(1, status);
            stm.setInt(2, courseId);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CourseDAO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } finally {
            DBContext.close(connecion);
        }

    }

    @Override
    public Course getCourseDetailAll(int courseId) {
        Connection connection = DBContext.getConnection();
        String sql = "SELECT c.courseId, c.name AS courseName, cc.name AS coursecategory, "
                + "c.courseCategoryId, lv.name AS `level` ,c.levelId , c.price, d.name AS duration,\n"
                + "c.durationId, u.name AS authorname,c.authorId, u.img AS imgAuthor, "
                + "l.name AS `language`,c.languageId, c.description, c.img\n"
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

    @Override
    public List<Course> getCourseByAuthor(int pageIndex, String searchInfor, int level, int category, int duration, int language, int userId) {
        List<Course> course = new ArrayList<>();
        Connection connection = DBContext.getConnection();
        String sql = "SELECT t.courseId, t.coursename, t.courseCategoryId, t.price, t.levelId, \n"
                + "       t.levelname, t.durationId, t.durationname, t.authorId, t.username, \n"
                + "       t.languageId, t.languagename, t.description, t.createdTime, t.img, t.isActivated, \n"
                + "       t.coursecategoyname \n"
                + "FROM (\n"
                + "    SELECT ROW_NUMBER() OVER (ORDER BY c.createdTime DESC) AS rownum, c.isActivated,\n"
                + "           c.courseId, c.name as coursename, c.courseCategoryId, c.price, \n"
                + "           c.levelId, l.name as levelname, c.durationId, d.name as durationname, \n"
                + "           c.authorId, u.name as username, c.languageId, lan.name as languagename, \n"
                + "           c.description, c.createdTime, c.img, cc.name as coursecategoyname\n"
                + "    FROM course c\n"
                + "    JOIN coursecategory cc ON c.courseCategoryId = cc.courseCategoryId\n"
                + "    JOIN `level` l ON c.levelId = l.levelId\n"
                + "    JOIN duration d  ON c.durationId = d.durationId\n"
                + "    JOIN `user` u ON c.authorId = u.userId\n"
                + "    JOIN `language` lan ON c.languageId = lan.languageId\n"
                + "    WHERE (c.name LIKE ? OR u.name LIKE ?) ";
        if (level != 0) {
            sql += "AND c.levelId = ? ";
        }
        if (category != 0) {
            sql += "AND c.courseCategoryId = ? ";
        }
        if (duration != 0) {
            sql += "AND c.durationId = ? ";
        }
        if (language != 0) {
            sql += "AND c.languageId = ? ";
        }
        sql += "AND c.authorId = ? ) t WHERE t.rownum >= (?-1)*8+1 AND t.rownum <= ?*8";

        try {
            int paramIndex = 1;
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(paramIndex++, "%" + searchInfor + "%");
            stm.setString(paramIndex++, "%" + searchInfor + "%");
            if (level != 0) {
                stm.setInt(paramIndex++, level);
            }
            if (category != 0) {
                stm.setInt(paramIndex++, category);
            }
            if (duration != 0) {
                stm.setInt(paramIndex++, duration);
            }
            if (language != 0) {
                stm.setInt(paramIndex++, language);
            }
            stm.setInt(paramIndex++, userId);
            stm.setInt(paramIndex++, pageIndex);
            stm.setInt(paramIndex, pageIndex);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Course c = new Course();
                c.setIsActivated(rs.getBoolean("isActivated"));
                c.setCourseId(rs.getInt("courseId"));
                c.setName(rs.getString("coursename"));
                c.setPrice(rs.getLong("price"));
                c.setImg(rs.getString("img"));
                Level cl = new Level();
                cl.setLevelId(rs.getInt("levelId"));
                cl.setName(rs.getString("levelname"));
                c.setLevel(cl);
                CourseCategory courseCategory = new CourseCategory();
                courseCategory.setCourseCategoryId(rs.getInt("courseCategoryId"));
                courseCategory.setName(rs.getString("coursecategoyname"));
                c.setCategory(courseCategory);
                course.add(c);
                Duration durationC = new Duration();
                durationC.setDurationId(rs.getInt("durationId"));
                durationC.setName(rs.getString("durationname"));
                c.setDuration(durationC);

                Language language1 = new Language();
                language1.setLanguageId(rs.getInt("languageId"));
                language1.setName(rs.getString("languagename"));
                c.setLanguage(language1);

                User author = new User();
                author.setName(rs.getString("username"));
                c.setAuthor(author);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CourseDAO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } finally {
            DBContext.close(connection);
        }
        return course;
    }

    @Override
    public int getTotalRecordByAuthor(String searchInfor, int level, int category, int duration, int language, int userId) {
        Connection connection = DBContext.getConnection();
        String sql = "SELECT COUNT(*) AS numOfRecord\n"
                + "   FROM course c\n"
                + "    JOIN coursecategory cc ON c.courseCategoryId = cc.courseCategoryId\n"
                + "    JOIN `level` l ON c.levelId = l.levelId\n"
                + "    JOIN duration d  ON c.durationId = d.durationId\n"
                + "    JOIN `user` u ON c.authorId = u.userId\n"
                + "    JOIN `language` lan ON c.languageId = lan.languageId\n"
                + "    WHERE (c.name LIKE ? OR u.name LIKE ?) ";
        if (level != 0) {
            sql += "AND c.levelId = ? ";
        }
        if (category != 0) {
            sql += "AND c.courseCategoryId = ? ";
        }
        if (duration != 0) {
            sql += "AND c.durationId = ? ";
        }
        if (language != 0) {
            sql += "AND c.languageId = ? ";
        }
        sql += "AND c.authorId = ? ";
        try {
            int paramIndex = 1;
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(paramIndex++, "%" + searchInfor + "%");
            stm.setString(paramIndex++, "%" + searchInfor + "%");
            if (level != 0) {
                stm.setInt(paramIndex++, level);
            }
            if (category != 0) {
                stm.setInt(paramIndex++, category);
            }
            if (duration != 0) {
                stm.setInt(paramIndex++, duration);
            }
            if (language != 0) {
                stm.setInt(paramIndex++, language);
            }
            stm.setInt(paramIndex, userId);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                return rs.getInt("numOfRecord");
            }
        } catch (SQLException ex) {
            Logger.getLogger(CourseDAO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } finally {
            DBContext.close(connection);
        }
        return 0;
    }
    public static void main(String[] args) {
        System.out.println(new CourseDAO().getCourseByAuthor(1, "", 0, 0, 0, 0, 18).size());
    }
}
