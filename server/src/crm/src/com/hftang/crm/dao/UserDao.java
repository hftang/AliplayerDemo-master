package com.hftang.crm.dao;

import com.hftang.crm.domain.User;

public interface UserDao {
    void save(User user);

    User login(User user);
}
