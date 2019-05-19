package cn.itcast.dao;

import cn.itcast.domain.QueryVo;
import cn.itcast.domain.User;

import java.util.List;

public interface UserDao {
    /**
     * 查询所有用户及对应的角色信息
     * @return
     */
    List<User> findAllUserAndRole();

    /**
     * 查询所有用户及对应的账户信息
     * @return
     */
    List<User> findAllUserAndAccount();


    /**
     * 查询所有用户
     * @return
     */
    List<User> findAll();

    /**
     * 保存用户
     * @param user
     */
    void saveUser(User user);

    /**
     * 更新用户
     * @param user
     */
    void updateUser(User user);

    /**
     * 根据id删除用户
     * @param id
     */
    void deleteUser(int id);

    /**
     * 根据id查询用户信息
     * @param uid
     * @return
     */
    User findById(Integer uid);

    /**
     * 根据名称模糊查询
     * @param name
     * @return
     */
    List<User> findByName(String name);

    /**
     * 查询总记录条数
     * @return
     */
    int findTotalCount();

    /**
     * 根据QueryVo中的条件查询用户
     * @param vo
     * @return
     */
    List<User> findUserByVo(QueryVo vo);

    /**
     * 条件查询
     * @param user
     * @return
     */
    List<User> findUserByCondition(User user);

    /**
     * 根据id集合查询用户
     * @param vo
     * @return
     */
    List<User> findInIds(QueryVo vo);
}
