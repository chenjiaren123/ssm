package cn.itcast.test;

import cn.itcast.dao.UserDao;
import cn.itcast.domain.User;

import cn.itcast.mybatis.io.Resources;
import cn.itcast.mybatis.sqlsession.SqlSession;
import cn.itcast.mybatis.sqlsession.SqlSessionFactory;
import cn.itcast.mybatis.sqlsession.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTest {
    public static void main(String[] args) throws IOException {
        //1、读取配置文件
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");

        //2、创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(is);
        //3、使用工厂生产SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //4、使用SqlSession创建Dao借口的代理对象
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        //5、使用代理对象执行方法
        List<User> list = userDao.findAll();
        for (User user : list) {
            System.out.println(user);
        }
        //6、释放资源
        sqlSession.close();
        is.close();
    }
}
