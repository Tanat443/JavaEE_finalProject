package servlets;

import db.DBUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.User;

import java.io.IOException;

@WebServlet(value = "/editUser")
public class EditUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("currentUser");
        if (user != null) {
            request.getRequestDispatcher("./editUser.jsp").forward(request, response);
        }
        response.sendRedirect("/login");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fullName = request.getParameter("fullName");
        User user = (User) request.getSession().getAttribute("currentUser");

        String redirect = "/editUser?errorEditUser";

        if (user != null) {
            if (!user.getFullName().equals(fullName)) {
                user.setFullName(fullName);
                DBUtil.editUser(user);
                redirect = "/editUser?successEditUser";
            }
        }
        response.sendRedirect(redirect);
    }
}
