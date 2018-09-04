package com.hftang.servlet;

import com.hftang.bean.User;
import com.hftang.dao.UserDao;
import com.hftang.dao.UserDaoImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Map;

@WebServlet(name = "ServletLogin", urlPatterns = "/login")
public class ServletLogin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        String pwd = request.getParameter("pwd");
        String login_auto = request.getParameter("login_auto");
//
//        Map<String, String[]> stringMap = request.getParameterMap();
        User user = new User();
//
//        try {
//            BeanUtils.populate(user,stringMap);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }


        user.setName(username);
        user.setPwd(pwd);
        String toString = user.toString();
        System.out.print(toString);

        UserDao userDao = new UserDaoImpl();
        try {
            User user1 = userDao.login(user);

            if (user1 != null) {


                if("no".equals(login_auto)){
                    Cookie cookie=new Cookie("autoLogin",username+"#"+pwd);
                    cookie.setMaxAge(60*60*24*7);
                    cookie.setPath("/AutoLogin");
                    response.addCookie(cookie);
                }




                //成功了
                request.getSession().setAttribute("user", user1);


            } else {
                //失败了
            }

            request.getRequestDispatcher("index.jsp").forward(request, response);


        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
