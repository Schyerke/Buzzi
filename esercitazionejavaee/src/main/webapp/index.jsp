<%@ page import="java.lang.*"%>
<%@ page import="com.example.esercitazione.database.DatabaseManager" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.SQLException" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
    <title> Esercitazione </title>
</head>
<body>

<form action="index.jsp" method="get">
    <label for="userinput">Inserisci nome di un customer</label>
    <br>
    <input type="text" name="userinput" id="userinput">
    <br>

    <input type="submit" id="submit" value="Cerca">
</form>

<%
    String userinput = request.getParameter("userinput");

    if(userinput == null) {
        out.println("Non hai ancora inserito nessun nome!");
        return;
    }

    StringBuilder userMessage = new StringBuilder("Non ho trovato nessun customer con nome: " + userinput);

    DatabaseManager databaseManager = new DatabaseManager();
    try (ResultSet resultSet = databaseManager.queryCustomerByName(userinput)) {
        if(resultSet != null) {
            userMessage = new StringBuilder();
            while(resultSet.next()) {
                userMessage.append("Nome customer: ")
                        .append(resultSet.getString(1))
                        .append("<br>")
                        .append("Customer number: ")
                        .append(resultSet.getString(2))
                        .append("<br>")
                        .append("Customer phone: ")
                        .append(resultSet.getString(3))
                        .append("<br>");
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    out.println("<h1>");
    out.println(userMessage.toString());
    out.println("</h1>");
%>
</body>
</html>