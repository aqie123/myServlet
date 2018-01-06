<%@ page import="login.User" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/1/5
  Time: 11:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EL表达式学习2</title>
</head>
<body>
    <%
        String email = "2924811900@qq.com";
        // 把数据放入域中
        pageContext.setAttribute("email",email);

        // 普通的对象
        User user = new User("1","啊切");
        pageContext.setAttribute("user",user);

        // 数组或List集合
        User[] users = new User[2];
        users[0] = new User("aqie");
        users[1] = new User("bqie");
        pageContext.setAttribute("users",users);

        // List 集合
        List<User> userList = new ArrayList<>();
        userList.add(users[0]);
        userList.add(users[1]);
        pageContext.setAttribute("userList",userList);

        // Map 集合
        Map<String,User> userMap = new HashMap<>();
        userMap.put("001",users[0]);
        userMap.put("002",users[1]);
        pageContext.setAttribute("userMap",userMap);
    %>
    普通字符串 ： ${email} <br>
    普通的对象 ： ${user} ${user.id} <br>
    users数组 ： ${users} <br>
    数组中第一个对象： ${users[0]} <br>
    List集合 ： ${userList[0]} <br>
    Map集合 ： ${userMap['001']}
</body>
</html>
