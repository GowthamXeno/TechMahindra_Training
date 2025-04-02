package com.GowthamAssignment.core.servlets;
import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;
import com.day.cq.wcm.api.WCMException;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.apache.sling.api.resource.ResourceResolver;
import org.osgi.service.component.annotations.Component;
import javax.jcr.Session;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;

@Component(service = Servlet.class, property = {
        "sling.servlet.paths=/bin/createPage",
        "sling.servlet.methods=GET"
})
public class CreatePageServlet extends SlingSafeMethodsServlet {

    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException {
        ResourceResolver resourceResolver = request.getResourceResolver();
        Session session = resourceResolver.adaptTo(Session.class);

        if (session == null) {
            response.getWriter().write("Session not available");
            return;
        }

        PageManager pageManager = resourceResolver.adaptTo(PageManager.class);
        if (pageManager == null) {
            response.getWriter().write("PageManager not available");
            return;
        }

        String parentPath = "/content/mysite";  // Parent path where the page will be created
        String newPageName = "new-page";        // Name of the new page
        String templatePath = "/conf/mysite/settings/wcm/templates/basic-template";  // Template for the new page
        String title = "New Page Title";        // Title of the new page

        try {
            Page newPage = pageManager.create(parentPath, newPageName, templatePath, title);
            if (newPage != null) {
                session.save();
                response.getWriter().write("Page created successfully at: " + newPage.getPath());
            } else {
                response.getWriter().write("Page creation failed.");
            }
        } catch (WCMException | javax.jcr.RepositoryException e) {
            response.getWriter().write("Error: " + e.getMessage());
        }
    }
}
