package com.wrapper;

import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestData {

    @Test
    public void test01() {
        MyDataSource myDataSource = new MyDataSource();

        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = myDataSource.getConnection();
            String sql = "insert into account VALUES (?,?,?)";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, 4);
            ps.setString(2, "xinhh");
            ps.setInt(3, 4000);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();//这个地方并不是关闭资源 而是把使用过后的资源 放回 链接池中 使用的是包装类
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


    }
}
