import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/GetUrlParameterServlet")
public class GetUrlParameterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    protected void doGet(HttpServletRequest request, 
         HttpServletResponse response)
                  throws ServletException, IOException {
    response.setContentType("text/html"); 
        PrintWriter out = response.getWriter();

//get parameters from request object.
        String userName = request.getParameter("userName").trim();
        String password = request.getParameter("password").trim();
        
        out.println("Username: " + userName + "");
        out.println("Password: " + password);       
        out.close();   
        }}