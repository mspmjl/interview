package com.interview.designmode.factory.abstractfactory;

/**
 * Created by Miaojiale on 2021/3/8.
 */
public class XiaomiFactory implements ProductFactory {
    @Override
    public Phone getPhone() {
        return new XiaomiPhone();
    }

    @Override
    public Router getRouter() {
        return new XiaomiRouter();
    }
}
