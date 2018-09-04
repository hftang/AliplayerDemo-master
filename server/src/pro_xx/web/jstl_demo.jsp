<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.huafeng.bean.User" %><%--
  Created by IntelliJ IDEA.
  User: hftang
  Date: 2018/8/9
  Time: 上午10:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    List list = new ArrayList();
    list.add(new User("lisi01", 101));
    list.add(new User("lisi02", 102));
    list.add(new User("lisi03", 103));
    list.add(new User("lisi04", 104));

    pageContext.setAttribute("list", list);
%>

<c:forEach var="item" items="${list}">

    ${item.name}--><br>
    ${item.age}---><br>

</c:forEach>

</body>
</html>
