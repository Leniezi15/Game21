<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Game 21</title>
</head>
<body>

<%
    Integer playerScoreStr = (Integer) request.getAttribute("playerScore");
    Integer pcScoreStr = (Integer) request.getAttribute("pcScore");
    int playerScore = playerScoreStr == null ? 0 : (playerScoreStr);
    int pcScore = pcScoreStr == null ? 0 : (pcScoreStr);

    boolean playerWin = request.getAttribute("playerWin") != null;
    boolean pcWin = request.getAttribute("pcWin") != null;
%>
<div style="padding: 5px">
    <form method=POST action="/" style="margin: 5px">
        <p>Очки игрока: <%= playerScore %> <%= playerWin ? "<span style='color:red'>Winner</span>" : "" %>
        </p>

        <p>Очки сервера: <%= pcScore %> <%= pcWin ? "<span style='color:red'>Winner</span>" : "" %>
        </p>
        <input type="hidden" name="playerScore" value="<%= playerScore %>"/>
        <input type="hidden" name="pcScore" value="<%= pcScore %>"/>

        </br>
        <button type="submit" name="take" value="Взять карту">Взять карту</button>
        <button type="submit" name="pass" value="Пасс">Пасс</button>
        <button type="submit" name="restart" value="Начать заново">Начать заново
        </button>
    </form>
</div>
</body>
</html>
