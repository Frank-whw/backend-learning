package com.itheima.extend;



public class GoldCard extends  Card{
    public GoldCard(String cardId, String name, String phone, double money) {
        super(cardId, name, phone, money);
    }
    @Override
    public void consume(double money) {
        System.out.println("your recent cost: " + money);
        System.out.println("after coupon: " + money * 0.8);
        setMoney(getMoney() - money * 0.8);
        if(money * 0.8 > 200){
            printTickect();
        }else{
            System.out.println("no more than 200, so you can't wash car for free");
        }
    }
    public void printTickect(){
        System.out.println("here is your car wash ticket");
    }
}
