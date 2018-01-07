<%@ page import="java.util.List" %>
<%@ page import="login.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/1/7
  Time: 15:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="aqie" uri="http://www.aqie.com" %>
<html>
<head>
    <title>foreach标签</title>
</head>
<body>
    <%
        List<User> list = new ArrayList<>();
        list.add(new User("aqie"));
        list.add(new User("bqie"));
        pageContext.setAttribute("list",list);

        Map<String,User> map = new HashMap<>();
        map.put("001",new User("啊切"));
        map.put("002",new User("啊切2"));
        map.put("003",new User("啊切3"));
        pageContext.setAttribute("map",map);
    %>

    <aqie:foreach items="${list}" var="user">
        姓名：${user.name}
    </aqie:foreach>
    <aqie:foreach items="${map}" var="entry">
    姓名：${entry.key}-${entry.value}
    </aqie:foreach>
</body>
</html>
