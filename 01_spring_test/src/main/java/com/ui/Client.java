package com.ui;

import com.dao.IAccountDao;
import com.service.IAccountService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * 模拟表现层,用于调用业务层
 */
public class Client {
    /**
     * 获取spring核心容器，并根据id获取对象
     *      ClassPathXmlApplicationContext: 它可以加载类路径下的配置文件，要求配置文件必须在类路径下。不在的话，加载不了。
     *      FileSystemXmlApplicationContext: 它可以加载磁盘任意路径下的配置文件（必须有访问权限）
     *      AnnotationConfigApplicationContext: 它是用于读取注解创建容器
     *
     * 核心容器的谅解接口引发出的问题：
     *  ApllicationContext:     单例对象适用      实际开发中采用此接口创建容器对象
     *      它在创建核心容器时，创建对象采取的策略是采用立即加载的方式。也就是说，只要一读完配置文件马上就创建配置文件中的配置的对象
     *  BeanFactory:            多例对象适用
     *      它在构建核心容器时，创建对象采取的策略是采用延迟加载的方式。也就是说，什么时候根据id获取对象了，什么时候才真正的创建对象
     *
     *
     * @param args
     */
    public static void main(String[] args) {
        //1.获取核心容器对象
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.根据id获取bean对象
        IAccountService as = (IAccountService) ac.getBean("accountService");
        IAccountDao ad = ac.getBean("accountDao", IAccountDao.class);

        System.out.println(as + "   " +ad);

        /*//-------BeanFactory-------
        Resource resource = new ClassPathResource("bean.xml");
        BeanFactory factory = new XmlBeanFactory(resource);
        IAccountService as = (IAccountService) factory.getBean("accountService");
        System.out.println(as);*/
    }
}
