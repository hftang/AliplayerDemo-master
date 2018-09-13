package com.hftang.crm.web.action;

import com.hftang.crm.domain.PageBean;
import com.hftang.crm.domain.SaveVisit;
import com.hftang.crm.service.SaleVisitService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.loader.custom.Return;

import javax.annotation.Resource;
import java.util.Date;

public class SaleVisitAction extends ActionSupport implements ModelDriven<SaveVisit> {
    private SaveVisit saleVisit = new SaveVisit();

    //使用注解 注入 service
    @Resource(name = "saleVisitService")
    private SaleVisitService saleVisitService;

    @Override
    public SaveVisit getModel() {

        return saleVisit;
    }

    //分页数
    private Integer currPage = 1;
    private Integer pageSize = 3;

    public void setCurrPage(Integer currPage) {
        if (currPage == null) {
            currPage = 1;
        }
        this.currPage = currPage;
    }

    public void setPageSize(Integer pageSize) {
        if (pageSize == null) {
            pageSize = 3;
        }
        this.pageSize = pageSize;
    }

    /**
     * saleVisit_findAll
     */

    private Date visit_time;
    private Date visit_end_time;

    public Date getVisit_time() {
        return visit_time;
    }

    public Date getVisit_end_time() {
        return visit_end_time;
    }

    public void setVisit_time(Date visit_time) {
        this.visit_time = visit_time;
    }

    public void setVisit_end_time(Date visit_end_time) {
        this.visit_end_time = visit_end_time;
    }

    public String findAll() {
        //创建离线查询条件
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(SaveVisit.class);
        if (saleVisit.getVisit_time() != null) {
            //大于等于
            detachedCriteria.add(Restrictions.ge("visit_time", saleVisit.getVisit_time()));
        }
        if (visit_end_time != null) {
            //小于等于
            detachedCriteria.add(Restrictions.le("visit_time", visit_end_time));
        }
        PageBean<SaveVisit> pageBean = saleVisitService.findByPage(detachedCriteria, currPage, pageSize);
        ActionContext.getContext().getValueStack().push(pageBean);
        return "findAll";
    }

    /**
     *
     */

    public String saveUI() {
        return "saveUI";
    }

    /***
     * 保存客户拜访记录的一个方法
     */

    public String save() {
        saleVisitService.save(saleVisit);
        return "saveSuccess";
    }
}
