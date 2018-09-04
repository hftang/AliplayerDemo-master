package com.hftang;

import com.huafeng.bean.Student;
import com.user.dao.UserDao;
import com.user.dao.impl.UseDaoImpl;
import com.utils.JDBCUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ServletLoginService", urlPatterns = "/login")
public class ServletLoginService extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //防止中文乱码
        request.setCharacterEncoding("utf-8");
        String name = request.getParameter("name");
        String pwd = request.getParameter("pwd");

        UserDao userDao = new UseDaoImpl();
        boolean login = userDao.Login(name, pwd);

        response.setContentType("text/html;charset=utf-8");

        if (login) {
            List<Student> list = new ArrayList<>();
            //1,先获取数据 然后存到session中
            Connection conn = JDBCUtil.getConn();
            String sql = "SELECT * from t_stu";
            try {
                PreparedStatement preparedStatement = conn.prepareStatement(sql);
                ResultSet resultSet = preparedStatement.executeQuery();


                while (resultSet.next()) {
                    Student student = new Student();
                    int id = resultSet.getInt("id");
                    student.setId(id);
                    String name1 = resultSet.getString("name");
                    student.setName(name1);
                    int age = resultSet.getInt("age");
                    student.setAge(age);
                    String gender = resultSet.getString("gender");
                    student.setGender(gender);
                    String adress = resultSet.getString("adress");
                    student.setAddress(adress);

                    list.add(student);
                }


            } catch (SQLException e) {
                e.printStackTrace();

            }

            request.getSession().setAttribute("xx",list);


            //2 再跳转到 success页面
            response.sendRedirect("successpage.jsp");


            response.getWriter().write("登录成功！");
        } else {
            response.getWriter().write("登录失败！");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request, response);
    }
}
