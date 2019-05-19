package cn.itcast.dao;

import cn.itcast.domain.Account;

import java.util.List;

public interface AccountDao {
    /**
     * 查询所有账户，同时获取账户的所属用户信息
     * @return
     */
    List<Account> findAll();

    Account findByUid(Integer uid);
}
