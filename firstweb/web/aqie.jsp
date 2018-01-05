<%@ page import="java.util.Random" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/1/4
  Time: 17:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Aqie</title>
</head>
<body>
    <%--引入其他页面--%>
    <%@include file="header.jsp"%>
    <%
        String name = "aqie";
        int a = 10;
        int b = 20;
    %>
    <%--jsp表达式--%>
    <%=name %><br>
    <%=(a+b)%>
    <%--jsp脚本--%>
    <%
        Random random = new Random();
        float num = random.nextFloat();
        out.write("随机小数："+num);
    %>
    <%
        for (int i=1;i<=3;i++){
     %>
        <h2>循环</h2>
    <%
        }
    %>
    <%--九九乘法表--%>
    <%
        for(int i=1;i<10;i++){
            for(int j=1;j<=i;j++){
     %>
            <%=i %>*<%=j %>=<%=(i*j)%>
            <%}%>
    <br>
    <%
        }
    %>

    <%--jsp声明--%>
    <%!
        String email = "2924811900@qq.com";
        public void sayHello(){
            System.out.println("hello aqie");
        }
        // public void _jspInit(){};
    %>
    <%--JSP注释--%>
    <%--<jsp:forward page="/index.html"></jsp:forward>--%>

</body>
</html>
