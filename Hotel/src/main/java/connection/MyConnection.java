package connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class MyConnection 
{
   static Connection con=null;
    
    static
    {
    	try
    	{
    		Class.forName(DBInfo.driver);
    	con=	DriverManager.getConnection(DBInfo.url,DBInfo.user,DBInfo.pass);
    	}catch(Exception e)
    	{
    	   e.printStackTrace();
    	}
    }
    
    public static Connection getMyConnection()
    {
    	return con;
    }
}
