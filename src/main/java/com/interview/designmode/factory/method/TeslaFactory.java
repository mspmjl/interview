package com.interview.designmode.factory.method;

/**
 * Created by Miaojiale on 2021/3/8.
 */
public class TeslaFactory implements CarFactory{
    @Override
    public Car getCar() {
        return new Tesla();
    }
}
