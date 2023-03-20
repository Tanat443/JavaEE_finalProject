<%@ page import="java.util.List" %>
<%@ page import="models.News" %><%--
  Created by IntelliJ IDEA.
  User: w2
  Date: 09.03.2023
  Time: 23:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>BITLAB NEWS</title>
    <%@include file="vendor/head.jsp" %>
</head>
<body>
<%@include file="vendor/navbar.jsp" %>
<div class="container">
    <div class="row mt-5">
        <div class="col-sm-8 offset-2">
            <% List<News> news = (List<News>) request.getAttribute("news");
                for (News n : news) {
            %>
            <div class="py-3">
                <h2><%=n.getTitle()%></h2>
                <p><%=n.getContent()%></p>
                <span><b><%=translations.getTextPostedAt()%> <%=n.getPostDate()%></b></span>
            </div>

            <%}%>
        </div>
    </div>
</div>
</div>
</body>
</html>
