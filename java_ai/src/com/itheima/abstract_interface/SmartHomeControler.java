package com.itheima.abstract_interface;

public class SmartHomeControler {
    public void control(Application app){
        app.press();
    }
    public void printAll(Application[] apps){
        int i = 0;
        for (Application app : apps) {
            System.out.println(++i + ": " +app.getName() + " " + (app.isStatus() ? "on" : "off"));
        }
    }
}
