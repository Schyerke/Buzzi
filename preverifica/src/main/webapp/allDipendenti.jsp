<%@ page import="com.example.preverifica.entity.Dipendente" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.preverifica.db.DatabaseManager" %><%--
  Created by IntelliJ IDEA.
  User: s.buzzi
  Date: 18/04/2023
  Time: 08:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tutti i dipendenti</title>
</head>
<body>

<a href="index.jsp">Ritorna indietro</a> <br>

<%
    DatabaseManager databaseManager = new DatabaseManager();
    List<Dipendente> dipendenteList = databaseManager.findAllDipendenti();

    for(Dipendente dipendente : dipendenteList) {
        out.println("<p>");
        out.println(dipendente);
        out.println("</p>");
        out.println("<br><br>");
    }
%>

</body>
</html>
