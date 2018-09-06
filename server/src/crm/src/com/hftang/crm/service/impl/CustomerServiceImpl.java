package com.hftang.crm.service.impl;

import com.hftang.crm.dao.CustomerDao;
import com.hftang.crm.domain.Customer;
import com.hftang.crm.service.CustomerService;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class CustomerServiceImpl implements CustomerService {

    private CustomerDao customerDao;

    public void setCustomerDao(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }


    @Override
    public void save(Customer customer) {
        customerDao.save(customer);
    }
}
