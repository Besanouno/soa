<%--
  Created by IntelliJ IDEA.
  User: marcin
  Date: 29.03.17
  Time: 09:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<html>
<head>
    <title>Sklep internetowy</title>
</head>
<body>
<jsp:useBean id="basket" class="pl.basistam.shop.Basket" scope="session"/>
<c:import var="data" url="/products.xml"/>
<x:parse xml="${data}" var="products"/>
<form method=post action="basket.do">
    <button type="submit">Koszyk</button>
</form>
<p> Produkty: </p>
<br>
<table border="1">
    <tr>
        <th>Nazwa</th>
        <th>Cena</th>
        <th>Dodaj do koszyka</th>
    </tr>
    <x:forEach var="part" select="$products/computerParts/part">
        <tr>
            <td><x:out select="name"/></td>
            <td><x:out select="price"/></td>
            <form method=post action="basket.do">
                <td align="center"><button name="add" value="<x:out select="name"/>" type="submit">+</button></td>
            </form>
        </tr>
    </x:forEach>
</table>
</body>
</html>
