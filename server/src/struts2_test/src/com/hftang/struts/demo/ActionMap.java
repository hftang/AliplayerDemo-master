package com.hftang.struts.demo;

import com.hftang.struts.bean.Product;
import com.opensymphony.xwork2.ActionSupport;

import java.util.Map;

public class ActionMap extends ActionSupport {

    private Map<String, Product> map;


    public void setMap(Map<String, Product> map) {
        this.map = map;
    }

    public Map<String, Product> getMap() {
        return map;
    }

    public String getMapMethod() {

        for (String key : map.keySet()) {

            Product product = map.get(key);

            System.out.println(product);

        }

        return NONE;
    }
}
