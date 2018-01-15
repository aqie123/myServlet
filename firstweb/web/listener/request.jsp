<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/1/13
  Time: 19:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>请求监听器</title>
</head>
<body>
<h1>显示用户IP</h1>
    <h3>您的IP地址为：${sessionScope.myip} </h3>
    <%
        request.setAttribute("name","aqie呀");
        request.setAttribute("name","啊切");
        request.removeAttribute("name");
    %>
</body>
</html>
