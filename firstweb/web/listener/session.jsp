<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/1/14
  Time: 9:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" session="true" %>
<html>
<head>
    <title>session监听器</title>
</head>
<body>
    <%
        // 设置过期时间 秒
       // session.setMaxInactiveInterval(20);
        session.setAttribute("name","aqie");    // 添加
        session.setAttribute("name","aqie123"); // 修改
        session.removeAttribute("name");
    %>
    session的jsp页面
    当前访客人数：${applicationScope.count}
</body>
</html>
