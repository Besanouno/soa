<%--
  Created by IntelliJ IDEA.
  User: marcin
  Date: 23.03.17
  Time: 08:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<font color="red">${ErrorMessage}</font>

<form action method="post">
    Login: <input type="text" name="login"/><br/>
    Password: <input type="password" name="pass"/><br/>
    <br/><br/>
    <button type="submit">Log in!</button>
</form>
</body>
</html>
