package com.hftang.struts.demo;

import com.hftang.struts.bean.Peoper;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;
import org.apache.struts2.ServletActionContext;

import javax.servlet.ServletContext;
import java.util.ArrayList;
import java.util.List;

public class OgnlvalueStack02 extends ActionSupport {

    Peoper peoper;

    public Peoper getPeoper() {
        return peoper;
    }

    public void setPeoper(Peoper peoper) {
        this.peoper = peoper;
    }

    public String handleValueStack() {
        ValueStack valueStack = ActionContext.getContext().getValueStack();
        peoper = new Peoper("张三", "55");

//        valueStack.push(peoper);

        valueStack.set("kk", peoper);

        List<Peoper> list = new ArrayList<>();

        list.add(new Peoper("aaa", "111"));
        list.add(new Peoper("bbb", "222"));
        list.add(new Peoper("ccc", "333"));

        valueStack.set("list", list);


        //向context中存值


        ServletActionContext.getRequest().setAttribute("name", "r_hftang哈");
        ServletActionContext.getRequest().getSession().setAttribute("name", "s_hftang_session");
        ServletActionContext.getRequest().getServletContext().setAttribute("name", "a_hftang_application");


        return "result";
    }


}
