<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/1/22
  Time: 17:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>部门列表 条件查询</title>
</head>
<body>
    <form action="${pageContext.request.contextPath }/pagination/department" method="post">
        <table align="center" width="600px">
            <tr>
                <td>
                    部门名称： <input type="text" size="8" name="name" value="${param['name'] }" />
                    负责人： <input type="text" size="8" name="leader" value="${param['leader'] }"/>
                    职能：<input type="text" size="10" name="function" value="${param['function'] }"/>
                    <input type="submit" value="搜索"/>
                </td>
            </tr>
        </table>
    </form>
    <table align="center" border="1" width="600px">
        <tr>
            <th>编号</th>
            <th>部门名称</th>
            <th>负责人</th>
            <th>部门职能</th>
        </tr>
        <c:forEach items="${list}" var="dept">
            <tr>
                <td>${dept.id }</td>
                <td>${dept.name }</td>
                <td>${dept.leader }</td>
                <td>${dept.function }</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
