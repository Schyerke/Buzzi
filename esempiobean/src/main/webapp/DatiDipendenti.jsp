<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <jsp:useBean id="dipendente" scope="session" class="beans.DipendentiBean"/>
    <jsp:setProperty name="dipendenti" property="cognome" param="cognome"/>
    <jsp:setProperty name="dipendenti" property="nome" param="nome"/>
    <jsp:setProperty name="dipendenti" property="eta" param="eta"/>
    <jsp:setProperty name="dipendenti" property="oreLavorate" param="oreLavorate"/>
    <jsp:setProperty name="dipendenti" property="pagaOraria" param="pagaOraria"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<p>Dati dipendente: </p>
	
	<label for="cognome">Cognome</label>
	<jsp:getProperty property="cognome" name="dipendente"/>
	
	<label for="nome">Nome</label>
	<jsp:getProperty property="nome" name="dipendente"/>
	
	<label for="eta">Eta</label>
	<jsp:getProperty property="eta" name="dipendente"/>
	
	<label for="oreLavorate">Ore lavorate</label>
	<jsp:getProperty property="oreLavorate" name="dipendente"/>
	
	<label for="pagaOraria">Paga oraria</label>
	<jsp:getProperty property="pagaOraria" name="dipendente"/>
	
	<input type ="submit" value="Invia"/>
	
	<input type="reset" value="Cancella"/>
	
	<div>
		<h2>Paga Giornaliera</h2>
		<% out.println(dipendente.pagaGiornaliera(dipendente.getPagaOraria(), dipendente.getOreLavorate())); %>
	</div>

</body>
</html>