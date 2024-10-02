package com.example.slstore.practice.model;

public class Person {
    private String name;
    private int age;

    public Person() {
    }

    // Chapter1 Lesson2 Section C
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
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

    // Chapter1 Lesson2 Section B
    public String introduce() {
        return "私は " + this.name + " ! " + this.age + " 歳です!";
    }
}
