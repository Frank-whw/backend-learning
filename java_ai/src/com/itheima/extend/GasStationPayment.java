package com.itheima.extend;

import java.util.Scanner;

public class GasStationPayment {
    public static void main(String[] args) {
        GoldCard goldCard = new GoldCard("A860MM", "张三", "13800000000", 5000);
        SilverCard silverCard = new SilverCard("B860MM", "数据库", "135345250", 2130);

    }
    public static void pay(Card card){
        System.out.println("please input your cost:");
        Scanner scanner = new Scanner(System.in);
        double money = scanner.nextDouble();
        card.consume(money);
    }
}
