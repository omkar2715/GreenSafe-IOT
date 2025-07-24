package food.com.services;
import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionDB {
	
	static Connection Con = null;
	public static Connection getCon()
		{
			try
			{
				
			if(Con==null)
			{
			Class.forName("com.mysql.cj.jdbc.Driver");
			 Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/food_temp","root","");
			}
		}
		catch(Exception e)
			{
			e.printStackTrace();
			
			}
			return Con;
		}
	}



