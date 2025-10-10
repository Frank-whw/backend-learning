package com.itheima.oop;

public class Movie {
    private int id;
    private String name;
    private double price;
    private String actor;

    // 有有参数构造器，无参构造器一定要写
    public Movie(){
    }
    // 定义一个有参数构造器
    public Movie(int id, String name, double price, String actor) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.actor = actor;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
