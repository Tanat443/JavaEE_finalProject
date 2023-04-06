package servlets;

import db.DBUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Comment;
import models.News;
import models.User;

import java.io.IOException;
import java.util.List;

@WebServlet(value = "/viewNews")
public class ViewNewsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("currentUser");
        if (user != null) {
            Integer id = Integer.parseInt(request.getParameter("id"));
            News news = DBUtil.getNewsById(id);
            List<Comment> comments = DBUtil.getCommentsByNewsId(id);
            request.setAttribute("news", news);
            request.setAttribute("comments", comments);
            request.getRequestDispatcher("./viewNews.jsp").forward(request, response);
        }
        response.sendRedirect("/login");
    }
}
