<%@ page import="java.util.List" %>
<%@ page import="sjc.entity.Userinfo" %><%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2020/11/30
  Time: 11:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
    <style type="text/css">
        <!--
        .style1 {
            color: #000066;
            font-weight: bold;
        }
        .style2 {color: #FF0000}
        -->
    </style>

    <script type="text/javascript" src="webjars/jquery/3.5.1/jquery.min.js"></script>
    <script type="text/javascript" src="js/listUsers.js"></script>
</head>
<body bgcolor="#CCCCFF">
<%
    response.setHeader("Pragma","No-cache");
    response.setHeader("Cache-Control","no-cache");
    response.setDateHeader("Expires",0);
    response.flushBuffer();
%>
<table width="490" border="0" align="center">
    <tr>
        <td align="center"><img src="image/header.gif" width="468" height="60"></td>
    </tr>
    <tr>
        <td align="center"> 【<a href="all.do">用户管理</a>】【<a href="listNews.html">新闻管理</a>】【商铺管理】【论坛管理】【<a href="welcome.html">网站首页</a>】</td>
    </tr>
</table>
<br>
<table width="350" border="0" align="center" cellpadding="0" cellspacing="0">
    <tr>
        <td height="54" align="center"><span class="style1"><font size="7"><b><font face="华文彩云" size="6" color="#666699">用户列表显示：</font></b></font></span></td>
    </tr>
    <tr>
        <td>
            <table width="100%" border="1" align="center" bordercolor="#660033" bgcolor="#99CCCC" cellspacing="1">
                <tr align="center">
                    <td width="25%">编号</td>
                    <td width="40%">用户名</td>
                    <td>用户密码</td>
                </tr>
                <%--循环--%>
                <%--items是集合： ${list}是servlet中保存的数据  var变量名--%>
               <c:forEach items="${lists}" var="user">
                <tr align="center">
                    <td width="25%"><a href="userInfo.jsp?id=${user.id}&uname=${user.username}&upwd=${user.password}">${user.id}</a></td>
                    <td width="40%">${user.username}</td>
                    <td>${user.password}</td>
                </tr>

               </c:forEach>
            </table></td>
    </tr>
    <tr>
        <td align="right">
            第${pageInfo.currentPage}/${pageInfo.totalPage}页&nbsp;&nbsp;
            <%--begin=1 end=3--%>
            <c:forEach begin="1" end="${pageInfo.totalPage}" var="i">
                <a href="all.do?pageIndex=${i}">${i}</a>
            </c:forEach>

            &nbsp;&nbsp;

            <%--下拉列表--%>   <!-- 判断是否是选择的当前页=1 被选中 -->
            <select id="selectPage" >
                 <c:forEach begin="1" end="${pageInfo.totalPage}" var="pageIndex">
                     <c:choose>
                          <c:when test="${pageInfo.currentPage eq pageIndex}">
                             <option value="${pageIndex}" selected>${pageIndex}</option>
                          </c:when>
                          <c:otherwise>
                              <option value="${pageIndex}">${pageIndex}</option>
                          </c:otherwise>
                     </c:choose>
                 </c:forEach>
                </select>页

                &nbsp;&nbsp;

            跳转至
            <input type="text" name="pageIndex" id="inputPage"
                   value="${pageInfo.currentPage}" style="width:35px;"/>页

            &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;
            <a href="all.do?pageIndex=1">首页</a>||
            <%--<a href="all.do?pageIndex=${pageInfo.currentPage-1}">上页</a>||--%>
            <%--<a href="all.do?pageIndex=${pageInfo.currentPage+1}">下页</a>||--%>
            <a href="all.do?pageIndex=${pageInfo.currentPage-1<1?(1):(pageInfo.currentPage-1)}">上页</a>||
            <a href="all.do?pageIndex=${pageInfo.currentPage+1>pageInfo.totalPage?(pageInfo.totalPage):(pageInfo.currentPage+1)}">下页</a>||
            <a href="all.do?pageIndex=${pageInfo.totalPage}">末页</a>
        </td>
    </tr>
    <tr>
        <td align="center" height="40"><span class="style2">权利保留！！！</span></td>
    </tr>
</table>
</body>
</html>

<script type="text/javascript">

    $(function(){
        $("#inputPage").blur(function(){
           //输入数字
            var id= $(this).val();
            // alert(id);
            var regexp = /^[1-9]\d*$/;
            var totalPage =${pageInfo.totalPage} ;
            if (id == "") {
                alert("请输入跳转的页数！");
                return false;
            } else if (!regexp.test(id)) {
                alert("请输入正确的数字！");
                return false;
            } else if ((id - totalPage) > 0) {
                alert("总页码是" + totalPage + "页，请重新输入！");
                return false;
            } else {
                //跳转到servlet处理
                document.location.href="all.do?pageIndex="+id;
            }

        });
    });
</script>