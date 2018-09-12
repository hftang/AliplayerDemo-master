package com.hftang.crm.web.action;

import com.hftang.crm.domain.PageBean;
import com.hftang.crm.domain.SaveVisit;
import com.hftang.crm.service.SaleVisitService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.loader.custom.Return;

import javax.annotation.Resource;

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

    public String findAll() {

        //创建离线查询条件

        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(SaveVisit.class);

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
