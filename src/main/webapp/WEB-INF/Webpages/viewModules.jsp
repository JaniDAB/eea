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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/viewModules.css">
</head>
<body>
<div class="header">
    <h1 class="head" >Time Table System</h1>
</div>
<ul>
    <li><a  href="${pageContext.request.contextPath}/admin">home</a></li>

</ul>

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
                <button><a href="${pageContext.request.contextPath}/updateModuleForm/${tempModules.module_id}">Edit</a>
                </button>
            </td>
            <td>
                <button><a href="${pageContext.request.contextPath}/assignModuleForm/${tempModules.module_id}">Assign</a>
                </button>
            </td>

        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
