package com.itheima.extend;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// lombok技术可以实现为类自动添加构造方法、getter、setter、toString、equals、hashCode
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Card {
    private String cardId;
    private String name;
    private String phone;
    private double money;

    public void deposit(double money) {
        this.money += money;
    }
    public void consume(double money) {
        this.money -= money;
    }
}
