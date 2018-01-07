<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/1/6
  Time: 15:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="aqie" uri="http://www.aqie.com" %>
<html>
<head>
    <title>获取ip地址</title>
</head>
<body>
    <%--<%
        String ip = request.getRemoteHost();
        out.write("您的IP地址为 ："+ip);
    %>--%>
    <%--
        使用自定义标签代替上面脚本
        showIp标签:显示客户端IP地址
    --%>
    <aqie:showIp></aqie:showIp>

</body>
</html>
