package EMPLOYEE_MANAGEMENT_SYSTEM1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class REGISTEREMP
 */
@WebServlet("/REGISTEREMP")
public class REGISTEREMP extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public REGISTEREMP() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		
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
				System.out.println(e);
			}
		
	}

}
