package com.hftang.dao;

import com.hftang.bean.Student;

import java.sql.SQLException;
import java.util.List;

public interface StudentDao {

    List<Student> findAll() throws SQLException;

    void insert(Student student) throws SQLException;

    void deleteBySid(String sid) throws SQLException;

    Student findStudentById(String sid) throws SQLException;

    void updateStudent(Student student) throws SQLException;

    List<Student> queryList(String sname, String sgender) throws SQLException;
}
