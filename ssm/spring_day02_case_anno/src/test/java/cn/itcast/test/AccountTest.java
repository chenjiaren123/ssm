package cn.itcast.test;

import cn.itcast.domain.Account;
import cn.itcast.service.AccountService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class AccountTest {
    private AccountService accountService;

    @Before
    public void init() {
        accountService = new ClassPathXmlApplicationContext("bean.xml").getBean("accountService", AccountService.class);
    }

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
