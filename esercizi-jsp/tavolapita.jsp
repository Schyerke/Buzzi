<%@ page language="java" %> <%@ page import="java.util.*" %> <%@ page
contentType="text/html; charset=UTF-8" %>

<html>
  <head>
    <title>Tavola pitagorica</title>
  </head>
  <body>
    <h1 style="text-align: center">Tavola pitagorica</h1>
    <table border="1" align="center">
      <% for(int i=0; i<10; i++) { %>
      <tr>
        <% for(int j=0; j<10; j++) { %>
        <td align="center"><%= i*j %></td>
        <% } %>
      </tr>
      <% } %>
    </table>
  </body>
</html>
