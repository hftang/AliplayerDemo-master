<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="com.huafeng.bean.User" %>


<%--
  Created by IntelliJ IDEA.
  User: hftang
  Date: 2018/8/9
  Time: 上午9:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

1、先放入值：

<%
    pageContext.setAttribute("name", "pageContext");
    request.setAttribute("name", "request");
    session.setAttribute("name", "session");
    application.setAttribute("name", "application");
%>

2、取出值：
<%= pageContext.getAttribute("name")%><br>
<%= request.getAttribute("name")%><br>
<%= session.getAttribute("name")%><br>
<%= application.getAttribute("name")%><br>

3. EL表达式的方式：<<br>

${pageScope.name}<br>
${requestScope.name}<br>
${sessionScope.name}<br>
${applicationScope.name}<br>

4.el 取数组里的数<<br>

<%
    String[] a = {"a", "b", "c", "d", "e", "f", "g"};

    session.setAttribute("arr", a);
%>

${sessionScope.arr[3]}

5.list集合中存取的情况

<%
    List list=new ArrayList();
    list.add("0");
    list.add("1");
    list.add("2");
    list.add("3");

    pageContext.setAttribute("list",list);
%>


在list中取出数据：<br>

${list[0]}
${list[1]}

6,map集合中存取数

<%
    Map map=new HashMap();
    map.put("name","hftang");
    map.put("age",100);
    map.put("height",188);

    pageContext.setAttribute("map",map);

%>

${map.name}
${map.age}
${map.height}

7,存对象 和 取对象的属性

<%
    User user = new User("hftang", 30);

    pageContext.setAttribute("u",user);


%>

取出的值为：

${
 u.name
}



</body>
</html>
