package servlets;

import db.DBUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import models.User;

import java.io.IOException;

@WebServlet(value = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("currentUser");
        if (user == null) {
            request.getRequestDispatcher("./login.jsp").forward(request, response);
        }
        response.sendRedirect("/home");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String redirect = "/login?errorEmail";

        User user = DBUtil.getUserByEmail(email);

        if (user != null) {
            redirect = "/login?errorPassword";
            if (user.getPassword().equals(password)) {
                HttpSession session = request.getSession();
                session.setAttribute("currentUser", user);
                redirect = "/home";
            }
        }
        response.sendRedirect(redirect);
    }
}
