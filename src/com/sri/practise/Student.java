package com.sri.practise;

import java.util.List;

/**
 * Copyright (c) 2024 Srikanth Pula. All rights reserved.
 *
 * @author Srikanth Pula
 * Date: 29-08-2024
 */


public class Student {

    private int id;
    private String name;
    private String dept;

    private String city;
    private List<String> phones;

    public Student(int id, String name, String dept, String city, List<String> phones) {
        this.id = id;
        this.name = name;
        this.dept = dept;
        this.city = city;
        this.phones = phones;
    }




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<String> getPhones() {
        return phones;
    }

    public void setPhones(List<String> phones) {
        this.phones = phones;
    }
    
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dept='" + dept + '\'' +
                ", city='" + city + '\'' +
                ", phones=" + phones +
                '}';
    }
}
