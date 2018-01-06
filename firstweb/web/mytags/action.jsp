<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/1/6
  Time: 7:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>动作标签</title>
</head>
<body>
    <%--1.<jsp:forward/> 转发标签--%>
    <%--2.<jsp:param/>   参数标签--%>
    <%--<jsp:include/>  包含标签--%>
    <%--<jsp:forward page="/mytags/actionReceive.jsp">
        <jsp:param name="name" value="aqie"/>
        <jsp:param name="hobbies" value="ping-pang"/>
        <jsp:param name="hobbies" value="badminton"/>
    </jsp:forward>--%>
    <jsp:include page="/mytags/footer.jsp">
        <jsp:param name="name" value="aqie"/>
    </jsp:include>
</body>
</html>
