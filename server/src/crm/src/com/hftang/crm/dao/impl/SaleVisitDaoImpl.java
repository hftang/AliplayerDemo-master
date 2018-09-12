package com.hftang.crm.dao.impl;

import com.hftang.crm.dao.SaleVisitDao;
import com.hftang.crm.domain.Customer;
import com.hftang.crm.domain.SaveVisit;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

public class SaleVisitDaoImpl extends HibernateDaoSupport implements SaleVisitDao {


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

    @Override
    public List<SaveVisit> findByPage(DetachedCriteria detachedCriteria, Integer begin, Integer pageSize) {

        detachedCriteria.setProjection(null);
        return (List<SaveVisit>) getHibernateTemplate().findByCriteria(detachedCriteria, begin, pageSize);
    }

    @Override
    public void save(SaveVisit saleVisit) {
        getHibernateTemplate().save(saleVisit);
    }
}
