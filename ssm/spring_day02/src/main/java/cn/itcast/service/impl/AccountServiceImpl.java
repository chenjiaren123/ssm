package cn.itcast.service.impl;

import cn.itcast.dao.AccountDao;
import cn.itcast.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao accountDao;


    public AccountDao getAccountDao() {
        return accountDao;
    }

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }


    public AccountServiceImpl() {
        System.out.println("AccountService对象被创建了");
    }

    public void saveAccount() {
        accountDao.saveAccount();
    }

    public void init() {
        System.out.println("对象初始化");
    }

    public void destroy() {
        System.out.println("对象被销毁");
    }

}
