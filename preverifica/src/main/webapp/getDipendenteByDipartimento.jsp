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
    <title>get dipendenti by dipartimento</title>
</head>
<body>

<form action="getDipendenteByDipartimento.jsp" method="get">

  <label for="id-dipartimento">Inserisci l'id del dipartimento</label>
  <input type="number" name="id-dipartimento" id="id-dipartimento" required >

  <input type="submit" value="Cerca">

</form>

<a href="index.jsp">Ritorna indietro</a> <br>

<%

  int id;
  try {
    String idDipartimento = request.getParameter("id-dipartimento");
    if(idDipartimento == null) {
      return;
    }

    id = Integer.parseInt(idDipartimento);
  } catch (NumberFormatException e) {
    e.printStackTrace();
    out.println("Errore nella form. Dati sbagliati");
    return;
  }

  DatabaseManager databaseManager = new DatabaseManager();
  for(Dipendente dipendente : databaseManager.findDipendentiByDipartimentoId(id)) {
    out.println("<p>");
    out.println(dipendente);
    out.println("</p>");
    out.println("<br><br>");
  }

%>

</body>
</html>
