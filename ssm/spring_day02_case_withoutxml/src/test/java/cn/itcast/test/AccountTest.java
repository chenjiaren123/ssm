package cn.itcast.test;

import cn.itcast.domain.Account;
import cn.itcast.service.AccountService;
import config.SpringConfiguration;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class AccountTest {
    @Autowired
    private AccountService accountService;

    /*@Before
    public void init() {
        accountService = new AnnotationConfigApplicationContext(SpringConfiguration.class).getBean("accountService", AccountService.class);
    }*/

    @Test
    public void testSaveAccount() {
        Account account = new Account();
        account.setName("罗洲");
        account.setMoney(123F);
        accountService.saveAccount(account);
    }

    @Test
    public void testUpdateAccount() {
        Account account = new Account();
        account.setId(4);
        account.setName("胖虎");
        accountService.updateAccount(account);
    }

    @Test
    public void testDeleteAccount() {
        accountService.deleteAccount(4);
    }

    @Test
    public void testFindById() {
        Account byId = accountService.findById(3);
        System.out.println(byId);
    }

    @Test
    public void testFindAll() {
        List<Account> list = accountService.findAll();
        System.out.println(list);
    }
}
