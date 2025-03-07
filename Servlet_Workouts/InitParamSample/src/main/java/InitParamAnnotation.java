import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
    urlPatterns = "/InitParamAnnotation",
    initParams = {
        @WebInitParam(name = "address", value = "Chennai"),
        @WebInitParam(name = "email", value = "abcd@gmail.com"),
        @WebInitParam(name = "phone", value = "9384564715")
    }
)
public class InitParamAnnotation extends HttpServlet {

    private String address;
    private String email;
    private String phone;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config); // Correct way to call parent init
        address = config.getInitParameter("address");
        email = config.getInitParameter("email");
        phone = config.getInitParameter("phone");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<html><body>");
        out.println("<h1>ServletConfig Example</h1>");
        out.println("<p>Address: " + address + "</p>");
        out.println("<p>Email: " + email + "</p>");
        out.println("<p>Phone: " + phone + "</p>");
        out.println("</body></html>");
        out.close();
    }
}
