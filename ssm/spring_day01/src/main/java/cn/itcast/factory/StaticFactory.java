package cn.itcast.factory;

import cn.itcast.service.AccountService;
import cn.itcast.service.impl.AccountServiceImpl;

public class StaticFactory {
    public static AccountService getAccountService(){
        return new AccountServiceImpl();
    }
}
