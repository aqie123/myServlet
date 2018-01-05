<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/1/5
  Time: 7:46
  To change this template use File | Settings | File Templates.
--%>
<%@
        page contentType="text/html;charset=UTF-8" language="java"
             isErrorPage="true"
%>
<html>
<head>
    <title>全局错误页面</title>
</head>
<body>
    <h3>出错啦！</h3>
<%=exception.getMessage()%>
</body>
</html>
