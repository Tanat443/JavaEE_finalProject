package models;

public class NewsContent {
    private int id;
    private String title;
    private String content;
    private int newsID;
    private int languageID;

    public NewsContent(int id, String title, String content, int newsID, int languageID) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.newsID = newsID;
        this.languageID = languageID;
    }

    public NewsContent() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getNewsID() {
        return newsID;
    }

    public void setNewsID(int newsID) {
        this.newsID = newsID;
    }

    public int getLanguageID() {
        return languageID;
    }

    public void setLanguageID(int languageID) {
        this.languageID = languageID;
    }
}
