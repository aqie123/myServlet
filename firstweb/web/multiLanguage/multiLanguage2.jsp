<%@ page import="java.util.ResourceBundle" %>
<%@ page import="java.util.Locale" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/1/15
  Time: 9:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
    <title>character</title>
</head>
<body>
<fmt:setBundle basename="MultiLanguage/message"/>
    <fmt:message key="username"></fmt:message> ：<input type="text" name="username">
    <fmt:message key="password"></fmt:message> ：<input type="text" name="password">
</body>
</html>
