package com.dao;

import com.domain.Account;

import java.util.List;

public interface IAccountDao {

    /**
     * 查询所有账户，同时还要获取到当前账户的所属用户的信息
     * @return
     */
    List<Account> findAll();
}
