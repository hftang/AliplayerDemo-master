<%--
  Created by IntelliJ IDEA.
  User: hftang
  Date: 2018/8/23
  Time: 下午4:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>商品列表</title>

    <form action="${pageContext.request.contextPath}/product_action.action" method="post">
        产品名称： <input type="text" name="list[0].name"/></br>
        产品价格： <input type="text" name="list[0].price"/></br>

        产品名称： <input type="text" name="list[1].name"/></br>
        产品价格： <input type="text" name="list[1].price"/></br>

        产品名称： <input type="text" name="list[2].name"/></br>
        产品价格： <input type="text" name="list[2].price"/></br>

        <input type="submit" value="提交">

    </form>


</head>
<body>

</body>
</html>
