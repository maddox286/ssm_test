package com.test;

import com.dao.IUserDao;
import com.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class AnnotationCRUDTest {
    private InputStream in;
    private SqlSessionFactory factory;
    private SqlSession session;
    private IUserDao userDao;

    @Before
    public void init() throws IOException {
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        factory = new SqlSessionFactoryBuilder().build(in);
        session = factory.openSession();
        userDao = session.getMapper(IUserDao.class);
    }

    @After
    public void destroy() throws IOException {
        session.commit();
        session.close();
        in.close();
    }

    @Test
    public void testSave(){
        User user = new User();
        user.setUsername("test123123");
        user.setAddress("北京市顺义区");

        userDao.saveUser(user);
    }

    @Test
    public void testUpdate(){
        User user = new User();
        user.setId(51);
        user.setUsername("毛毛");
        user.setSex("女");
        user.setAddress("杭州");

        userDao.updateUser(user);
    }

    @Test
    public void testDelete(){

        userDao.deleteUser(51);
    }

    @Test
    public void testfindById(){
        User user = userDao.findById(50);
        System.out.println(user);
    }

    @Test
    public void testfindByName(){
        //List<User> user = userDao.findByName("%王%");
        List<User> user = userDao.findByName("王");
        for (User user1 : user) {
            System.out.println(user1);
        }
    }

    @Test
    public void testfindTotal(){
        int u = userDao.findTotaluser();
        System.out.println(u);
    }
}
