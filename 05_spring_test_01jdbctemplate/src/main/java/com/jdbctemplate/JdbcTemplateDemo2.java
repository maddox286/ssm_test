package com.jdbctemplate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * jdbcTemplate最基本用法
 */
public class JdbcTemplateDemo2 {

    public static void main(String[] args) {
        //1.获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.获取对象
        JdbcTemplate jt = ac.getBean("jdbcTemplate", JdbcTemplate.class);
        //3.执行操作

        //保存
        //jt.update("insert into account1(name,money)values (?,?)","eee",333f);
        //更新
        //jt.update("update account1 set name=?,money=? where id=?","test",4567,18);
        //删除
        //jt.update("delete from account1 where id=?",18);
        //查询所有

        //查询一个
        //查询返回一行一列（使用聚合参数，但不加group by子句）
    }
}
