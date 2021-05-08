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
        <th>Batch ID </th>
        <th> Batch Code </th>
        <th> Batch Description </th>


    </tr>
    </thead>
    <tbody>

    <c:forEach var="tempBatch" items="${batches}">

        <tr>
            <td>${tempBatch.batchID}</td>
            <td>${tempBatch.batchCode}</td>
            <td>${tempBatch.description}</td>
            <td>
                <button><a href="${pageContext.request.contextPath}/directUpdateMBatchForm/${tempBatch.batchID}">Edit</a>
                </button>
            </td>


        </tr>
    </c:forEach>
    </tbody>
</table>


</body>
</html>
