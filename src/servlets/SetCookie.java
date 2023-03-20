package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Translations;

import java.io.IOException;

@WebServlet(value = "/setCookie")
public class SetCookie extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {



    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer langId = Integer.parseInt(req.getParameter("id"));
        Cookie cookie = new Cookie("lang_id", langId+"");
        resp.addCookie(cookie);
        String referer = req.getHeader("Referer");
        resp.sendRedirect(referer);
    }
}
