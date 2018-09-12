package com.hftang.crm.service.impl;

import com.hftang.crm.dao.SaleVisitDao;
import com.hftang.crm.domain.PageBean;
import com.hftang.crm.domain.SaveVisit;
import com.hftang.crm.service.SaleVisitService;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Transactional
public class SaleVisitServiceImpl implements SaleVisitService {

    @Resource(name = "saleVisitDao")
    private SaleVisitDao saleVisitDao;

    @Override
    public PageBean<SaveVisit> findByPage(DetachedCriteria detachedCriteria, Integer currPage, Integer pageSize) {

        PageBean<SaveVisit> pageBean = new PageBean<>();

        //设置pagebean 所需要的内容

        pageBean.setPageSize(pageSize);
        pageBean.setCurrentPage(currPage);

        Integer totalCount = saleVisitDao.findCount(detachedCriteria);
        pageBean.setTotalCount(totalCount);

        //设置总页数
        double tc = totalCount;
        Double num = Math.ceil(tc / pageSize);
        pageBean.setTotalPage(num.intValue());

        //每页显示的数据集合

        Integer begin = (currPage - 1) * pageSize;
        List<SaveVisit> list = saleVisitDao.findByPage(detachedCriteria, begin, pageSize);
        pageBean.setList(list);


        return pageBean;

    }

    @Override
    public void save(SaveVisit saleVisit) {
        saleVisitDao.save(saleVisit);
    }
}
