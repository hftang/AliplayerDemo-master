package com.hftang.test;

import com.hftang.utils.HibernateUtils;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class TestUtils {

    @Test
    public void run01() {

        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        User user = new User();

        user.setPwd("123");
        user.setName("hftang");

        session.save(user);

        transaction.commit();

        session.close();
        sessionFactory.close();


    }


    @Test
    public void run02() {
        Session session = HibernateUtils.openSession();
        Transaction transaction = session.beginTransaction();
        User user = new User();
        user.setName("hftang666");
        user.setPwd("9999999");
        session.save(user);

        transaction.commit();
        session.close();


    }

    @Test
    public void run03() {
        Session session = HibernateUtils.openSession();
        Transaction transaction = session.beginTransaction();
        //先查询
//        User user = session.get(User.class, 1);
        User user = session.load(User.class, 2);
        System.out.print(user);
        transaction.commit();
        session.close();
    }

    @Test
    public void run04() {
        Session session = HibernateUtils.openSession();
        Transaction transaction = session.beginTransaction();
        User user = session.get(User.class, 1);
        user.setPwd("新改的密码！");
        session.update(user);
        transaction.commit();
        session.close();
    }

    @Test
    public void run05() {
        Session session = HibernateUtils.openSession();
        Transaction transaction = session.beginTransaction();
        User user = session.get(User.class, 1);
        session.delete(user);
        transaction.commit();
        session.close();
    }

    //saveOrUpdate

    @Test
    public void run06() {
        Session session = HibernateUtils.openSession();
        Transaction transaction = session.beginTransaction();
        User user = new User();
        user.setId(2);
        user.setName("saveOrUpdate***");
        user.setPwd("--->");
        session.saveOrUpdate(user);

        transaction.commit();

    }

    //query 查询

    @Test
    public void run07() {
        Session session = HibernateUtils.openSession();
        Transaction transaction = session.beginTransaction();
        //创建 query HQL hibernation Query Langer
        Query query = session.createQuery("from User");
        List<User> list = query.list();
        for (User item : list) {
            System.out.print(item);
        }


        transaction.commit();


    }

    // createSQLQuery

    @Test
    public void run08() {
        Session session = HibernateUtils.openSession();
        Transaction transaction = session.beginTransaction();

        SQLQuery sqlQuery = session.createSQLQuery("select * from tab_user");
        List<Object[]> list = sqlQuery.list();



        for (Object[]  item : list) {

            System.out.print(Arrays.toString(item) + "\n");

        }

        transaction.commit();
        session.close();


    }


}
