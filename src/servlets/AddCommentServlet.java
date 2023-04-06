package servlets;

import db.DBUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Comment;
import models.User;

import java.io.IOException;

@WebServlet(value = "/addComment")
public class AddCommentServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("currentUser");
        if (user != null) {
            String description = request.getParameter("description");
            Integer newsId = Integer.parseInt(request.getParameter("newsId"));

            Comment comment = new Comment();
            comment.setComment(description);
            comment.setUser(user);
            comment.setNews(DBUtil.getNewsById(newsId));
            DBUtil.addComment(comment);
            response.sendRedirect("/viewNews?id=" + newsId);
        }

    }
}
