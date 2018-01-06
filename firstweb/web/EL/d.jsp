<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/1/5
  Time: 13:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EL  11个内置对象</title>
</head>
<body>

    <%--pageContext 等价于jsp pageContext--%>
    <%=pageContext.getRequest()%> <br>

    <%--获取上下文路径--%>
    ${pageContext.request.contextPath} <br>

    <%--获取参数 http://localhost:8080/EL/d.jsp?name=aqie&name=toby --%>
    <%=request.getParameter("name")%> <br>
    <%=request.getParameterValues("name")[1]%> <br>
    <%--param 返回所有参数的集合--%>
    ${param['name']}<br>
    ${paramValues['name'][0]}<br>

    <%--获取请求头--%>
    <%=request.getHeader("host")%><br>
    <%=request.getHeaders("host").nextElement()%><br>
    ${header['host']}<br>
    ${headerValues['host'][0]}<br>

    <%--获取cookie--%>
    <%=request.getCookies()[3].getValue()%><br>
    <%=request.getCookies()[3].getName()%><br>

    ${cookie['Phpstorm-d94e29df'].name}------${cookie['Phpstorm-d94e29df'].value}<br>


    <%--获取全局参数--%>
    <%=application.getInitParameter("AAA")%><br>
    ${initParam['BBB']}
</body>
</html>
