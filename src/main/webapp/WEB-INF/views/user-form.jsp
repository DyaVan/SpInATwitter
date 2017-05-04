<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Register</title>
</head>
<body>

<form method="POST">
    <c:choose>
        <c:when test="${mode eq 'edit'}">
            <h1> Edit user ${user.name}</h1>
        </c:when>
        <c:otherwise>
            <h1>Register</h1>
        </c:otherwise>
    </c:choose>

Username: <input type="text" name="name" value="${user.name}"/>
Password: <input type="password" name="password" value="${user.password}"/><br/>

<c:choose>
    <c:when test="${mode eq 'edit'}">
        <input type="submit" value="Edit" />
    </c:when>
    <c:otherwise>
        <input type="submit" value="Register" />
    </c:otherwise>
</c:choose>


</form>

</body>
</html>