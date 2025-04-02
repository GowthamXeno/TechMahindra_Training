package com.GowthamAssignment.core.servlets;
import com.day.cq.search.PredicateGroup;
import com.day.cq.search.Query;
import com.day.cq.search.QueryBuilder;
import com.day.cq.search.result.Hit;
import com.day.cq.search.result.SearchResult;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.apache.sling.api.resource.ResourceResolver;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component(service = Servlet.class, property = {
        "sling.servlet.paths=/bin/searchContent",
        "sling.servlet.methods=GET"
})
public class SearchServlet extends SlingSafeMethodsServlet {
    @Reference
    private QueryBuilder queryBuilder;

    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException {
        ResourceResolver resourceResolver = request.getResourceResolver();
        Session session = resourceResolver.adaptTo(Session.class);

        if (session == null) {
            response.getWriter().write("Session not available");
            return;
        }

        Map<String, String> map = new HashMap<>();
        map.put("path", "/content/mysite"); // Define search root
        map.put("type", "cq:Page");         // Look for pages
        map.put("p.limit", "-1");           // Fetch all results

        Query query = queryBuilder.createQuery(PredicateGroup.create(map), session);
        SearchResult result = query.getResult();

        response.setContentType("text/plain");
        for (Hit hit : result.getHits()) {
            try {
                response.getWriter().write(hit.getPath() + "\n");
            } catch (RepositoryException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
