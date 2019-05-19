package cn.itcast.dao.impl;

import cn.itcast.dao.AccountDao;
import cn.itcast.domain.Account;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class AccountDaoImpl implements AccountDao {
    private QueryRunner runner;

    public AccountDaoImpl() {
    }

    public AccountDaoImpl(QueryRunner runner) {
        this.runner = runner;
    }

    public void setRunner(QueryRunner runner) {
        this.runner = runner;
    }

    public void save(Account account) {
        try {
            runner.update("insert into account values (null,?,?)", account.getName(),account.getMoney());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Account account) {
        try {
            runner.update("update account set name=?,money=? where id=?", account.getName(),account.getMoney(),account.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(Integer id) {
        try {
            runner.update("delete from account where id = ?", id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Account findById(Integer id) {
        try {
            return runner.query("select * from account where id=?", new BeanHandler<Account>(Account.class),id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Account> findAll() {
        try {
            return runner.query("select * from account", new BeanListHandler<Account>(Account.class));
        } catch (SQLException e) {
            throw new RuntimeException(e);

        }
    }
}
