package com.hftang.struts.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class MyInterceptor01 extends AbstractInterceptor {
    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        System.out.println("MyInterceptor01----->执行");
        String invoke = actionInvocation.invoke();
        System.out.println("MyInterceptor01----->执行_结束");

        return invoke;
    }
}
