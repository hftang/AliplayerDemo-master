package com.hftang.servlet;

import com.hftang.service.StudentService;
import com.hftang.service.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class ServletDelete extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String sid = request.getParameter("sid");

        StudentService studentService = new StudentServiceImpl();
        try {
            studentService.deleteBySid(sid);

            request.getRequestDispatcher("/student_servlet").forward(request, response);

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
