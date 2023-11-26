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

String email=request.getParameter("email");
String password=request.getParameter("pwd");



try {
	
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con=DriverManager.getConnection("jdbc:Oracle:thin:@localhost:1521:xe","nagaraju","welcome");
	
	PreparedStatement ps=con.prepareStatement("select * from empusers where email=? and password=?");

	ps.setString(1, email);
	ps.setString(2, password);
	
	ResultSet rs=ps.executeQuery();
	
	
	
	if(rs.next()) {
		response.sendRedirect("emphome.jsp");
	}else {
		
		out.println("check email and password");
	}
	
}
catch(Exception e) {
	out.println(e);
}

  %>

</body>
</html>