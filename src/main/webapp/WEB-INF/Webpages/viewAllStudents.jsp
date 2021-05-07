<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: janithdabare
  Date: 5/5/21
  Time: 09:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View All Students</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/viewUsers.css">
</head>
<body>

<div class="header">
    <h1>Time Table System</h1>
</div>

<ul>
    <li><a href="${pageContext.request.contextPath}/admin/users/allLectruer">View Lecturers</a></li>

    <li style="float:right"><a href="${pageContext.request.contextPath}/logout">Log out</a></li>


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
        <th>phone Number</th>
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
            <td>
                <button><a href="${pageContext.request.contextPath}/showFormUpdate/${tempUser.userId}">Edit</a>
                </button>
            </td>

        </tr>

    </c:forEach>
    </tbody>
</table>

</body>
</html>
