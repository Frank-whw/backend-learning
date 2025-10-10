package com.itheima.abstract_interface;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Application implements Swich {
    private String name;
    private boolean status;

    @Override
    public void press() {
        System.out.println("current status is " + (this.isStatus() ? "on" : "off"));
        status = !status;
        System.out.println("after press, status is " + (this.isStatus() ? "on" : "off"));
    }
}
