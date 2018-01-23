<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/1/21
  Time: 15:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Employees List</title>
</head>
<body>
    <form id="queryForm" action="${pageContext.request.contextPath }/pagination/list" method="post">
        <%--当前页 --%>
        <input type="hidden" id="currentPage" name="currentPage" value="${pageBean.currentPage }"/>
        <%--每页显示记录数 --%>
        <input type="hidden" id="pageSizeId" name="pageSize" value="${pageBean.pageSize }"/>
        <table align="center" border="1" width="800px">
            <tr>
                <td>
                    姓名： <input type="text" name="name" value="${param['name'] }"/>
                    性别：
                    <input type="radio" name="gender" value="1"/>男
                    <input type="radio" name="gender" value="0"/>女
                    职位：<input type="text" name="title"/>
                    邮箱：<input type="text" name="email"/>
                    薪水： 从
                    <input type="text" size="3" name="beginSalary"/>
                    到
                    <input type="text" size="3" name="endSalary"/>
                    部门：
                    <select name="dpID">
                        <option value="0">不选</option>
                        <c:forEach items="${departments}" var="dept">
                            <option value="${dept.id }" <c:if test="${param['dpID']==dept.id }">selected="selected"</c:if>>${dept.name }</option>
                        </c:forEach>
                    </select>
                    <input type="submit" value="搜索"/>
                </td>
            </tr>
        </table>
    </form>
    <h1 style="text-align: center">pagination employee</h1>
    <table border="1px" align="center">
        <tr>
            <th>ID</th>
            <th>姓名</th>
            <th>性别</th>
            <th>职位</th>
            <th>邮箱</th>
            <th>薪水</th>
            <th>所在部门</th>
        </tr>
        <%--<c:forEach items="${employees}" var="bean" varStatus="varSta">--%>
        <c:forEach items="${pageBean.data}" var="bean" varStatus="varSta">
        <tr>
            <td>${varSta.count}</td>
            <td>${bean.getName()}</td>
            <td>${bean.getGender()}</td>
            <td>${bean.getPosition()}</td>
            <td>${bean.getEmail()}</td>
            <td>${bean.getSalary()}</td>
            <td>${bean.getDepartment().getName()}</td>
        </tr>
        </c:forEach>
        <%--
            如果当前页是首页,不能点击首页和上一页，
            如果当前页是末页,不能点击末页和下一页
         --%>
        <tr>
            <td align="center" colspan="6">
                <c:choose>
                    <c:when test="${pageBean.getCurrentPage()>pageBean.getFirstPage()}">
                        <a href="/pagination/list?currentPage=1">首页</a>${pageBean.getFirstPage()}&nbsp;
                        <a href="/pagination/list?currentPage=${pageBean.getPrePage()}">上一页</a>${pageBean.getPrePage()}&nbsp;
                    </c:when>
                    <c:otherwise>
                        <a >首页</a>${pageBean.getFirstPage()}&nbsp;
                        <a>上一页</a>${pageBean.getPrePage()}&nbsp;
                    </c:otherwise>
                </c:choose>
                <c:choose>
                    <c:when test="${pageBean.getCurrentPage()!=pageBean.getTotalPage()}">
                        <a href="/pagination/list?currentPage=${pageBean.getNextPage()}">下一页</a>${pageBean.getNextPage()}&nbsp;
                        <a href="/pagination/list?currentPage=${pageBean.getTotalPage()}">尾页</a>${pageBean.getTotalPage()}&nbsp;
                    </c:when>
                    <c:otherwise>
                        <a>下一页</a>${pageBean.getNextPage()}&nbsp;
                        <a >尾页</a>${pageBean.getTotalPage()}&nbsp;
                    </c:otherwise>
                </c:choose>

                总数量${pageBean.getTotalCount()}&nbsp;
                当前页${pageBean.getCurrentPage()}&nbsp;
                每页显示 <input type="text" size="2" value="${pageBean.getPageSize()}" onblur="changePageSize()" id="pagesize">&nbsp;
                跳转到 <input type="text" value="${pageBean.getCurrentPage()}" onblur="changeCurrentPage()" id="currentPage">
            </td>
        </tr>
    </table>

    <script>
        function changePageSize() {
            var pageSize = document.getElementById("pagesize").value;
            var reg = /^[1-9][0-9]?$/;
            if(!reg.test(pageSize)){
                alert("只能输入1-2位的数字");
                return;
            }
            //2.请求ListEmpServlet，同时发送参数(pageSize)
            var url = "${pageContext.request.contextPath}/pagination/list?pageSize="+pageSize;
            window.location.href=url;
        }
        function changeCurrentPage() {
            var currentPage = document.getElementById("currentPage").value;
            var reg = /^[1-9][0-9]?$/;
            if(!reg.test(currentPage)){
                alert("只能输入1-2位的数字");
                return;
            }
            /*如果输入的页码大于等于总页数*/
            var totalPage = "${pageBean.totalPage}";
            if(currentPage>totalPage){
                alert("已经超过总页数");
                return;
            }
            var url = "${pageContext.request.contextPath}/pagination/list?currentPage="+currentPage+"&pageSize=${pageBean.pageSize}";
            window.location.href=url;
        }

    </script>
</body>
</html>
