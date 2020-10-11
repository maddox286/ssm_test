package com.service;

import com.domain.Account;

import java.util.List;

public interface IAccountService {

    /**
     * 查询全部
     * @return
     */
    List<Account> findAll();

    /**
     * 查询一个
     * @return
     */
    Account findAccountById(Integer accountId);

    /**
     * 保存
     * @param account
     */
    void saveAccount(Account account);

    /**
     * 查询
     * @param account
     */
    void updateAccount(Account account);

    /**
     * 删除
     * @param id
     */
    void deleteAccount(Integer id);
}
