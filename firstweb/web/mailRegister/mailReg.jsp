<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/1/28
  Time: 13:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户邮箱注册</title>
</head>
<body>
    <form action="${pageContext.request.contextPath }/mailReg" method="post">
        用户名：<input type="text" name="name">
        密码：<input type="password" name="password">
        邮箱：<input type="text" name="email">
        <input type="submit" value="邮箱注册">
    </form>
</body>
</html>
