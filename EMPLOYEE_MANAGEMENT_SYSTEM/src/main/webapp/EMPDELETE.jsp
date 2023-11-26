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
 
String mobileno=request.getParameter("phno");


try {
	
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con=DriverManager.getConnection("jdbc:Oracle:thin:@localhost:1521:xe","nagaraju","welcome");
	
	PreparedStatement ps=con.prepareStatement("delete from empusers where mobilenumber=?");
	
	ps.setString(1, mobileno);
	
	
	int i=ps.executeUpdate();
	
	if(i==1) {
		out.println("user deleted succesfully");
	}else {
		out.println("check mobile number once");
	}
	
}
catch(Exception e) {
	out.println(e);
}
 
  %>

</body>
</html>