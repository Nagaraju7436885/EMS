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
 * Servlet implementation class EMPUPDATE
 */
@WebServlet("/EMPUPDATE")
public class EMPUPDATE extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EMPUPDATE() {
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
			System.out.println(e);
		}
	}

}
