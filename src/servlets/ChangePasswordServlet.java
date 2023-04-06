package servlets;

import db.DBUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.User;

import java.io.IOException;

@WebServlet(value = "/changePassword")
public class ChangePasswordServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String currentPassword = request.getParameter("currentPassword");
        String newPassword = request.getParameter("newPassword");
        String reNewPassword = request.getParameter("reNewPassword");
        User user = (User) request.getSession().getAttribute("currentUser");

        String redirect = "/editUser?errorOldPassword";

        if (user != null) {
            if (user.getPassword().equals(currentPassword)) {
                redirect = "/editUser?errorDifferentPassword";
                if (newPassword.equals(reNewPassword)) {
                    user.setPassword(newPassword);
                    DBUtil.changePassword(user);
                    redirect = "/editUser?successPassword";
                }
            }
        }
        response.sendRedirect(redirect);
    }
}
