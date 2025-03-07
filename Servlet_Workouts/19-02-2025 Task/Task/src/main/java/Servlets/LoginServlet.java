package Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println("username: " + username);
		System.out.println("password: " + password);
		PrintWriter writer = response.getWriter();
		String htmlRespone = "<html>";
		        htmlRespone += "<h2>Your username is: " + username + "<br/>";      
		        htmlRespone += "Your password is: " + password + "</h2></html>";    
		          writer.println(htmlRespone);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
