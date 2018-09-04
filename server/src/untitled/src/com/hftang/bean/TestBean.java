package com.hftang.bean;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class TestBean implements HttpSessionBindingListener {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void valueBound(HttpSessionBindingEvent event) {
        System.out.print("--------》valueBound");

    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent event) {
        System.out.print("--------》valueUnbound");
    }
}
