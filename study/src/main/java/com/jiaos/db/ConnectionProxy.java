package com.jiaos.db;

import java.sql.SQLException;
import java.sql.Statement;

/**
 * @（#）:ConnectionProxy.java
 * @description:
 * @author: jiaosen 2017/10/25
 * @version: Version 1.0
 */
public class ConnectionProxy implements Connection {
    private Connection connection;

    public ConnectionProxy(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Statement createStatement() throws SQLException {
        return connection.createStatement();

    }

    @Override
    public void close() throws SQLException {
        System.out.println("不真正的关闭连接");
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        return null;
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return false;
    }
}
