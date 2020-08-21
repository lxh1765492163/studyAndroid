package com.example.myapplication.model;

import java.io.Serializable;
import java.security.PublicKey;

public class TestBean implements Serializable {
    private String name;
    private int age;
    private String weight;

    public TestBean() {

    }

    @Override
    public String toString() {
        return "TestBean{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", weight='" + weight + '\'' +
                '}';
    }

    public TestBean(String name, int age, String weight) {
        setName(name);
        setAge(age);
        setWeight(weight);
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

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }
}