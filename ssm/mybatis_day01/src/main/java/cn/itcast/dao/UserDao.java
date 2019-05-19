package cn.itcast.dao;

import cn.itcast.domain.User;

import java.util.List;

public interface UserDao {
    //@Select("select * from user")
    List<User> findAll();
}
