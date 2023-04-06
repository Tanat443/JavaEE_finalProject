package servlets;

import db.DBUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.User;

import java.io.IOException;

@WebServlet(value = "/deleteNews")
public class DeleteNewsServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));

        User user = (User) request.getSession().getAttribute("currentUser");
        if (user != null) {
            if (Integer.parseInt(user.getRoleId()) == 1) {
                DBUtil.deleteNewsContent(id);
                DBUtil.deleteComments(id);
                DBUtil.deleteNews(id);
                response.sendRedirect("/adminPage");
            }
        }
    }
}
