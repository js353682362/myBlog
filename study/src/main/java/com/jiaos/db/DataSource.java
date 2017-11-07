package com.jiaos.db;

import java.sql.Connection;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @（#）:DataSource.java
 * @description:
 * @author: jiaosen 2017/10/26
 * @version: Version 1.0
 */
public class DataSource {

    private BlockingQueue<Connection> connectionQueue = new LinkedBlockingDeque<>();

    static{
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private DataSource() {
    }

    public static DataSource getInstance(){
        return DataSourceInstance.dataSource;
    }

    private static class DataSourceInstance{
        private static DataSource dataSource = new DataSource();
    }
}
