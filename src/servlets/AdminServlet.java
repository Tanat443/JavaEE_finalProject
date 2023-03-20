package servlets;

import db.DBUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.News;
import models.Translations;

import java.io.IOException;
import java.util.List;

@WebServlet(value = "/adminPage")
public class AdminServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<News> news = DBUtil.getAllNews();
        request.setAttribute("news", news);
        int langID = 1;
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals("lang_id")) {
                    langID = Integer.parseInt(c.getValue());
                }
            }
        }
        Translations translations = DBUtil.getTranslationsById(langID);
        request.setAttribute("translations", translations);
        request.getRequestDispatcher("./admin.jsp").forward(request, response);
    }
}
