<%--
  Created by IntelliJ IDEA.
  User: hftang
  Date: 2018/8/23
  Time: 上午10:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>数据展示页面</title>
</head>
<body>

<h3>数据展示页面</h3>


<%--  //向里面放入数据
        context.put("requestapp", "requestValue");
        context.getSession().put("sessionapp", "sessionValue");
        context.getApplication().put("applicationapp", "applicationValue");
--%>

${requestapp}<br>
${sessionapp}<br>
${applicationapp}<br>


</body>
</html>
