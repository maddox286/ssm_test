package com.ui;

import com.factory.Beanfactory;
import com.service.IAccountService;
import com.service.impl.AccountServiceImpl;

/**
 * 模拟表现层,用于调用业务层
 */
public class Client {
    public static void main(String[] args) {

        for (int i = 0; i < 5; i++) {
            IAccountService as = (IAccountService) Beanfactory.getBean("accountService");
            System.out.println(as);
            as.saveAccount();
        }


    }
}
