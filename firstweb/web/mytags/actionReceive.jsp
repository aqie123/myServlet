<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/1/6
  Time: 8:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>接收参数</title>
</head>
<body>
    接收参数：${param['name']}<br>
    接收多个同名参数 ${paramValues['hobbies'][0]}~~ ${paramValues['hobbies'][1]}
</body>
</html>
