/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.swp391_onlinelearning.dal;

import com.fpt.swp391_onlinelearning.dal.idal.IDAO;
import com.fpt.swp391_onlinelearning.dal.idal.ISettingListDAO;
import com.fpt.swp391_onlinelearning.model.Duration;
import com.fpt.swp391_onlinelearning.model.Setting;
import com.fpt.swp391_onlinelearning.model.SettingType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class SettingListDAO implements IDAO<Setting>, ISettingListDAO {

    @Override
    public Setting get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean update(Setting t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean insert(Setting t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Setting> getAll(int pageindex, int pagesize, String info, int typeid, int status) {
        Connection connection = DBContext.getConnection();
        ArrayList<Setting> level = new ArrayList<>();
        try {
            int paramIndex = 0;
            StringBuilder bonus = new StringBuilder();
            List<Object> paramValues = new ArrayList<>();

            if (typeid != 0) {
                bonus.append(" AND typeid = ?");
                paramValues.add(typeid);
            }
            if (info != null && !"".equals(info)) {
                bonus.append(" AND name LIKE ?");
                paramValues.add("%" + info + "%");
            }
            if (status != 3) {
                bonus.append(" AND status = ?");
                paramValues.add(status);
            }

            String sql = "  SELECT rownum,name, typeid,typename, `order`, `status`\n"
                    + "from (\n"
                    + "    select row_number() over (order by typeid asc) as rownum, name, typeid,typename, `order`, `status`\n"
                    + "FROM (\n"
                    + "    SELECT d.name AS name,st.typeid AS typeid ,st.name AS typename, d.durationId AS `order`, d.isActivated AS `status`\n"
                    + "    FROM duration AS d\n"
                    + "    JOIN settingtype AS st ON d.typeid = st.typeid\n"
                    + "\n"
                    + "    UNION ALL\n"
                    + "\n"
                    + "    SELECT l.name AS name, st.typeid AS typeid ,st.name AS typename, l.languageId AS `order`, l.isActivated AS `status`\n"
                    + "    FROM language AS l\n"
                    + "    JOIN settingtype AS st ON l.typeid = st.typeid\n"
                    + "\n"
                    + "    UNION ALL\n"
                    + "\n"
                    + "    SELECT le.name AS name,st.typeid AS typeid ,st.name AS typename, le.levelId AS `order`, le.isActivated AS `status`\n"
                    + "    FROM `level` AS le\n"
                    + "    JOIN settingtype AS st ON le.typeid = st.typeid\n"
                    + "\n"
                    + "    UNION ALL\n"
                    + "\n"
                    + "      SELECT ro.name AS name,st.typeid AS typeid ,st.name AS typename, ro.roleId AS `order`, ro.isActivated AS `status`\n"
                    + "    FROM `role` AS ro\n"
                    + "    JOIN settingtype AS st ON ro.typeid = st.typeid\n"
                    + "    \n"
                    + "    UNION ALL\n"
                    + "\n"
                    + "      SELECT pc.name AS name,st.typeid AS typeid ,st.name AS typename, pc.postCategoryId AS `order`, pc.isActivated AS `status`\n"
                    + "    FROM `postcategory` AS pc\n"
                    + "    JOIN settingtype AS st ON pc.typeid = st.typeid\n"
                    + "    \n"
                    + "    UNION ALL\n"
                    + "\n"
                    + "      SELECT cc.name AS name,st.typeid AS typeid ,st.name AS typename, cc.courseCategoryId AS `order`, cc.isActivated AS `status`\n"
                    + "    FROM `coursecategory` AS cc\n"
                    + "    JOIN settingtype AS st ON cc.typeid = st.typeid\n"
                    + "    \n"
                    + "    UNION ALL\n"
                    + "\n"
                    + "      SELECT bc.name AS name,st.typeid AS typeid ,st.name AS typename, bc.blogCategoryId AS `order`, bc.isActivated AS `status`\n"
                    + "    FROM `blogcategory` AS bc\n"
                    + "    JOIN settingtype AS st ON bc.typeid = st.typeid\n"
                    + "    \n"
                    + ") AS combined_data WHERE 1=1 " + bonus + " \n"
                    + ") t\n"
                    + "where rownum >= (? - 1) * ? + 1 \n"
                    + "and rownum <= ? * ?; ";
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
                Setting l = new Setting();
                l.setName(rs.getString("name"));
                SettingType st = new SettingType();
                st.setName(rs.getString("typename"));
                st.setTypeid(rs.getInt("typeid"));
                l.setType(st);
                l.setOrder(rs.getInt("order"));
                l.setStatus(rs.getBoolean("status"));
                level.add(l);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CourseDAO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } finally {
            DBContext.close(connection);
        }
        return level;
    }

    @Override
    public List<Setting> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<SettingType> getAllType() {
        Connection connection = DBContext.getConnection();
        ArrayList<SettingType> level = new ArrayList<>();
        try {
            String sql = "SELECT typeid ,NAME FROM settingtype";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                SettingType l = new SettingType();
                l.setTypeid(rs.getInt("typeid"));
                l.setName(rs.getString("name"));
                level.add(l);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CourseDAO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } finally {
            DBContext.close(connection);
        }
        return level;
    }

    @Override
    public int getCount(String info, int typeid, int status) {
        Connection connection = DBContext.getConnection();
        try {
            int paramIndex = 0;
            StringBuilder bonus = new StringBuilder();
            List<Object> paramValues = new ArrayList<>();

            if (typeid != 0) {
                bonus.append(" AND typeid = ?");
                paramValues.add(typeid);
            }
            if (info != null && !"".equals(info)) {
                bonus.append(" AND name LIKE ?");
                paramValues.add("%" + info + "%");
            }
            if (status != 3) {
                bonus.append(" AND status = ?");
                paramValues.add(status);
            }

            String sql = "  SELECT COUNT(*) AS total_rows\n"
                    + "from (\n"
                    + "    select row_number() over (order by typeid asc) as rownum, name, typeid,typename, `order`, `status`\n"
                    + "FROM (\n"
                    + "    SELECT d.name AS name,st.typeid AS typeid ,st.name AS typename, d.durationId AS `order`, d.isActivated AS `status`\n"
                    + "    FROM duration AS d\n"
                    + "    JOIN settingtype AS st ON d.typeid = st.typeid\n"
                    + "\n"
                    + "    UNION ALL\n"
                    + "\n"
                    + "    SELECT l.name AS name, st.typeid AS typeid ,st.name AS typename, l.languageId AS `order`, l.isActivated AS `status`\n"
                    + "    FROM language AS l\n"
                    + "    JOIN settingtype AS st ON l.typeid = st.typeid\n"
                    + "\n"
                    + "    UNION ALL\n"
                    + "\n"
                    + "    SELECT le.name AS name,st.typeid AS typeid ,st.name AS typename, le.levelId AS `order`, le.isActivated AS `status`\n"
                    + "    FROM `level` AS le\n"
                    + "    JOIN settingtype AS st ON le.typeid = st.typeid\n"
                    + "\n"
                    + "    UNION ALL\n"
                    + "\n"
                    + "      SELECT ro.name AS name,st.typeid AS typeid ,st.name AS typename, ro.roleId AS `order`, ro.isActivated AS `status`\n"
                    + "    FROM `role` AS ro\n"
                    + "    JOIN settingtype AS st ON ro.typeid = st.typeid\n"
                    + "    \n"
                    + "    UNION ALL\n"
                    + "\n"
                    + "      SELECT pc.name AS name,st.typeid AS typeid ,st.name AS typename, pc.postCategoryId AS `order`, pc.isActivated AS `status`\n"
                    + "    FROM `postcategory` AS pc\n"
                    + "    JOIN settingtype AS st ON pc.typeid = st.typeid\n"
                    + "    \n"
                    + "    UNION ALL\n"
                    + "\n"
                    + "      SELECT cc.name AS name,st.typeid AS typeid ,st.name AS typename, cc.courseCategoryId AS `order`, cc.isActivated AS `status`\n"
                    + "    FROM `coursecategory` AS cc\n"
                    + "    JOIN settingtype AS st ON cc.typeid = st.typeid\n"
                    + "    \n"
                    + "    UNION ALL\n"
                    + "\n"
                    + "      SELECT bc.name AS name,st.typeid AS typeid ,st.name AS typename, bc.blogCategoryId AS `order`, bc.isActivated AS `status`\n"
                    + "    FROM `blogcategory` AS bc\n"
                    + "    JOIN settingtype AS st ON bc.typeid = st.typeid\n"
                    + "    \n"
                    + ") AS combined_data  WHERE 1=1 " + bonus + " \n"
                    + ") t";
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
                return rs.getInt("total_rows");
            }
        } catch (SQLException ex) {
            Logger.getLogger(CourseDAO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } finally {
            DBContext.close(connection);
        }
        return -1;
    }

    @Override
    public void update(int typeid, int id, String name, int status) {
        Connection connection = DBContext.getConnection();
        String sql = null;
        try {
            if (typeid == 1) {
                sql = "UPDATE duration AS d\n"
                        + "	SET d.name=?,d.isActivated=?\n"
                        + "	WHERE d.typeid=? AND d.durationId=?";
            }
            if (typeid == 2) {
                sql = "UPDATE `language` AS lan\n"
                        + "	SET lan.name=?,lan.isActivated=?\n"
                        + "	WHERE lan.typeid=? AND lan.languageId=?";
            }
            if (typeid == 3) {
                sql = "	UPDATE `level` AS le\n"
                        + "	SET le.name=?,le.isActivated=?\n"
                        + "	WHERE le.typeid=? AND le.levelId=?";
            }
            if (typeid == 4) {
                sql = "		UPDATE role AS ro\n"
                        + "	SET ro.name=?,ro.isActivated=?\n"
                        + "	WHERE ro.typeid=? AND ro.roleId=?";
            }
            if (typeid == 5) {
                sql = "		UPDATE postcategory AS pc\n"
                        + "	SET pc.name=?,pc.isActivated=?\n"
                        + "	WHERE pc.typeid=? AND pc.postCategoryId=?";
            }
            if (typeid == 6) {
                sql = "		UPDATE coursecategory AS cc\n"
                        + "	SET cc.name=?,cc.isActivated=?\n"
                        + "	WHERE cc.typeid=? AND cc.courseCategoryId=?";
            }
            if (typeid == 7) {
                sql = "		UPDATE blogcategory AS bc\n"
                        + "	SET bc.name=?,bc.isActivated=?\n"
                        + "	WHERE bc.typeid=? AND bc.blogCategoryId=?";
            }
            PreparedStatement stm = connection.prepareStatement(sql);

            stm.setString(1, name);
            stm.setInt(2, status);
            stm.setInt(3, typeid);
            stm.setInt(4, id);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBContext.close(connection);
        }
    }

    @Override
    public void insert(int typeid, String name, int status) {
        Connection connection = DBContext.getConnection();
        String sql = null;
        try {
            if (typeid == 1) {
                sql = "INSERT INTO duration  (name,isActivated)\n"
                        + "VALUES (?, ?);\n";
            }
            if (typeid == 2) {
                sql = "INSERT INTO language  (name,isActivated)\n"
                        + "VALUES (?, ?);\n";
            }
            if (typeid == 3) {
                sql = "	INSERT INTO level  (name,isActivated)\n"
                        + "VALUES (?, ?);\n";
            }
            if (typeid == 4) {
                sql = "	INSERT INTO role  (name,isActivated)\n"
                        + "VALUES (?, ?);\n";
            }
            if (typeid == 5) {
                sql = "	INSERT INTO postcategory  (name,isActivated)\n"
                        + "VALUES (?, ?);\n";
            }
            if (typeid == 6) {
                sql = "	INSERT INTO coursecategory  (name,isActivated)\n"
                        + "VALUES (?, ?);\n";
            }
            if (typeid == 7) {
                sql = "	INSERT INTO postcategory  (name,isActivated)\n"
                        + "VALUES (?, ?);\n";
            }

            PreparedStatement stm = connection.prepareStatement(sql);

            stm.setString(1, name);
            stm.setInt(2, status);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBContext.close(connection);
        }
    }

    

}
