<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/1/5
  Time: 11:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EL表达式学习</title>
</head>
<body>
    <%
        //String name = ;
        // 变量放入到域对象
        pageContext.setAttribute("name","aqie",PageContext.REQUEST_SCOPE);
    %>
    <%--<%=name%>--%>
    <br>
    EL表达式：
        ${name}
        ${requestScope.name}
    <br>
    <%=pageContext.findAttribute("name")%>
</body>
</html>
