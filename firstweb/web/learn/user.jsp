<%@ page import="java.util.List" %>
<%@ page import="login.User" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/1/5
  Time: 8:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>user列表</title>
</head>
<body>
    <table border="1" align="center" width="500px">
        <tr>
            <th>姓名</th>
        </tr>
        <%
            // request 域中获取list数据
            List<User> list = (List<User>) request.getAttribute("list");
            for(User user : list){
        %>
        <tr>
            <td><%=user.getName()%>
            </td>
        </tr>
        <%
            }
        %>
    </table>
</body>
</html>
