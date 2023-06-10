<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <jsp:useBean id="saluti" scope="session" class="beans.Saluti"/>
    <jsp:setProperty property="message" name="saluti"/>
   <!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Saluti</title>
</head>
<body>

<h1>Ciao!</h1>
<h2><%= saluti.getMessage() %></h2>

</body>
</html>