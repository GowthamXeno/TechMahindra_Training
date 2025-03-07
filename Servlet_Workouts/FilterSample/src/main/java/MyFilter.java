import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.DirectoryStream.Filter;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/MyFilter")
public class MyFilter implements Filter {
    private FilterConfig filterConfig;
    
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }
public void doFilter(ServletRequest request, 
            ServletResponse response,FilterChain chain) 
                       throws IOException, ServletException {
response.setContentType("text/html"); 
        PrintWriter out = response.getWriter();
        String appUser = filterConfig.getInitParameter("appUser");
        if (appUser != null && appUser.equals("jai")) {
            chain.doFilter(request, response); 
        } else {
            out.print("Invalid application user.");
        }
}  
    
    public void destroy() { }
	@Override
	public boolean accept(Object entry) throws IOException {
		// TODO Auto-generated method stub
		return false;
	}
    }
