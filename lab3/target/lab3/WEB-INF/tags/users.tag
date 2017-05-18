<%@ tag import="pl.basistam.login.Session" %>
<%@ tag import="java.util.List" %>
<%@ tag import="pl.basistam.login.ActiveUsers" %>
<%@ tag import="java.util.Collection" %>
<%@ tag import="java.util.Collections" %>
<%@ tag import="java.util.Comparator" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ attribute name="order" required="true" %>
<%@ attribute name="color" required="false" %>
<%!
        List<Session> getSortedList(String order) {
                List<Session> sessions = ActiveUsers.getInstance().getUsers();
                if ("desc".equals(order)) {
                        Collections.sort(sessions, (o1, o2) -> o2.getNick().compareTo(o1.getNick()));
                } else {
                        Collections.sort(sessions, Comparator.comparing(Session::getNick));
                }
                return sessions;
        }
%>

<table border="1">
<tr>
        <th><b>Nick:</b></th>
        <th>Czas logowania:</th>
</tr>
<c:forEach var="session" items="<%= getSortedList(order) %>">
        <tr>
                <th><c:out value="${session.nick}"/></th>
                <th>
                <c:choose>
                        <c:when test="${not empty color}">
                                <font color="${color}"><c:out value="${session.loginDateTime}"/></font>
                        </c:when>
                        <c:otherwise>
                                <c:out value="${session.loginDateTime}"/>
                        </c:otherwise>
                </c:choose>
                </th>
        </tr>
</c:forEach>
</table>

