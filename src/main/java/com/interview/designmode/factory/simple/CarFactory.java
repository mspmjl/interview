package com.interview.designmode.factory.simple;

/**
 * Created by Miaojiale on 2021/3/8.
 */
public class CarFactory {
    // 方法一 不好拓展
    public static Car getCar(String car) {
        if ("五菱宏光".equals(car)) {
            return new Wuling();
        } else if ("Tesla".equals(car)) {
            return new Tesla();
        }
        return null;
    }

    public Car getTesla(){
        return new Tesla();
    }
}
