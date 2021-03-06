<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: janithdabare
  Date: 5/14/21
  Time: 19:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View MOdules of the Batch</title>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/register.css">
</head>
<body>

<div class="header">
    <h1 class="header1"> Timetabler 766 </h1>
</div>
<ul class="nav_link" style="margin-bottom: 0">
    <li><a href="${pageContext.request.contextPath}/lecturer"> Home</a></li>
</ul>

<!------ Include the above in your HEAD tag ---------->

<div class="container register" style="max-width: 100%;">
    <div class="row">
        <div class="col-md-3 register-left">
            <img src="https://img.icons8.com/plasticine/100/ffffff/ingredients-list.png"/>
            <%--            <img src="https://img.icons8.com/material/100/ffffff/add-list--v1.png"/>--%>
            <%--            <img src="https://i.ibb.co/6bkWbL7/icons8-business-group-64.png" alt="icons8-business-group-64" border="0">--%>
            <h3>Your Current Teaching Modules </h3>
            <p> And Number of Batches Enrolled </p>

        </div>
        <div class="col-md-9 register-right">

            <div class="tab-content" id="myTabContent">
                <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
                    <h3 class="register-heading">Lecturers Modules</h3>

                    <div class="row register-form">
                        <div class="col-md-6">
                            <%--                            <ul class="list-group list-group-flush">--%>
                            <%--                                <c:forEach var="moduelList" items="${moduleInfoList}" >--%>
                            <%--                                    <li class="list-group-item">${moduelList.moduleName}</li>--%>
                            <%--                                </c:forEach>--%>
                            <%--                            </ul>--%>
                            <c:forEach var="moduelList" items="${moduleInfoList}">

                                <%--                                <li class="list-group-item d-flex justify-content-between align-items-center">--%>
                                <%--                                ${moduelList.moduleName}--%>
                                <%--                                    <span class="badge badge-success badge-pill">${moduelList.batchList.size()} Batches</span>--%>
                                <%--                                   <br>--%>
                                <%--                                    <c:forEach var="batches" items="${moduelList.batchList}">--%>
                                <%--                                        <p>${batches.batchCode}</p>--%>
                                <%--                                    </c:forEach>--%>

                                <%--                                </li>--%>

                                <div class="card text-white bg-info mb-3  text-center"
                                     style="max-width: 18rem; max-height: 18rem;">
                                    <div class="card-header">${moduelList.moduleCode}
                                        <span class="badge badge-success badge-pill">${moduelList.batchList.size()} Batches</span>
                                    </div>
                                    <div class="card-body">
                                        <h5 class="card-title">${moduelList.moduleName}</h5>
                                        <c:forEach var="batches" items="${moduelList.batchList}">
                                           ${batches.batchCode}*
                                        </c:forEach>
                                    </div>

                                </div>
                            </c:forEach>


                        </div>

                        <div class="col-md-6">

                        </div>
                    </div>

                </div>

            </div>
        </div>
    </div>

</div>
</body>
</html>


