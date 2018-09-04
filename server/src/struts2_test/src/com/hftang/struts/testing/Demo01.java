package com.hftang.struts.testing;

import org.junit.Test;

public class Demo01 {


    @Test
    public void test01() {

        UserDao dao = new UserDaoImpl();
        UserDao userDao = new ProxyUserDao(dao).createUserDaoProxy();
        userDao.save();

    }
}
