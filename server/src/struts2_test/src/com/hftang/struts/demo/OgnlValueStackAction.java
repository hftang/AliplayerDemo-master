package com.hftang.struts.demo;

import com.hftang.struts.bean.Peoper;
import com.hftang.struts.bean.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

public class OgnlValueStackAction extends ActionSupport {

    private Peoper peoper;

    public Peoper getPeoper() {
        return peoper;
    }

    public String handleValueStack() {
        ValueStack valueStack = ActionContext.getContext().getValueStack();
        System.out.println(valueStack);
        peoper = new Peoper("hftang", "30");
        return "result";
    }
}


