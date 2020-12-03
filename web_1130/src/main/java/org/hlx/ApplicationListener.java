package org.hlx;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

//@WebListener()
public class ApplicationListener implements ServletContextListener {

    // Public constructor is required by servlet spec
    public ApplicationListener() {
        System.out.println("ApplicationListener 创建实例....");
    }

    private Thread th;

    // -------------------------------------------------------
    // ServletContextListener implementation
    // -------------------------------------------------------
    public void contextInitialized(ServletContextEvent sce) {
      /* This method is called when the servlet context is
         initialized(when the Web application is deployed). 
         You can initialize servlet context related data here.
      */
        System.out.println("ApplicationListener 创建......");
        th = new Thread(new MyRunnable());
        th.start();

    }

    public void contextDestroyed(ServletContextEvent sce) {
      /* This method is invoked when the Servlet Context 
         (the Web application) is undeployed or 
         Application Server shuts down.
      */
        System.out.println("ApplicationListener 销毁......");
        th.stop();
    }


}
