<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: janithdabare
  Date: 5/7/21
  Time: 21:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View All Modules</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/viewUsers.css">
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

</head>
<body>
<div class="header">
    <h1 class="head" >Time Table System</h1>
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
        <li> <a class="nav-link" href="${pageContext.request.contextPath}/admin">Home</a></li>

        <li style="float:right"><a class="fa fa-sign-out nav-link"  href="${pageContext.request.contextPath}/logout"> Logout</a></li>
    </ul>
</nav>

<table class="content-table">

    <thead><tr>
        <th>Module ID </th>
        <th> Module Name </th>
        <th>  Module Lecturer </th>
        <th>  Update </th>
        <th>  Lecturer Assign </th>


    </tr>
    </thead>
    <tbody>

    <c:forEach var="tempModules" items="${modules}">

        <tr>
            <td>${tempModules.module_id}</td>
            <td>${tempModules.moduleName}</td>
            <td>${tempModules.lecUser.firstname}</td>
            <td>
         <a href="${pageContext.request.contextPath}/updateModuleForm/${tempModules.module_id}" class="btn btn-outline-danger">Edit</a>

            </td>
            <td>
               <a href="${pageContext.request.contextPath}/assignModuleForm/${tempModules.module_id}" class="btn btn-outline-success">Assign</a>
            </td>

        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
