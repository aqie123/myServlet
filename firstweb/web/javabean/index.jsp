<%@ page import="login.User" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/1/7
  Time: 16:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>操作javabean</title>
</head>
<body>
    <%
        /*User user = new User();
        user.setName("aqie");
        String  name = user.getName();*/
    %>
    <%--构造对象--%>
    <jsp:useBean id="user" class="login.User"></jsp:useBean>
    
    <%--给javabean对象赋值
        name:给哪个对象赋值
        property:对象赋值属性
        value:赋的值
    --%>
    <jsp:setProperty name="user" property="name" value="aqie"></jsp:setProperty>

    <%--获取javabean属性
        name:获取对象
        property:获取对象属性
    --%>
    <jsp:getProperty name="user" property="name"></jsp:getProperty>
</body>
</html>
