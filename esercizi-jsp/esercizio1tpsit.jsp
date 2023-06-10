<%@ page language="java" %> <%@ page import="java.util.*" %> <%@ page
contentType="text/html; charset=UTF-8" %>

<html>
  <head>
    <title>esercizio1tpsit</title>
  </head>
  <body>
    <table border="1" align="center">
      <tr>
        <td>Numeri da 1 a 10</td>
        <td>I quadrati della tabella</td>
      </tr>
      <tr>
        <td><% for(int i=0; i<10; i++) { %>
                <%= i %>
            <% } %></td>

            <td>
                <% for(int i=0; i<10; i++) { %>
                    <%= i*i %>
                    <% } %>
            </td>
      </tr>
    </table>
  </body>
</html>
