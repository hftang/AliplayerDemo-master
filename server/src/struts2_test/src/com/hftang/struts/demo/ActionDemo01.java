package com.hftang.struts.demo;

import com.opensymphony.xwork2.ActionSupport;

import java.util.Date;

public class ActionDemo01 extends ActionSupport {

    /**
     * private String name;
     * private Integer age;
     * private Date birthday;
     * private double salary;
     */

    private String name;
    private Integer age;
    private Date birthday;
    private double salary;

    //设置属性的 所有setter方法


    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String handleDatas() {

        //收到的数据

        System.out.println(name);
        System.out.println(age);
        System.out.println(birthday);
        System.out.println(salary);


        return NONE;
    }

}
