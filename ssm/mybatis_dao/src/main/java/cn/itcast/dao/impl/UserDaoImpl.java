package cn.itcast.dao.impl;

import cn.itcast.dao.UserDao;
import cn.itcast.domain.QueryVo;
import cn.itcast.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class UserDaoImpl implements UserDao {
    //private SqlSessionFactory factory;
    private SqlSession sqlSession;

    public UserDaoImpl(SqlSessionFactory factory) {
        //this.factory = factory;
        sqlSession = factory.openSession(true);
    }

    public List<User> findAll() {
        List<User> list = sqlSession.selectList("cn.itcast.dao.UserDao.findAll");
        return list;
    }

    public void saveUser(User user) {
        sqlSession.insert("cn.itcast.dao.UserDao.saveUser", user);
        sqlSession.close();
    }

    public void updateUser(User user) {
        sqlSession.update("cn.itcast.dao.UserDao.updateUser", user);
        sqlSession.close();
    }

    public void deleteUser(int id) {
        sqlSession.delete("cn.itcast.dao.UserDao.deleteUser", id);
        sqlSession.close();
    }

    public User findById(Integer uid) {
        User o = sqlSession.selectOne("cn.itcast.dao.UserDao.findById", uid);
        sqlSession.close();
        return o;
    }

    public List<User> findByName(String name) {
        List<User> list = sqlSession.selectList("cn.itcast.dao.UserDao.findByName", name);
        sqlSession.close();

        return list;
    }

    public int findTotalCount() {
        Integer o = sqlSession.selectOne("cn.itcast.dao.UserDao.findTotalCount");
        sqlSession.close();
        return o;
    }

    public List<User> findUserByVo(QueryVo vo) {
        List<User> list = sqlSession.selectList("cn.itcast.dao.UserDao.findUserByVo", vo);
        sqlSession.close();
        return list;
    }
}
