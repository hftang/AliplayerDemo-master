<%--
  Created by IntelliJ IDEA.
  User: hftang
  Date: 2018/8/16
  Time: 上午9:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页</title>
</head>
<body>

<form action="/login" method="post">

    用户名：<input type="text" name="username"><br>
    密 码：<input type="password" name="pwd"><br>
    <input type="checkbox" name="login_auto"> 自动登录
    <input type="submit" value="登录">


</form>

</body>
</html>
