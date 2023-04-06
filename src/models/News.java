package models;

import java.time.LocalDateTime;

public class News {
    private int id;
    private NewsCategory newsCategory;
    private LocalDateTime postDate;
    private NewsContent newsContent;

    public News(int id, NewsCategory newsCategory, LocalDateTime postDate, NewsContent newsContent) {
        this.id = id;
        this.newsCategory = newsCategory;
        this.postDate = postDate;
        this.newsContent = newsContent;
    }

    public News() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public NewsCategory getNewsCategory() {
        return newsCategory;
    }

    public void setNewsCategory(NewsCategory newsCategory) {
        this.newsCategory = newsCategory;
    }

    public LocalDateTime getPostDate() {
        return postDate;
    }

    public void setPostDate(LocalDateTime postDate) {
        this.postDate = postDate;
    }

    public NewsContent getNewsContent() {
        return newsContent;
    }

    public void setNewsContent(NewsContent newsContent) {
        this.newsContent = newsContent;
    }
}