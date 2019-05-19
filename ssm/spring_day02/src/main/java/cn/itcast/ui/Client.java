package cn.itcast.ui;

import cn.itcast.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        AccountService accountService = context.getBean("accountServiceImpl", AccountService.class);
        accountService.saveAccount();
        ((ClassPathXmlApplicationContext)context).close();
    }
}
