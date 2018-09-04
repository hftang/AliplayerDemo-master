package com.hftang.crm.service.impl;

import com.hftang.crm.dao.UserDao;
import com.hftang.crm.domain.User;
import com.hftang.crm.service.UserService;
import com.hftang.crm.utils.MD5Utils;
import org.springframework.transaction.annotation.Transactional;


//添加事务 在 业务上 有

@Transactional
public class UserServiceImpl implements UserService {


    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void save(User user) {

        //对密码进行md5加密
        user.setUser_password(MD5Utils.md5(user.getUser_password()));


        userDao.save(user);
    }
}
