package com.jdbctemplate;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * jdbcTemplate最基本用法
 */
public class JdbcTemplateDemo1 {

    public static void main(String[] args) {
        //准备数据源:spring内置数据源
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/test?characterEncoding=utf-8&serverTimezone=UTC");
        ds.setUsername("root");
        ds.setPassword("12345678");

        //1.创建jdbcTemplate对象
        JdbcTemplate jt = new JdbcTemplate();

        jt.setDataSource(ds);
        //2.执行操作
        jt.execute("insert into account1(name,money)values ('cd',1000)");
    }
}
