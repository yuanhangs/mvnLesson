package org.hlx;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

//@WebListener()
public class MyListener implements ServletContextListener {

    // Public constructor is required by servlet spec
    public MyListener() {
        System.out.println("start listener...");
    }

    Thread th;

    // -------------------------------------------------------
    // ServletContextListener implementation
    // -------------------------------------------------------
    public void contextInitialized(ServletContextEvent sce) {
      /* This method is called when the servlet context is
         initialized(when the Web application is deployed). 
         You can initialize servlet context related data here.
      */
        System.out.println("start init....");
        th = new Thread(new SchuduleServer());
        th.start();

    }

    public void contextDestroyed(ServletContextEvent sce) {
      /* This method is invoked when the Servlet Context 
         (the Web application) is undeployed or 
         Application Server shuts down.
      */
        System.out.println("end destroy....");

        th.stop();

    }


}
