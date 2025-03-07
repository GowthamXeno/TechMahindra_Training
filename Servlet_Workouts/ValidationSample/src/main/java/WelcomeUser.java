import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WelcomeUser extends HttpServlet { 
 
 public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
 {

	 response.setContentType("text/html"); 
    PrintWriter pwriter = response.getWriter(); 
 
    String name=request.getParameter("uname"); 
    pwriter.print("Hello "+name+"!");
    pwriter.print(" Welcome to Beginnersbook.com");
    }
 }
