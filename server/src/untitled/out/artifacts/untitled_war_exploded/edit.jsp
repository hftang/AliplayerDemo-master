<%--
  Created by IntelliJ IDEA.
  User: hftang
  Date: 2018/8/14
  Time: 下午3:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>更改学生信息</title>
</head>
<body>

<h3>更改学生信息</h3>

<form action="/update_servlet" method="post">

    <input type="hidden" name="sid" value="${student.sid}"/>

    <table align="center" border="1">
        <tr>
            <td>姓名</td>
            <td><input type="text" name="sname" value="${student.sname}"/></td>
        </tr>

        <tr>
            <td>性别</td>
            <td><input name="gender" type="radio" value="男" <c:if test="${student.gender=='男'}">checked</c:if>/>男
                <input name="gender" type="radio" value="女" <c:if test="${student.gender=='女'}">checked</c:if>/>女
            </td>
        </tr>

        <tr>
            <td>电话</td>
            <td><input type="text" name="phone" value="${student.phone}"></td>
        </tr>

        <tr>
            <td>生日</td>
            <td><input name="birthday" type="text" value="${student.birthday}"/></td>
        </tr>

        <tr>
            <td>爱好</td>
            <td>
                <input type="checkbox" name="hobby" value="游泳"
                       <c:if test="${fn:contains(student.hobby,'游泳' )}">checked</c:if>>游泳
                <input type="checkbox" name="hobby" value="篮球"
                       <c:if test="${fn:contains(student.hobby,'篮球' )}">checked</c:if>>篮球
                <input type="checkbox" name="hobby" value="足球"
                       <c:if test="${fn:contains(student.hobby,'足球' )}">checked</c:if>>足球
                <input type="checkbox" name="hobby" value="看书"
                       <c:if test="${fn:contains(student.hobby,'看书' )}">checked</c:if>>看书
                <input type="checkbox" name="hobby" value="写字"
                       <c:if test="${fn:contains(student.hobby,'写字' )}">checked</c:if>>写字

            </td>
        </tr>

        <tr>
            <td>简介</td>
            <td><textarea name="info" rows="3" cols="20">${student.info}</textarea></td>
        </tr>

        <tr>
            <td colspan="2"><input type="submit" value="更改"></td>
        </tr>


    </table>
</form>
</body>
</html>
