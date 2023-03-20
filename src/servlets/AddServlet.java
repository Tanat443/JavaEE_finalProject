package servlets;

import db.DBUtil;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import models.News;


import java.io.IOException;
import java.util.Date;

@WebServlet(value = "/addNew")
public class AddServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String title = request.getParameter("title");
        String content = request.getParameter("content");
        Integer languageId = Integer.parseInt(request.getParameter("languageId"));
        Date currentDate = new Date();

        News n = new News();
        n.setTitle(title);
        n.setContent(content);
        n.setLanguageId(languageId);
        n.setPostDate(currentDate);

        DBUtil.addNews(n);
        response.sendRedirect("/adminPage");


    }
}
