package org.hlx;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

@WebListener()
public class RequestListener implements ServletRequestListener {

    // Public constructor is required by servlet spec
    public RequestListener() {
        System.out.println("RequestListener.....");
    }

    // 当用户请求到达、初始化时触发该方法
    @Override
    public void requestDestroyed(ServletRequestEvent sre) {

        HttpServletRequest request =(HttpServletRequest)sre.getServletRequest();
        System.out.println("++++发向" + request.getRequestURI() + "请求被销毁++++");
    }

    // 当用户请求结束、被销毁时触发该方法
    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        HttpServletRequest request =(HttpServletRequest)sre.getServletRequest();

        System.out.println("++++发向" + request.getRequestURI() + "请求被初始化++++");
    }
}
