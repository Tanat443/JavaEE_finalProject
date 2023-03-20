package db;


import models.News;
import models.Translations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DBUtil {

    private static Connection connection;

    static {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/postgres",
                    "postgres",
                    "root"
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<News> getNews(int langId) {
        //Method for displaying elements by language, if a certain language is selected
        List<News> news = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "select * from news WHERE language_id=?");
            statement.setInt(1, langId);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                News n = new News();
                n.setId(resultSet.getLong("id"));
                n.setTitle(resultSet.getString("title"));
                n.setContent(resultSet.getString("content"));
                n.setLanguageId(resultSet.getInt("language_id"));
                n.setPostDate(resultSet.getDate(("post_date")));
                news.add(n);
            }
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return news;
    }

    public static List<News> getAllNews() {
        //Method for displaying all elements for Admin Page
        List<News> news = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "select * from news");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                News n = new News();
                n.setId(resultSet.getLong("id"));
                n.setTitle(resultSet.getString("title"));
                n.setContent(resultSet.getString("content"));
                n.setLanguageId(resultSet.getInt("language_id"));
                n.setPostDate(resultSet.getDate(("post_date")));
                news.add(n);
            }
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return news;
    }

    public static void addNews(News n) {
        //Method for adding news, post date is set by sql method NOW()
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "insert into news(title, content, language_id, post_date) values (?, ?, ?, NOW())");

            statement.setString(1, n.getTitle());
            statement.setString(2, n.getContent());
            statement.setInt(3, n.getLanguageId());

            statement.executeUpdate();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteNews(int id) {
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "delete from news i where i.id=?");
            statement.setInt(1, id);

            statement.executeUpdate();
            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<Translations> getAllTranslations() {
        //Method for
        List<Translations> translations = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "select * from translations");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Translations t = new Translations();
                t.setId(resultSet.getInt("id"));
                t.setTextTitle(resultSet.getString("text_title"));
                t.setTextContent(resultSet.getString("text_content"));
                t.setTextPostDate(resultSet.getString("text_post_date"));
                t.setTextLanguage(resultSet.getString("text_language"));
                t.setTextAdminPanel(resultSet.getString("btn_admin_panel"));
                t.setTextAdd(resultSet.getString("btn_add"));
                t.setTextCancel(resultSet.getString("btn_cancel"));
                t.setTextModalTitle(resultSet.getString("modal_title"));
                t.setTextDetails(resultSet.getString("text_details"));
                t.setTextPostedAt(resultSet.getString("text_posted_at"));
                t.setName(resultSet.getString("name"));
                t.setTextDelete(resultSet.getString("text_delete"));
                t.setTextForDelete(resultSet.getString("text_for_delete"));
                t.setTextSave(resultSet.getString("text_save"));
                translations.add(t);
            }
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return translations;
    }

    public static Translations getTranslationsById(int id) {
        //Method for fetch the words
        Translations t = new Translations();
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "select * from translations where id=?");
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {

                t.setId(resultSet.getInt("id"));
                t.setTextTitle(resultSet.getString("text_title"));
                t.setTextContent(resultSet.getString("text_content"));
                t.setTextPostDate(resultSet.getString("text_post_date"));
                t.setTextLanguage(resultSet.getString("text_language"));
                t.setTextAdminPanel(resultSet.getString("btn_admin_panel"));
                t.setTextAdd(resultSet.getString("btn_add"));
                t.setTextCancel(resultSet.getString("btn_cancel"));
                t.setTextModalTitle(resultSet.getString("modal_title"));
                t.setTextDetails(resultSet.getString("text_details"));
                t.setTextPostedAt(resultSet.getString("text_posted_at"));
                t.setName(resultSet.getString("name"));
                t.setTextDelete(resultSet.getString("text_delete"));
                t.setTextForDelete(resultSet.getString("text_for_delete"));
                t.setTextSave(resultSet.getString("text_save"));
            }
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return t;
    }

    public static News getNewsById(int id) {
        //Method for fetch the words
        News n = new News();
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "select * from news where id=?");
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {

                n.setId(resultSet.getLong("id"));
                n.setTitle(resultSet.getString("title"));
                n.setContent(resultSet.getString("content"));
                n.setLanguageId(resultSet.getInt("language_id"));
                n.setPostDate(resultSet.getDate("post_date"));

            }
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return n;
    }

}
