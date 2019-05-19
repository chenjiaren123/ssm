package cn.itcast.dao;

import cn.itcast.domain.Account;

import java.util.List;

public interface AccountDao {
    /**
     * 保存账户
     */
    void save(Account account);

    /**
     * 更新
     * @param account
     */
    void update(Account account);

    /**
     * 删除
     * @param id
     */
    void delete(Integer id);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    Account findById(Integer id);

    /**
     * 查询所有
     * @return
     */
    List<Account> findAll();
}
