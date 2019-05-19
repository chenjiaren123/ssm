package cn.itcast.dao.impl;

import cn.itcast.dao.AccountDao;
import cn.itcast.domain.Account;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.List;

public class AccountDaoImpl extends JdbcDaoSupport implements AccountDao {
    public Account findAccountById(Integer accountId) {
        List<Account> list = super.getJdbcTemplate().query("select * from Account where id = ?", new BeanPropertyRowMapper<Account>(Account.class), accountId);
        return list.isEmpty() ? null : list.get(0);
    }

    public Account findAccountByName(String accountName) {
        List<Account> list = super.getJdbcTemplate().query("select * from Account where name = ?", new BeanPropertyRowMapper<Account>(Account.class), accountName);
        if (list.isEmpty()) return null;
        if (list.size() > 1) throw new RuntimeException("结果集不唯一");
        return list.get(0);
    }

    public void updateAccount(Account account) {
        super.getJdbcTemplate().update("update Account set name = ?,money=? where id = ?", account.getName(), account.getMoney(), account.getId());
    }
}
