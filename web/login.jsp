<%--
  Created by IntelliJ IDEA.
  User: w2
  Date: 09.03.2023
  Time: 23:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>BITLAB NEWS - log in</title>
    <%@include file="vendor/head.jsp" %>
    <style>
        html,
        body {
            height: 100%;
        }

        body {
            display: flex;
            align-items: center;
            padding-top: 40px;
            padding-bottom: 40px;
            background-color: #f5f5f5;
        }

        .form-signin {
            max-width: 330px;
            padding: 15px;
        }

        .form-signin .form-floating:focus-within {
            z-index: 2;
        }

        .form-signin input[type="email"] {
            margin-bottom: -1px;
            border-bottom-right-radius: 0;
            border-bottom-left-radius: 0;
        }

        .form-signin input[type="password"] {
            margin-bottom: 10px;
            border-top-left-radius: 0;
            border-top-right-radius: 0;
        }
    </style>
</head>

<body class="text-center">
<%
    String emailError = request.getParameter("errorEmail");
    String passwordError = request.getParameter("errorPassword");
    String successRegister = request.getParameter("successRegister");
%>
<main class="form-signin w-100 m-auto">
    <form action="/login" method="post">
        <h1 class="h3 mb-3 fw-normal">Please sign in</h1>
        <div class="form-floating">
            <input type="text" class="form-control" id="email" name="email" placeholder="Email">
            <label for="email">Email</label>
        </div>
        <div class="form-floating">
            <input type="password" class="form-control" id="password" name="password" placeholder="Password">
            <label for="password">Password</label>
        </div>
        <button class="w-100 mb-3 btn btn-lg btn-dark" type="submit">Sign in</button>
        <a class="link-primary text-decoration-none" href="/register">Create new account</a>
        <p class="mt-5 mb-3 text-muted">&copy; 2023</p>
    </form>
    <% if (emailError != null) { %>
    <div class="alert alert-danger" role="alert">
        Пользователь с таким email не зарегистрирован.
    </div>
    <%}%>
    <% if (passwordError != null) { %>
    <div class="alert alert-danger" role="alert">
        Неверный пароль.
    </div>
    <%}%>

    <% if (successRegister != null) { %>
    <div class="alert alert-success" role="alert">
        Вы успешно зарегистрировались.
    </div>
    <%}%>
</main>
</body>
</html>
