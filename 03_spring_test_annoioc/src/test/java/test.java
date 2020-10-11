import com.domain.Account;
import com.service.IAccountService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.util.List;

public class test {
    ApplicationContext ac;
    IAccountService as;

    @Before//用户在测试方法之前执行
    public void init() throws IOException {
        //1.获取容器
        ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.得到业务层对象
        as = (IAccountService) ac.getBean("accountService");

    }
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
