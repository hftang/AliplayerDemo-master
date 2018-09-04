package com.hftang.dao;

import com.hftang.bean.User;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class UserDaoImpl implements UserDao {
    @Override
    public User login(User user) throws SQLException {

        QueryRunner queryRunner = new QueryRunner(new ComboPooledDataSource());


        User user1 = queryRunner.query("select * from user where name = ? and pwd = ?", new BeanHandler<User>(User.class),
                user.getName(),
                user.getPwd()
        );


        return user1;
    }
}
