package com.hftang.struts.demo;

import com.hftang.struts.bean.User;
import com.opensymphony.xwork2.ActionSupport;

public class ActionDemo02 extends ActionSupport {

    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String handlerDatas() {

        System.out.print(user);

        return NONE;
    }

}
