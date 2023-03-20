<%@ page import="models.Translations" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<div class="hero">
    <nav>
        <a href="/" class="logo text-decoration-none"><h4 class=""><b>BITLAB</b> NEWS</h4></a>
        <ul>
            <% Translations translations = (Translations) request.getAttribute("translations");%>
            <li><a href="/adminPage" class="nav-link px-2 text-white"><%=translations.getTextAdminPanel()%>
            </a></li>
            <li>
                <form action="/setCookie?id=2" method="POST">
                    <button class="nav-link px-2  text-white">РУС</button>
                </form>
            </li>
            <li>
                <form action="/setCookie?id=1" method="POST">
                    <button class="nav-link px-2  text-white"> ENG</button>
                </form>
            </li>
        </ul>
    </nav>
</div>
