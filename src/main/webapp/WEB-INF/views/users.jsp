<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Ivan_Diachuk
  Date: 4/21/2017
  Time: 2:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Users</title>
</head>
<body>
<center><h1>USERS</h1></center>

<c:forEach var="user" items="${users}">
    <div>
        User:
        <c:out value="${user.name}"/><br>
        <c:out value="${user.id}"/><br>
        <a href="edit/${user.id}">
        <button>Edit</button>
        </a>
        <hr>
    </div>
</c:forEach>

<a href="register">
    <button>Register</button>
</a>

</body>
</html>
