package com.itheima.extend;




public class SilverCard extends Card{
    public SilverCard(String cardId, String name, String phone, double money) {
        super(cardId, name, phone, money);
    }
    @Override
    public void consume(double money) {
        System.out.println("your recent cost: " + money);
        System.out.println("after coupon: " + money * 0.9);
        setMoney(getMoney() - money * 0.9);
    }
}
