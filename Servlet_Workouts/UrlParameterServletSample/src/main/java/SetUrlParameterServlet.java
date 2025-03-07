import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SetUrlParameterServlet")
public class SetUrlParameterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
protected void doPost(HttpServletRequest request, 
    HttpServletResponse response)
                throws ServletException, IOException {
    response.setContentType("text/html"); 
        PrintWriter out = response.getWriter();
        
        //get parameters from request object.
        String userName = request.getParameter("userName").trim();
        String password = request.getParameter("password").trim();

//check for null and empty values.
        if(userName == null || userName.equals("") || 
                password == null || password.equals("")){
            out.print("Please enter both username and " +
                    "password. <br><br>");
            RequestDispatcher requestDispatcher = 
                request.getRequestDispatcher("/index.html");

requestDispatcher.include(request, response);
        }//Check for valid username and password.
        else if(userName.equals("gowtham") && password.equals("xeno")){

out.println("Logged in successfully.<br>"); 
            out.println("Click on the below link to see " +
                   "the values of Username and Password.<br>");
            out.println("<a href=\"GetUrlParameterServlet?userName=&quot; +userName+&quot;&password=&quot;+password+&quot;\">Click here</a>");
}else{
         out.print("Wrong username or password. <br><br>");
         RequestDispatcher requestDispatcher = 
             request.getRequestDispatcher("/index.html");
         requestDispatcher.include(request, response);
     }    }}