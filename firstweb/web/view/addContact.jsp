<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/1/10
  Time: 14:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加联系人</title>
</head>
<body>
<form action="${pageContext.request.contextPath }/contact/add" method="post">
    <table border="1" align="center" width="500px">
        <tr>
            <th>姓名</th>
            <td><input type="text" name="name"/><font color="red">${msg }</font></td>
        </tr>
        <tr>
            <th>性别</th>
            <td>
                <input type="radio" name="gender" value="1"/>男
                <input type="radio" name="gender" value="0"/>女
            </td>
        </tr>
        <tr>
            <th>电话</th>
            <td><input type="text" name="phone"/></td>
        </tr>
        <tr>
            <th>邮箱</th>
            <td><input type="text" name="email"/></td>
        </tr>
        <tr>
            <th>地址</th>
            <td><input type="text" name="address"/></td>
        </tr>
        <tr>
            <td colspan="2" align="center"><input type="submit" value="添加"/></td>
        </tr>
    </table>
</form>
</body>
</html>
