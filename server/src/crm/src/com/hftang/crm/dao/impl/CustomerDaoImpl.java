package com.hftang.crm.dao.impl;

import com.hftang.crm.dao.CustomerDao;
import com.hftang.crm.domain.Customer;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

public class CustomerDaoImpl extends HibernateDaoSupport implements CustomerDao {

    @Override
    public void save(Customer customer) {
        this.getHibernateTemplate().save(customer);


    }
}
