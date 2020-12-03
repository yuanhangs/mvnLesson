<%@ page import="org.hlx.entity.Cards" %>
<%@ page import="org.hlx.biz.CardsServer" %><%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2020/11/26
  Time: 12:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    //1.中文处理
    request.setCharacterEncoding("utf-8");

    //2.获取参数值
    String card=request.getParameter("name");
    String pwd=request.getParameter("pwd");
    //确认密码
    String repwd=request.getParameter("repwd");

    System.out.println(card+"\t"+pwd+"\t"+repwd);

    //3.封装
    Cards cards =new Cards(0,card,pwd);

    //4.业务
    CardsServer server =new CardsServer();

    //5.调用方法
    int count =server.isLogin(cards);

    System.out.println("count="+count);

    //判断
    if(count>0){
        response.sendRedirect("show.jsp");
    }else{
        response.sendRedirect("wangyin.html");
    }

%>