import com.domain.Account;
import com.service.IAccountService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:bean.xml")
public class test {
    @Autowired
    @Qualifier("proxyAccountService")
    IAccountService as;

    @Test
    public void testTransfer(){
        as.transfer("ccc","hhhhh", 500f);
    }

}
