<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/1/5
  Time: 14:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>GuessNumber</title>
</head>
<body>
    <h3>GuessNumber</h3>
    <span style="color: red">${requestScope.msg}</span><br>
    Please input your lucky number(0-10): (${requestScope.answer})
    <form action="${pageContext.request.contextPath}/games/guessNumber" method="post">
        <input type="text" name="lucky">
        <input type="hidden" name="count" value="${requestScope.count}">
        <div>${requestScope.countMsg}</div>
        <br><br>
        <button>Submit</button>
    </form>
</body>
</html>
