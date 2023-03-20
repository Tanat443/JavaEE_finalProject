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

@WebServlet(value = "/details")
public class DetailsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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

        List<Translations> allTranslations = DBUtil.getAllTranslations();
        request.setAttribute("allTranslations", allTranslations);


        int id = Integer.parseInt(request.getParameter("id"));
        News n = DBUtil.getNewsById(id);
        request.setAttribute("news", n);
        request.getRequestDispatcher("./details.jsp").forward(request, response);
    }
}
