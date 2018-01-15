<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/1/15
  Time: 11:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
    <title>日期国际化</title>
</head>
<body>
<%--生成一个当前日期的时间对象--%>
<jsp:useBean id="now" class="java.util.Date" scope="page"></jsp:useBean>
    <%
        // value :需要转换的日期时间值
        //    type:选择日期或者时间,或者日期时间生效
    %>
    <fmt:formatDate value="${now}" dateStyle="full" timeStyle="long" type="both"></fmt:formatDate>
</body>
</html>
