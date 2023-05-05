<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2023/05/04
  Time: 18:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Customer Detail</h1><br>
<button><a href="customer">Back</a></button>
<table border="1" style="width: 100%" >
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Email</th>
        <th>Address</th>
    </tr>
    <tr>
        <td>${customer.getId()}</td>
        <td>${customer.getName()}</td>
        <td>${customer.getEmail()}</td>
        <td>${customer.getAddress()}</td>
    </tr>
</table>
</body>
</html>
