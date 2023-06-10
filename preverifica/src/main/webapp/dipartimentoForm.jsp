<%@ page import="com.example.preverifica.db.DatabaseManager" %>
<%@ page import="com.example.preverifica.entity.Dipartimento" %><%--
  Created by IntelliJ IDEA.
  User: s.buzzi
  Date: 18/04/2023
  Time: 08:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dipartimento form</title>
</head>
<body>

<form action="dipartimentoForm.jsp" method="post">

    <label for="descrizione">Descrizione</label>
    <input type="text" id="descrizione" name="descrizione" required><br>

    <br>

    <input type="submit" value="Invia">
</form>

<a href="index.jsp">Ritorna indietro</a> <br>

<%
    String descrizione;

    try {
        descrizione = request.getParameter("descrizione");

        if(descrizione == null) {
            return;
        }

    } catch(Exception e ){
        e.printStackTrace();
        out.println("Errore nella form. Dati non corretti");
        return;
    }

    DatabaseManager databaseManager = new DatabaseManager();
    Dipartimento dipartimento = new Dipartimento(descrizione);

    boolean result = databaseManager.addDipartimento(dipartimento);
    if(result)
        out.println("Dipartimento inserito con successo");
    else
        out.println("Dipartimento NON inserito. Errore nel database");

%>

</body>
</html>
