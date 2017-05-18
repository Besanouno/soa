<%--
  Created by IntelliJ IDEA.
  User: marcin
  Date: 29.03.17
  Time: 09:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Basket</title>
</head>
<body>
<form method=post action="catalog.do">
    <button type="submit">Powrót do sklepu</button>
</form>
<jsp:useBean id="basket" class="pl.basistam.shop.Basket" scope="session"/>
<p>Koszyk</p>

<%
    if (request.getParameter("add") != null) {
        basket.add(request.getParameter("add"), 1);
    }
    else if (request.getParameter("inc") != null) {
        basket.increment(request.getParameter("inc"));
    }
    else if (request.getParameter("dec") != null) {
        basket.decrement(request.getParameter("dec"));
    }
%>
<% if (basket.getProducts().size() != 0) { %>
<table border="1">
    <tr>
        <th>Nazwa</th>
        <th>Ilosc</th>
        <th> </th>
        <th> </th>
    </tr>
<c:forEach var="product" items="<%= basket.getProducts() %>">
    <tr>
        <th><c:out value="${product.key}"/></th>
        <th><c:out value="${product.value}"/></th>
        <form method=post action="basket.do">
            <th><button name="inc" value="${product.key}" type="submit">+</button></th>
            <th><button name="dec" value="${product.key}" type="submit">-</button></th>
        </form>
    </tr>
</c:forEach>
</table>
<% } else { %>
    <br>
    Koszyk jest pusty!
<% } %>
</body>
</html>
