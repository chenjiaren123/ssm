package cn.itcast.test;


import cn.itcast.dao.UserDao;
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


public class UserTest {
    private UserDao userDao;
    private InputStream is;
    private SqlSession sqlSession;
    @Before
    public void init() throws IOException {
        is = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        sqlSession = factory.openSession();
        userDao = sqlSession.getMapper(UserDao.class);
    }
    @After
    public void after() throws IOException {
        sqlSession.commit();
        sqlSession.close();
        is.close();
    }

    @Test
    public void testFindAll() {
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println(user);
            System.out.println(user.getAccounts());
        }
    }
    @Test
    public void testSave() {
        User user = new User();
        user.setUsername("张三");
        user.setAddress("北京");
        user.setBirthday(new Date());
        user.setSex("男");
        userDao.saveUser(user);
    }

    @Test
    public void testUpdate() {
        User user = new User();
        user.setId(59);
        user.setUsername("李四");
        user.setAddress("北京");
        user.setBirthday(new Date());
        user.setSex("女");
        userDao.updateUser(user);
    }

    @Test
    public void testDelete() {
        userDao.deleteUser(59);
    }

    @Test
    public void testFindById() {
        User user = userDao.findById(41);
        System.out.println(user);
    }

    @Test
    public void testFindByName() {
        List<User> list = userDao.findByName("%王%","%北%");
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
    public void testFindAllUserAndRole() {
        List<User> users = userDao.findAllUserAndRole();
        for (User user : users) {
            System.out.println(user);
            System.out.println(user.getRoles());
        }
    }
}
