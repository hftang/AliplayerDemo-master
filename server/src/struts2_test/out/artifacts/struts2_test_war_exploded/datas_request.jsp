<%--
  Created by IntelliJ IDEA.
  User: hftang
  Date: 2018/8/23
  Time: 下午1:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>数据请求页面</title>
</head>
<body>
<%-- private String name;
    private Integer age;
    private Date birthday;
    private double salary;--%>

<h3>${pageContext.request.contextPath}  是什么</h3>

<form action="${pageContext.request.contextPath}/request_datas.action" method="post">


    用户名：<input type="text" name="name"/><br/>
    密码：<input type="text" name="age"/><br/>
    生日：<input type="text" name="birthday"/><br/>
    工资：<input type="text" name="salary"/><br/>
    <input type="submit" value="提交">


</form>

</body>
</html>
