<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<form method="post">
    <c:choose>
        <c:when test="${empty sessionScope.user}">
            <c:if test="${not empty sessionScope.error}">
                <font color="red">${sessionScope.error}</font><br>
            </c:if>
            Login: <input type="text" name="nick"/><br/>
            Password: <input type="password" name="password"/><br/>
            <br/><br/>
            <button type="submit" name="btnLogin">Log in!</button>
        </c:when>
        <c:otherwise>
            Witaj ${sessionScope.user}<br/>
            <button type="submit" name="btnLogout">Wyloguj</button>
        </c:otherwise>
    </c:choose>
</form>