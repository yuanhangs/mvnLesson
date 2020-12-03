<%@ page import="org.hlx.entity.Cards" %>
<%@ page import="org.hlx.biz.CardsServer" %><%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2020/11/26
  Time: 11:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    //1.中文处理
    request.setCharacterEncoding("utf-8");

    //2.获取参数值
    String card=request.getParameter("card");
    String name=request.getParameter("name");

    //3.封装
    Cards cards =new Cards(card,name);

    //4.业务
    CardsServer  server =new CardsServer();

    //5.调用方法
    int count =server.add(cards);

    //判断
    if(count>0){
        response.sendRedirect("wangyin.html");
    }else{
        response.sendRedirect("zhuce.html");
    }

%>