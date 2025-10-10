package com.itheima.basic;

import java.util.Scanner;

public class GenerateCAPTCHA {
    public static void main(String[] args) {
        System.out.println("how many bits of code do u want to get");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        System.out.println(getCode(num));
    }
    public static String getCode(int n) {
        String code = "";
        for(int i = 0; i < n; i++){
            int type = (int)(Math.random() * 3);
            switch(type){
                case 0:
                    int num = (int)(Math.random() * 10);
                    code += num;
                    break;
                case 1:
                    int num1 = (int)(Math.random() * 26);
                    char ch = (char)('A' + num1);
                    code += ch;
                    break;
                case 2:
                    int num2 = (int)(Math.random() * 26);
                    char ch2 = (char)('a' + num2);
                    code += ch2;
                    break;
            }
        }
        return code;
    }
}
