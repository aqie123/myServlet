<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/1/7
  Time: 14:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="aqie" uri="http://www.aqie.com" %>
<html>
<head>
    <title>choose标签</title>
</head>
<body>

    <aqie:choose>
        <aqie:when test="${1000-7<0}">
            condition establishment
        </aqie:when>
        <aqie:otherwise>
            Conditional failure
        </aqie:otherwise>
    </aqie:choose>
</body>
</html>
