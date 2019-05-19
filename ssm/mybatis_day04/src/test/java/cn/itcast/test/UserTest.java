package cn.itcast.test;


import cn.itcast.dao.UserDao;
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
import java.util.ArrayList;
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
    public void testFindById() {
        User user = userDao.findById(48);
        System.out.println(user);
    }
    @Test
    public void testFindAll() {
        List<User> users = userDao.findAll();
        /*for (User user : users) {
            System.out.println(user);
            System.out.println(user.getAccounts());
        }*/
    }

}
