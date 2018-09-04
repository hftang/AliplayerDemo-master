<%--
  Created by IntelliJ IDEA.
  User: hftang
  Date: 2018/8/24
  Time: 下午1:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>结果页</title>
</head>
<body>

<s:debug></s:debug>

<s:property value="kk.name"></s:property>


<s:property value="list[0].name"></s:property></
<br/>
<s:property value="list[0].age"></s:property>
<br/>


<s:property value="list[1].name"></s:property></
<br/>
<s:property value="list[1].age"></s:property>
<br/>


<s:property value="list[2].name"></s:property></
<br/>
<s:property value="list[2].age"></s:property>
<br/>

<h6>--------</h6>
<s:property value="#request.name"></s:property></<br>
<s:property value="#session.name"></s:property></<br>
<s:property value="#application.name"></s:property></<br>

<s:property value="#attr.name"></s:property></<br>
<s:property value="#parameters.id"></s:property>


<h4> 使用# 构建 list</h4>


<s:iterator var="i" value="{'aaa','bbb','ccc'}">

    <s:property value="i"></s:property>
    ====
    <s:property value="#i"></s:property>

</s:iterator>


<h4> 使用# 构建 map</h4>

<s:iterator value="#{'aa':'111','bb':'222','cc':'333'}">

    <s:property value="key"></s:property> ---
    <s:property value="value"></s:property></<br>


</s:iterator>


<hr>

<s:radio list="{'男','女'}" name="sex" label="性别">
</s:radio>

<hr>

<s:radio list="#{'1':'女','2':'男'}" label="性别" name="sex"></s:radio>

<h3>%的强制解析ognl的使用</h3>

<%

    request.setAttribute("name", "hftang");

%>

姓名：<s:textfield name="name" value="%{#request.name}"></s:textfield>


</body>
</html>
