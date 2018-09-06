package com.hftang.crm.service;

import com.hftang.crm.domain.User;

public interface UserService {
    void save(User user);

    User login(User user);
}
