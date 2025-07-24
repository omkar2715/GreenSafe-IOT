package food.com.services;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Adminlogin
 */
public class Adminlogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Adminlogin() {
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
		String username = request.getParameter("Username");
		String pass = request.getParameter("Password");
	    PrintWriter pw=response.getWriter();

	if(username.equals("admin@gmail.com")&&pass.equals("admin"))
	{
		System.out.println("success");
		pw.println("<script type=\"text/javascript\">");
		pw.println("alert('Login Successful');");
		pw.println("</script>");
		RequestDispatcher rd=request.getRequestDispatcher("AdminDashboard.html");
		rd.include(request, response);
	}
	else
	{
		System.out.println("Failed");
		pw.println("<script type=\"text/javascript\">");
		pw.println("alert('Login Successful');");
		pw.println("</script>");
		RequestDispatcher rd=request.getRequestDispatcher("admin.html");
		rd.include(request, response);
	}
     
}

}
