package cn.itcast.dao;

import cn.itcast.domain.Role;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface RoleDao {
    /**
     * 查询所有角色及关联的用户信息
     * @return
     */
    List<Role> findAll();

    /**
     * 根据uid查询角色信息
     * @param uid
     * @return
     */
    @Select("SELECT * FROM user_role ur,role r WHERE ur.RID = r.ID AND ur.UID = #{uid}")
    @Results(id = "roleMap", value = {
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "roleName",column = "role_name"),
            @Result(property = "roleDesc",column = "role_desc"),
    })
    List<Role> findByUid(Integer uid);
}
