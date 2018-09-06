package com.hftang.crm.service.impl;

import com.hftang.crm.dao.CustomerDao;
import com.hftang.crm.service.CustomerService;

public class CustomerServiceImpl implements CustomerService {

    private CustomerDao customerDao;

    public void setCustomerDao(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }


}
