<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2023/05/04
  Time: 19:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="customer" method="post">
<table>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Email</th>
        <th>Address</th>
    </tr>
    <tr>
          <td><input readonly type=" text" name="id" value="${customerEdit.getId()}"></td>
          <td><input type=" text" name="name" value="${customerEdit.getName()}"></td>
        <td><input type="text" name="email" value="${customerEdit.getEmail()}"></td>
        <td><input type="text" name="address" value="${customerEdit.getAddress()}"></td>
    </tr>
</table>
<input type="submit" name="action" value="update">
</form>
</body>
</html>
