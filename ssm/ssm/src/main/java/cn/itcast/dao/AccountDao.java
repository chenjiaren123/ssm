package cn.itcast.dao;

import cn.itcast.domain.Account;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountDao {
    @Select("select * from account")
    List<Account> findAll();

    @Insert("insert into account values(null ,#{name} , #{money})" )
    void saveAccount(Account account);
}
