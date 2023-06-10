<%@ page import="com.example.preverifica.db.DatabaseManager" %>
<%@ page import="com.example.preverifica.entity.Dipendente" %><%--
  Created by IntelliJ IDEA.
  User: s.buzzi
  Date: 18/04/2023
  Time: 09:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>get dipendenti by qualifica</title>
</head>
<body>

<form action="getDipendenteByQualifica.jsp" method="get">

  <label for="qualifica">Inserisci la qualifica del dipendente</label>
  <input type="text" name="qualifica" id="qualifica" required >

  <input type="submit" value="Cerca">

</form>
<a href="index.jsp">Ritorna indietro</a> <br>

<%
  String qualifica;
  try {
    qualifica = request.getParameter("qualifica");
    if(qualifica == null) {
      return;
    }
  } catch (Exception e) {
    e.printStackTrace();
    out.println("Errore nella form. Dati sbagliati");
    return;
  }

  DatabaseManager databaseManager = new DatabaseManager();
  for(Dipendente dipendente : databaseManager.findDipendentiByQualifica(qualifica)) {
    out.println("<p>");
    out.println(dipendente);
    out.println("</p>");
    out.println("<br><br>");
  }

%>
</body>
</html>
