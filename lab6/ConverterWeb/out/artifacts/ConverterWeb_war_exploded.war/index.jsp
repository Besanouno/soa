<%--
  Created by IntelliJ IDEA.
  User: marcin
  Date: 02.05.17
  Time: 13:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form action="converter" method="get">
    Podaj temperature:<input type="text" value="temp"/>
    <br/>
    Opcje sortowania:
    <select>
      <option value="c2f">C -> F</option>
      <option value="f2c">F -> C</option>
    </select>
    <br>
    <button type="submit">Przelicz</button>
  </form>
  </body>
</html>
