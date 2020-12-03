package org.hlx;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Date;

@WebListener()
public class SessionListener implements HttpSessionListener, HttpSessionAttributeListener {

    // Public constructor is required by servlet spec
    public SessionListener() {
        System.out.println("SessionListener 实例化。。。。。");
    }



 private int count=0;
    // -------------------------------------------------------
    // HttpSessionListener implementation
    // -------------------------------------------------------
    public void sessionCreated(HttpSessionEvent se) {
        /* Session is created. */
        count++;
       //保存数据
        se.getSession().getServletContext().setAttribute("count",count);
    }

    public void sessionDestroyed(HttpSessionEvent se) {
        /* Session is destroyed. */
        count--;
        //保存数据
        se.getSession().getServletContext().setAttribute("count",count);
    }

    // -------------------------------------------------------
    // HttpSessionAttributeListener implementation
    // -------------------------------------------------------

    public void attributeAdded(HttpSessionBindingEvent sbe) {
      /* This method is called when an attribute 
         is added to a session.
      */
      show("添加属性attributeAdded"+sbe.getName()+"\t"+sbe.getValue());
    }

    /**
     * 输出结果-保存到本地
     * @param msg  消息
     */
    private String fileName="e:/out.txt" ;

    private void show(String msg) {
        //输出流
        try {
            //true：追加数据
            PrintWriter out = new PrintWriter(new FileOutputStream(fileName,true));
            //写入
            out.write(new Date()+"\t"+msg+"\n");
            //关闭流
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void attributeRemoved(HttpSessionBindingEvent sbe) {
      /* This method is called when an attribute
         is removed from a session.
      */
        show("移除属性attributeRemoved"+sbe.getName());
    }

    public void attributeReplaced(HttpSessionBindingEvent sbe) {
      /* This method is invoked when an attibute
         is replaced in a session.
      */
        show("修改属性attributeReplaced"+sbe.getName()+"\t"+sbe.getValue());
    }


}
