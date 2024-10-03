package com.example.slstore.customer.model.dto;

public class Account {

    // Chapter1 Lesson2 Section A
    private String name;

    private int points;

    // // Chapter1 Lesson2 Section C
    public Account() {

    }

    public Account(String name, int points) {
        this.name = name;
        this.points = points;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    // // Chapter1 Lesson2 Section B
    public String greeting() {
        return "こんにちは、" + this.name + "さん";
    }

}
