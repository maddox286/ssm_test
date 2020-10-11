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
import java.util.Date;
import java.util.List;

public class MybatisTest {

    private InputStream in;
    private SqlSession session;
    private IUserDao userDao;

    @Before//用户在测试方法之前执行
    public void init() throws IOException {
        //1.读取配置文件
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建SqlSessionFactory工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //3.使用工厂生产SqlSession对象
        session = factory.openSession();
        //4.使用SqlSession创建Dao接口的代理对象
        userDao = session.getMapper(IUserDao.class);
    }
    @After//在测试方法之后执行
    public void testDestory() throws IOException{
        //提交事务
        session.commit();
        //6.释放资源
        session.close();
        in.close();

    }

    @Test
    public void testFindAll() {
        //5.使用代理对象执行方法
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println(user);
        }
    }
    @Test
    public void testSave() {
        User user = new User();
        user.setUsername("mybatis last insert");
        user.setAddress("北京市顺义区");
        user.setSex("男");
        user.setBirthday(new Date());
        System.out.println(user);

        //5.使用代理对象执行方法
        userDao.saveUser(user);
        System.out.println(user);
    }
    @Test
    public void updateUser() {
        User user = new User();
        user.setId(50);
        user.setUsername("mybatis updateUser");
        user.setAddress("北京市顺义区");
        user.setSex("女");
        user.setBirthday(new Date());

        userDao.updateUser(user);

    }

    @Test
    public void deleteUser() {
        userDao.deleteUser(48);
    }

    @Test
    public void testFindById() {
        User user = userDao.findById(50);
        System.out.println(user);
    }

    /**
     * 模糊查询 需要加%%
     */
    @Test
    public void testfindByName() {
        List<User> users = userDao.findByName("%王%");
        /*List<User> users = userDao.findByName("王");*/
        System.out.println(users);
    }
    @Test
    public void testfindTotal() {
        int count = userDao.findTotal();
        System.out.println(count);
    }

}
