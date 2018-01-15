<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/1/13
  Time: 19:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>context 对象监听器</title>
</head>
<body>
    <%
        application.setAttribute("name","aqie");    // 增加
        application.setAttribute("name","aqie123"); // 修改
        application.removeAttribute("name");        // 删除
    %>
</body>
</html>
