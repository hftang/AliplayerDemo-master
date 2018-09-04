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

/***
 * 更新的servlet
 */
public class ServletEdit extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String sid = request.getParameter("sid");

        StudentService studentService = new StudentServiceImpl();
        try {
            Student student = studentService.findStudentById(sid);

            request.getSession().setAttribute("student", student);
            request.getRequestDispatcher("edit.jsp").forward(request,response);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
