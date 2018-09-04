package com.test;

import com.utils.JDBCUtil;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class TestDataSource implements DataSource {

    List<Connection> list = new ArrayList<>();

    public TestDataSource() {
        //创建10个connection
        for (int i = 0; i < 10; i++) {
            Connection conn = JDBCUtil.getConn();
            list.add(conn);
        }
    }

    @Override
    public Connection getConnection() throws SQLException {

        //获取连接池中的connection时 不够的话 自动扩充 5个

        if (list.size() == 0) {
            for (int i = 0; i < 5; i++) {
                Connection conn = JDBCUtil.getConn();
                list.add(conn);
            }
        }
        Connection connection = list.remove(0);
        return connection;
    }

    //回收 connection

    public void addBack(Connection connection) {
        list.add(connection);
    }

    @Override
    public Connection getConnection(String username, String password) throws SQLException {
        return null;
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        return null;
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return false;
    }

    @Override
    public PrintWriter getLogWriter() throws SQLException {
        return null;
    }

    @Override
    public void setLogWriter(PrintWriter out) throws SQLException {

    }

    @Override
    public void setLoginTimeout(int seconds) throws SQLException {

    }

    @Override
    public int getLoginTimeout() throws SQLException {
        return 0;
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return null;
    }
}
