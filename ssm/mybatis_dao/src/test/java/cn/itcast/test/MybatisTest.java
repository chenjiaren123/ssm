package cn.itcast.test;


import cn.itcast.dao.UserDao;
import cn.itcast.dao.impl.UserDaoImpl;
import cn.itcast.domain.QueryVo;
import cn.itcast.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;


public class MybatisTest {
    private UserDao userDao;
    private InputStream is;
    @Before
    public void init() throws IOException {
        is = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        userDao = new UserDaoImpl(factory);
    }
    @After
    public void after() throws IOException {
        is.close();
    }

    @Test
    public void testSave() {
        User user = new User();
        user.setUsername("张三");
        user.setAddress("北京");
        user.setBirthday(new Date());
        user.setSex("男");
        System.out.println("保存之前"+user);
        userDao.saveUser(user);
        System.out.println("保存之后"+user);
    }

    @Test
    public void testUpdate() {
        User user = new User();
        user.setId(61);
        user.setUsername("李四");
        user.setAddress("北京");
        user.setBirthday(new Date());
        user.setSex("女");

        userDao.updateUser(user);
    }

    @Test
    public void testDelete() {
        userDao.deleteUser(61);
    }

    @Test
    public void testFindById() {
        User user = userDao.findById(48);
        System.out.println(user);
    }

    @Test
    public void testFindByName() {
        List<User> list = userDao.findByName("%王%");
        for (User user : list) {
            System.out.println(user);
        }
    }

    @Test
    public void testFindTotalCount() {
        int i = userDao.findTotalCount();
        System.out.println(i);
    }

    @Test
    public void testFindByVo(){
        User user = new User();
        QueryVo vo = new QueryVo();
        user.setUsername("%王%");
        vo.setUser(user);
        List<User> list = userDao.findUserByVo(vo);
        for (User u : list) {
            System.out.println(u);
        }
    }
}
