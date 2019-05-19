package cn.itcast.service;

import cn.itcast.domain.Account;

import java.util.List;

public interface AccountService {
    /**
     * 保存账户
     */
    void saveAccount(Account account);

    /**
     * 更新
     *
     * @param account
     */
    void updateAccount(Account account);

    /**
     * 删除
     *
     * @param id
     */
    void deleteAccount(Integer id);

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    Account findById(Integer id);

    /**
     * 查询所有
     *
     * @return
     */
    List<Account> findAll();
}
