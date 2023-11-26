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
 * Servlet implementation class EMPDELETE
 */
@WebServlet("/EMPDELETE")
public class EMPDELETE extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EMPDELETE() {
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
			System.out.println(e);
		}
	}

}
