package com.hftang.crm.dao.impl;

import com.hftang.crm.dao.UserDao;
import com.hftang.crm.domain.User;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

public class UserDaoImpl extends HibernateDaoSupport implements UserDao {


    @Override
    public void save(User user) {

        this.getHibernateTemplate().save(user);
    }
}
