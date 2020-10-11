package com.service.impl;

import com.dao.IAccountDao;
import com.dao.Impl.AccountDaoImpl;
import com.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

/**
 * xml的配置
 * <bean id="accountService" class="com.service.impl.AccountServiceImpl"
 *       scope="" init-method="" destroy-method="">
 *       <property name="" value="" | ref=""/>
 * </bean>
 *
 * 1、用于创建对象的注解
 *      它们的作用就和在xml配置文件中编写一个<bean>标签实现的功能一样
 *      Component:
 *          作用：用于把当前对象存入spring容器
 *          属性：
 *              value：用于指定bean的id。当我们不写时，他的默认值是当前类名且首字母小写
 *      Controller：一般用于表现层
 *      Service：一般用于业务层
 *      Repository：一般用于持久层
 *          作用与属性和Component一模一样。它们三个是spring框架为我们提供明确的三层使用的注解，使我们的三层对象更加清晰
 *
 * 2、用于注入数据
 *      它们的作用就和在xml配置文件中编写一个<property>标签实现的功能一样
 *      Autowired:
 *          作用：自动按照类型注入。只要容器中有唯一的一个bean对象类型和要注入的变量类型匹配，就可以注入成功。
 *               如果ioc容器中没有任何bean的类型和要注入的变量类型匹配，则报错
 *               如果ioc容器中有多个类型匹配时
 *          出现位置：可以是变量上，也可以是方法上
 *          细节：在使用注解注入时，set方法就不是必须的了
 *      Qualifier:              需要和Autowired注解配合使用
 *          作用：在按照类中注入的基础之上再按照名称注入。它在给类成员注入时不能单独使用，但是在给方法参数注入的时候可以
 *          属性：
 *              value：用于指定bean的id
 *      Resource
 *          作用：直接按照bean的id注入。它可以直接使用
 *          属性：
 *              name：用于指定bean的id
 *      以上三个注解都只能注入其他bean类型的数据，而基本类型和String类型无法使用上述注解实现。
 *      另外，集合类型的注入只能通过xml来实现
 *
 *      Value
 *          作用：用于注入基本类型和String类型的数据
 *          属性：
 *              value：用于指定数据的值。它可以使用spring中SpEl（String的el表达式）
 *                     SpEL的写法：${表达式}
 * 3、用于改变作用范围的
 *      它们的作用就和在bean标签中使用scope属性实现的功能是一样
 *      Scope
 *          作用：用于指定bean的作用范围
 *          属性：
 *              value：指定范围的取值。常用取值：singleton(单例) prototype(多例)
 * 4、改变生命周期 （了解）
 *      它们的作用就和在bean标签中使用 init-method 和 destroy-method 属性实现的功能是一样
 *      PreDestroy
 *          作用：用于指定销毁的方法
 *      PostConstruct
 *          作用：用于指定初始化的方法
 *
 * 使用注解
 * 账户的业务层实现类
 */
@Service(value = "accountService")
//@Scope(value = "singleton")
public class AccountServiceImpl implements IAccountService {

/*    @Autowired
    @Qualifier("accountDao")*/
    @Resource(name = "accountDao1")
    private IAccountDao accountDao;

    public void saveAccount() {
        accountDao.saveAccount();
    }
    @PostConstruct
    public void init(){
        System.out.println("-----1-----");
    }
    @PreDestroy
    public void destroy(){
        System.out.println("-----2-----");

    }
}
