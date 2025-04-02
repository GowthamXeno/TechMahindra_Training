package com.gowthamxeno.core.models;


import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

@Model(adaptables = Resource.class)
public class NewsModel {

    @Inject
    private String newsHeadline;

    @ValueMapValue
    private String newsDetail;

    @ValueMapValue
    private Date newsPublishDate;

    @ValueMapValue
    private String newsImg;

    @ValueMapValue
    private List<String> newsTitle;

    public String getNewsDetail() {
        return newsDetail;
    }

    public Date getNewsPublishDate() {
        return newsPublishDate;
    }

    public String getNewsImg() {
        return newsImg;
    }

    public String getNewsHeadline() {
        return newsHeadline;
    }

    public List<String> getNewsTitle() {
        if (newsTitle != null) {
            return new ArrayList<String>(newsTitle);
        } else {
            return Collections.emptyList();
        }
    }

}

