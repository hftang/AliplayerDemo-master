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
import java.util.List;

public class ServletQuery extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        String sname = request.getParameter("sname");
        String sgender = request.getParameter("sgender");


        StudentService studentService = new StudentServiceImpl();
        try {
            List<Student> studentList = studentService.queryList(sname, sgender);

            request.getSession().setAttribute("list", studentList);
            request.getSession().setAttribute("name", sname);
            request.getSession().setAttribute("gender", sgender);

            request.getRequestDispatcher("list.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
