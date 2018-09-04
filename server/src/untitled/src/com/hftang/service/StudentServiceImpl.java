package com.hftang.service;

import com.hftang.bean.Student;
import com.hftang.dao.StudentDao;
import com.hftang.dao.daoImpl.StudentDaoImpl;

import java.sql.SQLException;
import java.util.List;

public class StudentServiceImpl implements StudentService {
    @Override
    public List<Student> findAll() throws SQLException {


        StudentDao studentDao = new StudentDaoImpl();


        return studentDao.findAll();
    }

    @Override
    public void insert(Student student) throws SQLException {
        StudentDao studentDao = new StudentDaoImpl();
        studentDao.insert(student);
    }

    @Override
    public void deleteBySid(String sid) throws SQLException {
        StudentDao studentDao = new StudentDaoImpl();
        studentDao.deleteBySid(sid);
    }

    @Override
    public Student findStudentById(String sid) throws SQLException {
        StudentDao studentDao = new StudentDaoImpl();
        Student student = studentDao.findStudentById(sid);


        return student;
    }

    @Override
    public void updateStudent(Student student) throws SQLException {

        StudentDao studentDao=new StudentDaoImpl();
        studentDao.updateStudent(student);
    }

    @Override
    public List<Student> queryList(String sname, String sgender) throws SQLException {

        StudentDao studentDao=new StudentDaoImpl();
      List<Student> studentList= studentDao.queryList(sname,sgender);


        return studentList;
    }
}
