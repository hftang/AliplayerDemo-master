package com.hftang.dao.daoImpl;

import com.hftang.bean.Student;
import com.hftang.dao.StudentDao;
import com.hftang.utils.TextUtils;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao {
    @Override
    public List<Student> findAll() throws SQLException {

        QueryRunner queryRunner = new QueryRunner(new ComboPooledDataSource());
        List<Student> studentList = queryRunner.query("select * from stu", new BeanListHandler<Student>(Student.class));


        return studentList;
    }

    @Override
    public void insert(Student student) throws SQLException {

        QueryRunner queryRunner = new QueryRunner(new ComboPooledDataSource());

        int update = queryRunner.update("insert into stu values(null,?,?,?,?,?,?)",
                student.getSname(),
                student.getGender(),
                student.getPhone(),
                student.getBirthday(),
                student.getHobby(),
                student.getInfo()

        );


    }

    @Override
    public void deleteBySid(String sid) throws SQLException {

        QueryRunner queryRunner = new QueryRunner(new ComboPooledDataSource());
        queryRunner.update("delete from stu where sid = ?", sid);

    }

    @Override
    public Student findStudentById(String sid) throws SQLException {

        QueryRunner queryRunner = new QueryRunner(new ComboPooledDataSource());

        Student student = queryRunner.query("select * from stu where sid = ?", new BeanHandler<Student>(Student.class), sid);


        return student;
    }

    @Override
    public void updateStudent(Student student) throws SQLException {
        int sid = student.getSid();


        QueryRunner queryRunner = new QueryRunner(new ComboPooledDataSource());
        int update = queryRunner.update("update stu set sname=?,gender=?,phone=?,birthday=?,hobby=?,info=? where sid = ?",
                student.getSname(),
                student.getGender(),
                student.getPhone(),
                student.getBirthday(),
                student.getHobby(),
                student.getInfo(),
                student.getSid());

        System.out.print(update);

    }

    @Override
    public List<Student> queryList(String sname, String sgender) throws SQLException {

        QueryRunner queryRunner = new QueryRunner(new ComboPooledDataSource());

        List<String> list = new ArrayList<>();

        String sql = "select * from stu where 1=1";

        if (!TextUtils.isEmpty(sname)) {
            sql = sql + " and sname like ?";
            list.add("%" + sname + "%");
        }

        if (!TextUtils.isEmpty(sgender)) {
            sql = sql + " and gender = ?";
            list.add(sgender);
        }

        Object[] objects = list.toArray();

        String s = objects.toString();



        System.out.print(sql);


        List<Student> studentList = queryRunner.query(sql, new BeanListHandler<Student>(Student.class), list.toArray());


        return studentList;
    }
}
