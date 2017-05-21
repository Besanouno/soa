<%@ page import="pl.basistam.model.Book" %>
<%@ page import="javax.ws.rs.HttpMethod" %><%--
  Created by IntelliJ IDEA.
  User: marcin
  Date: 21.05.17
  Time: 10:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Zapisz książkę</title>
</head>
<body>
<jsp:useBean id="library" class="pl.basistam.service.LibraryService" scope="application"/>

<%
    Book book;
    String passedId = request.getParameter("edit");
    if (passedId != null) {
        book = library.find(Long.parseLong(passedId));
    } else {
        book = new Book();
    }
%>

<form action="index.jsp" method="post">
    Tytuł: <input type="text" name="title" required="true" value="<%= book.getTitle() %>"/><br/>
    Autor: <input type="text" name="author" required="true" value="<%= book.getAuthor() %>"/><br/>
    Rok wydania: <input type="text" name="year" required="true" value="<%= book.getYear() %>"/><br/>
    Isbn: <input type="text" name="isbn" required="true" value="<%= book.getIsbn() %>"/><br/>
    Cena: <input type="text" name="price" required="true" value="<%= book.getPrice() %>"/><br/>
    <input name="id" type="hidden" value="<%= book.getId() %>"/>

    <button name="save" type="submit">Zapisz</button>
</form>
</body>
</html>
