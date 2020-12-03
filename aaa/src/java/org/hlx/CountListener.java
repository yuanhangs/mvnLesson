package org.hlx;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener()
public class CountListener implements
        HttpSessionListener {

    //声明变量
    private int userNumber = 0;
    // Public constructor is required by servlet spec
    public CountListener() {
        System.out.println("start sessionListener....");
    }


    // -------------------------------------------------------
    // HttpSessionListener implementation
    // -------------------------------------------------------
    public void sessionCreated(HttpSessionEvent se) {
        /* Session is created. */
        userNumber++;
        se.getSession().getServletContext().setAttribute("count",userNumber);
    }

    public void sessionDestroyed(HttpSessionEvent se) {
        /* Session is destroyed. */
        userNumber--;
        se.getSession().getServletContext().setAttribute("count",userNumber);
    }


}
