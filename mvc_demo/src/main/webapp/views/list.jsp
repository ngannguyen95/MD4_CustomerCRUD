<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2023/05/04
  Time: 14:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1 style="text-align: center; color: blue"> CUSTOMER MANAGE</h1>
<table border="1" style="width: 100%">
    <tr>
        <th>STT</th>
        <th>Name</th>
        <th>Email</th>
        <th>Address</th>
        <th colspan="3">Action</th>
    </tr>
    <c:forEach items='${requestScope["listCustomer"]}' var="ctm">
        <tr>
            <td>${ctm.getId()}</td>
            <td>${ctm.getName()}</td>
            <td>${ctm.getEmail()}</td>
            <td>${ctm.getAddress()}</td>
            <td><a href="/customer?action=detail&id=${ctm.getId()}">Watch</a></td>
            <td><a href="/customer?action=edit&id=${ctm.getId()}">Edit</a></td>
            <td><a href="/customer?action=delete&id=${ctm.getId()}">Delete</a></td>
        </tr>
    </c:forEach>
        <a href="/customer?action=ADD">Create</a>
</table>
</body>
</html>
