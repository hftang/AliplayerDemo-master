package com.hftang.crm.dao.impl;

import com.hftang.crm.dao.CustomerDao;
import com.hftang.crm.domain.Customer;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

public class CustomerDaoImpl extends HibernateDaoSupport implements CustomerDao {

    @Override
    public void save(Customer customer) {
        this.getHibernateTemplate().save(customer);


    }

    /**
     * 带条件 统计个数的方法
     *
     * @param detachedCriteria
     * @return
     */
    @Override
    public Integer findCount(DetachedCriteria detachedCriteria) {
        DetachedCriteria detachedCriteria1 = detachedCriteria.setProjection(Projections.rowCount());
        List<Long> list = (List<Long>) getHibernateTemplate().findByCriteria(detachedCriteria1);
        if (list.size() > 0) {
            return list.get(0).intValue();
        }

        return null;
    }

    /**
     * 带条件 分页查询的方法
     *
     * @param detachedCriteria
     * @param begin
     * @param pageSize
     * @return
     */

    @Override
    public List<Customer> findByPage(DetachedCriteria detachedCriteria, Integer begin, Integer pageSize) {

        detachedCriteria.setProjection(null);
        return (List<Customer>) getHibernateTemplate().findByCriteria(detachedCriteria, begin, pageSize);
    }

    @Override
    public Customer findById(Long cust_id) {
//        List<Customer> list = (List<Customer>) this.getHibernateTemplate().find("from Customer where cust_id = ?", cust_id);
//        if(list!=null){
//            return list.get(0);
//        }
        return this.getHibernateTemplate().get(Customer.class, cust_id);
    }

    /**
     * 删除客户
     *
     * @param customer
     */
    @Override
    public void delete(Customer customer) {
        this.getHibernateTemplate().delete(customer);
    }

    /***
     * 修改用户
     * @param customer
     */
    @Override
    public void update(Customer customer) {
        getHibernateTemplate().update(customer);
    }

    @Override
    public List<Customer> findAll() {
        List<Customer> list = (List<Customer>) getHibernateTemplate().find("from Customer");
        return list;
    }
}
