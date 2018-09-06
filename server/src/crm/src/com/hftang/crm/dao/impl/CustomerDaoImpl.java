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
}
