package servlets;

import db.DBUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.*;

import java.io.IOException;
import java.util.List;

@WebServlet(value = "/details")
public class DetailsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("currentUser");
        if (user != null) {
            if (Integer.parseInt(user.getRoleId()) == 1) {
                int id = Integer.parseInt(request.getParameter("id"));
                News n = DBUtil.getNewsById(id);

                List<NewsCategory> allCategories = DBUtil.getAllCategories();
                List<Languages> allLanguages = DBUtil.getAllLanguages();

                request.setAttribute("allCategories", allCategories);
                request.setAttribute("allLanguages", allLanguages);
                request.setAttribute("news", n);
                request.getRequestDispatcher("./details.jsp").forward(request, response);
            } else {
                response.sendRedirect("/");
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("currentUser");
        if (user != null) {
            if (Integer.parseInt(user.getRoleId()) == 1) {
                Integer categoryId = Integer.parseInt(req.getParameter("categoryId"));
                Integer newsId = Integer.parseInt(req.getParameter("id"));
                String title = req.getParameter("title");
                String content = req.getParameter("content");
                String languageId = req.getParameter("languageId");

                NewsContent newsContent = new NewsContent();
                newsContent.setTitle(title);
                newsContent.setContent(content);
                newsContent.setLanguageID(Integer.parseInt(languageId));
                newsContent.setNewsID(newsId);

                DBUtil.editNews(categoryId, newsContent);
                DBUtil.editNewsContent(newsContent);
                resp.sendRedirect("/adminPage");
            }
        }
    }
}
