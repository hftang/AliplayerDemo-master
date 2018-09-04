<%--
  Created by IntelliJ IDEA.
  User: hftang
  Date: 2018/8/23
  Time: 下午5:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<title>商品列表</title>

<form action="${pageContext.request.contextPath}/get_map_action.action" method="post">
    产品名称： <input type="text" name="map['one'].name"/></br>
    产品价格： <input type="text" name="map['one'].price"/></br>

    产品名称： <input type="text" name="map['two'].name"/></br>
    产品价格： <input type="text" name="map['two'].price"/></br>

    产品名称： <input type="text" name="map['three'].name"/></br>
    产品价格： <input type="text" name="map['three'].price"/></br>

    <input type="submit" value="提交">

</form>


</body>
</html>
