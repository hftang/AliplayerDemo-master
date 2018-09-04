package com.hftang.struts.testing;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyUserDao implements InvocationHandler {

    private UserDao userDao;

    public ProxyUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public UserDao createUserDaoProxy() {

        UserDao instance = (UserDao) Proxy.newProxyInstance(userDao.getClass().getClassLoader(), userDao.getClass().getInterfaces(), this);


        return instance;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        if ("save".equals(method.getName())) {

            //要加强的方法：
            System.out.println("==========>加强=======》");

            return method.invoke(userDao, args);
        }


        return method.invoke(userDao, args);
    }
}
