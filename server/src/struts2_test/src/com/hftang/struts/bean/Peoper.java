package com.hftang.struts.bean;

public class Peoper {

    private String name;
    private String age;


    public Peoper() {
    }

    public Peoper(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Peoper{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
