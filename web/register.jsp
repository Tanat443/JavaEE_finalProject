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
    <title>BITLAB NEWS - register</title>
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
            margin-bottom: 10px;
            border-bottom-right-radius: 0;
            border-bottom-left-radius: 0;
        }

        .form-signin input[type="password"] {
            margin-bottom: 10px;

        }

        .form-signin input[type="text"] {
            margin-bottom: 10px;
            border-top-left-radius: 0;
            border-top-right-radius: 0;
        }
    </style>
</head>

<body class="text-center">
<%
    String registerEmailError = request.getParameter("registerEmailError");
%>
<main class="form-signin w-100 m-auto">
    <form action="/register" method="post">
        <h1 class="h3 mb-3 fw-normal">Sign up</h1>
        <div class="form-floating">
            <input type="email" class="form-control" id="email" name="email" placeholder="Email">
            <label for="email">Email</label>
        </div>
        <div class="form-floating">
            <input type="password" class="form-control" id="password" name="password" placeholder="Password">
            <label for="password">Password</label>
        </div>
        <div class="form-floating">
            <input type="text" class="form-control" id="fullName" name="fullName" placeholder="Full Name">
            <label for="email">Full Name</label>
        </div>
        <button class="w-100 btn btn-lg mb-3 btn-dark" type="submit">Sign up</button>
        <span>Do you have an account? <a class="link-primary text-decoration-none" href="/login">Sign In</a></span>
        <p class="mt-5 mb-3 text-muted">&copy; 2023</p>
    </form>
    <% if (registerEmailError != null) { %>
    <div class="alert alert-danger" role="alert">
        Пользователь с таким email уже существует.
    </div>
    <%}%>
</main>

</body>
</html>
