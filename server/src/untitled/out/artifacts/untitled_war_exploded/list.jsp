<%--
  Created by IntelliJ IDEA.
  User: hftang
  Date: 2018/8/14
  Time: 下午1:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

<html>
<head>
    <title>展示页面</title>
</head>
<script type="text/javascript">
    function doDelete(sid) {

        var flag = confirm("确定要删除吗？");

        if (flag) {
            window.location.href = "/delete_servlet?sid=" + sid;
        }
    }

</script>
<body>

<form method="post" action="/query">

    <table border="1" align="center">

        <%--添加--%>

        <tr>
            <td colspan="8">


                按姓名查询：<input type="text" name="sname" value="${name}"/>
                按性别查询：<select name="sgender">
                <option value="---请选择---">---请选择---
                <option value="男" <c:if test="${gender=='男'}">selected</c:if>>男
                <option value="女" <c:if test="${gender=='女'}">selected</c:if>>女


            </select>

                <input type="submit" value="查询">

                <a href="add.jsp">添加</a>
            </td>

        </tr>

        <tr align="center">
            <td>编号</td>
            <td>姓名</td>
            <td>性别</td>
            <td>电话</td>
            <td>生日</td>
            <td>爱好</td>
            <td>简介</td>
            <td>操作</td>
        </tr>


        <c:forEach var="item" items="${list}">

            <tr align="center">
                <td>${item.sid}</td>
                <td>${item.sname}</td>
                <td>${item.gender}</td>
                <td>${item.phone}</td>
                <td>${item.birthday}</td>
                <td>${item.hobby}</td>
                <td>${item.info}</td>

                <td><a href="/servlet_edit?sid=${item.sid}">更新</a>|<a href="#" onclick="doDelete(${item.sid})">删除</a>
                </td>


            </tr>


        </c:forEach>
    </table>
</form>
</body>
</html>
