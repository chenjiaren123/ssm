package cn.itcast.mybatis.sqlsession.defaults;


import cn.itcast.mybatis.cfg.Configuration;
import cn.itcast.mybatis.sqlsession.SqlSession;
import cn.itcast.mybatis.sqlsession.proxy.MapperProxy;
import cn.itcast.mybatis.utils.DataSourceUtil;

import java.lang.reflect.Proxy;
import java.sql.Connection;

/**
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 * SqlSession接口的实现类
 */
public class DefaultSqlSession implements SqlSession {

    private Configuration cfg;
    private Connection connection;

    public DefaultSqlSession(Configuration cfg){
        this.cfg = cfg;
        connection = DataSourceUtil.getConnection(cfg);
    }

    /**
     * 用于创建代理对象
     * @param daoInterfaceClass dao的接口字节码
     * @param <T>
     * @return
     */

    public <T> T getMapper(Class<T> daoInterfaceClass) {
        return (T) Proxy.newProxyInstance(
                daoInterfaceClass.getClassLoader(),
                new Class[]{daoInterfaceClass},
                new MapperProxy(cfg.getMappers(),connection));
    }

    /**
     * 用于释放资源
     */

    public void close() {
        if(connection != null) {
            try {
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
