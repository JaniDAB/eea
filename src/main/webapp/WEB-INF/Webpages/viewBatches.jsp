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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/viewModules.css">
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
</head>
<body style="background-image: url(/images/timetable.png)">

<div class="header">
    <h1 class="head" >Time Table System</h1>
</div>
<ul>
    <li><a  href="${pageContext.request.contextPath}/admin">home</a></li>

</ul>

<table class="content-table">

    <thead><tr>
        <th>Batch ID </th>
        <th> Batch Code </th>
        <th> Batch Description </th>
        <th> Edit Batch </th>
        <th> Assign Modules to Batch </th>
        <th> More Info </th>


    </tr>
    </thead>
    <tbody>

    <c:forEach var="tempBatch" items="${batches}">

        <tr>
            <td>${tempBatch.batchID}</td>
            <td>${tempBatch.batchCode}</td>
            <td>${tempBatch.description}</td>
            <td>
                <span><a href="${pageContext.request.contextPath}/directUpdateMBatchForm/${tempBatch.batchID}" class="btn btn-outline-primary">Edit</a>
                </span>
            </td>
            <td>
                <span><a href="${pageContext.request.contextPath}/assignModule/${tempBatch.batchID}" class="btn btn-outline-primary">Assign</a>
                </span>
            </td>
            <td>
                <span><a href="${pageContext.request.contextPath}/modulelist/${tempBatch.batchID}" class="btn btn-outline-primary">Info</a>
                </span>
            </td>


        </tr>
    </c:forEach>
    </tbody>
</table>


</body>
</html>
