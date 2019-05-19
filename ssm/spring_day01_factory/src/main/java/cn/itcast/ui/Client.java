package cn.itcast.ui;

import cn.itcast.factory.BeanFactory;
import cn.itcast.service.AccountService;
import cn.itcast.service.impl.AccountServiceImpl;

public class Client {
    public static void main(String[] args) {
       // AccountService accountService = new AccountServiceImpl();
        AccountService accountService = (AccountService)BeanFactory.getBean("accountService");
        accountService.saveAccount();
    }
}
