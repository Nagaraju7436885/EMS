package EMPLOYEE_MANAGEMENT_SYSTEM1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EMPSEARCH
 */
@WebServlet("/EMPSEARCH")
public class EMPSEARCH extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EMPSEARCH() {
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
			System.out.println(e);
		}
		
	}

}
