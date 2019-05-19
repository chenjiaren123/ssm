package cn.itcast.test;

import cn.itcast.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AOPTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        AccountService accountService = (AccountService)context.getBean("accountService");
        accountService.saveAccount();
       /* System.out.println("-------------------------");
        accountService.updateAccount(1);
        System.out.println("-------------------------");
        accountService.deleteAccount();*/
    }
}
