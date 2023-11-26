<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%@ page import="java.sql.*" %>
<%

String user_name=request.getParameter("user_name");


try {
	
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con=DriverManager.getConnection("jdbc:Oracle:thin:@localhost:1521:xe","nagaraju","welcome");
	
	PreparedStatement ps=con.prepareStatement("select * from empusers where user_name=?");
	ps.setString(1, user_name);
	
	ps.executeUpdate();
	
	ResultSet rs=ps.executeQuery();
	
	
	
		while(rs.next()) {
			for(int i=1;i<=8;i++) {
				out.print(rs.getString(i)+" ");
			}
			out.println("<br>");
		}
	
}
catch(Exception e) {
	out.println(e);
}
 
 %>

</body>
</html>