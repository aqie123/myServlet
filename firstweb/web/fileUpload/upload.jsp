<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/1/15
  Time: 11:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传</title>
</head>
<body>
<%--<form action="${pageContext.request.contextPath}/fileupload/single" method="post" enctype="multipart/form-data">--%>
<form action="${pageContext.request.contextPath}/fileupload/self" method="post" enctype="multipart/form-data">
<%--<form action="" method="post" enctype="multipart/form-data">--%>
    File Viewer <input type="file" name="attachment"> <br>
    File Viewer <input type="file" name="attachment2"> <br>
    File Name : <input type="text" name="name">
    <button type="submit">Upload</button>
</form>
</body>
</html>
