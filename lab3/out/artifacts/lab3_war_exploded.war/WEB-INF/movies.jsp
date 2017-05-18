<%--
  Created by IntelliJ IDEA.
  User: marcin
  Date: 29.03.17
  Time: 00:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
    <title>Filmy</title>
</head>
<body>
<jsp:useBean id="filmy" class="pl.basistam.movies.Movies" scope="application"/>

<p>Lista filmów</p>
<br><br>
<table border="1">
    <tr>
        <th><b>Tytuł</b></th>
        <th><b>Gatunek</b></th>
        <th><b>Rok</b></th>
        <th><b>Dochód</b></th>
    </tr>

    <c:forEach var="movie" items="${ filmy.movies }">
        <tr>
            <th><c:out value="${movie.title}"/> </th>
            <c:choose>
                <c:when test="${movie.type eq \"wojenny\"}">
                    <th bgcolor="#00bfff">
                        <c:out value="${movie.type}"/>
                    </th>
                </c:when>
                <c:otherwise>
                    <th>
                        <c:out value="${movie.type}"/>
                    </th>
                </c:otherwise>
            </c:choose>
            <th><c:out value="${movie.year}"/></th>
            <th><fmt:formatNumber value="${movie.income}" type="currency"/></th>
        </tr>
    </c:forEach>
</table>
</body>
</html>
