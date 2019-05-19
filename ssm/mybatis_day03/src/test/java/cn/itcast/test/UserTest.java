package cn.itcast.test;


import cn.itcast.dao.AccountDao;
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

import javax.activation.DataSource;
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
        user.setId(56);
        user.setUsername("李四");
        user.setAddress("北京");
        user.setBirthday(new Date());
        user.setSex("女");

        userDao.updateUser(user);
    }

    @Test
    public void testDelete() {
        userDao.deleteUser(56);
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

    @Test
    public void testFindUserByCondition(){
        User user = new User();
        user.setUsername("老王");
        List<User> list = userDao.findUserByCondition(user);
        for (User u : list) {
            System.out.println(u);
        }
    }

    @Test
    public void testFindInIds(){
        QueryVo vo = new QueryVo();
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(41);
        list.add(42);
        list.add(43);
        vo.setIds(list);
        List<User> inIds = userDao.findInIds(vo);
        for (User inId : inIds) {
            System.out.println(inId);
        }
    }

    @Test
    public void testFindAllUserAndAccount(){
        List<User> users = userDao.findAllUserAndAccount();
        for (User user : users) {
            System.out.println(user);
            System.out.println(user.getAccounts());
        }
    }
    @Test
    public void testFindAllUserAndRole(){
        List<User> users = userDao.findAllUserAndRole();
        for (User user : users) {
            System.out.println(user);
            System.out.println(user.getRoles());
        }
    }
}
