<%--
  Created by IntelliJ IDEA.
  User: hftang
  Date: 2018/8/9
  Time: 下午5:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>成员管理页面</h3>

<h5>成员列表</h5>

<c:forEach var="stt" items="${xx}">
    ${stt.name}
</c:forEach>

<table border="1" width="700">

    <tr>
        <td>编号</td>
        <td>姓名</td>
        <td>性别</td>
        <td>年龄</td>
        <td>住址</td>
    </tr>

    <c:forEach items="${xx}" var="student">
        <tr>
            <td align="center">${student.id}</td>
            <td>${student.name}</td>
            <td>${student.gender}</td>
            <td>${student.age}</td>
            <td>${student.address}</td>
        </tr>
    </c:forEach>



</table>


</body>
</html>
