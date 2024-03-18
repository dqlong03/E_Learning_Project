/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.swp391_onlinelearning.dal;

import com.fpt.swp391_onlinelearning.dal.idal.IDAO;
import com.fpt.swp391_onlinelearning.dal.idal.IUserDAO;
import com.fpt.swp391_onlinelearning.model.Account;
import com.fpt.swp391_onlinelearning.model.Role;
import com.fpt.swp391_onlinelearning.model.User;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tran Hoang Phuc
 */
public class UserDAO extends DBContext implements IUserDAO, IDAO<User> {

    private static final String DEFAULT_IMG = "data:image/jpeg;base64,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";


    @Override
    public User getUserByAccountId(int accId) {
        Connection connection = DBContext.getConnection();
        String sql = "SELECT `userId`, `name`, `gender`, `dob`, `phone`, `img`, "
                + "`address`, `postCode`, `accId`, `balance` "
                + "FROM `swp391_onlinelearning`.`user`"
                + "WHERE `accId` = ?";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, accId);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                User user = new User();
                user.setUserId(rs.getInt("userId"));
                user.setName(rs.getString("name"));
                user.setGender(rs.getBoolean("gender"));
                user.setDob(rs.getDate("dob"));
                user.setPhone(rs.getString("phone"));
                user.setImg(rs.getString("img"));
                user.setAddress(rs.getString("address"));
                user.setPostCode(rs.getString("postCode"));
             
                Account account = new Account();
                account.setAccId(accId);
                user.setAccount(account);
                user.setBalance(rs.getLong("balance"));
                return user;

            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBContext.close(connection);
        }
        return null;
    }
    
    @Override
    public List<User> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public User get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean update(User t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean insert(User user) {
        Connection connection = DBContext.getConnection();
        String sql = "INSERT INTO `swp391_onlinelearning`.`user` "
                + "(`name`, `gender`, `dob`, `phone`, `accId`, `img`) "
                + " VALUES (?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, user.getName());
            stm.setBoolean(2, user.isGender());
            stm.setDate(3, user.getDob());
            stm.setString(4, user.getPhone());
            stm.setInt(5, user.getAccount().getAccId());
            stm.setString(6, DEFAULT_IMG);
            stm.executeUpdate();
            return true;
        } catch (SQLException ex) {
            return false;
        } finally {
            DBContext.close(connection);
        }
    }

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void updateBalance(User u) {
        Connection connection = DBContext.getConnection();
        String sql = "UPDATE `swp391_onlinelearning`.`user` SET `balance`= ? WHERE  `userId`=?;";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setLong(1, u.getBalance());
            stm.setInt(2, u.getUserId());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBContext.close(connection);
        }

    }

    @Override
    public void updateUser(User model) {
        Connection connection= DBContext.getConnection();
        try {
            String sql = "UPDATE `user` AS u \n"
                    + "   SET u.name=?, u.gender=?,u.dob=?,u.phone=?,u.img=?,u.address=?,u.postCode=?\n" 
                    + "   WHERE u.accId=?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, model.getName());
            stm.setBoolean(2, model.isGender());
            stm.setDate(3, model.getDob());
            stm.setString(4, model.getPhone());
            stm.setString(5, model.getImg());
            stm.setString(6, model.getAddress());
            stm.setString(7, model.getPostCode());
            stm.setInt(8, model.getAccount().getAccId());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            DBContext.close(connection);
        }
    }

    @Override
    public List<User> getUserRegistrationInfo(int pageSize, int pageIndex, Date startDate, Date endDate) {
        Connection connection = DBContext.getConnection();
        try {
            List<User> userList = new ArrayList<User>();

            String sql = "SELECT accId, email,createdTime, registeredTime, name\n"
                    + "FROM (SELECT ROW_NUMBER() OVER (ORDER BY a.registeredTime desc) AS rownum, a.accId,a.email,a.createdTime,a.registeredTime,u.name\n"
                    + "FROM account a JOIN `user` AS u\n"
                    + "On a.accId=u.accId\n"
                    + "WHERE a.registeredTime BETWEEN ? AND ?) AS t\n"
                    + "WHERE rownum >= (? -1)*? + 1 AND rownum<= ? * ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setDate(1, startDate);
            stm.setDate(2, endDate);
            stm.setInt(3, pageIndex);
            stm.setInt(4, pageSize);
            stm.setInt(5, pageIndex);
            stm.setInt(6, pageSize);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                User u = new User();

                Account a = new Account();
                a.setAccId(rs.getInt("accId"));
                a.setEmail(rs.getString("email"));
                a.setCreatedTime(rs.getTime("createdTime"));
                a.setRegisteredTime(rs.getDate("registeredTime"));

                u.setAccount(a);
                u.setName(rs.getString("name"));

                userList.add(u);
            }
            return userList;
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBContext.close(connection);
        }
        return null;
    }

    @Override
    public int userCount(Date startDate, Date endDate) {
        Connection connection = DBContext.getConnection();
        try {
            String sql = "SELECT COUNT(*) as total FROM\n"
                    + "(SELECT a.accId,a.email,a.createdTime,a.registeredTime,u.name\n"
                    + "FROM account a JOIN `user` AS u\n"
                    + "On a.accId=u.accId\n"
                    + "WHERE a.registeredTime BETWEEN ? AND ?) AS t";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setDate(1, startDate);
            stm.setDate(2, endDate);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                return rs.getInt("total");
            }
            return 0;
        } catch (SQLException ex) {
            return 0;
        } finally {
            DBContext.close(connection);
        }

    }

    @Override
    public int userCount(Date date) {
        Connection connection = DBContext.getConnection();
        try {
            String sql = "SELECT COUNT(*) as total FROM\n"
                    + "(SELECT a.accId,a.email,a.createdTime,a.registeredTime,u.name\n"
                    + "FROM account a JOIN `user` AS u\n"
                    + "On a.accId=u.accId\n"
                    + "WHERE a.registeredTime =?) AS t";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setDate(1, date);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                return rs.getInt("total");
            }
            return 0;
        } catch (SQLException ex) {
            return 0;
        } finally {
            DBContext.close(connection);
        }
    }

    @Override
    public List<User> getUserRegistrationInfo(Date startDate, Date endDate) {
        Connection connection = DBContext.getConnection();
        try {
            List<User> userList = new ArrayList<User>();

            String sql = "SELECT a.accId,a.email,a.createdTime,a.registeredTime,u.name\n"
                    + "FROM account a JOIN `user` AS u\n"
                    + "On a.accId=u.accId\n"
                    + "WHERE a.registeredTime BETWEEN ? AND ?\n"
                    + "ORDER BY a.registeredTime desc";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setDate(1, startDate);
            stm.setDate(2, endDate);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                User u = new User();

                Account a = new Account();
                a.setAccId(rs.getInt("accId"));
                a.setEmail(rs.getString("email"));
                a.setCreatedTime(rs.getTime("createdTime"));
                a.setRegisteredTime(rs.getDate("registeredTime"));

                u.setAccount(a);
                u.setName(rs.getString("name"));

                userList.add(u);
            }
            return userList;
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBContext.close(connection);
        }
        return null;
    }
    @Override
    public List<User> getAllUser(int pageindex, int pagesize, String info, int roleid, int status) {
        Connection connection = DBContext.getConnection();
        List<User> users = new ArrayList<>();
        try {
            int paramIndex = 0;
            StringBuilder bonus = new StringBuilder();
            List<Object> paramValues = new ArrayList<>();

            if (info != null ) {
                bonus.append(" AND (a.email LIKE ? or u.name like ? )");
                paramValues.add("%" + info + "%");
                paramValues.add("%" + info + "%");
            }

            if (roleid != 0) {
                bonus.append(" AND ro.roleId = ?");
                paramValues.add(roleid);
            }
            if (status != 3) {
                bonus.append(" AND a.isActivated = ?");
                paramValues.add(status);
            }

            String sql = "select accId, email, username, dob, gender, phone, roleId, rolename, status,img \n"
                    + "from (\n"
                    + "    select row_number() over (order by accId asc) as rownum, a.accId, a.email, u.name AS username, u.dob, u.gender, u.phone, u.img, u.address, u.balance, ro.roleId, ro.name AS rolename, a.createdTime, a.isActivated AS status\n"
                    + "    from account AS a \n"
                    + "    join `user` AS u on u.accId = a.accId  \n"
                    + "    JOIN role AS ro on a.roleId = ro.roleId\n"
                    + "    WHERE 1=1 " + bonus.toString() + "\n"
                    + ") t\n"
                    + "where rownum >= (? - 1) * ? + 1 \n"
                    + "and rownum <= ? * ?";

            PreparedStatement stm = connection.prepareStatement(sql);
            for (Object paramValue : paramValues) {
                paramIndex++;
                if (paramValue instanceof Integer) {
                    stm.setInt(paramIndex, (Integer) paramValue);
                } else if (paramValue instanceof String) {
                    stm.setString(paramIndex, (String) paramValue);
                } else if (paramValue instanceof Boolean) {
                    stm.setBoolean(paramIndex, (Boolean) paramValue);
                }
            }
            stm.setInt(paramIndex + 1, pageindex);
            stm.setInt(paramIndex + 2, pagesize);
            stm.setInt(paramIndex + 3, pageindex);
            stm.setInt(paramIndex + 4, pagesize);

            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                User user = new User();

                user.setName(rs.getString("username"));
                user.setGender(rs.getBoolean("gender"));
                user.setDob(rs.getDate("dob"));
                user.setPhone(rs.getString("phone"));

                Role role = new Role();
                role.setRoleId(rs.getInt("roleId"));
                role.setName(rs.getString("rolename"));

                Account account = new Account();
                account.setAccId(rs.getInt("accId"));
                account.setEmail(rs.getString("email"));
                account.setIsActivated(rs.getInt("status"));
                account.setRole(role);

                user.setAccount(account);

                users.add(user);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBContext.close(connection);
        }
        return users;
    }
    public static void main(String[] args) {
        System.out.println(new UserDAO().getAllUser(1, 2, "tien", 0, 3).size());
    }
    @Override
    public User getUserById(int accountId) {
        Connection connection = DBContext.getConnection();
        String sql = "SELECT u.userId,a.email,u.name,u.dob,u.gender,u.phone,u.img,u.address,u.balance,ro.roleId,ro.name ,a.createdTime,a.isActivated\n"
                + "FROM `user` AS u \n"
                + "JOIN account AS a ON u.accId = a.accId \n"
                + "JOIN role AS ro  ON a.roleId = ro.roleId\n"
                + "\n"
                + "WHERE a.accId=?";
        User user = new User();
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, accountId);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {

                user.setUserId(rs.getInt("u.userId"));
                user.setName(rs.getString("u.name"));
                user.setGender(rs.getBoolean("u.gender"));
                user.setDob(rs.getDate("u.dob"));
                user.setPhone(rs.getString("u.phone"));
                user.setImg(rs.getString("u.img"));
                user.setAddress(rs.getString("u.address"));

                Role role = new Role();
                role.setRoleId(rs.getInt("ro.roleId"));
                role.setName(rs.getString("ro.name"));

                Account account = new Account();
                account.setAccId(accountId);
                account.setEmail(rs.getString("a.email"));
                account.setIsActivated(rs.getInt("a.isActivated"));
                account.setCreatedTime(rs.getDate("a.createdTime"));
                account.setRole(role);

                user.setAccount(account);
                user.setBalance(rs.getLong("balance"));

            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBContext.close(connection);
        }
        return user;
    }

    @Override
    public User getUserByPhone(String phone) {
        Connection connection = DBContext.getConnection();
        String sql = "SELECT userId FROM `user` WHERE phone = ?";
        User user = new User();
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, phone);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {

                user.setUserId(rs.getInt("userId"));

            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBContext.close(connection);
        }
        return user;
    }

    @Override
    public int getCount(String info, int roleid, int status) {
        Connection connection = DBContext.getConnection();

        int paramIndex = 0;
        StringBuilder bonus = new StringBuilder();
        List<Object> paramValues = new ArrayList<>();

        if (info != null && !"".equals(info)) {
            bonus.append(" AND a.email LIKE ? AND u.name LIKE ?");
            paramValues.add("%" + info + "%");
            paramValues.add("%" + info + "%");
        }
        if (roleid != 0) {
            bonus.append(" AND ro.roleId= ?");
            paramValues.add(roleid);
        }
        if (status != 3) {
            bonus.append(" AND a.isActivated =?");
            paramValues.add(status);
        }

        String sql = "SELECT COUNT(*) AS total_rows\n"
                + "FROM (\n"
                + "    SELECT a.accId\n"
                + "    FROM account AS a \n"
                + "    JOIN `user` AS u ON u.accId = a.accId  \n"
                + "    JOIN role AS ro ON a.roleId = ro.roleId\n"
                + "    WHERE 1=1 " + bonus.toString() + "\n"
                + ") t;";
        try {
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
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBContext.close(connection);
        }
        return -1;
    }

    @Override
    public void blockAccountByRoleId(int roleid) {
        Connection connection = DBContext.getConnection();
        try {
            String sql = "UPDATE account AS a SET a.isActivated = 2  WHERE a.roleId =? ;";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, roleid);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBContext.close(connection);
        }
    }

    @Override
    public void blockRoleByRoleId(int roleid) {
        Connection connection = DBContext.getConnection();
        try {
            String sql = "UPDATE role AS r SET r.isActived =0 WHERE r.roleId =?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, roleid);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBContext.close(connection);
        }
    }
}
