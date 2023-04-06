package servlets;

import db.DBUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.NewsContent;
import models.User;

import java.io.IOException;

@WebServlet(value = "/addNews")
public class AddNewsServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("currentUser");
        if (user != null) {
            if (Integer.parseInt(user.getRoleId()) == 1) {

                Integer categoryId = Integer.parseInt(request.getParameter("categoryId"));
                int newsId = DBUtil.addNews(categoryId);

                String title = request.getParameter("title");
                String content = request.getParameter("content");
                String languageId = request.getParameter("languageId");

                NewsContent newsContent = new NewsContent();
                newsContent.setNewsID(newsId);
                newsContent.setTitle(title);
                newsContent.setContent(content);
                newsContent.setLanguageID(Integer.parseInt(languageId));

                DBUtil.addNewsContent(newsContent);
                response.sendRedirect("/adminPage?success");
            }
        }
    }
}
