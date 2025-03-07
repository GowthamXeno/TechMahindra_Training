package Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyFirstServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.setContentType("text/html");      
	       PrintWriter pwriter = response.getWriter();    
	       pwriter.println("<html><body>");
	       pwriter.println("<h2>Html file from Servlet!</h2>");
	       pwriter.println("</body></html>");
	}
}
