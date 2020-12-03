package org.hlx;

import javax.servlet.*;
import java.io.IOException;

public class ChinaFilter implements Filter {
    public void destroy() {
        System.out.println("3.过滤器销毁！！ filter destroy");
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        //中文处理
        req.setCharacterEncoding(string);

        //放行，下一个过滤连或web资源；
        chain.doFilter(req, resp);

        System.out.println("2.过滤器处理！ filter head");
    }

    private String string = "";

    public void init(FilterConfig config) throws ServletException {
        //初始化参数
        string = config.getInitParameter("encoding");

        System.out.println("1.过滤器初始化！！ filter init");
    }

}
