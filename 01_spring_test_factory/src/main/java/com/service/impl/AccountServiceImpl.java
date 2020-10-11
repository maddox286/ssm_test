package com.service.impl;

import com.dao.IAccountDao;
import com.dao.Impl.AccountDaoImpl;
import com.factory.Beanfactory;
import com.service.IAccountService;

/**
 * 账户的业务层实现类
 */
public class AccountServiceImpl implements IAccountService {
    //private IAccountDao accountDao = new AccountDaoImpl();
    private IAccountDao accountDao = (IAccountDao) Beanfactory.getBean("accountDao1");

    private int i = 1;
    public void saveAccount() {
        accountDao.saveAccount();
        System.out.println(i);
        i++;
    }
}
