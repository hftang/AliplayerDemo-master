package com.hftang.crm.web.interceptor;

import com.hftang.crm.domain.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import org.apache.struts2.ServletActionContext;

/**
 * 配置拦截器
 *
 * 然后在 struts中进行配置
 */
public class PrivilegeInterceptor extends MethodFilterInterceptor {
    @Override
    protected String doIntercept(ActionInvocation actionInvocation) throws Exception {
        //判断session中是否有用户登录的信息
        User existUser = (User) ServletActionContext.getRequest().getSession().getAttribute("existUser");
        if (existUser == null) {
            //没有登录 存一个错误信息 跳转到登录页
            ActionSupport actionSupport = (ActionSupport) actionInvocation.getAction();
            actionSupport.addActionError("你还没有登录，请先登录。");
            return "login";
        } else {
            //已经登录过了
            return actionInvocation.invoke();
        }

    }
}
