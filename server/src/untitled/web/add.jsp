<%--
  Created by IntelliJ IDEA.
  User: hftang
  Date: 2018/8/14
  Time: 下午3:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加学生</title>
</head>
<body>

<h3>添加学生表</h3>

<form action="/add_servlet" method="post">

    <table align="center" border="1">
        <tr>
            <td>姓名</td>
            <td><input type="text" name="sname"/></td>
        </tr>

        <tr>
            <td>性别</td>
            <td><input name="gender" type="radio" value="男"/>男
                <input name="gender" type="radio" value="女"/>女
            </td>
        </tr>

        <tr>
            <td>电话</td>
            <td><input type="text" name="phone"></td>
        </tr>

        <tr>
            <td>生日</td>
            <td><input name="birthday" type="text"/></td>
        </tr>

        <tr>
            <td>爱好</td>
            <td>
                <input type="checkbox" name="hobby" value="游泳">游泳
                <input type="checkbox" name="hobby" value="篮球">篮球
                <input type="checkbox" name="hobby" value="足球">足球
                <input type="checkbox" name="hobby" value="看书">看书
                <input type="checkbox" name="hobby" value="写字">写字

            </td>
        </tr>

        <tr>
            <td>简介</td>
            <td><textarea name="info" rows="3" cols="20"></textarea></td>
        </tr>

        <tr>
            <td colspan="2"><input type="submit" value="提交"></td>
        </tr>


    </table>
</form>
</body>
</html>
