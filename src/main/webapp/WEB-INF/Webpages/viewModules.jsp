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
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

</head>
<body style="background : -webkit-linear-gradient(right,#c4e5ec, #5484c7);">
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

        <li  style="float:right"> <form method="post" action="${pageContext.request.contextPath}/logout"> <button type="submit" class="fa fa-sign-out nav-link" > Logout</button></form> </li>
    </ul>
</nav>
<div class="row justify-content-center successmessage" role="alert" >
    ${deleted}
    ${error}
</div>

<table class="content-table">

    <thead><tr>
        <th>Module ID </th>
        <th> Module Name </th>
        <th>  Batches Enrolled  </th>
        <th>  Module Lecturer </th>
        <th>  Update </th>
        <th>  Lecturer Assign </th>
        <th>   DeAssign </th>



    </tr>
    </thead>
    <tbody>

    <c:forEach var="tempModules" items="${modules}">

        <tr>
            <td>${tempModules.module_id}</td>
            <td>${tempModules.moduleName}</td>
            <td>
                <c:forEach items="${tempModules.batchList}" var="batchlist">
                    ${batchlist.batchCode} <br>
                </c:forEach>
            </td>
            <td>${tempModules.lecUser.firstname}</td>
            <td>
         <a href="${pageContext.request.contextPath}/updateModuleForm/${tempModules.module_id}" class="btn btn-outline-danger">
             <i class="material-icons">&#xe3c9;</i>
         </a>

            </td>
            <td>
               <a href="${pageContext.request.contextPath}/assignModuleForm/${tempModules.module_id}" class="btn btn-outline-success ">
                   <i class="material-icons">&#xea4d;</i>
               </a>
            </td>
            <td>
                <a href="${pageContext.request.contextPath}/deAssign/${tempModules.module_id}" class="btn btn-outline-secondary ">
                    <i class="material-icons">&#xe7ad;</i>
                </a>
            </td>

        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
