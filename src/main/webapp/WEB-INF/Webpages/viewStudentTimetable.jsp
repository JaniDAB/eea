<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: janithdabare
  Date: 5/16/21
  Time: 19:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/viewSheduleList.css">
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

</head>
<body style="background : -webkit-linear-gradient(right,#c4e5ec, #5484c7);">

<div class="header">
    <h1 class="head">Timetabler 766</h1>
</div>
<%--<ul>--%>
<%--    <li><a  href="${pageContext.request.contextPath}/admin">home</a></li>--%>

<%--</ul>--%>

<%--<nav class="navbar navbar-expand-lg navbar-light bg-light">--%>

<%--    <div class="collapse navbar-collapse" id="navbarNav">--%>
<%--        <ul class="navbar-nav">--%>
<%--            <li class="nav-item active">--%>
<%--                <a class="nav-link" href="${pageContext.request.contextPath}/admin">Home</a>--%>
<%--            </li>--%>
<%--        </ul>--%>
<%--    </div>--%>
<%--</nav>--%>
<nav class="fill">
    <ul>
        <li><a class="nav-link" href="${pageContext.request.contextPath}/student">Home</a></li>
        <li><a class="nav-link" href="${pageContext.request.contextPath}/student/TodayTimetable">Today Schedules</a>
        </li>

        <li style="float:right">
            <form action="${pageContext.request.contextPath}/student/searchUser" method="get" class="d-flex">
                FROM<input class="form-control" style="width: 200px; border-radius: 25px 25px 25px 25px" type="date"
                       name="date" placeholder="Search..(First Name)" aria-label="Search" required="required">
                TO <input class="form-control" style="width: 200px; border-radius: 25px 25px 25px 25px" type="date"
                          name="date2" placeholder="Search.." aria-label="Search" required="required">
                <button class="btn btn-primary" type="submit"><i class="fa fa-search"></i></button>

        <li/>

        <li style="float:right">
            <form method="post" action="${pageContext.request.contextPath}/logout">
                <button type="submit" class="fa fa-sign-out nav-link"> Logout</button>
            </form>
        </li>
    </ul>
</nav>
<div class="row justify-content-center successmessage" role="alert">
    ${emptys}
</div>
<div class="container">
    <div class="row">
        <div class="col-md-offset-1 col-md-10 ss">
            <div class="panel">
                <div class="panel-heading">
                    <div class="row">
                        <div class="col col-sm-3 col-xs-12">
                            <h4 class="title">My <span>Schedules</span></h4>
                        </div>
                        <div class="col-sm-9 col-xs-12 text-right">
                            <div class="btn_group">

                            </div>
                        </div>


                    </div>
                </div>
                <div class="panel-body table-responsive">
                    <table class="table">
                        <thead>
                        <tr>
                            <th> Scheduled Date</th>
                            <th>Starting Time</th>
                            <th> Ending Time</th>
                            <th> Module</th>
                            <th> Room</th>
                            <th> Room Type</th>
                            <th> Lecturer</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="timetable" items="${timetableList}">

                            <tr>
                                <td> ${timetable.date} </td>
                                <td>${timetable.startTime}</td>
                                <td>${timetable.endTIme}</td>
                                <td>${timetable.module.moduleName}</td>
                                <td>${timetable.classRoom.roomId}</td>
                                <td>${timetable.classRoom.roomType}</td>
                                <td>${timetable.module.lecUser.firstname}</td>
                            </tr>
                        </c:forEach>
                        </tbody>

                    </table>
                    <c:if test="${timetableList.size() == 0 }">
                        <div class="container mt-2">
                            <div class="row">
                                <div class="col-sm-12">

                                    <div class="alert alert-success" style="text-align: center">
                                        No Schedules For today.
                                    </div>
                                </div>
                            </div>
                        </div>
                    </c:if>
                </div>

            </div>
        </div>
    </div>
</div>


<%--<table class="content-table">--%>

<%--    <thead><tr>--%>
<%--        <th>Date</th>--%>
<%--        <th>Start Time </th>--%>
<%--        <th> End Time </th>--%>
<%--        <th>  Module  </th>--%>
<%--        <th>   Room </th>--%>
<%--        <th>   Room Type </th>--%>
<%--        <th>  Lecturer  </th>--%>

<%--    </tr>--%>
<%--    </thead>--%>
<%--    <tbody>--%>

<%--    <c:forEach var="timetable" items="${timetableList}">--%>

<%--        <tr>--%>
<%--            <td> ${timetable.date} </td>--%>
<%--            <td>${timetable.startTime}</td>--%>
<%--            <td>${timetable.endTIme}</td>--%>
<%--            <td>${timetable.module.moduleName}</td>--%>
<%--            <td>${timetable.classRoom.roomId}</td>--%>
<%--            <td>${timetable.classRoom.roomType}</td>--%>
<%--            <td>${timetable.module.lecUser.firstname}</td>--%>


<%--        </tr>--%>
<%--    </c:forEach>--%>
<%--    </tbody>--%>
<%--</table>--%>


</body>
</html>
