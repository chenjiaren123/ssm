package cn.itcast.service;

public interface AccountService {
    /**
     * 模拟保存账户
     */
    void saveAccount();

    /**
     * 模拟更新用户
     * @param i
     */
    void updateAccount(int i);

    /**
     * 模拟删除账户
     * @return
     */
    int deleteAccount();
}
