<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/12/28
  Time: 16:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${empty sessionScope.user}">
  <c:redirect url="${pageContext.request.contextPath}/login.html"></c:redirect>
</c:if>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  hello world <br>
  欢迎回来,${sessionScope.user}
  </body>
</html>
