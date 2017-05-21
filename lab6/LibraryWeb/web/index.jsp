<%--
  Created by IntelliJ IDEA.
  User: marcin
  Date: 04.05.17
  Time: 14:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>$Title$</title>
</head>
<body>
<jsp:useBean id="library" class="pl.basistam.web.LibraryBean" scope="session"/>

<%
    if (request.getParameter("reserve") != null) {
        library.reserveBook(request.getParameter("reserve"));
    } else if (request.getParameter("loan") != null) {
        library.loanBook(request.getParameter("loan"));
    } else if (request.getParameter("return") != null) {
        library.returnBook(request.getParameter("return"));
    }
%>

<table border="1">
    <tr>
        <th>Tytuł</th>
        <th>Autorzy</th>
        <th>Isbn</th>
        <th></th>
        <th></th>
    </tr>
    <c:forEach var="book" items="<%= library.getIdleBooks() %>">
        <tr>
            <th>
                <c:forEach var="title" items="${book.titles}">
                    <c:out value="[${title.language}] ${title.name}"/><br/>
                </c:forEach>
            </th>
            <th>
                <c:forEach var="author" items="${book.authors}">
                    <c:out value="${author}"/><br/>
                </c:forEach>
            </th>
            <th><c:out value="${book.isbn}"/></th>
            <form method=post action="index.jsp">
                <th>
                    <button name="reserve" value="${book.isbn}" type="submit">Zarezerwuj</button>
                </th>
                <th>
                    <button name="loan" value="${book.isbn}" type="submit">Wypożycz</button>
                </th>
            </form>
        </tr>
    </c:forEach>
</table>
<br/><br/>
<table border="1">
    <tr>
        <th>Tytuł</th>
        <th>Autorzy</th>
        <th>Isbn</th>
        <th></th>
        <th></th>
    </tr>
    <c:forEach var="book" items="<%= library.getReservedBooks() %>">
        <tr>
            <th>
                <c:forEach var="title" items="${book.titles}">
                    <c:out value="[${title.language}] ${title.name}"/><br/>
                </c:forEach>
            </th>
            <th>
                <c:forEach var="author" items="${book.authors}">
                    <c:out value="${author}"/><br/>
                </c:forEach>
            </th>
            <th><c:out value="${book.isbn}"/></th>
            <form method=post action="index.jsp">
                <th>
                    <button name="return" value="${book.isbn}" type="submit">Anuluj</button>
                </th>
                <th>
                    <button name="loan" value="${book.isbn}" type="submit">Wypożycz</button>
                </th>
            </form>
        </tr>
    </c:forEach>
</table>
<br/><br/>
<table border="1">
    <tr>
        <th>Tytuł</th>
        <th>Autorzy</th>
        <th>Isbn</th>
        <th></th>
    </tr>
    <c:forEach var="book" items="<%= library.getLoanedBooks() %>">
        <tr>
            <th>
                <c:forEach var="title" items="${book.titles}">
                    <c:out value="[${title.language}] ${title.name}"/><br/>
                </c:forEach>
            </th>
            <th>
                <c:forEach var="author" items="${book.authors}">
                    <c:out value="${author}"/><br/>
                </c:forEach>
            </th>
            <th><c:out value="${book.isbn}"/></th>
            <form method=post action="index.jsp">
                <th>
                    <button name="return" value="${book.isbn}" type="submit">Zwróć</button>
                </th>
            </form>
        </tr>
    </c:forEach>
</table>

</body>
</html>
