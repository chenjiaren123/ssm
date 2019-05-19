package cn.itcast.dao;

import cn.itcast.domain.User;

import java.util.List;

public interface UserDao {

    /**
     * 查询所有用户
     * @return
     */
    List<User> findAll();

    /**
     * 根据id查询用户信息
     * @param uid
     * @return
     */
    User findById(Integer uid);
}
