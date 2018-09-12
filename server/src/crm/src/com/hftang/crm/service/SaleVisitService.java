package com.hftang.crm.service;

import com.hftang.crm.domain.PageBean;
import com.hftang.crm.domain.SaveVisit;
import org.hibernate.criterion.DetachedCriteria;

public interface SaleVisitService {
    PageBean<SaveVisit> findByPage(DetachedCriteria detachedCriteria, Integer currPage, Integer pageSize);

    void save(SaveVisit saleVisit);

}
