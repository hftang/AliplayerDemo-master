package com.hftang.servlet;

import com.hftang.bean.Student;
import com.hftang.dao.StudentDao;
import com.hftang.dao.daoImpl.StudentDaoImpl;
import com.hftang.service.StudentService;
import com.hftang.service.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


public class ServletStudent extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();
//        request.getRequestDispatcher("success.jsp").forward(request, response);

        StudentService studentService = new StudentServiceImpl();
        try {
            List<Student> daoAll = studentService.findAll();

            session.setAttribute("list", daoAll);
            request.getRequestDispatcher("list.jsp").forward(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
