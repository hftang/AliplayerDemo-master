package com.hftang.crm.dao;

import com.hftang.crm.domain.SaveVisit;
import org.hibernate.criterion.DetachedCriteria;

import java.util.List;

public interface SaleVisitDao  {
    Integer findCount(DetachedCriteria detachedCriteria);

    List<SaveVisit> findByPage(DetachedCriteria detachedCriteria, Integer begin, Integer pageSize);

    void save(SaveVisit saleVisit);
}
