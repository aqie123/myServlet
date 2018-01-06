<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/1/5
  Time: 13:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EL执行表达式</title>
</head>
<body>
    <%
        int a = 10;
        int b = 5;
        String name = "";
        pageContext.setAttribute("a",a);
        pageContext.setAttribute("b",b);
        pageContext.setAttribute("name",name);
    %>

    ${a+b} <br>
    ${a>b} <br>
    ${true&&true} <br>
    ${name == null} <br>
    ${empty name} <br>

</body>
</html>
