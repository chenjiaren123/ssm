package cn.itcast.dao;

import cn.itcast.domain.Account;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

import static org.apache.ibatis.mapping.FetchType.EAGER;

public interface AccountDao {
    /**
     * 查询所有账户，同时获取账户的所属用户信息
     * @return
     */
    @Select("select * from account")
    @Results(id = "accountMap",value = {
            @Result(id = true , property = "id" , column = "id"),
            @Result(property = "uid" , column = "uid"),
            @Result(property = "money" , column = "money"),
            @Result(property = "user" , column = "uid" ,
                    one = @One(select = "cn.itcast.dao.UserDao.findById" , fetchType = EAGER))
    })
    List<Account> findAll();

    /**
     * 根据uid查找账户信息
     * @param uid
     * @return
     */
    @Select("select * from account where uid = #{uid}")
    List<Account> findByUid(Integer uid);
}
