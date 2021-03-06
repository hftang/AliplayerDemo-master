package com.hftang.crm.service;

import com.hftang.crm.domain.Customer;
import com.hftang.crm.domain.PageBean;
import org.hibernate.criterion.DetachedCriteria;

import java.util.List;

public interface CustomerService {
    void save(Customer customer);

    PageBean<Customer> findByPage(DetachedCriteria detachedCriteria, Integer currentpage, Integer pageSize);

    Customer findById(Long cust_id);

    void delete(Customer customer);

    void update(Customer customer);

    List<Customer> findAll();

}
