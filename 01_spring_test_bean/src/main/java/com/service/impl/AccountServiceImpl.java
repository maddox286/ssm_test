package com.service.impl;

import com.service.IAccountService;

/**
 * 账户的业务层实现类
 */
public class AccountServiceImpl implements IAccountService {

    public AccountServiceImpl() {
        System.out.println("对象被创建了");
    }

    public void saveAccount() {
        System.out.println("------saveAccount方法被执行了------");
    }

    public void init() {
        System.out.println("------对象被初始化了------");
    }

    public void destory() {
        System.out.println("------对象被销毁了------");
    }
}
