package com.hftang.crm.web.action;

import com.hftang.crm.domain.Customer;
import com.hftang.crm.service.CustomerService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class CustomerAction extends ActionSupport implements ModelDriven<Customer> {

    private Customer customer = new Customer();

    //
    private CustomerService customerService;

    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Override
    public Customer getModel() {


        return customer;
    }


    public String saveUI() {


        return "saveUI";
    }

//    保存的方法

    public String save() {

        customerService.save(customer);

        return NONE;
    }

}
