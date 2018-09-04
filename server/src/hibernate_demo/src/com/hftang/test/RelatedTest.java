package com.hftang.test;

import com.hftang.bean.Customer;
import com.hftang.bean.LinkMan;
import com.hftang.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

public class RelatedTest {

    @Test
    public void test01() {
        Session session = HibernateUtils.openSession();
        Transaction transaction = session.beginTransaction();

        Customer customer = new Customer();
        customer.setCust_name("customer01");

        Customer customer02 = new Customer();
        customer02.setCust_name("customer02");


        LinkMan linkMan01 = new LinkMan();
        linkMan01.setLkm_name("linkMan01");

        LinkMan linkMan02 = new LinkMan();
        linkMan02.setLkm_name("linkMan02");

        LinkMan linkMan03 = new LinkMan();
        linkMan03.setLkm_name("linkMan03");

        //设置关系
        linkMan01.setCustomer(customer);
        linkMan02.setCustomer(customer02);
        linkMan03.setCustomer(customer02);

        customer.getLinkMENs().add(linkMan01);
        customer.getLinkMENs().add(linkMan03);
        customer02.getLinkMENs().add(linkMan02);


        session.save(customer);
        session.save(customer02);

        session.save(linkMan01);
        session.save(linkMan02);
        session.save(linkMan03);


        transaction.commit();
    }

    @Test
    public void test02() {

        Session session = HibernateUtils.openSession();
        Transaction transaction = session.beginTransaction();

        Customer customer = new Customer();
        customer.setCust_name("hftang006");

        LinkMan linkMan = new LinkMan();
        linkMan.setLkm_name("联系人99");


        linkMan.setCustomer(customer);
        customer.getLinkMENs().add(linkMan);

        session.save(customer);


        transaction.commit();


    }

    @Test
    public void test03() {

        Session session = HibernateUtils.openSession();
        Transaction transaction = session.beginTransaction();

        LinkMan linkMan = new LinkMan();
        linkMan.setLkm_name("昵称：：");

        Customer customer = new Customer();
        customer.setCust_name("cccKK");

        linkMan.setCustomer(customer);
        session.save(linkMan);
        transaction.commit();
    }

    //对象的导航

    @Test
    public void test04() {

        Session session = HibernateUtils.openSession();
        Transaction transaction = session.beginTransaction();

        Customer customer = new Customer();
        customer.setCust_name("---消费者---");

        LinkMan linkMan01 = new LinkMan();
        linkMan01.setLkm_name("联系人01");
        LinkMan linkMan02 = new LinkMan();
        linkMan02.setLkm_name("联系人02");
        LinkMan linkMan03 = new LinkMan();
        linkMan03.setLkm_name("联系人03");

        linkMan03.setCustomer(customer);
        customer.getLinkMENs().add(linkMan01);
        customer.getLinkMENs().add(linkMan02);


        session.save(linkMan03);


        transaction.commit();
    }

    //级联删除
    public void test05(){
        Session session = HibernateUtils.openSession();
        Transaction transaction = session.beginTransaction();

        Customer customer = session.get(Customer.class, 1L);

        session.delete(customer);




        transaction.commit();

    }
}
