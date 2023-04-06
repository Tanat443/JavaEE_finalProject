<%@ page import="models.News" %>
<%@ page import="models.Languages" %>
<%@ page import="java.util.List" %>
<%@ page import="models.NewsCategory" %>
<%--
  Created by IntelliJ IDEA.
  User: w2
  Date: 19.03.2023
  Time: 11:00
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
    <% News news = (News) request.getAttribute("news");%>
    <div class="row">
        <div class="col-sm-8 offset-2">
            <form action="/details?id=<%=news.getId()%>" method="post">
                <div class="mb-3">
                    <label class="col-form-label">Category:</label>
                    <select class="form-select" name="categoryId">
                        <%
                            List<NewsCategory> allCategories = (List<NewsCategory>) request.getAttribute("allCategories");
                            for (NewsCategory c : allCategories) {
                        %>
                        <option value="<%=c.getId()%>" <%=(news.getNewsContent().getLanguageID() == c.getId() ? "selected" : "")%> ><%=c.getName()%>
                        </option>
                        <%
                            }
                        %>
                    </select>
                </div>
                <div class="mb-3">
                    <label class="col-form-label">Language:</label>
                    <select class="form-select" name="languageId">
                        <%
                            List<Languages> allLanguages = (List<Languages>) request.getAttribute("allLanguages");
                            for (Languages l : allLanguages) {
                        %>
                        <option value="<%=l.getId()%>" <%=(news.getNewsContent().getLanguageID() == l.getId() ? "selected" : "")%> ><%=l.getName()%>
                        </option>
                        <%
                            }
                        %>
                    </select>
                </div>

                <div class="mb-3">
                    <label class="col-form-label">Title:</label>
                    <input type="text" class="form-control" name="title" value="<%=news.getNewsContent().getTitle()%>">
                </div>
                <div class="mb-3">
                    <label class="col-form-label">Content:</label>
                    <input type="text" class="form-control" name="content"
                           value="<%=news.getNewsContent().getContent()%>">
                </div>
                <div class="form-footer mt-3">
                    <button type="button" class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#exampleModal">
                        Delete
                    </button>
                    <button type="submit" class="btn btn-primary">Save
                    </button>
                </div>
            </form>

            <!-- Modal -->
            <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel"
                 aria-hidden="true">
                <div class="modal-dialog modal-sm">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h1 class="modal-title fs-5" id="exampleModalLabel">Delete news?
                            </h1>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div class="modal-body">
                            <form action="/deleteNews?id=<%=news.getId()%>" method="post">
                                <div class="">
                                    <button type="submit" class="btn btn-danger">Delete
                                    </button>
                                    <button type="button" class="btn btn-secondary"
                                            data-bs-dismiss="modal">Cancel
                                    </button>
                                </div>
                            </form>
                        </div>

                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
