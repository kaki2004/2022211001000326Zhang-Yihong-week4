<%--
  Created by IntelliJ IDEA.
  User: j
  Date: 2024/3/20
  Time: 23:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>UserData Display</title>
</head>
<body>
<h1>UserData Information</h1>
<p>ID: ${user.Id}</p>
<p>Username: ${user.Username}</p>
<p>Password: ${user.Password}</p>
<p>Email: ${user.email}</p>
<p>Gender: ${user.gender}</p>
<p>Birthday: ${user.birthday}</p>
</body>
</html>
