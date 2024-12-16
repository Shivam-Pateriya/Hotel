package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import bean.CustomerBean;
import connection.MyConnection;

public class CustomerRegitrationDAO 
{ 
	
	public int k=0;
	
	  public int register(CustomerBean cb)
	  {
		  try
		  {
			   Connection con=MyConnection.getMyConnection();
			   
			  PreparedStatement ps= con.prepareStatement
			        ("insert into Customer34 values(?,?,?,?)");
			  
			  ps.setLong(1, cb.getId());
			  ps.setString(2, cb.getName());
			  ps.setString(3, cb.getAddress());
			  ps.setLong(4,cb.getPhone());
			  
		    	k=  ps.executeUpdate();
			  
		  }catch(Exception e)
		  {
			  e.printStackTrace();
		  }
		  return k;
	  }
	  

}
