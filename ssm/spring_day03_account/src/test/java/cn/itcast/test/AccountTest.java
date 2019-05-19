package cn.itcast.test;

import cn.itcast.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:bean.xml")
public class AccountTest {
    @Autowired
    @Qualifier("proxyAccountService")
   private AccountService as;
    @Test
    public void testTransfer(){
        as.transfer("aaa","bbb",100f);
    }
}
