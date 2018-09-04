package com.hftang.struts.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class MyInterceptor02 extends AbstractInterceptor {

    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        System.out.println("MyInterceptor02---->开始");
        String invoke = actionInvocation.invoke();
        System.out.println("MyInterceptor02---->结束");


        return invoke;
    }
}
