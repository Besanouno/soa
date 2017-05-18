<%@ page import="java.util.Random" %>
<%@ page import="static java.lang.System.out" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Zgadnij numer!</title>
</head>
<body>

<%
    boolean beginning = session.isNew();
    int attempts = 0;
    int number;

    if (beginning) {
        number = new Random().nextInt(100);
        session.setAttribute("number", number);
        session.setAttribute("attempts", attempts);
    } else {
        number = (int) session.getAttribute("number");
        attempts = (int) session.getAttribute("attempts");
    }

    String guess = request.getParameter("guess");
    String message = "";
    int guessAsInt = -1;
    if (!beginning) {
        try {
            guessAsInt = Integer.parseInt(guess);
        } catch (NumberFormatException e) {
            message = guess + " nie jest poprawnym numerem";
            return;
        }

        attempts++;
        session.setAttribute("attempts", attempts);
    }
        if (guessAsInt == number) {
            session.invalidate();
    %>
        Poprawny numer! Zajęło to <%= attempts %> prób!";
        <form method="post">
            <input type="submit" value="Zagraj ponownie!";/>
        </form>
    <%
        } else  {
            if (guessAsInt != -1) {
                if (guessAsInt > number) {
                    message = "Podana liczba jest zbyt duża! Dotychczasowe Próby: " + attempts;
                } else if (guessAsInt < number) {
                    message = "Podana liczba jest zbyt mała! Dotychczasowe Próby: " + attempts;
                }
            }
            %>
        <form method="post" action="game.do">
            Podaj liczbę: <input type="text" name="guess"/>
            <button type="submit">Zgaduj!</button>
            <br>
            <%= message != "" ? message + ". " : "" %>
        </form>
<%
    }
    %>

</body>
</html>
