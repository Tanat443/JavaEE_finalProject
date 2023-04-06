<%@ page import="java.util.List" %>
<%@ page import="models.News" %>
<%@ page import="java.time.format.DateTimeFormatter" %><%--
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
    <div class="row mt-5 justify-content-center">
        <% List<News> news = (List<News>) request.getAttribute("news");
            for (News n : news) {
        %>
        <div class="col-md-10 ">
            <div class="row g-0 border rounded overflow-hidden flex-md-row mb-4 shadow-sm h-md-250 position-relative">
                <div class="col p-4 d-flex flex-column position-static">
                    <strong class=" mb-1 text-white bg-dark p-1 col-2 border rounded text-center fs-6"><%=n.getNewsCategory().getName()%>
                    </strong>
                    <h4 class="mb-0"><%=n.getNewsContent().getTitle()%>
                    </h4>
                    <div class="mb-1 text-body-secondary"><%=n.getPostDate().format(DateTimeFormatter.ofPattern("HH:mm, d MMM yyyy"))%>
                    </div>
                    <p class="card-text mb-auto text-break"><%=n.getNewsContent().getContent().substring(0, 180) + "..."%>
                    </p>
                    <a href="/viewNews?id=<%=n.getId()%>" class="stretched-link">Continue reading</a>
                </div>
                <div class="col-auto d-none d-lg-block">
                    <svg class="bd-placeholder-img" width="200" height="250" xmlns="http://www.w3.org/2000/svg"
                         role="img" aria-label="Placeholder: Thumbnail" preserveAspectRatio="xMidYMid slice"
                         focusable="false"><title>Placeholder</title>
                        <rect width="100%" height="100%" fill="#55595c"></rect>
                        <text x="50%" y="50%" fill="#eceeef" dy=".3em">Picture</text>
                    </svg>
                </div>
            </div>
        </div>
        <%}%>
    </div>
</div>
</div>
</body>
</html>
