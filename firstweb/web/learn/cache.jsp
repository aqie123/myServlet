<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/1/5
  Time: 10:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>测试缓存</title>
</head>
<body>
    <%
        out.write("123");
        System.out.println("当前缓存区大小："+out.getBufferSize()); // 8192
        System.out.println("缓存区剩余大小 ："+out.getRemaining()); // 8123  8126
        // 手动刷新、
        // out.flush();
        response.getWriter().write("abc");
    %>

    <%
        // 作用1. 获取其他八个对象
        out.write("相等:"+(pageContext.getRequest()== request)+"<br>");
        out.write("相等:"+(pageContext.getResponse()== response)+"<br>");
        // 作用2. 作为域对象 (默认保存到page域)
        pageContext.setAttribute("name","aqie");        // 保存数据
        String msg = (String)pageContext.getAttribute("name");
        out.print("作为域对象保存数据： "+msg);

        // 作用3. 保存到其他三个域中(request,session,application)
        pageContext.setAttribute("message","request's message",PageContext.REQUEST_SCOPE);
        // 等价 request.setAttribute("message","request's message");

        // 获取数据
        String message = (String)pageContext.getAttribute("message",PageContext.REQUEST_SCOPE);
        out.print("request 对象："+message);
    %>
</body>
</html>
