package com.bean;

/**
 * Created by yuyu on 2016/10/19.
 */
public class Student {

    private Long id;

    private String name;

    private int age;

    private String xxoo;

    private Teacher teacher;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getXxoo() {
        return xxoo;
    }

    public void setXxoo(String xxoo) {
        this.xxoo = xxoo;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

}
