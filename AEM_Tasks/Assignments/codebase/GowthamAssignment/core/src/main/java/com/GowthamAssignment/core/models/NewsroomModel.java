package com.GowthamAssignment.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.apache.sling.models.annotations.injectorspecific.Self;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class NewsroomModel {

    @Self
    private Resource currentResource;

    @Inject
    private ResourceResolver resourceResolver;

    @ValueMapValue
    private String[] newsPaths;

    public List<NewsArticleModel> getNewsArticles() {
        List<NewsArticleModel> newsList = new ArrayList<>();

        if (newsPaths != null) {
            for (String newsPath : newsPaths) {
                Resource newsArticleRes = resourceResolver.getResource(newsPath + "/jcr:content/root/container/news_article");

                if (newsArticleRes != null) {
                    NewsArticleModel news = newsArticleRes.adaptTo(NewsArticleModel.class);
                    if (news != null) {
                        newsList.add(news);
                    }
                }
            }
        }
        return newsList;
    }
}
