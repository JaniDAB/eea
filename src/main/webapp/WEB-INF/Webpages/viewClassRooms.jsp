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
    ${errorDelete}

</div>
<table class="content-table">

    <thead><tr>
        <th>Room ID </th>
        <th> Room Type </th>
        <th> Room Capacity </th>
        <th> Update</th>
        <th> Delete</th>


    </tr>
    </thead>
    <tbody>

    <c:forEach var="room" items="${rooms}">

        <tr>
            <td>${room.roomId}</td>
            <td>${room.roomType}</td>
            <td>${room.roomCapacity}</td>
            <td>
                <span><a href="${pageContext.request.contextPath}/admin/updateRoom/${room.roomId}" class="btn btn-primary">
                     <i class="material-icons">&#xe3c9;</i>
                </a>
                </span>
            </td>
            <td>
                <a href="${pageContext.request.contextPath}/admin/deleteRoom/${room.roomId}" onclick="return confirm('Remove Room:${room.roomId} ')" class="btn btn-danger">
                    <i class="material-icons">&#xe872;</i>
                </a>
            </td>


        </tr>
    </c:forEach>
    </tbody>
</table>


</body>
</html>
