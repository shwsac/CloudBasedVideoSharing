package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manager.RDSManager;


public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public UpdateServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String rate = request.getParameter("rate");
		String fileName = request.getParameter("fileName");
		System.out.println("rate: "+rate+" fileName: "+fileName);
		
		//todo update in RDS
		RDSManager rdsManager = new RDSManager();
		int rating = 0;
		try
		{
			rating = Integer.parseInt(rate);
			rdsManager.updateRating(fileName, rating);
			rdsManager.close();
		}
		catch(Exception e)
		{
			System.out.println("Invalid rating");
		}		
		response.sendRedirect("list.jsp");
	}

}
