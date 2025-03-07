import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Task4 extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html lang='en'>");
        out.println("<head><meta charset='UTF-8'><title>Custom Page</title></head>");
        out.println("<body>");
        out.println("<header><h1>Hello from the Java Servlet!</h1></header>");
        out.println("<section><p>This page is dynamically generated using a servlet.</p></section>");
        out.println("</body>");
        out.println("</html>");
    }
}
