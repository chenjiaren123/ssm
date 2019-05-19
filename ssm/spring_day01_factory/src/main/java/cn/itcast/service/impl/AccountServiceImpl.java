package cn.itcast.service.impl;

import cn.itcast.dao.AccountDao;
import cn.itcast.dao.impl.AccountDaoImpl;
import cn.itcast.factory.BeanFactory;
import cn.itcast.service.AccountService;

public class AccountServiceImpl implements AccountService {
    //private AccountDao accountDao = new AccountDaoImpl();
    private AccountDao accountDao = (AccountDao)BeanFactory.getBean("accountDao");
    public void saveAccount() {
        accountDao.saveAccount();
    }
}
