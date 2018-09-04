package com.hftang.com.hftang.test;

import com.hftang.bean.Student;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

public class TestStudent {


//    @Test
//    public void test01() {
//
//        QueryRunner queryRunner = new QueryRunner(new ComboPooledDataSource());
//        List<Student> studentList = null;
//        try {
//            studentList = queryRunner.query("select * from stu", new BeanListHandler<Student>(Student.class));
//            int size = studentList.size();
//            for (int i = 0; i < studentList.size(); i++) {
//
//                Student student = studentList.get(i);
//
//                System.out.print(student);
//
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//
//    }
}
