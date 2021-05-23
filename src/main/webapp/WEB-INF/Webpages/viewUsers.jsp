<%--
  Created by IntelliJ IDEA.
  User: janithdabare
  Date: 5/4/21
  Time: 17:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title> View User</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/viewStudents.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>

</head>
<body style="background : -webkit-linear-gradient(right,#c4e5ec, #5484c7);">

<div class="header">
    <h1 >Time Table System</h1>
</div>

<%--<ul>--%>
<%--    <li><a  href="${pageContext.request.contextPath}/admin">Home</a></li>--%>
<%--    <li><a  href="${pageContext.request.contextPath}/admin/users/allStudents">View Students & Assign Batches</a></li>--%>
<%--    <li><a  href="${pageContext.request.contextPath}/admin/users/allLectruer">View All Lecturers</a></li>--%>

<%--    <li><a  class="fa fa-sign-out"  href="${pageContext.request.contextPath}/login">Log out</a></li>--%>
<%--</ul>--%>
<nav class="fill">
    <ul>
        <li><a   class="nav-link" href="${pageContext.request.contextPath}/admin">Home</a></li>
        <li><a class="nav-link" href="${pageContext.request.contextPath}/admin/users/allStudents">View Students & Assign Batches</a></li>
        <li><a   class="nav-link" href="${pageContext.request.contextPath}/admin/users/allLectruer">View Lecturers</a></li>
        <li  style="float:right"> <form method="post" action="${pageContext.request.contextPath}/logout"> <button type="submit" class="fa fa-sign-out nav-link" > Logout</button></form> </li>

    </ul>
</nav>
<div class="row justify-content-center alert-light ml-5 successmessage" role="alert" style="color: #55efc4">
    ${deleted}
</div>

<table class="content-table">
    <thead>
    <tr>
        <th> First Name</th>
        <th> Last Name</th>
        <th>Email</th>
        <th>gender</th>
        <th>Date of Birth</th>
        <th> User Name</th>
        <th>Contact Number</th>


    </tr>
    </thead>
    <tbody>

    <c:forEach var="tempUser" items="${users}">

        <tr>
            <td> ${tempUser.firstname}</td>
            <td>${tempUser.lastname}</td>
            <td>${tempUser.email}</td>
            <td>${tempUser.gender}</td>
            <td>${tempUser.dateOfBirth}</td>
            <td>${tempUser.username}</td>
            <td>${tempUser.mobile}</td>

        </tr>

    </c:forEach>
    </tbody>
</table>

</body>
</html>
