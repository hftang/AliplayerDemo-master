package com.hftang.crm.service.impl;

import com.hftang.crm.dao.CustomerDao;
import com.hftang.crm.domain.Customer;
import com.hftang.crm.domain.PageBean;
import com.hftang.crm.service.CustomerService;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    @Override
    public PageBean<Customer> findByPage(DetachedCriteria detachedCriteria, Integer currentpage, Integer pageSize) {

        PageBean<Customer> pageBean = new PageBean<>();

        //封装当前得页数
        pageBean.setCurrentPage(currentpage);
        //封装每页显示的记录数
        pageBean.setPageSize(pageSize);
        //封装总记录数
        Integer totalCount = customerDao.findCount(detachedCriteria);
        pageBean.setTotalCount(totalCount);

        //封装总页数
        Double tc = totalCount.doubleValue();
        Double num = Math.ceil(tc / pageSize);
        pageBean.setTotalPage(num.intValue());

        //每页显示数据的集合
        Integer begin = (currentpage - 1) * pageSize;
        List<Customer> list = customerDao.findByPage(detachedCriteria, begin, pageSize);
        pageBean.setList(list);


        return pageBean;
    }

    @Override
    public Customer findById(Long cust_id) {

     Customer customer=   customerDao.findById(cust_id);

        return customer;
    }
}
