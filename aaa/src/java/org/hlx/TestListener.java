package org.hlx;

import javax.servlet.*;
import javax.servlet.annotation.WebListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

@WebListener()
public class TestListener implements ServletContextListener,
        ServletContextAttributeListener {

    private ServletContext context = null; //定义一个ServletContext对象变量，赋为null

    // Public constructor is required by servlet spec
    public TestListener() {
        System.out.println("context........");
    }

    // -------------------------------------------------------
    // ServletContextListener implementation
    // -------------------------------------------------------
    public void contextInitialized(ServletContextEvent sce) {
      /* This method is called when the servlet context is
         initialized(when the Web application is deployed). 
         You can initialize servlet context related data here.
      */
        this.context = sce.getServletContext(); //初始化一个ServletContext对象
         System.out.print("ServletContext初始化......"); //打印出该方法的操作信息
    }

    public void contextDestroyed(ServletContextEvent sce) {
      /* This method is invoked when the Servlet Context 
         (the Web application) is undeployed or 
         Application Server shuts down.
      */
        this.context =null;
        System.out.print("ServletContext被释放......"); //打印出该方法的操作信息
    }


    @Override
    public void attributeAdded(ServletContextAttributeEvent event) {
       show( "增加ServletContext对象的一个属性：attributeAdded('"+event.getName()+"',' "+event.getValue()+"')");
    }

    /**
     * 显示数据
     * @param s
     */
    private void show(String s) {
        //调用该方法在txt文件中打印出message字符串信息
        PrintWriter out =null;
        try {
            out = new PrintWriter(new FileOutputStream("e:/output.txt",true));
            //写入
            out.println(new java.util.Date()+" ContextListener: "+s);
            //关闭
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent event) {
        show( "删除ServletContext对象的一个属性：attributeRemoved('"+event.getName()+")");
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent event) {
        show( "更改ServletContext对象的一个属性：attributeAdded('"+event.getName()+"',' "+event.getValue()+"')");
    }
}
