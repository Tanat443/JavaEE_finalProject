package db;


import models.*;

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

    public static List<News> getNewsByLangId(int langID) {
        //Method for displaying elements by language, if a certain language is selected
        List<News> news = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT news.id, news.post_date, news_categories.id AS category_id," +
                    "news_categories.name AS category_name, languages.id AS language_id, " +
                    "news_contents.title, news_contents.content\n" +
                    "FROM news\n" +
                    "         INNER JOIN news_categories ON news.category_id = news_categories.id\n" +
                    "         INNER JOIN news_contents ON news.id = news_contents.news_id\n" +
                    "         INNER JOIN languages ON news_contents.language_id = languages.id where language_id=?");
            statement.setInt(1, langID);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                News n = new News();
                n.setId(resultSet.getInt("id"));
                n.setPostDate(resultSet.getTimestamp("post_date").toLocalDateTime());

                NewsCategory category = new NewsCategory();
                category.setId(resultSet.getInt("category_id"));
                category.setName(resultSet.getString("category_name"));
                n.setNewsCategory(category);

                NewsContent newsContent = new NewsContent();
                newsContent.setTitle(resultSet.getString("title"));
                newsContent.setContent(resultSet.getString("content"));
                newsContent.setLanguageID(resultSet.getInt("language_id"));
                n.setNewsContent(newsContent);

                news.add(n);
            }
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return news;
    }

    public static List<News> getAllNews() {
        //Method for displaying news for admin panel
        List<News> news = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT news.id, news.post_date, news_categories.id AS category_id," +
                    "news_categories.name AS category_name, languages.id AS language_id, " +
                    "news_contents.title, news_contents.content\n" +
                    "FROM news\n" +
                    "         INNER JOIN news_categories ON news.category_id = news_categories.id\n" +
                    "         INNER JOIN news_contents ON news.id = news_contents.news_id\n" +
                    "         INNER JOIN languages ON news_contents.language_id = languages.id");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                News n = new News();
                n.setId(resultSet.getInt("id"));
                n.setPostDate(resultSet.getTimestamp("post_date").toLocalDateTime());

                NewsCategory category = new NewsCategory();
                category.setId(resultSet.getInt("category_id"));
                category.setName(resultSet.getString("category_name"));
                n.setNewsCategory(category);

                NewsContent newsContent = new NewsContent();
                newsContent.setTitle(resultSet.getString("title"));
                newsContent.setContent(resultSet.getString("content"));
                newsContent.setLanguageID(resultSet.getInt("language_id"));
                n.setNewsContent(newsContent);

                news.add(n);
            }
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return news;
    }

    public static News getNewsById(int id) {
        //Method for displaying news for view
        News n = null;
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT news.id, news.post_date, news_categories.id AS category_id, " +
                    "news_categories.name AS category_name, " +
                    "languages.id AS language_id, news_contents.title, news_contents.content\n" +
                    "FROM news\n" +
                    "INNER JOIN news_categories ON news.category_id = news_categories.id\n" +
                    "INNER JOIN news_contents ON news.id = news_contents.news_id\n" +
                    "INNER JOIN languages ON news_contents.language_id = languages.id where news_id =?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                n = new News();
                n.setId(resultSet.getInt("id"));
                n.setPostDate(resultSet.getTimestamp("post_date").toLocalDateTime());

                NewsCategory category = new NewsCategory();
                category.setId(resultSet.getInt("category_id"));
                category.setName(resultSet.getString("category_name"));
                n.setNewsCategory(category);

                NewsContent newsContent = new NewsContent();
                newsContent.setTitle(resultSet.getString("title"));
                newsContent.setContent(resultSet.getString("content"));
                newsContent.setLanguageID(resultSet.getInt("language_id"));
                n.setNewsContent(newsContent);
            }
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return n;
    }

    public static int addNews(int categoryId) {
        int id = 0;
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "insert into news(post_date, category_id) " + "values (NOW(), ?) RETURNING id ");
            statement.setInt(1, categoryId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                id = resultSet.getInt("id");
            }
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }

    public static void addNewsContent(NewsContent newsContent) {
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "insert into news_contents(title, content, news_id, language_id) " + "values (?, ?, ?, ?)");
            statement.setString(1, newsContent.getTitle());
            statement.setString(2, newsContent.getContent());
            statement.setInt(3, newsContent.getNewsID());
            statement.setInt(4, newsContent.getLanguageID());
            statement.executeUpdate();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void editNews(int categoryId, NewsContent newsContent) {
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "UPDATE news SET category_id = ? where id=?");
            statement.setInt(1, categoryId);
            statement.setInt(2, newsContent.getNewsID());

            statement.executeUpdate();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void editNewsContent(NewsContent newsContent) {
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "UPDATE news_contents SET title = ?, content=?, language_id=? where news_id=?");
            statement.setString(1, newsContent.getTitle());
            statement.setString(2, newsContent.getContent());
            statement.setInt(3, newsContent.getLanguageID());
            statement.setInt(4, newsContent.getNewsID());

            statement.executeUpdate();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void deleteNews(int id) {
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "delete from news  where id=?");
            statement.setInt(1, id);

            statement.executeUpdate();
            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void deleteNewsContent(int id) {
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "delete from news_contents  where news_id=?");
            statement.setInt(1, id);

            statement.executeUpdate();
            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static List<NewsCategory> getAllCategories() {
        //Method for displaying all categories on create new news
        List<NewsCategory> newsCategories = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "select * from news_categories");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                NewsCategory newsCategory = new NewsCategory();
                newsCategory.setId(resultSet.getInt("id"));
                newsCategory.setName(resultSet.getString(("name")));
                newsCategories.add(newsCategory);
            }
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return newsCategories;
    }
    public static List<Languages> getAllLanguages() {
        //Method for displaying all languages on create new news
        List<Languages> allLanguages = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "select * from languages");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Languages languages = new Languages();
                languages.setId(resultSet.getInt("id"));
                languages.setName(resultSet.getString(("name")));
                allLanguages.add(languages);
            }
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return allLanguages;
    }

    public static void addNewUser(User u) {
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "insert into users(email,password, full_name, role_id) values (?, ?, ?,? )");

            statement.setString(1, u.getEmail());
            statement.setString(2, u.getPassword());
            statement.setString(3, u.getFullName());
            statement.setString(4, "2");

            statement.executeUpdate();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static User getUserByEmail(String email) {
        User u = null;
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "select * from users where email=?");
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                u = new User();
                u.setId(resultSet.getInt("id"));
                u.setEmail(resultSet.getString("email"));
                u.setPassword(resultSet.getString("password"));
                u.setFullName(resultSet.getString("full_name"));
                u.setRoleId(resultSet.getString("role_id"));
            }
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return u;
    }

    public static void editUser(User user) {
        try {
            PreparedStatement statement = connection.prepareStatement("update users " +
                    "set full_name=? where id = ?");
            statement.setString(1, user.getFullName());
            statement.setInt(2, user.getId());
            statement.executeUpdate();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void changePassword(User user) {
        try {
            PreparedStatement statement = connection.prepareStatement("update users " +
                    "set password=? where id = ?");
            statement.setString(1, user.getPassword());
            statement.setInt(2, user.getId());
            statement.executeUpdate();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void addComment(Comment comment) {
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "insert into comments(comment,post_date, user_id, news_id) values (?, now(), ?,? )");

            statement.setString(1, comment.getComment());
            statement.setInt(2, comment.getUser().getId());
            statement.setInt(3, comment.getNews().getId());

            statement.executeUpdate();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void deleteComments(int id) {
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "delete from comments WHERE news_id=?");

            statement.setInt(1, id);

            statement.executeUpdate();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<Comment> getCommentsByNewsId(Integer newsId) {
        List<Comment> comments = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "select c.id, c.comment, c.post_date,  c.user_id, c.news_id, u.full_name, u.email\n" +
                    "                    from comments c\n" +
                    "                    inner join users u on u.id = c.user_id\n" +
                    "                    where c.news_id=?");
            statement.setInt(1, newsId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Comment comment = new Comment();
                comment.setId(resultSet.getInt("id"));
                comment.setComment(resultSet.getString("comment"));
                comment.setPostDate(resultSet.getTimestamp("post_date").toLocalDateTime());

                User user = new User();
                user.setFullName(resultSet.getString("full_name"));
                user.setFullName(resultSet.getString("email"));
                comment.setUser(user);
                News news = new News();
                news.setId(resultSet.getInt("news_id"));
                comment.setNews(news);
                comments.add(comment);
            }
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return comments;
    }

}
