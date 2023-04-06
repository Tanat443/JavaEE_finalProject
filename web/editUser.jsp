<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>BITLAB NEWS - Edit user</title>
    <%@include file="vendor/head.jsp" %>
</head>
<body>
<%@include file="vendor/navbar.jsp" %>
<%
    String errorEditUser = request.getParameter("errorEditUser");
    String successEditUser = request.getParameter("successEditUser");
    String errorOldPassword = request.getParameter("errorOldPassword");
    String errorDifferentPassword = request.getParameter("errorDifferentPassword");
    String successPassword = request.getParameter("successPassword");
%>
<div class="container">
    <div class="row">
        <div class="col-sm-6 offset-3">

            <form action="/editUser" method="post" class="mt-3">
                <h5>Change Full Name</h5>
                <div class="mb-3">
                    <label class="col-form-label">Full Name:</label>
                    <input type="text" class="form-control" name="fullName" value="<%=user.getFullName()%>">
                </div>
                <% if (errorEditUser != null) { %>
                <div class="alert alert-danger my-4" role="alert">
                    You must enter new data!
                </div>
                <%}%>
                <% if (successEditUser != null) { %>
                <div class="alert alert-success my-4" role="alert">
                    Full name changed successfully.
                </div>
                <%}%>
                <div class="form-footer mt-3">
                    <button type="submit" class="btn btn-dark">Save</button>
                </div>
            </form>
            <hr class="my-4">
            <h5>Change Password</h5>
            <form action="/changePassword" method="post">
                <div class="mb-3">
                    <label class="col-form-label">Current Password:</label>
                    <input type="password" class="form-control" name="currentPassword"
                           placeholder="Insert current password">
                </div>
                <% if (errorOldPassword != null) { %>
                <div class="alert alert-danger my-4" role="alert">
                    Incorrect password current password!
                </div>
                <%}%>
                <div class="mb-3">
                    <label class="col-form-label">New password:</label>
                    <input type="password" class="form-control" name="newPassword" placeholder="Сreate a password">
                </div>
                <div class="mb-3">
                    <label class="col-form-label">Retype new password:</label>
                    <input type="password" class="form-control" name="reNewPassword" placeholder="Repeat new password">
                </div>
                <% if (errorDifferentPassword != null) { %>
                <div class="alert alert-danger my-4" role="alert">
                    Passwords do not match!
                </div>
                <%}%>
                <% if (successPassword != null) { %>
                <div class="alert alert-success my-4" role="alert">
                    Passwords changed successfully.
                </div>
                <%}%>
                <div class="form-footer mt-3">
                    <button type="submit" class="btn btn-dark">Save password</button>
                </div>
            </form>

        </div>
    </div>
</div>
</body>
</html>
