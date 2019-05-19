package cn.itcast.factory;

import cn.itcast.service.AccountService;
import cn.itcast.service.impl.AccountServiceImpl;

public class InstanceFactory {
    public AccountService getAccountService(){
        return new AccountServiceImpl();
    }
}
