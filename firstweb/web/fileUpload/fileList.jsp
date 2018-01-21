<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/1/21
  Time: 9:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>mysql文件上传列表</title>
</head>
<body>
    <h3>所有上传文件列表</h3>
    <table border="1px">
        <tr>
            <th>编号</th>
            <th>文件名</th>
            <th>大小</th>
            <th>类型</th>
            <th>上传时间</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${list}" var="bean" varStatus="varSta">
            <tr>
                <td>${varSta.count}</td>
                <td>${bean.name}</td>
                <td>${bean.size}</td>
                <td>${bean.type}</td>
                <td>${bean.addTime}</td>
                <td><a href="${pageContext.request.contextPath}/mysql/download?id=${bean.id}">下载</a></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
