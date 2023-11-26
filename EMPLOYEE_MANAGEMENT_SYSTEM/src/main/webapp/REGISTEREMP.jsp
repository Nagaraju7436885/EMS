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

String user_name=request.getParameter("uname");
String email=request.getParameter("email");
String password=request.getParameter("pwd");
String gender=request.getParameter("gender");
String phno=request.getParameter("phno");
String state=request.getParameter("state");
String country=request.getParameter("country");
String address=request.getParameter("address");


 try {
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:Oracle:thin:@localhost:1521:xe","nagaraju","welcome");
		
		PreparedStatement ps=con.prepareStatement("insert into empusers values(?,?,?,?,?,?,?,?)");
		ps.setString(1, user_name);
		ps.setString(2, password);
		ps.setString(3, email);
		ps.setString(4, gender);
		ps.setString(5, phno);
	    ps.setString(6, state);
	    ps.setString(7, country);
		ps.setString(8, address);
		
		int i=ps.executeUpdate();
		
		if(i==1) {
			out.println("user registered succesfully");
		}else {
			out.println("user registered failed");
		}
		
	}
	catch(Exception e) {
		out.println(e);
	}

 %>

</body>
</html>