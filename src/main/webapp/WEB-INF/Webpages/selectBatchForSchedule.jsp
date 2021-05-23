<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: janithdabare
  Date: 5/14/21
  Time: 19:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View Batches</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/viewM.css">
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

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
        <li> <a class="nav-link" href="${pageContext.request.contextPath}/addRoom">Add Room</a></li>
        <li> <a class="nav-link" href="${pageContext.request.contextPath}/getAllSchedules">View Schedule</a></li>

        <li style="float:right"><a class="fa fa-sign-out nav-link"  href="${pageContext.request.contextPath}/logout"> Logout</a></li>
    </ul>
</nav>
<div class="row justify-content-center  headingg">
    <h3>
        Please Select a Batch to Schedule the  time table
    </h3>
</div>

<table class="content-table">

    <thead><tr>
        <th> Batch Code </th>
        <th> Batch Description </th>
        <th> Schedule a Time table </th>

    </tr>
    </thead>
    <tbody>

    <c:forEach var="tempBatch" items="${batches}">

        <tr>
            <td>${tempBatch.batchCode}</td>
            <td>${tempBatch.description}</td>
            <td>
                <span><a href="${pageContext.request.contextPath}/admin/addTimetable/${tempBatch.batchID}" class="btn btn-success">Schedule</a>
                </span>
            </td>



        </tr>
    </c:forEach>
    </tbody>
</table>


</body>
</html>
