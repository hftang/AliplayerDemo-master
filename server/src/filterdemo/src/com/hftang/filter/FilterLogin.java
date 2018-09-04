package com.hftang.filter;

import com.hftang.bean.User;
import com.hftang.dao.UserDao;
import com.hftang.dao.UserDaoImpl;
import com.hftang.utils.CookieUtil;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(filterName = "FilterLogin", urlPatterns = "/*")
public class FilterLogin implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest request = (HttpServletRequest) req;

        try {

            //先判断session中有没有
            User user = (User) request.getSession().getAttribute("user");
            if (user != null) {
                //说明还在活着 放行
                chain.doFilter(req, resp);
            } else {
                //表示 session 已失效
                //查看 cookie
                Cookie[] cookies = request.getCookies();
                Cookie autoLogin = CookieUtil.findCookie(cookies, "autoLogin");
                if (autoLogin == null) {
                    //表示第一来请求 放行
                    chain.doFilter(req, resp);
                } else {
                    //表示已登录过
                    String value = autoLogin.getValue();
                    String[] strings = value.split("#");
                    String name = strings[0];
                    String pwd = strings[1];

                    //帮忙登录一次 然后再次存在session中
                    User user1 = new User();
                    user1.setName(name);
                    user1.setPwd(pwd);

                    UserDao userDao = new UserDaoImpl();
                    User loginUser = userDao.login(user1);
                    request.getSession().setAttribute("user", loginUser);
                    chain.doFilter(request, resp);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            chain.doFilter(request, resp);//出现异常也放行

        }


    }

    public void init(FilterConfig config) throws ServletException {

    }

}
