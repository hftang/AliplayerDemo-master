<%--
  Created by IntelliJ IDEA.
  User: hftang
  Date: 2018/8/23
  Time: 上午11:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>第二种struts的访问方式</title>
</head>
<body>

<form action="${pageContext.request.contextPath}/request_second.action" method="post">

    用户：<input type="text" name="username"/><br>
    密码：<input type="password" name="pwd"/><br>
    <input type="submit" value="提交">


</form>


</body>
</html>
