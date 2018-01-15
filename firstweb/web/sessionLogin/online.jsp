<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/1/14
  Time: 16:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Online User</title>
</head>
<body>

    <table border="1" width="600px">
        <tr>
            <th>编号</th>
            <th>登录名</th>
            <th>登录时间</th>
            <th>上次登陆时间</th>
            <th>登录IP</th>
            <th>操作</th>
        </tr>
        <%--<c:forEach items="${applicationScope.onLine}" var="entry" varStatus="varSta">--%>
        <c:forEach items="${requestScope.list}" var="bean" varStatus="varSta">
        <tr>
            <td>${varSta.count}</td>
            <td>${bean.name}</td>
            <td>${bean.loginTime}</td>
            <td>${bean.lastTime}</td>
            <td>${bean.ip}</td>
            <td><a href="${pageContext.request.contextPath}/session/kickOut?sessionID=${bean.sessionID}">踢出<</a></td>
        </tr>
        </c:forEach>
    </table>
</body>
</html>
