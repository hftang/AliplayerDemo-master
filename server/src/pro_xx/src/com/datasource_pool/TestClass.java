package com.datasource_pool;

import com.huafeng.bean.AcountBean;
import com.utils.JDBCUtil;
import com.utils.JDBCUtil02;
import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

import java.sql.*;
import java.util.List;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class TestClass {


    @Test
    public void run01() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost/spring_day03");
        dataSource.setUsername("root");
        dataSource.setPassword("root");

        Connection connection = null;

        PreparedStatement ps = null;
        try {
            connection = dataSource.getConnection();
            String sql = "insert into account VALUES (?,?,?)";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, 5);
            ps.setString(2, "jjjj");
            ps.setInt(3, 50000);

            ps.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

        }

    }

    @Test
    public void run02() {

        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        QueryRunner queryRunner = new QueryRunner(dataSource);
        String sql = "select * from account where id = ?";
        try {
            AcountBean acountBean = queryRunner.query(sql, new BeanHandler<AcountBean>(AcountBean.class), 1);
            System.out.print(acountBean);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    //查询集合

    @Test
    public void testList() {

        QueryRunner queryRunner = new QueryRunner(new ComboPooledDataSource());
        try {
            List<AcountBean> list = queryRunner.query("select * from account", new BeanListHandler<AcountBean>(AcountBean.class));
            for (int i = 0; i < list.size(); i++) {

                System.out.print(list.get(i));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }


    public void update(String sql, Object... args) {


        PreparedStatement ps = null;
        Connection conn = null;

        try {
            conn = JDBCUtil02.getConn();
            ps = conn.prepareStatement(sql);
            ParameterMetaData metaData = ps.getParameterMetaData();//获取到原数据
            int parameterCount = metaData.getParameterCount();//获取到问号的参数的个数
            for (int i = 0; i < parameterCount; i++) {
                ps.setObject(i + 1, args[i]);
            }
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            JDBCUtil.release(conn, ps);
        }


    }

    @Test
    public void testUpdate() {
        update("insert into account values(?,?,?)", 7, "hftang6662", 99991);
    }

    @Test
    public void testDel() {
        update("delete from account where id = ?", 7);
    }

    //修改

    @Test
    public void testUpdatemethod() {

        update("update account set name = ? where id = ?", "uuu_uuu", 6);

    }

    //写一个通用的 查询方法

    public void queryMethod(String sql, Object... args) {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = JDBCUtil02.getConn();
            ps = conn.prepareStatement(sql);
            ParameterMetaData metaData = ps.getParameterMetaData();
            int parameterCount = metaData.getParameterCount();
            for (int i = 0; i < parameterCount; i++) {
                ps.setObject(i + 1, args[i]);
            }
            ResultSet resultSet = ps.executeQuery();




        } catch (SQLException e) {
            e.printStackTrace();
        }


    }


}
