package com.hftang.crm.web.action;

import com.hftang.crm.domain.Customer;
import com.hftang.crm.domain.PageBean;
import com.hftang.crm.service.CustomerService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.hibernate.criterion.DetachedCriteria;

import java.util.List;

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

    /***
     * 使用属性依赖
     * @return
     */

    private Integer currentpage;//当前页数

    public void setCurrentpage(Integer currentpage) {
        if (currentpage == null) {
            currentpage = 1;
        }
        this.currentpage = currentpage;
    }

    private Integer pageSize;//每页的记录数

    public void setPageSize(Integer pageSize) {
        if (pageSize == null) {
            pageSize = 3;
        }
        this.pageSize = pageSize;
    }

    //分页查询 客户的方法
    public String findAll() {

        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Customer.class);

        PageBean<Customer> pageBean = customerService.findByPage(detachedCriteria, currentpage, pageSize);

        //向值栈里放
        ActionContext.getContext().getValueStack().push(pageBean);


        return "findAll";
    }

}
