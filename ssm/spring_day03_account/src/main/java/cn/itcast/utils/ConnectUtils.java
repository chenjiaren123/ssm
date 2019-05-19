package cn.itcast.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
@Component
public class ConnectUtils {
    private ThreadLocal<Connection> tl = new ThreadLocal<Connection>();
    @Autowired
    private DataSource dataSource;

    public Connection getThreadConnection() {
        Connection connection = tl.get();
        try {
            if (connection == null) {
                connection = dataSource.getConnection();
                tl.set(connection);
            }
            return connection;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void removeConnection(){
        tl.remove();
    }
}
