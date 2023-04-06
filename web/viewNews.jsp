<%@ page import="models.News" %>
<%@ page import="models.Comment" %>
<%@ page import="java.util.List" %>
<%@ page import="java.time.format.DateTimeFormatter" %><%--
  Created by IntelliJ IDEA.
  User: w2
  Date: 03.04.2023
  Time: 22:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>BITLAB NEWS</title>
    <%@include file="vendor/head.jsp" %>
</head>
<body>
<%@include file="vendor/navbar.jsp" %>
<div class="container">
    <div class="row mt-5 ">
        <%
            News news = (News) request.getAttribute("news");
        %>
        <div class="col-md-10 offset-md-1">
            <article class="blog-post">
                <h3 class="blog-post-title mb-1"><%=news.getNewsContent().getTitle()%>
                </h3>
                <p class="blog-post-meta text-secondary"><%=news.getPostDate().format(DateTimeFormatter.ofPattern("HH:mm, d MMM yyyy"))%>
                </p>
                <p><%=news.getNewsContent().getContent()%>
                </p>
            </article>
            <hr>

            <hr>
            <div class="list-group col-5 offset-md-1">
                <form method="post" action="/addComment?newsId=<%=news.getId()%>">
                    <div class="mb-3 ">
                        <label for="Textarea1" class="form-label">Оставить комментарий</label>
                        <textarea class="form-control" id="Textarea1" rows="2" name="description" required></textarea>
                    </div>
                    <button class="btn btn-sm btn-dark">Отправить</button>
                </form>
                <%
                    List<Comment> comments = (List<Comment>) request.getAttribute("comments");
                    if (comments != null) {
                        for (Comment comment : comments) {
                %>
                <a href="#" class="list-group-item list-group-item-action d-flex gap-3 py-3" aria-current="true">
                    <img src="https://github.com/twbs.png" alt="twbs" width="32" height="32"
                         class="rounded-circle flex-shrink-0">
                    <div class="d-flex gap-2 w-100 justify-content-between">
                        <div>
                            <h6 class="mb-0"><%=comment.getUser().getFullName()%>
                            </h6>
                            <p class="mb-0 opacity-75"><%=comment.getComment()%>
                            </p>
                        </div>
                        <small class="opacity-50 text-nowrap"><%=comment.getPostDate().format(DateTimeFormatter.ofPattern("HH:mm, d MMM yyyy"))%>
                        </small>
                    </div>
                </a>
                <%
                        }
                    }
                %>
            </div>
        </div>
    </div>
</div>
</div>
</body>
</html>
