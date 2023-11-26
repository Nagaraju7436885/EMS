<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<center><h2>EMPLOYEE MANAGEMENT SYSTEM</h2></center>
        <center><a href="home.html" style="font-size: large;"><h4>Home</a> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;   <a href="login.html" style="font-size: large;">login</a> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;   <a href="register.html" style="font-size: large;">register</a>  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  <a href="contact.html" style="font-size: large;">contact</a></center>

      <center>  <div style="width: 340px; height:150px; border: 2px solid black;">
          
            <h3>View Your Details</h3>
            <form action="EMPSEARCH.jsp" method="post">
                Name : <input type="text" name="user_name"><br><br>
                <input type="submit" value="Search">
            </form>
            
            </div>
        </center>
        

</body>
</html>