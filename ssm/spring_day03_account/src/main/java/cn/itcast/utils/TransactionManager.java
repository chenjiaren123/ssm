package cn.itcast.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

@Component
public class TransactionManager {
    @Autowired
    private ConnectUtils connectUtils;

    public void beginTransaction(){
        try {
            connectUtils.getThreadConnection().setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void commit(){
        try {
            connectUtils.getThreadConnection().commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void rollback(){
        try {
            connectUtils.getThreadConnection().rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void release(){
        try {
            connectUtils.getThreadConnection().close();
            connectUtils.removeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
