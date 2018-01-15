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
    <title>文字国际化</title>
</head>
<body>
<%
    // 读取用户浏览器带来的语言环境
    Locale locale = request.getLocale();
    ResourceBundle bundle = ResourceBundle.getBundle("MultiLanguage/message", locale);
    // ResourceBundle bundle = ResourceBundle.getBundle("MultiLanguage/message", Locale.US);
%>
<%=new String(bundle.getString("username").getBytes("ISO8859-1"),"GB2312")%>：<input type="text" name="username">
<%=new String(bundle.getString("password").getBytes("ISO8859-1"),"GB2312")%>：<input type="text" name="password">
</body>
</html>
