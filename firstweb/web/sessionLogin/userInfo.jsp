<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/1/14
  Time: 13:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户详情页</title>
</head>
<body>
<h2>欢迎回来,${sessionScope.name}</h2>
<a href="${pageContext.request.contextPath}/session/logout">安全退出</a>
<a href="${pageContext.request.contextPath}/session/getOnline">查看在线登录用户</a>
</body>
</html>
