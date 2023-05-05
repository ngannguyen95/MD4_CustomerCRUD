<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2023/05/04
  Time: 16:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/customer" method="post">

    <table>
        <tr>
            <th>Name</th>
            <th>Email</th>
            <th>Address</th>
        </tr>
        <tr>
            <td ><input type="text" name="name"></td>
            <td ><input type="text" name="email"></td>
            <td ><input type="text" name="address"></td>
        </tr>
    </table>
    <br>
    <input type="submit" name="action" value="CREATE">
</form>

</body>
</html>
