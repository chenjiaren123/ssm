package cn.itcast.dao;

import cn.itcast.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

import static org.apache.ibatis.mapping.FetchType.EAGER;

public interface UserDao {
    /**
     * 查询所有用户及对应的角色信息
     *
     * @return
     */
    @Select("select * from user")
    @Results(id = "userRoleMap", value = {
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "birthday", column = "birthday"),
            @Result(property = "sex", column = "sex"),
            @Result(property = "address", column = "address"),
            @Result(property = "roles" ,column = "id",many = @Many(select = "cn.itcast.dao.RoleDao.findByUid",fetchType = EAGER))
    })
    List<User> findAllUserAndRole();

    /**
     * 查询所有用户
     *
     * @return
     */
    @Select("select * from user")
    @Results(id = "userMap", value = {
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "birthday", column = "birthday"),
            @Result(property = "sex", column = "sex"),
            @Result(property = "address", column = "address"),
            @Result(property = "accounts", column = "id",
                    many = @Many(select = "cn.itcast.dao.AccountDao.findByUid", fetchType = EAGER))
    })
    List<User> findAll();

    /**
     * 保存用户
     *
     * @param user
     */
    @Insert("INSERT INTO USER (username,birthday,sex,address) VALUES (#{username},#{birthday},#{sex},#{address})")
    void saveUser(User user);

    /**
     * 更新用户
     *
     * @param user
     */
    @Update("UPDATE USER SET username=#{username},address=#{address},sex=#{sex},birthday=#{birthday} WHERE id = #{id}")
    void updateUser(User user);

    /**
     * 根据id删除用户
     *
     * @param id
     */
    @Delete("DELETE FROM USER WHERE id = #{id}")
    void deleteUser(int id);

    /**
     * 根据id查询用户信息
     *
     * @param uid
     * @return
     */
    @Select("SELECT * FROM USER WHERE id = #{uid}")
    User findById(Integer uid);

    /**
     * 根据名称模糊查询
     *
     * @param name
     * @return
     */
    @Select("SELECT * FROM USER WHERE username LIKE #{name} and address like #{address}")
    List<User> findByName(@Param("name") String name,@Param("address") String address);

    /**
     * 查询总记录条数
     *
     * @return
     */
    @Select("SELECT count(id) FROM user")
    int findTotalCount();
}
