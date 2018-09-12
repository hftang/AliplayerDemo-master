package com.hftang.crm.dao.impl;

import com.hftang.crm.dao.UserDao;
import com.hftang.crm.domain.User;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

public class UserDaoImpl extends HibernateDaoSupport implements UserDao {


    @Override
    public void save(User user) {

        this.getHibernateTemplate().save(user);
    }

    @Override
    public User login(User user) {


        List<User> list = (List<User>) getHibernateTemplate().find("from User where user_code = ? and user_password = ?", user.getUser_code(), user.getUser_password());

        if (list != null && list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    @Override
    public List<User> findAll() {
        List<User> list = (List<User>) getHibernateTemplate().find("from  User");
        return list;
    }
}
