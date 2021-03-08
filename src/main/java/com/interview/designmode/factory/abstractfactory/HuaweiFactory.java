package com.interview.designmode.factory.abstractfactory;

/**
 * Created by Miaojiale on 2021/3/8.
 */
public class HuaweiFactory implements ProductFactory {
    @Override
    public Phone getPhone() {
        return new HuaweiPhone();
    }

    @Override
    public Router getRouter() {
        return new HuaweiRouter();
    }
}
