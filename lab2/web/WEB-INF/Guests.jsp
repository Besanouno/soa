<%--
  Created by IntelliJ IDEA.
  User: marcin
  Date: 23.03.17
  Time: 11:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Guests</title>
</head>
<body>
<form action method="post">
    Nick: <input type="text" name="nick"/><br/>
    Comment: <input type="text" name="comment"/><br/>
    <br/><br/>
    <button type="submit">Confirm</button>
</form>

<hr>
    <c:forEach items="${comments}" var="comment">
        <b>${comment.user}</b><br/>
         ${comment.content}
        <br/><br/>
    </c:forEach>
</body>
</html>
