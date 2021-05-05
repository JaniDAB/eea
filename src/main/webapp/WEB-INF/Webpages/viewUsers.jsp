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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/viewUsers.css">
</head>
<body>

<div class="header">
    <h1 >Time Table System</h1>
</div>

<ul>
    <li><a  href="${pageContext.request.contextPath}/admin/users/allStudents">View All Students</a></li>
    <li><a  href="${pageContext.request.contextPath}/admin/users/allLectruer">View All Lecturers</a></li>

</ul>

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
        <th>Delete</th>

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
            <td><button><a href="${Remove}">Remove</a></button></td>

        </tr>

    </c:forEach>
    </tbody>
</table>

</body>
</html>
