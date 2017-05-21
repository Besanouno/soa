<%@ page import="pl.basistma.beans.BookCreator" %>
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
<jsp:useBean id="library" class="pl.basistma.LibraryBean" scope="session"/>

<%
    if (request.getParameter("addNewBook") != null) {
        BookCreator bookCreator = new BookCreator(request.getParameter("author"),
                request.getParameter("title"),
                request.getParameter("language"),
                request.getParameter("isbn"));
        library.save(bookCreator.createBook());
    } else if (request.getParameter("reserve") != null) {
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
            <td>
                <c:forEach var="title" items="${book.titles}">
                    <c:out value="[${title.language}] ${title.name}"/><br/>
                </c:forEach>
            </td>
            <td>
                <c:forEach var="author" items="${book.authors}">
                    <c:out value="${author}"/><br/>
                </c:forEach>
            </td>
            <td><c:out value="${book.isbn}"/></td>
            <td>
                <form method=post action="index.jsp">
                    <button name="reserve" value="${book.isbn}" type="submit">Zarezerwuj</button>
                </form>
            </td>
            <td>
                <form method=post action="index.jsp">
                    <button name="loan" value="${book.isbn}" type="submit">Wypożycz</button>
                </form>
            </td>
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
            <td>
                <c:forEach var="title" items="${book.titles}">
                    <c:out value="[${title.language}] ${title.name}"/><br/>
                </c:forEach>
            </td>
            <td>
                <c:forEach var="author" items="${book.authors}">
                    <c:out value="${author}"/><br/>
                </c:forEach>
            </td>
            <td><c:out value="${book.isbn}"/></td>
            <td>
                <form method=post action="index.jsp">
                    <button name="return" value="${book.isbn}" type="submit">Anuluj</button>
                </form>
            </td>
            <td>
                <form method=post action="index.jsp">
                    <button name="loan" value="${book.isbn}" type="submit">Wypożycz</button>
                </form>
            </td>
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
            <td>
                <c:forEach var="title" items="${book.titles}">
                    <c:out value="[${title.language}] ${title.name}"/><br/>
                </c:forEach>
            </td>
            <td>
                <c:forEach var="author" items="${book.authors}">
                    <c:out value="${author}"/><br/>
                </c:forEach>
            </td>
            <td><c:out value="${book.isbn}"/></td>
            <td>
                <form method=post action="index.jsp">
                    <button name="return" value="${book.isbn}" type="submit">Zwróć</button>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
<hr>
<form method="post" action="index.jsp">
    Autor: <input name="author"/><br/>
    Tytuł: <input name="title"/>
    Język tytułu: <input name="language"/><br/>
    Isbn: <input name="isbn"/><br/>
    <button type="submit" name="addNewBook">Dodaj</button>
</form>
</body>
</html>
