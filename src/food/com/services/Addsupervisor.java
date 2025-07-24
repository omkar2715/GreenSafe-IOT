package food.com.services;
import java.util.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class Addsupervisor
 */
public class Addsupervisor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Addsupervisor() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String name,address,email,password,contact;
		
		name=request.getParameter("Name");
		address=request.getParameter("Address");
		email=request.getParameter("Email");
		password=request.getParameter("Password");
		contact=request.getParameter("Contact");
		
		try{
			Connection Con= ConnectionDB.getCon();
			PreparedStatement ps2= Con.prepareStatement("insert into supervisor values(?,?,?,?,?,?)");
			ps2.setLong(1, 0);
			ps2.setString(2,name);
			ps2.setString(3,address);
			ps2.setString(4,email);
		    ps2.setString(5,password);
			ps2.setString(6,contact);
			int i=ps2.executeUpdate();
	        if(i>0)
	        {
	        	System.out.println("welcome");
	        response.sendRedirect("AdminDashboard.html");
	        }
	        else{
	        	System.out.println("Hi");
	        	response.sendRedirect("AddSupervisor.html");
	        }
			
			}
		catch(Exception e){
		
		e.printStackTrace();
	
		
		}
  }

}
	
	


