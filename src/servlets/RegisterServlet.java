package servlets;

import db.DBUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.User;

import java.io.IOException;

@WebServlet(value = "/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("./register.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String fullName = req.getParameter("fullName");
        String redirect = "/register?registerEmailError";
        User user = DBUtil.getUserByEmail(email);

        if (user == null) {
            User newUser = new User();
            newUser.setEmail(email);
            newUser.setPassword(password);
            newUser.setFullName(fullName);
            DBUtil.addNewUser(newUser);
            redirect = "/login?successRegister";
        }
        resp.sendRedirect(redirect);
    }
}
