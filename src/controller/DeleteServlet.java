package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manager.AmazonS3Manager;
import manager.RDSManager;


public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public DeleteServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String fileName = request.getParameter("fileName");
		//delete object from S3 
		AmazonS3Manager s3Manager = new AmazonS3Manager();
		s3Manager.deleteObject(fileName);
		
		//delete object from RDS
		RDSManager rdsManager = new RDSManager();
		rdsManager.deleteObject(fileName);
		rdsManager.close();
		
		response.sendRedirect("list.jsp");
	}

}
