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
    <title>View Schedule </title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/viewUsers.css">
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
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

        <li style="float:right"><a class="fa fa-sign-out nav-link"  href="${pageContext.request.contextPath}/logout"> Logout</a></li>
    </ul>
</nav>
<%--<div class="row justify-content-center  headingg">--%>
<%--    <h3>--%>
<%--        Please Select a Batch to Schedule the  time table--%>
<%--    </h3>--%>
<%--</div>--%>

<table class="content-table">

    <thead><tr>
        <th>Batch</th>
        <th>Date</th>
        <th>Start Time </th>
        <th> End Time </th>
        <th>  Module  </th>
        <th>   Room </th>
        <th>   Room Type </th>
        <th>  Lecturer  </th>
        <th> Reschedule</th>
    </tr>
    </thead>
    <tbody>

    <c:forEach var="temptimetable" items="${allSchedules}">

        <tr>
            <td> ${temptimetable.batch.batchCode} </td>
            <td> ${temptimetable.date} </td>
            <td>${temptimetable.startTime}</td>
            <td>${temptimetable.endTIme}</td>
            <td>${temptimetable.module.moduleName}</td>
            <td>${temptimetable.classRoom.roomId}</td>
            <td>${temptimetable.classRoom.roomType}</td>
            <td>${temptimetable.module.lecUser.firstname}</td>
            <td>
                <span><a href="${pageContext.request.contextPath}/admin/rescheduleDirect/${temptimetable.timetableID}/${temptimetable.batch.batchID}" class="btn btn-success">Reschedule</a>
                </span>
            </td>



        </tr>
    </c:forEach>
    </tbody>
</table>


</body>
</html>
