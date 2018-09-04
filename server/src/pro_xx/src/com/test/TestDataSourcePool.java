package com.test;

import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class TestDataSourcePool {


    @Test
    public void testDataSourcePool() {

        TestDataSource testDataSource = new TestDataSource();//实例化连接池
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = testDataSource.getConnection();//获取连接

            String sql = "insert into account VALUES (?,?,?)";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, 3);
            ps.setString(2, "hhh");
            ps.setInt(3, 3000);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            testDataSource.addBack(connection);//回退连接
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }


    }
}
