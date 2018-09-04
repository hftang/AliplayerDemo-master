package com.hftang;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet(name = "cookie", urlPatterns = "/cookier")
public class cookie extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");

        System.out.print(name);

        response.setContentType("text/html;charset=utf-8");

        Cookie[] cookies = request.getCookies();

        String userName = null;
        String time = null;

        if (cookies != null) {

            for (int i = 0; i < cookies.length; i++) {
                if ("hftang".equals(cookies[i].getName())) {
                    userName = cookies[i].getValue();
                }
                if ("last".equals(cookies[i].getName())) {
                    time = cookies[i].getValue();
                }
            }
        }

        if ("hftang".equals(name)) {
            //表示登录成功
            Cookie cookier = new Cookie("name", name);
            cookier.setMaxAge(60 * 60 * 24 * 30);
            response.addCookie(cookier);
            Cookie cookier02 = new Cookie("last", System.currentTimeMillis() + "");
            cookier02.setMaxAge(60 * 60 * 24 * 30);
            response.addCookie(cookier02);
            if (userName != null || time != null) {
                long aLong = Long.parseLong(time);
                response.getWriter().write("欢迎：" + name + "回归！上次登录时间是：" + new Date(aLong));
            }
        } else {
            response.getWriter().write("登录失败");
        }


    }
}
