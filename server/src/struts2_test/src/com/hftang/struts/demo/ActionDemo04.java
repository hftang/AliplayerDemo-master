package com.hftang.struts.demo;

import com.hftang.struts.bean.User;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ActionDemo04 extends ActionSupport implements ModelDriven<User> {

    User user = new User();

    @Override
    public User getModel() {

        return user;
    }

    public String getMode() {


        System.out.print("--" + user);

        return NONE;
    }


}
