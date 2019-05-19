package cn.itcast.dao.impl;

import cn.itcast.dao.AccountDao;
import org.springframework.stereotype.Component;

@Component("accountDaoImpl1")
public class AccountDaoImpl1 implements AccountDao {
    public void saveAccount() {
        System.out.println("保存了用户111111111111111");
    }
}
