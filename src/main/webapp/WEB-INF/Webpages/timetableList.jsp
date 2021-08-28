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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/viewSheduleList.css">
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
</head>
<body style="background : -webkit-linear-gradient(right,#c4e5ec, #5484c7);">

<div class="header">
    <h1 class="head" >Timetabler 766</h1>
</div>
<%--<ul>--%>
<%--    <li><a  href="${pageContext.request.contextPath}/admin">home</a></li>--%>

<%--</ul>--%>
<nav class="fill">
    <ul>
        <li> <a class="nav-link" href="${pageContext.request.contextPath}/admin">Home</a></li>

<%--     <li style="float:right"><a class="fa fa-sign-out nav-link"  href="${pageContext.request.contextPath}/logout"> Logout</a></li>--%>
        <li  style="float:right">  <form action="${pageContext.request.contextPath}/admin/searchTimetable" method="get" class="d-flex">
            <input class="form-control" style="width: 200px; border-radius: 25px 25px 25px 25px" type="date"  name="date" placeholder="Search..(First Name)" aria-label="Search" required="required">
            <button class="btn btn-primary" type="submit"><i class="fa fa-search"></i></button>

        <li/>


        <li  style="float:right"> <form method="post" action="${pageContext.request.contextPath}/logout">

            <button type="submit" class="fa fa-sign-out nav-link" > Logout</button></form> </li>

    </ul>
</nav>
<%--<div class="row justify-content-center  headingg">--%>
<%--    <h3>--%>
<%--        Please Select a Batch to Schedule the  time table--%>
<%--    </h3>--%>
<%--</div>--%>
<c:if test="${deleted !=  null }">
    <div class="container mt-2">
        <div class="row">
            <div class="col-sm-12">

                <div class="alert alert-success" style="text-align: center">
                        ${deleted}
                </div>
            </div>
        </div>
    </div>
</c:if>
<c:if test="${error !=  null }">
    <div class="container mt-2">
        <div class="row">
            <div class="col-sm-12">

                <div class="alert alert-danger" style="text-align: center">
                        ${error}
                </div>
            </div>
        </div>
    </div>
</c:if>
<%--<table class="content-table">--%>

<%--    <thead><tr>--%>
<%--        <th>Batches</th>--%>
<%--        <th>Date</th>--%>
<%--        <th>Start Time </th>--%>
<%--        <th> End Time </th>--%>
<%--        <th>  Module  </th>--%>
<%--        <th>   Room </th>--%>
<%--        <th>   Room Type </th>--%>
<%--        <th>  Lecturer  </th>--%>
<%--        <th> Reschedule</th>--%>
<%--        <th> Delete</th>--%>

<%--    </tr>--%>
<%--    </thead>--%>
<%--    <tbody>--%>

<%--    <c:forEach var="temptimetable" items="${allSchedules}">--%>

<%--        <tr>--%>
<%--            <td>--%>
<%--                    <c:forEach items="${temptimetable.batchList}" var="batchlist">--%>
<%--                     ${batchlist.batchCode} <br>--%>
<%--                    </c:forEach>--%>
<%--            </td>--%>
<%--            <td> ${temptimetable.date} </td>--%>
<%--            <td>${temptimetable.startTime}</td>--%>
<%--            <td>${temptimetable.endTIme}</td>--%>
<%--            <td>${temptimetable.module.moduleName}</td>--%>
<%--            <td>${temptimetable.classRoom.roomId}</td>--%>
<%--            <td>${temptimetable.classRoom.roomType}</td>--%>
<%--            <td>${temptimetable.module.lecUser.firstname}</td>--%>
<%--            <td>--%>
<%--                <span><a href="${pageContext.request.contextPath}/admin/rescheduleDirect/${temptimetable.timetableID}" class="btn btn-success">--%>
<%--                    <i class="material-icons">&#xe923;</i>--%>
<%--                </a>--%>
<%--                </span>--%>
<%--            </td>--%>
<%--            <td>--%>
<%--                <span><a href="${pageContext.request.contextPath}/deleteTimetable/${temptimetable.timetableID}" class="btn btn-danger" onclick="return confirm('Delete this Schedule')">--%>

<%--                <i class="material-icons">&#xe872;</i>--%>
<%--                    </a>--%>
<%--                </span>--%>
<%--            </td>--%>



<%--        </tr>--%>
<%--    </c:forEach>--%>
<%--    </tbody>--%>
<%--</table>--%>

<div class="container">
    <div class="row">
        <div class="col-md-offset-1 col-md-10 ss">
            <div class="panel">
                <div class="panel-heading">
                    <div class="row">
                        <div class="col col-sm-3 col-xs-12">
                            <h4   class="title">Schedule <span>List</span></h4>
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
                                    <th>Batches</th>
                                    <th>Date  Scheduled   </th>
                                    <th>Start  Time </th>
                                    <th>Ending   Time  </th>
                                    <th>  Module Name   </th>
                                    <th>   Room ID </th>
                                    <th>   Type of Room </th>
                                    <th>  Lecturer  </th>
                                    <th> Reschedule</th>
                                    <th> Delete</th>
                        </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="temptimetable" items="${allSchedules}">
                            <td>

                                                        <c:forEach items="${temptimetable.batchList}" var="batchlist">
                                                         ${batchlist.batchCode} <br>
                                                        </c:forEach>
                                                </td>
                                                <td> ${temptimetable.date} </td>
                                                <td>${temptimetable.startTime}</td>
                                                <td>${temptimetable.endTIme}</td>
                                                <td>${temptimetable.module.moduleName}</td>
                                                <td>${temptimetable.classRoom.roomId}</td>
                                                <td>${temptimetable.classRoom.roomType}</td>
                                                <td>${temptimetable.module.lecUser.firstname}</td>
                                                <td>
                                                    <span><a href="${pageContext.request.contextPath}/admin/rescheduleDirect/${temptimetable.timetableID}" class="btn btn-outline-success">
                                                        <i class="material-icons">&#xe923;</i>
                                                    </a>
                                                    </span>
                                                </td>
                                                <td>
                                                    <span><a href="${pageContext.request.contextPath}/deleteTimetable/${temptimetable.timetableID}" class="btn btn-outline-danger" onclick="return confirm('Delete this Schedule')">

                                                    <i class="material-icons">&#xe872;</i>
                                                        </a>
                                                    </span>
                            </td>
                            </tr>
                        </c:forEach>

                        </tbody>
                    </table>
                    <c:if test="${allSchedules.size() == 0 }">
                        <div class="container mt-2">
                            <div class="row">
                                <div class="col-sm-12">

                                    <div class="alert alert-success" style="text-align: center">
                                        No Schedules for this Day.
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

</body>
</html>
