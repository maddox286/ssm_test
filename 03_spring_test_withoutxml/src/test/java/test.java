import com.domain.Account;
import com.service.IAccountService;
import config.SpringConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * 使用Junit单元测试，测试我们的配置
 * Spring整合junit的配置
 *      1、导入spring整合junit的jar（坐标）
 *      2、使用Junit提供的一个注解把原有的main方法替换，替换成spring提供的
 *         @RunWith
 *      3、告知spring的运行器，spring和ioc创建是基于xml还是注解的，并且说明位置
 *         @ContextConfiguration
 *              locations：指定xml文件的位置，加上classpath关键字，表示在类路径下
 *              classes：指定注解类所在的位置
 * 当我们使用spring 5.x版本的时候，要求junit的jar必须是4.12及以上
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class test {

    @Autowired
    private IAccountService as;

    @Test
    public void testfindAllAccount(){
        List<Account> a = as.findAll();
        for (Account account : a) {
            System.out.println(account);
        }
    }
    @Test
    public void testfindAccountById(){
        System.out.println(as.findAccountById(7));

    }
    @Test
    public void testsave(){
        Account account = new Account();
        account.setName("wang");
        account.setMoney((float) 50000);
        as.saveAccount(account);
        testfindAllAccount();
    }
    @Test
    public void testupdate(){
        Account account = new Account();
        account.setId(14);
        account.setName("hhhhh");
        account.setMoney((float) 500);
        as.updateAccount(account);
        testfindAllAccount();
    }
    @Test
    public void testdelete(){
        as.deleteAccount(6);
        testfindAllAccount();
    }

}
