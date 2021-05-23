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
    <title>View Modules of the Batch</title>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/register.css">
</head>
<body>

<div class="header">
    <h1 class="header1"> Timetable System </h1>
</div>
<ul class="nav_link" style="margin-bottom: 0">
    <li><a href="${pageContext.request.contextPath}/admin">Admin Home</a></li>
</ul>

<!------ Include the above in your HEAD tag ---------->

<div class="container register" style="max-width: 100%;">
    <div class="row">
        <div class="col-md-3 register-left">
            <img src="https://img.icons8.com/dotty/80/ffffff/add-book.png"/>
            <img src="https://img.icons8.com/dotty/80/ffffff/elective.png"/>

            <h3>Modules Enrolled with the Batch</h3>
            <p> Batch : ${batchinfo.batchCode} </p>
            <p> Description : ${batchinfo.description}</p>
        </div>
        <div class="col-md-9 register-right">

            <div class="tab-content" id="myTabContent">
                <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
                    <h3 class="register-heading">Modules List</h3>

                    <div class="row register-form">
                        <div class="col-md-6">
                            <ul class="list-group list-group-flush">
                                <c:forEach var="moduelList" items="${moduleList}" >
                                    <li class="list-group-item">${moduelList.moduleName}</li>
                                </c:forEach>
                            </ul>
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


