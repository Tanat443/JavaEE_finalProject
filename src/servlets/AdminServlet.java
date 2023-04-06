package servlets;

import db.DBUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Languages;
import models.News;
import models.NewsCategory;
import models.User;

import java.io.IOException;
import java.util.List;

@WebServlet(value = "/adminPage")
public class AdminServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("currentUser");
        if (user != null) {
            if (Integer.parseInt(user.getRoleId()) == 1) {
                List<News> news = DBUtil.getAllNews();
                List<NewsCategory> allCategories = DBUtil.getAllCategories();
                List<Languages> allLanguages = DBUtil.getAllLanguages();
                request.setAttribute("news", news);
                request.setAttribute("allCategories", allCategories);
                request.setAttribute("allLanguages", allLanguages);

                request.getRequestDispatcher("./admin.jsp").forward(request, response);
            } else {
                response.sendRedirect("/");
            }
        }
    }
}
