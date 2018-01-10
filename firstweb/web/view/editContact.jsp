<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/1/10
  Time: 14:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>编辑联系人</title>
</head>
<body>
<form action="${pageContext.request.contextPath }/contact/update" method="post">
    <input type="hidden" name="id" value="${contact.id }"/>
    <table border="1" align="center" width="500px">
        <tr>
            <th>姓名</th>
            <td><input type="text" name="name" value="${contact.name }" readonly="readonly"/></td>
        </tr>
        <tr>
            <th>性别</th>
            <td>
                <input type="radio" name="gender" value="1"  <c:if test="${contact.gender=='1' }">checked="checked"</c:if>  />男
                <input type="radio" name="gender" value="0"  <c:if test="${contact.gender=='0' }">checked="checked"</c:if> />女
            </td>
        </tr>
        <tr>
            <th>电话</th>
            <td><input type="text" name="phone" value="${contact.phone }"/></td>
        </tr>
        <tr>
            <th>邮箱</th>
            <td><input type="text" name="email" value="${contact.email }"/></td>
        </tr>
        <tr>
            <th>地址</th>
            <td><input type="text" name="address" value="${contact.address }"/></td>
        </tr>
        <tr>
            <td colspan="2" align="center"><input type="submit" value="修改"/></td>
        </tr>
    </table>
</form>
</body>
</html>
