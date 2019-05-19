package cn.itcast.dao.impl;

import cn.itcast.dao.AccountDao;
import org.springframework.stereotype.Component;

@Component("accountDao")
public class AccountDaoImpl2 implements AccountDao {
    public void saveAccount() {
        System.out.println("保存了用户22222222222222222222");
    }
}
