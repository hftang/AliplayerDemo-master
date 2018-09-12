package com.hftang.crm.web.action;

import com.alibaba.fastjson.JSON;
import com.hftang.crm.domain.User;
import com.hftang.crm.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;

import java.io.IOException;
import java.util.List;

public class UserAction extends ActionSupport implements ModelDriven<User> {

    private User user = new User();

    @Override
    public User getModel() {


        return user;
    }

    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public String regist() {
        userService.save(user);
        return LOGIN;
    }

    //登录

    public String login() {
        User user_val = userService.login(user);
        if (user_val == null) {
            //登录失败
            addActionError("用户名或者密码错误！");
            return LOGIN;
        } else {
            ActionContext.getContext().getSession().put("existUser", user_val);
            return SUCCESS;
        }


    }

    public String findAllUser() {

        List<User> list = userService.findAll();

        Object toJSON = JSON.toJSON(list);

        ServletActionContext.getResponse().setContentType("text/html;charset=UTF-8");
        try {
            ServletActionContext.getResponse().getWriter().print(toJSON.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }


        return NONE;
    }


}
