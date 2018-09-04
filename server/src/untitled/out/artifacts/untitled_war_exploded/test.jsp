<%@ page import="com.hftang.bean.TestBean" %><%--
  Created by IntelliJ IDEA.
  User: hftang
  Date: 2018/8/15
  Time: 下午4:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    TestBean testBean = new TestBean();
    testBean.setName("是");
    session.setAttribute("bean", testBean);
%>

</body>
</html>
