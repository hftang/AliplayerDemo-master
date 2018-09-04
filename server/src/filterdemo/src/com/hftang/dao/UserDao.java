package com.hftang.dao;

import com.hftang.bean.User;

import java.sql.SQLException;

public interface UserDao {

    User login(User user) throws SQLException;
}
