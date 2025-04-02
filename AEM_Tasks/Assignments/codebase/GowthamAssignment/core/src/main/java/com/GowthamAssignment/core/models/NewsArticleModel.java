package com.GowthamAssignment.core.models;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import javax.inject.Inject;
import java.text.SimpleDateFormat;
import java.util.Calendar;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class NewsArticleModel {

    @Inject
    @Default(values = "No title provided")
    private String newsTitle;

    @Inject
    @Default(values = "No description available")
    private String newsDescription;

    @Inject
    private Calendar newsDate;

    @Inject
    private String newsImage;

    @Inject
    private Resource currentResource;

    public String getNewsTitle() {
        return newsTitle;
    }

    public String getNewsDescription() {
        return newsDescription;
    }

    public String getNewsImage() {
        return newsImage;
    }

    public String getNewsDate() {
        if (newsDate != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM, yyyy");
            return sdf.format(newsDate.getTime());
        }
        return "No date provided";
    }
    public String getNewsPagePath() {
        // Get the path of the news article page
        String pagePath = currentResource.getPath();
        return pagePath.substring(0, pagePath.indexOf("/jcr:content"));  // Extract page path
    }
}

