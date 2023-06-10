<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Seleziona Clienti</title>
</head>
<body>

<%

	Class.forName("com.mysql.cj.jdbc.Driver");

	try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels")){
		String sql = "SELECT customerName FROM customers WHERE city='San francisco'";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();
		if(rs.next() == false){
			out.println("Nessun record presente");
		}
		
		else {
			
			<table>
				<tr>
					<td>Nome Cliente</td>
				</tr>
				
				<% do{ %>
				
				<tr>
					<td> <%= rs.getString(1) %></td>
				</tr>
			} while(rs.next()); 
			</table>
		} %>
		
		}
	} catch(SQLException e) {
		e.printStackTrace();
	}
	
%>

</body>
</html>