package cn.itcast.dao.impl;

import cn.itcast.dao.AccountDao;
import cn.itcast.domain.Account;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository("accountDao")
public class AccountDaoImpl implements AccountDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Pointcut()
    public Account findAccountById(Integer accountId) {
        List<Account> list = jdbcTemplate.query("select * from Account where id = ?", new BeanPropertyRowMapper<Account>(Account.class), accountId);
        return list.isEmpty() ? null : list.get(0);
    }

    public Account findAccountByName(String accountName) {
        List<Account> list = jdbcTemplate.query("select * from Account where name = ?", new BeanPropertyRowMapper<Account>(Account.class), accountName);
        if (list.isEmpty()) return null;
        if (list.size() > 1) throw new RuntimeException("结果集不唯一");
        return list.get(0);
    }

    public void updateAccount(Account account) {
        jdbcTemplate.update("update Account set name = ?,money=? where id = ?", account.getName(), account.getMoney(), account.getId());
    }
}
