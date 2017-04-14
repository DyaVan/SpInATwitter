<%--
  Created by IntelliJ IDEA.
  User: Ivan_Diachuk
  Date: 4/14/2017
  Time: 4:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create User</title>
</head>
<body>


<form action="user/create" method="POST">
    <input type="number" name="id"/>
    <input type="text" name="name"/>
    <input type="submit" value="Create"/>
</form>

</body>
</html>
