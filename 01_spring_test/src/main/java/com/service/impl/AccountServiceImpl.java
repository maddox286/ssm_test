package com.service.impl;

import com.dao.IAccountDao;
import com.dao.Impl.AccountDaoImpl;
import com.service.IAccountService;

/**
 * 账户的业务层实现类
 */
public class AccountServiceImpl implements IAccountService {
    private IAccountDao accountDao = new AccountDaoImpl();

    public void saveAccount() {
        accountDao.saveAccount();
    }
}
