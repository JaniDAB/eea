<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: janithdabare
  Date: 5/8/21
  Time: 09:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View Batches</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/viewUsers.css">
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

</head>
<body style="background : -webkit-linear-gradient(right,#c4e5ec, #5484c7);">

<div class="header">
    <h1 class="head" >Time Table System</h1>
</div>
<%--<ul>--%>
<%--    <li><a  href="${pageContext.request.contextPath}/admin">home</a></li>--%>

<%--</ul>--%>

<nav class="fill">
    <ul>
        <li> <a class="nav-link" href="${pageContext.request.contextPath}/admin">Home</a></li>
        <li  style="float:right"> <form method="post" action="${pageContext.request.contextPath}/logout"> <button type="submit" class="fa fa-sign-out nav-link" > Logout</button></form> </li>

    </ul>
</nav>
<div class="row justify-content-center successmessage" role="alert" >
    ${deleted}
    ${error}
</div>
<table class="content-table">

    <thead><tr>
        <th>Batch ID </th>
        <th> Batch Code </th>
        <th> Batch Description </th>
        <th> Edit And Delete Batch </th>
        <th> Assign Modules to Batch </th>
        <th> More Info </th>

    </tr>
    </thead>
    <tbody>

    <c:forEach var="tempBatch" items="${batches}">

        <tr>
            <td>${tempBatch.batchID}</td>
            <td>${tempBatch.batchCode}</td>
            <td>${tempBatch.description}</td>
            <td>
                <span><a href="${pageContext.request.contextPath}/directUpdateMBatchForm/${tempBatch.batchID}" class="btn btn-primary">
                    <i class="material-icons">&#xe3c9;</i>
                </a>
                    <a href="${pageContext.request.contextPath}/deleteBatch/${tempBatch.batchID}" onclick="return confirm('Delete Batch :${tempBatch.batchCode}')" class="btn btn-danger">
                        <i class="material-icons">&#xe872;</i>
                    </a>
                </span>
            </td>
            <td>
                <span><a href="${pageContext.request.contextPath}/assignModule/${tempBatch.batchID}" class="btn btn-success">
                     <i class="material-icons">&#xea20;</i>
                </a>
                </span>
            </td>
            <td>
                <span><a href="${pageContext.request.contextPath}/modulelist/${tempBatch.batchID}" class="btn btn-outline-info">
                        <i class="material-icons">&#xe88e;</i>
                </a>
                </span>
            </td>


        </tr>
    </c:forEach>
    </tbody>
</table>


</body>
</html>
