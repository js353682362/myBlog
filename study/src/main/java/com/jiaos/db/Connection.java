package com.jiaos.db;

import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Wrapper;

/**
 * @（#）:Connection.java
 * @description:
 * @author: jiaosen 2017/10/25
 * @version: Version 1.0
 */
public interface Connection extends Wrapper {
    Statement createStatement() throws SQLException;

    void close() throws SQLException;
}
