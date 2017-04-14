<%--
  Created by IntelliJ IDEA.
  User: Ivan_Diachuk
  Date: 4/14/2017
  Time: 3:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>TweetsPage</title>
</head>
<body>


<h1> Hi ALL!</h1>

${2+2}

<c:forEach var="tweet" items="${allTweets}">
    <c:out value="${tweet}"/>
</c:forEach>


</body>
</html>
