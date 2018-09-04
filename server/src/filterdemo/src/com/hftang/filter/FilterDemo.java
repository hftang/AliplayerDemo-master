package com.hftang.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

public class FilterDemo implements Filter {
    public void destroy() {
        System.out.print("------filter------destroy---");
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        chain.doFilter(req, resp);

        System.out.print("------filter------doFilter---");
    }

    public void init(FilterConfig config) throws ServletException {

        System.out.print("------filter------init---");

    }

}
