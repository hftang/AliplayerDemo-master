package com.test;


import com.utils.JDBCUtil;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtils {


    @Test
    public void test01() throws SQLException {
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        Connection conn = JDBCUtil.getConn();
        try {
            conn.setAutoCommit(false);//关闭自动提交事务

            String sql = "UPDATE account SET money=money-? WHERE id=?";
            ps = conn.prepareStatement(sql);
            //减钱操作
            ps.setInt(1, 100);
            ps.setInt(2, 1);
            ps.executeUpdate();

            //加钱操作

            ps.setInt(1, -100);
            ps.setInt(2, 2);
            ps.executeUpdate();

            conn.commit();//提交事务
        } catch (SQLException e) {
            e.printStackTrace();
            conn.rollback();//回滚事务
        } finally {
            JDBCUtil.release(conn, ps, resultSet);//释放资源
        }


    }
}
