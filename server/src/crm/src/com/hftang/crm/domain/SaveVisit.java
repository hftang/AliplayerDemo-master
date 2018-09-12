package com.hftang.crm.domain;

import java.util.Date;

/**
 * 客户拜访记录
 */
public class SaveVisit {

    private String visit_id;
    private Date visit_time;
    private String visit_addr;
    private String visit_detail;
    private Date visit_nexttime;

    //关联 客户的id
    private Customer customer;
    //用户的对象

    private User user;

    public String getVisit_id() {
        return visit_id;
    }

    public void setVisit_id(String visit_id) {
        this.visit_id = visit_id;
    }

    public Date getVisit_time() {
        return visit_time;
    }

    public void setVisit_time(Date visit_time) {
        this.visit_time = visit_time;
    }

    public String getVisit_addr() {
        return visit_addr;
    }

    public void setVisit_addr(String visit_addr) {
        this.visit_addr = visit_addr;
    }

    public String getVisit_detail() {
        return visit_detail;
    }

    public void setVisit_detail(String visit_detail) {
        this.visit_detail = visit_detail;
    }

    public Date getVisit_nexttime() {
        return visit_nexttime;
    }

    public void setVisit_nexttime(Date visit_nexttime) {
        this.visit_nexttime = visit_nexttime;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "SaveVisit{" +
                "visit_id='" + visit_id + '\'' +
                ", visit_time=" + visit_time +
                ", visit_addr='" + visit_addr + '\'' +
                ", visit_detail='" + visit_detail + '\'' +
                ", visit_nexttime=" + visit_nexttime +
                ", customer=" + customer +
                ", user=" + user +
                '}';
    }
}
