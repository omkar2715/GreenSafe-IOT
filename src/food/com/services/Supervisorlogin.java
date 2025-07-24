package food.com.services;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class Supervisorlogin
 */
public class Supervisorlogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Supervisorlogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String email,pwd;
		email = request.getParameter("Email");
	    pwd = request.getParameter("Password");
	    PrintWriter pw=response.getWriter();
	    Connection Con= ConnectionDB.getCon();
	    try
	    {
	    	PreparedStatement ps = Con.prepareStatement("select * from supervisor where Email=? and Password=?");
	    	ps.setString(1, email);
			ps.setString(2, pwd);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				
		       String Email=rs.getString("Email");
		       UserInfo .setEmail(Email);
		       int Id=rs.getInt("Id");
		       UserInfo.setId(Id);
		       pw.println("<script type=\"text/javascript\">");
			    pw.println("alert('Login Successful');");
				pw.println("</script>");
				RequestDispatcher rd=request.getRequestDispatcher("supervisorDashboard.html");
				rd.include(request, response);
			}
			else
			{
				 pw.println("<script type=\"text/javascript\">");
					pw.println("alert('Login Failed');");
					pw.println("</script>");
					RequestDispatcher rd=request.getRequestDispatcher("supervisor.html");
					rd.include(request, response);
			}
		
	    }
	    catch(Exception e)
	    {
	    e.printStackTrace();
	    }
				
	}
}
				
			
			
	    
		
	
	