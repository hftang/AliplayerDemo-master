package com.hftang.servlet;

import com.hftang.bean.Student;
import com.hftang.service.StudentService;
import com.hftang.service.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


public class ServletAdd extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setCharacterEncoding("utf-8");

            String sname = request.getParameter("sname");
            String gender = request.getParameter("gender");
            String phone = request.getParameter("phone");
            String birthday = request.getParameter("birthday");
            String[] hobbies = request.getParameterValues("hobby");
            String info = request.getParameter("info");

            Student student = new Student();
            student.setSname(sname);
            student.setGender(gender);
            student.setPhone(phone);

            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(birthday);
            student.setBirthday(date);

            String sub = Arrays.toString(hobbies);

            String s = sub.substring(1, sub.length() - 1);


            student.setHobby(s);
            student.setInfo(info);


            StudentService studentService = new StudentServiceImpl();
            studentService.insert(student);


            request.getRequestDispatcher("student_servlet").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
