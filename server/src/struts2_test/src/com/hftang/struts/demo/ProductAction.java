package com.hftang.struts.demo;

import com.hftang.struts.bean.Product;
import com.opensymphony.xwork2.ActionSupport;

import java.util.List;

public class ProductAction extends ActionSupport {

    private List<Product> list;

    public void setList(List<Product> list) {
        this.list = list;
    }

    public List<Product> getList() {
        return list;
    }

    public String getObj() {

        for (Product item : list ) {

            System.out.print(item);

        }

        return NONE;
    }
}
