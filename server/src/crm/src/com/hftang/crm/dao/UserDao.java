package com.hftang.crm.dao;

import com.hftang.crm.domain.User;

import java.util.List;

public interface UserDao {
    void save(User user);

    User login(User user);

    List<User> findAll();
}
