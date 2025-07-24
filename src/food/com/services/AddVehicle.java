package food.com.services;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddVehicle
 */
public class AddVehicle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddVehicle() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);String name,vehicleno,contact;
		
		String lat=request.getParameter("lat");
		String lon=request.getParameter("lng");
		vehicleno=request.getParameter("vehicleno");
		name=request.getParameter("name");
		contact=request.getParameter("Contact");
	    PrintWriter pw=response.getWriter();

		try{
			Connection Con= ConnectionDB.getCon();
			PreparedStatement ps2= Con.prepareStatement("insert into vehicle_tbl values(?,?,?,?,?,?,?,?,?,?,?)");
			ps2.setLong(1, 0);
			ps2.setString(2,vehicleno);
			ps2.setString(3,name);
			ps2.setString(4,contact);
			ps2.setString(5,lat);
			ps2.setString(6,lon);
			ps2.setString(7,"0");
			ps2.setString(8,"0");
			ps2.setString(9,"0");
			ps2.setString(10,"0");
			ps2.setString(11,UserInfo.getEmail());
			int i=ps2.executeUpdate();
	        if(i>0)
	        {
	        	System.out.println("Added Successfully");
	        	pw.println("<script type=\"text/javascript\">");
	    		pw.println("alert('Added Successfully');");
	    		pw.println("</script>");
	    		RequestDispatcher rd=request.getRequestDispatcher("addVehicle.jsp");
	    		rd.include(request, response);
	        //response.sendRedirect("AdminDashboard.html");
	        }
	        else{
	        	System.out.println("Failed");
	        	pw.println("<script type=\"text/javascript\">");
	    		pw.println("alert('Failed to Add');");
	    		pw.println("</script>");
	    		RequestDispatcher rd=request.getRequestDispatcher("addVehicle.jsp");
	    		rd.include(request, response);
	        	//response.sendRedirect("AddSupervisor.html");
	        }
			
			}
		catch(Exception e){
		
		e.printStackTrace();
	
		
		}
  }

}
	