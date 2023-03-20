<%@ page import="models.News" %>
<%@ page import="java.util.List" %><%--
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
    <div class="row">
        <div class="col-sm-8 offset-2">
            <form action="/addNew" method="post">
                <% News news = (News) request.getAttribute("news");%>
                <div>
                    <label class="col-form-label"><%=translations.getTextTitle()%>:</label>
                    <input type="text" class="form-control" name="title" value="<%=news.getTitle()%>">
                </div>
                <div>
                    <label class="col-form-label"><%=translations.getTextContent()%>:</label>
                    <input type="text" class="form-control" name="content" value="<%=news.getContent()%>">
                </div>
                <div>
                    <label class="col-form-label"><%=translations.getTextLanguage()%>:</label>
                    <select class="form-select" name="languageId">
                        <%
                            List<Translations> allTranslations = (List<Translations>) request.getAttribute("allTranslations");
                            for (Translations t : allTranslations) {
                        %>
                        <option value="<%=t.getId()%>" <%=(news.getLanguageId() == t.getId() ? "selected" : "")%> ><%=t.getName()%>
                        </option>
                        <%
                            }
                        %>
                    </select>
                </div>
                <div class="form-footer">
                    <button type="button" class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#exampleModal">
                        <%=translations.getTextDelete()%>
                    </button>
                    <button type="submit" class="btn btn-primary"><%=translations.getTextSave()%>
                    </button>
                </div>
            </form>

            <!-- Modal -->
            <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel"
                 aria-hidden="true">
                <div class="modal-dialog modal-sm">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h1 class="modal-title fs-5" id="exampleModalLabel"><%=translations.getTextForDelete()%>
                            </h1>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div class="modal-body">
                            <form action="/deletePost?id=<%=news.getId()%>" method="post">
                                <div class="">
                                    <button type="submit" class="btn btn-danger"><%=translations.getTextDelete()%>
                                    </button>
                                    <button type="button" class="btn btn-secondary"
                                            data-bs-dismiss="modal"><%=translations.getTextCancel()%>
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
