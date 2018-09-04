<%--
  Created by IntelliJ IDEA.
  User: hftang
  Date: 2018/8/15
  Time: 下午5:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html>
<head>
    <title>结果页面</title>
</head>
<body>

<c:if test="${not empty user}">
    欢迎${user.name}
</c:if>

<c:if test="${empty user}">
    你还没有登录 ，请先登录！
</c:if>


</body>
</html>
