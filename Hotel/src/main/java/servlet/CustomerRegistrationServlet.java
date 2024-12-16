package servlet;

import java.io.IOException;

import bean.CustomerBean;
import dao.CustomerRegitrationDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/reg")
public class CustomerRegistrationServlet extends HttpServlet 
{
      @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    	 
    	  
    	     Long id=Long.parseLong(req.getParameter("id"));
    	     String name=req.getParameter("name");
    	     String add=req.getParameter("add");
    	     Long phone=Long.parseLong(req.getParameter("phone"));
    	     
    	     CustomerBean cb=new CustomerBean();
    	     cb.setId(id);
    	     cb.setName(name);
    	     cb.setAddress(add);
    	     cb.setPhone(phone);
    	     
    	     int k=new CustomerRegitrationDAO().register(cb);
    	     
    	     if(k>0)
    	     {
    	    	 req.setAttribute("msg", "Regitration successful...");
    	    	 req.getRequestDispatcher("RegSuccess.jsp").forward(req, res);  
    	     }
    	     else
    	     {
    	    	 req.setAttribute("msg", "Regitration unsuccessful...");
    	    	 req.getRequestDispatcher("Msg.jsp").forward(req, res);
    	     }

    }
}
