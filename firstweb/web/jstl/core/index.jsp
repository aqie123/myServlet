<%@ page import="login.User" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/1/6
  Time: 8:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>首页</title>
</head>
<body>

    <%
        // String name = "aqie";
        // pageContext.setAttribute("name",name);
    %>

    <%--<c:set var="name" value="aqie" scope="request"></c:set>--%>
    ${requestScope.name}

    获取域对象数据：<c:out value="${name}" default="<h3>默认值</h3>" escapeXml="false"></c:out>

    <%--<c:if test=""></c:if>--%>
    <c:if test="${10>8}">
        返回True <br>
    </c:if>

    <%--模拟登陆--%>
    <c:set var="user" value="aqie" scope="session"></c:set>

    <%--多条件判断  登录后把数据存放到session域--%>
    <c:choose>
        <c:when test="${!empty sessionScope.user}">
            欢迎回来,您的用户名为aqie <a href="">退出登录</a>
        </c:when>
        <c:otherwise>
            请先 <a href="">登录</a>  或 <a href="">注册</a>
        </c:otherwise>
    </c:choose>

    <%--迭代--%>
    <%
        List<User> userList = new ArrayList<>();
        userList.add(new User("aqie"));
        userList.add(new User("aqie123"));
        pageContext.setAttribute("userList",userList);

        // Map 集合
        Map<String,User> userMap = new HashMap<>();
        userMap.put("001",new User("啊切"));
        userMap.put("002",new User("啊切123"));
        pageContext.setAttribute("userMap",userMap);
    %>
    List集合：<br>
    <c:forEach begin="0" end="1" step="1" items="${userList}" var="user" varStatus="varSta">
        序号： ${varSta.index}姓名：${user.getName()} <br>
    </c:forEach>

    Map集合：<br>
    <c:forEach items="${userMap}" var="entry">
        编号：${entry.key}-${entry.value.getName()} <br>
    </c:forEach>

    <%--遍历特殊字符串--%>
    <c:set var="str" value="java-net-php-html"></c:set>
    <%
        String str = (String)pageContext.getAttribute("str");
        String[] strings = str.split("-");
        for (int i = 0;i<strings.length;i++){
            out.print(strings[i]+",");
        }
    %>

    <c:forTokens items="${str}" delims="-" var="s">
        ${s},
    </c:forTokens>

    <br>重定向：<br>
    <%
        // response.sendRedirect(request.getContextPath()+"/index.jsp");
    %>
    <c:redirect url="/index.jsp"></c:redirect>
    <script type="text/javascript">
        var u = navigator.userAgent;
        var isAndroid = u.indexOf('Android') > -1 || u.indexOf('Linux') > -1; //android终端或者uc浏览器
        var isiOS = !!u.match(/\(i[^;]+;( U;)? CPU.+Mac OS X/); //ios终端

        if(isAndroid) {
            android();
            function android() {
                alert("你是安卓");
                window.location.href = "openwjtr://com.tyrbl.wjtr";
                /***打开app的协议，有安卓同事提供***/
                window.setTimeout(function () {
                    window.location.href = "http://www.deweiyi.com/download/dwy.apk";
                    /***打开app的协议，有安卓同事提供***/
                }, 2000);
            }
        }
        if(isiOS){
            ios();
            function ios(){
                alert("你是iOS");
                var ifr = document.createElement("iframe");
                ifr.src = "openwjtr://com.lvqi.deweiyi"; /***打开app的协议，有ios同事提供***/
                ifr.style.display = "none";
                document.body.appendChild(ifr);
                window.setTimeout(function(){
                    document.body.removeChild(ifr);
                    window.location.href = "https://itunes.apple.com/us/app/%E5%BE%B7%E6%83%9F%E4%B8%80%E5%95%86%E5%9F%8E/id1254314870?l=zh&ls=1&mt=8"; /***下载app的地址***/
                },2000)
            }
        }
    </script>
</body>
</html>
