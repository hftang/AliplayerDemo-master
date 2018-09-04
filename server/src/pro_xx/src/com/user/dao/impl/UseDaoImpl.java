package com.user.dao.impl;

import com.user.dao.UserDao;
import com.utils.JDBCUtil;

import java.sql.*;

public class UseDaoImpl implements UserDao {


    @Override
    public boolean Login(String name, String pwd) {
        PreparedStatement prepareStatement = null;
        Connection conn;
        ResultSet resultSet = null;
        conn = JDBCUtil.getConn();
        String sql = "SELECT * from user WHERE  name=? AND pwd=?";
        try {
            prepareStatement = conn.prepareStatement(sql);
            prepareStatement.setString(1, name);
            prepareStatement.setString(2, pwd);
            resultSet = prepareStatement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.release(conn,prepareStatement,resultSet);
        }
        return false;
    }
}
