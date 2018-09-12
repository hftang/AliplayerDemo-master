package com.hftang.crm.service;

import com.hftang.crm.domain.User;

import java.util.List;

public interface UserService {
    void save(User user);

    User login(User user);

    List<User> findAll();

}
