<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Ivan_Diachuk
  Date: 4/20/2017
  Time: 7:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User page</title>
</head>
<body>
<h1>This is ${pageOwner.name} page!</h1>
<hr>

<c:forEach var="tweet" items="${timeline.tweets}">
    <c:out value="${tweet}"/>
</c:forEach>

</body>
</html>
