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
String password=request.getParameter("pwd");
String email=request.getParameter("email");
String mobileno=request.getParameter("phno");
String address=request.getParameter("address");

try {
	
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con=DriverManager.getConnection("jdbc:Oracle:thin:@localhost:1521:xe","nagaraju","welcome");
	
	PreparedStatement ps=con.prepareStatement("update empusers set password=?, email=?, mobilenumber=?, address=? where user_name=?");
	ps.setString(5, user_name);
	ps.setString(1, password);
	ps.setString(2, email);
	
	ps.setString(3, mobileno);

	ps.setString(4, address);
	
	int i=ps.executeUpdate();
	
	if(i==1) {
		out.println("user updated succesfully");
	}else {
		out.println("check username");
	}
	
}
catch(Exception e) {
	out.println(e);
}

 %>

</body>
</html>