package com.itheima.basic;

import java.util.Scanner;

public class GuessNum {
    public static void main(String[] args) {
        guess();

    }
    public static void guess(){
//        Random rand = new Random();
        int r = (int)(Math.random()*100) + 1;
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.println("plz input a num between 1 and 100");
            int num = sc.nextInt();
            if(num > r){
                System.out.println("too big!");
            }else if(num < r){
                System.out.println("too small!");
            }else{
                System.out.println("congratulations!");
                break;
            }
        }
    }
}
