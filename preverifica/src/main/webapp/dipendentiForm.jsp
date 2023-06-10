<%@ page import="com.example.preverifica.db.DatabaseManager" %>
<%@ page import="com.example.preverifica.entity.Dipendente" %><%--
  Created by IntelliJ IDEA.
  User: s.buzzi
  Date: 18/04/2023
  Time: 08:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dipendenti form</title>
</head>
<body>

<form action="dipendentiForm.jsp" method="post">

    <label for="cognome">Cognome</label>
    <input type="text" id="cognome" name="cognome" required><br>
    <label for="nome">Nome</label>
    <input type="text" id="nome" name="nome" required><br>
    <label for="qualifica">Qualifica</label>
    <input type="text" id="qualifica" name="qualifica" required><br>
    <label for="codice_dipartimento">Codice dipartimento</label>
    <input type="number" id="codice_dipartimento" name="codice_dipartimento" required> <br>

    <br>

    <input type="submit" value="Invia">
</form>
<a href="index.jsp">Ritorna indietro</a> <br>

<%
    String cognome;
    String nome;
    String qualifica;
    String codiceDipartimento;

    try {
        cognome = request.getParameter("cognome");
        nome = request.getParameter("nome");
        qualifica = request.getParameter("qualifica");
        codiceDipartimento = request.getParameter("codice_dipartimento");

        if(cognome == null || nome == null || qualifica == null || codiceDipartimento == null) {
            return;
        }

    } catch(Exception e ){
        e.printStackTrace();
        out.println("Errore nella form. Dati non corretti");
        return;
    }

    DatabaseManager databaseManager = new DatabaseManager();
    Dipendente dipendente = new Dipendente(cognome, nome, qualifica, Integer.parseInt(codiceDipartimento));

    boolean result = databaseManager.addDipendente(dipendente);
    if(result) out.println("Dipendente inserito con successo");
    else out.println("Dipendente NON inserito. codice dipartimento sbagliata?");

%>

</body>
</html>
