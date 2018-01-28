<%@ page import="java.util.Random" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/1/26
  Time: 14:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>易付宝支付</title>
</head>
<body>
    <form action="${pageContext.request.contextPath }/pay" method="post">
        订单号： <input type="text" name="orderNo" value="<%=new Random().nextInt(100000) %>"/><br/>
        支付金额： <input type="text" name="amount" /><br/>
        选择支付的银行：工行银行<input type="radio" name="bank" value="ICBC-NET"/><br/>
        <input type="submit" value="支付"/>
    </form>
</body>
</html>
