package com.dao.impl;

import com.dao.IAccountDao;
import com.domain.Account;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository("accountDao")
public class AccountDaoImpl implements IAccountDao {
    @Autowired
    private QueryRunner runner;

    @Override
    public List<Account> findAll(){
        try{
            return runner.query("select * from account1", new BeanListHandler<Account>(Account.class));

        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public Account findAccountById(Integer accountId) {
        try{
            return runner.query("select * from account1 where id = ? ", new BeanHandler<Account>(Account.class), accountId);

        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void saveAccount(Account account) {
        try{
            runner.update("insert into account1(name,money)values (?,?)",account.getName(),account.getMoney());

        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateAccount(Account account) {
        try{
            runner.update("update account1 set name = ?,money = ? where id = ?",account.getName(),account.getMoney(),account.getId());

        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteAccount(Integer id) {
        try{
            runner.update("delete from account1 where id = ?", id);

        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
