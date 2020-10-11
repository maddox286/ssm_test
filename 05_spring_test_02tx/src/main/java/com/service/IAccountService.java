package com.service;

import com.domain.Account;

/**
 * 账户业务层接口
 */
public interface IAccountService {
    /**
     * 根据id查询账户信息
     * @param id
     * @return
     */
    Account findAccountById(Integer id);

    void transfer(String sourceName, String targetName, Float money);
}
