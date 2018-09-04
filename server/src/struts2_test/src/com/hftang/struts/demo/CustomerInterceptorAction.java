package com.hftang.struts.demo;

import com.opensymphony.xwork2.ActionSupport;

public class CustomerInterceptorAction extends ActionSupport {

    public String doSomeThings() {

        System.out.println("_______ CustomerInterceptorAction 执行！");

        return "successpage";
    }
}
