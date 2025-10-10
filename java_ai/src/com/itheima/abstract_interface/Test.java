package com.itheima.abstract_interface;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Application[] apps = new Application[2];
        apps[0] = new TV("xiaomiTV", true);
        apps[1] = new Lamp("appleLamp", false);
        SmartHomeControler controler = new SmartHomeControler();
        while (true) {
            controler.printAll( apps);
            System.out.println("-------------------------");
            System.out.println("input the num of the application that you want to control, or input 'exit' to exit");
            String input = new Scanner(System.in).next();
            if ("exit".equals(input)) {
                break;
            }
            int index = Integer.parseInt(input);
            controler.control(apps[index - 1]);
        }
    }

}
