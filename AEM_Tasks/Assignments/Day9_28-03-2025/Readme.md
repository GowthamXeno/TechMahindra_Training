# AEM Training - Day 9 Assignment (28-03-2025)

# Newsroom Portfolio Website

## **Header**

- Use the OOTB (Out-Of-The-Box) header component.
- Create pages: **News (5 pages), About Me, Contact Me, Homepage**.
- Ensure "News" has a **drop-down** menu.
- Proper styling should be applied.

### **Implementation Steps**:

1. Go to **AEM Sites** → Create pages for Home, About Me, Contact Me, and News (5 pages under `/content/news`).
2. Add the **OOTB Header Component** to the template.
3. Modify the navigation structure to include News (as a drop-down) and other pages.
4. Apply CSS for styling.

#### **Custom Header Component (Example Code for Navigation)**:

```html
<nav class="newsroom-header">
  <ul>
    <li><a href="/content/home.html">Home</a></li>
    <li>
      <a href="/content/news.html">News</a>
      <ul>
        <li><a href="/content/news/news1.html">News 1</a></li>
        <li><a href="/content/news/news2.html">News 2</a></li>
        <li><a href="/content/news/news3.html">News 3</a></li>
        <li><a href="/content/news/news4.html">News 4</a></li>
        <li><a href="/content/news/news5.html">News 5</a></li>
      </ul>
    </li>
    <li><a href="/content/about-me.html">About Me</a></li>
    <li><a href="/content/contact-me.html">Contact Me</a></li>
  </ul>
</nav>
```

## **Footer**

Sections:

- **About Me**
- **Contact Me**
- **Latest 5 News (with hyperlinks, open in a new tab)**
- **Social Media Links**

### **Implementation Steps**:

1. Add the OOTB footer component at the template level.
2. Modify the footer to include the sections above.

#### **Footer Component Code Example:**

```html
<footer>
  <div class="footer-section">
    <h3>About Me</h3>
    <p>Journalist with experience in investigative reporting.</p>
  </div>
  <div class="footer-section">
    <h3>Latest News</h3>
    <ul>
      <li><a href="/content/news/news1.html" target="_blank">News 1</a></li>
      <li><a href="/content/news/news2.html" target="_blank">News 2</a></li>
      <li><a href="/content/news/news3.html" target="_blank">News 3</a></li>
      <li><a href="/content/news/news4.html" target="_blank">News 4</a></li>
      <li><a href="/content/news/news5.html" target="_blank">News 5</a></li>
    </ul>
  </div>
  <div class="footer-section">
    <h3>Follow Me</h3>
    <a href="#">Twitter</a> | <a href="#">LinkedIn</a>
  </div>
</footer>
```

## **Home Page**

- Use the **Teaser Component** to showcase an award ceremony for journalists.
- Include an image, title, description, and a CTA (linking to a detailed news page).

### **Implementation Steps**:

1. Use the **OOTB Teaser Component** in AEM.
2. Configure it with an **image, title, and description**.
3. Add a **CTA button** linking to a detailed news page.

#### **Example Teaser Code:**

```html
<div class="teaser">
  <img src="/content/dam/newsroom/award.jpg" alt="Journalism Award" />
  <h3>Investigative Journalism Award 2025</h3>
  <p>Recognizing excellence in journalism.</p>
  <a href="/content/news/award-details.html" class="cta-button">Read More</a>
</div>
```

## **News Page**

- Create a **NewsRoom Component** to fetch news articles from `/content/news`.
- News should be displayed as **cards** (Title, News Details, Image).

### **Implementation Steps**:

1. Create **news article pages** under `/content/news`.
2. Develop a custom **NewsRoom Component**.
3. Fetch and display news dynamically using Sling models.

#### **NewsRoom Component (Java Code)**:

```java
@Model(adaptables = Resource.class)
public class NewsRoomModel {
    @Inject @Via("resource")
    private List<Resource> newsList;

    public List<NewsArticle> getNewsArticles() {
        List<NewsArticle> articles = new ArrayList<>();
        for (Resource news : newsList) {
            articles.add(new NewsArticle(news));
        }
        return articles;
    }
}
```

#### **HTL Code for News Cards:**

```html
<sly data-sly-use.model="com.example.models.NewsRoomModel" />
<div class="news-container">
  <sly data-sly-list.article="${model.newsArticles}">
    <div class="news-card">
      <img src="${article.image}" alt="${article.title}" />
      <h3>${article.title}</h3>
      <p>${article.description}</p>
      <a href="${article.link}">Read More</a>
    </div>
  </sly>
</div>
```

## **About Me Page**

- Use the **Journalist Component** to showcase journalist information.

### **Implementation Steps**:

1. Develop a simple component for the journalist's bio.
2. Include profile image, description, and social links.

#### **Example HTL Code for Journalist Component:**

```html
<div class="journalist-profile">
  <img src="/content/dam/newsroom/journalist.jpg" alt="Journalist" />
  <h2>John Doe</h2>
  <p>Experienced journalist covering global events.</p>
  <a href="#">LinkedIn</a> | <a href="#">Twitter</a>
</div>
```

## **Contact Me Page**

- Use **Text or Teaser Components** to display contact details and social media links.

### **Implementation Steps**:

1. Add **OOTB Text Component** to include contact details.
2. Include **social media links**.

#### **Example Contact Section Code:**

```html
<div class="contact-section">
  <h3>Contact Me</h3>
  <p>Email: journalist@example.com</p>
  <p>Phone: +1 234 567 890</p>
  <a href="#">Twitter</a> | <a href="#">LinkedIn</a>
</div>
```

## **Final Notes**

- **Header & Footer** should be implemented at the **template level**.
- The **Home Page** can use the **OOTB Content Page Template**.
- The **News Page** should use the custom **Book Page Template**.
- Ensure all news articles are structured under `/content/news`.

### ✅ **Assignment Completed!**
