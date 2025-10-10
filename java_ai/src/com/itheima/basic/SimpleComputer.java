package com.itheima.basic;

import java.util.Scanner;

public class SimpleComputer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("plz input 2 nums: ");
        double num1 = sc.nextDouble();
        double num2 = sc.nextDouble();
        System.out.println("plz input operator(+-*/): ");
        String op = sc.next();
        double result = calculate(num1,num2,op);
        System.out.println("result: " + result);

    }
    public static double calculate(double num1, double num2, String op) {
         double result = 0;
         switch (op){
             case "+":
                 result = num1 + num2;
                 break;
             case "-":
                 result = num1 - num2;
                 break;
             case "*":
                 result = num1 * num2;
                 break;
             case "/":
                 result = num1 / num2;
                 break;
             default:
                 System.out.println("Error");

         }
         return result;
    }
}
