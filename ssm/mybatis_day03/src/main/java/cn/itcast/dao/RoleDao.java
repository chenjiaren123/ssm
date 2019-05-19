package cn.itcast.dao;

import cn.itcast.domain.Role;

import java.util.List;

public interface RoleDao {
    /**
     * 查询所有角色及关联的用户信息
     * @return
     */
    List<Role> findAll();
}
