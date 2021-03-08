package com.interview.designmode.factory.abstractfactory;

/**
 * Created by Miaojiale on 2021/3/8.
 */
// 抽象工厂
public interface ProductFactory {
    // 生产手机
    Phone getPhone();

    // 生产路由器
    Router getRouter();
}
