<%@ page import="models.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<header class="p-3 text-bg-dark">
    <% User user = (User) request.getSession().getAttribute("currentUser");%>
    <div class="container">
        <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
            <a href="/" class="d-flex align-items-center mb-2 mb-lg-0 text-white text-decoration-none">
                <span class="fs-4">BITLAB NEWS</span>
            </a>
            <ul class="col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
            </ul>
            <ul class="navbar-nav flex-row flex-wrap bd-navbar-nav align-items-center">
                <li class="nav-item">
                    <form action="/setCookie?id=2" method="POST" class="my-0">
                        <button class="nav-link px-2 btn btn-dark">РУС</button>
                    </form>
                </li>
                <li class="nav-item">
                    <form action="/setCookie?id=1" method="POST" class="my-0">
                        <button class="nav-link px-2 btn btn-dark"> ENG</button>
                    </form>
                </li>
            </ul>
            <div class="dropdown text-white">
                <button class="btn btn-dark dropdown-toggle" type="button" data-bs-toggle="dropdown"
                        aria-expanded="false">
                    <%=user.getFullName()%>
                </button>
                <ul class="dropdown-menu text-small  dropdown-menu-dark" style="">
                    <li><a class="dropdown-item" href="/editUser">Profile Settings</a></li>
                    <li>
                        <hr class="dropdown-divider">
                    </li>
                    <% if (user != null) {%>
                    <%if (Integer.parseInt(user.getRoleId()) == 1) {%>
                    <li><a href="/adminPage" class="dropdown-item">Admin Panel</a></li>
                    <%} %>
                    <li><a href="/logout" class="dropdown-item">Log Out
                    </a></li>
                    <%} else {%>
                    <li><a href="/login" class="dropdown-item">Login
                    </a></li>
                    <%} %>
                </ul>
            </div>
        </div>
    </div>
</header>
