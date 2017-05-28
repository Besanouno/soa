<%@ page import="pl.basistam.model.Book" %>
<%@ page import="java.math.BigDecimal" %>
<%@ page import="java.util.List" %>
<%@ page import="javax.ws.rs.HttpMethod" %><%--
  Created by IntelliJ IDEA.
  User: marcin
  Date: 21.05.17
  Time: 10:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<jsp:useBean id="library" class="pl.basistam.service.LibraryService" scope="application"/>

<%
    if ("POST".equals(request.getMethod())) {
        if (request.getParameter("delete") != null) {
            library.delete(Long.parseLong(request.getParameter("delete")));
        } else if (request.getParameter("save") != null) {
            Book book = Book.builder()
                    .title(request.getParameter("title"))
                    .price(new BigDecimal(request.getParameter("price")))
                    .isbn(request.getParameter("isbn"))
                    .author(request.getParameter("author"))
                    .year(Integer.parseInt(request.getParameter("year")))
                    .build();
            if (request.getParameter("id") != null && !"null".equals(request.getParameter("id").toLowerCase())) {
                book.setId(Long.parseLong(request.getParameter("id")));
            }
            library.save(book);
        }
    }
%>

<table border="1">
    <tr>
        <th>Tytuł</th>
        <th>Autor</th>
        <th>Isbn</th>
        <th>Rok wydania</th>
        <th>Cena</th>
        <th></th>
        <th></th>
    </tr>
    <c:forEach var="book" items="<%= library.getAll() %>">
        <tr>
            <th><c:out value="${book.title}"/></th>
            <th><c:out value="${book.author}"/></th>
            <th><c:out value="${book.isbn}"/></th>
            <th><c:out value="${book.year}"/></th>
            <th><c:out value="${book.price}"/></th>
            <th>
                <form action="bookEdit.jsp" method="post">
                    <button name="edit" value="${book.id}" type="submit">Edytuj</button>
                </form>
            </th>
            <th>
                <form action="index.jsp" method="post">
                    <button name="delete" value="${book.id}" type="submit">Usuń</button>
                </form>
            </th>
        </tr>
    </c:forEach>
</table>
<br/><br/>

<form action="bookEdit.jsp" method="post">
    <button name="add" type="submit">Dodaj</button>
</form>
</body>
</html>
