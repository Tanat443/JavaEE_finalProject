<%@ page import="java.util.List" %>
<%@ page import="models.News" %><%--
  Created by IntelliJ IDEA.
  User: w2
  Date: 09.03.2023
  Time: 23:37
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

    <div class="row mt-5">
        <div class="col-sm-12">
            <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">
                <%=translations.getTextAdd()%>
            </button>
            <table class="table table-hover mt-3">
                <thead>
                <tr>
                    <th>ID</th>
                    <th><%=translations.getTextTitle()%>
                    </th>
                    <th><%=translations.getTextLanguage()%>
                    </th>
                    <th><%=translations.getTextPostDate()%>
                    </th>
                    <th><%=translations.getTextDetails()%>
                    </th>
                </tr>
                </thead>
                <tbody>
                <% List<News> news = (List<News>) request.getAttribute("news");
                    for (News n : news) {
                %>
                <tr>
                    <td><%=n.getId()%>
                    </td>
                    <td><%=n.getTitle()%>
                    </td>
                    <% if (n.getLanguageId() == 2) { %>
                    <td>Русский</td>
                    <%} else {%>
                    <td>English</td>
                    <%}%>
                    <td><%=n.getPostDate()%>
                    </td>
                    <td><a href="/details?id=<%=n.getId()%>" class="btn btn-dark"><%=translations.getTextDetails()%>
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
                            <h1 class="modal-title fs-5" id="exampleModalLabel"><%=translations.getTextModalTitle()%>
                            </h1>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div class="modal-body">
                            <form action="/addNew" method="post">
                                <div>
                                    <label class="col-form-label"><%=translations.getTextTitle()%>:</label>
                                    <input type="text" class="form-control" name="title">
                                </div>
                                <div>
                                    <label class="col-form-label"><%=translations.getTextContent()%>:</label>
                                    <input type="text" class="form-control" name="content">
                                </div>
                                <div>
                                    <label class="col-form-label"><%=translations.getTextLanguage()%>:</label>
                                    <select class="form-control" name="languageId">
                                        <option value="1">English</option>
                                        <option value="2">Русский</option>
                                    </select>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary"
                                            data-bs-dismiss="modal"><%=translations.getTextCancel()%>
                                    </button>
                                    <button type="submit" class="btn btn-primary"><%=translations.getTextAdd()%>
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
