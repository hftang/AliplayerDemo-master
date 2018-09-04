<%--
  Created by IntelliJ IDEA.
  User: hftang
  Date: 2018/8/24
  Time: 上午9:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<s:property value="'struts'.length()"></s:property>

<h1>调用静态方法</h1>
<s:property value="@java.lang.Math@random()"></s:property>
</body>
</html>
