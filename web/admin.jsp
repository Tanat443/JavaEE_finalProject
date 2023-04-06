<%@ page import="java.util.List" %>
<%@ page import="models.News" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page import="models.Languages" %>
<%@ page import="models.NewsCategory" %><%--
  Created by IntelliJ IDEA.
  User: w2
  Date: 09.03.2023
  Time: 23:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>BITLAB NEWS - Admin panel</title>
    <%@include file="vendor/head.jsp" %>
</head>
<body>
<%@include file="vendor/navbar.jsp" %>
<div class="container">
    <div class="row mt-5">
        <div class="col-sm-12">
            <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">
                Add
            </button>
            <table class="table table-hover mt-3">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Title</th>
                    <th>Category</th>
                    <th>Language</th>
                    <th>Post Date</th>
                    <th>Details</th>
                </tr>
                </thead>
                <tbody>
                <% List<News> news = (List<News>) request.getAttribute("news");
                    for (News n : news) {
                %>
                <tr>
                    <td><%=n.getId()%>
                    </td>
                    <td><%=n.getNewsContent().getTitle()%>
                    </td>
                    <td><%=n.getNewsCategory().getName()%>
                    </td>
                    </td>
                    <td><%=n.getNewsContent().getLanguageID()%>
                    </td>
                    <td><%=n.getPostDate().format(DateTimeFormatter.ofPattern("HH:mm, d MMM yyyy"))%>
                    </td>
                    <td><a href="/details?id=<%=n.getId()%>" class="btn btn-dark">Details
                    </a></td>
                </tr>
                <%}%>
                </tbody>
            </table>

            <!-- Modal -->
            <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel"
                 aria-hidden="true">
                <div class="modal-dialog modal-lg">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h1 class="modal-title fs-5" id="exampleModalLabel">Add news
                            </h1>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div class="modal-body">
                            <form action="/addNews" method="post">
                                <div>
                                    <label class="col-form-label">Category:</label>
                                    <select class="form-select mb-3" name="categoryId">
                                        <%
                                            List<NewsCategory> allCategories = (List<NewsCategory>) request.getAttribute("allCategories");
                                            for (NewsCategory c : allCategories) {
                                        %>
                                        <option value="<%=c.getId()%>"><%=c.getName()%>
                                        </option>
                                        <%
                                            }
                                        %>
                                    </select>
                                </div>
                                <div>
                                    <label class="col-form-label">Language:</label>
                                    <select class="form-select mb-3" name="languageId">
                                        <%
                                            List<Languages> allLanguages = (List<Languages>) request.getAttribute("allLanguages");
                                            for (Languages l : allLanguages) {
                                        %>
                                        <option value="<%=l.getId()%>"><%=l.getName()%>
                                        </option>
                                        <%
                                            }
                                        %>
                                    </select>
                                </div>
                                <div>
                                    <label class="col-form-label">Title:</label>
                                    <input type="text" class="form-control" name="title" maxlength="115">
                                </div>
                                <div>
                                    <label class="col-form-label">Content:</label>
                                    <input type="text" class="form-control" name="content">
                                </div>

                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary"
                                            data-bs-dismiss="modal">Cancel
                                    </button>
                                    <button type="submit" class="btn btn-primary">Add
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
</div>
</body>
<script>
    const myModal = document.getElementById('myModal')
    const myInput = document.getElementById('myInput')

    myModal.addEventListener('shown.bs.modal', () => {
        myInput.focus()
    })
</script>
</html>
