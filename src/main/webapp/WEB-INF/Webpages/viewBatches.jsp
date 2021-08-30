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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/viewUser.css">
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <!-- JavaScript -->
    <script src="//cdn.jsdelivr.net/npm/alertifyjs@1.13.1/build/alertify.min.js"></script>

    <!-- CSS -->
    <link rel="stylesheet" href="//cdn.jsdelivr.net/npm/alertifyjs@1.13.1/build/css/alertify.min.css"/>
    <!-- Default theme -->
    <link rel="stylesheet" href="//cdn.jsdelivr.net/npm/alertifyjs@1.13.1/build/css/themes/default.min.css"/>
    <!-- Semantic UI theme -->
    <link rel="stylesheet" href="//cdn.jsdelivr.net/npm/alertifyjs@1.13.1/build/css/themes/semantic.min.css"/>
    <!-- Bootstrap theme -->
    <link rel="stylesheet" href="//cdn.jsdelivr.net/npm/alertifyjs@1.13.1/build/css/themes/bootstrap.min.css"/>
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>

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
        <li  style="float:right"> <form method="post" action="${pageContext.request.contextPath}/logout"> <button type="submit" class="fa fa-sign-out nav-link" > Logout</button></form> </li>

    </ul>
</nav>

<div>
    <p style="display: none" id="deleted">${deleted}</p>
</div>
<div>
    <p style="display: none" id="error">${error}</p>
</div>
<div>
    <p style="display: none" id="success">${successful}</p>
</div>
<div>
    <p style="display: none" id="fail">${fail}</p>
</div>
<div class="container">
    <div class="row">
        <div class="col-md-offset-1 col-md-10 ss">
            <div class="panel">
                <div class="panel-heading">
                    <div class="row">
                        <div class="col col-sm-3 col-xs-12">
                            <h4   class="title">Batch <span>Lists</span></h4>
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

                                    <th> Batch Code </th>
                                    <th> Batch Description </th>
                                    <th> Edit And Delete Batch </th>
                                    <th> Assign Modules to Batch </th>
                            <th>  Modules Assigned </th>
                                    <th> More Info </th>
                        </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="tempBatch" items="${batches}">
                            <tr>


                                                <td>${tempBatch.batchCode}</td>
                                                <td>${tempBatch.description}</td>
                                                <td>
                                                    <span><a href="${pageContext.request.contextPath}/directUpdateMBatchForm/${tempBatch.batchID}" class="btn btn-primary">
                                                        <i class="material-icons">&#xe3c9;</i>
                                                    </a>
                                                        <a href="${pageContext.request.contextPath}/deleteBatch/${tempBatch.batchID}" onclick="return confirm('Delete Batch :${tempBatch.batchCode}')" class="btn btn-danger">
                                                            <i class="material-icons">&#xe872;</i>
                                                        </a>
                                                    </span>
                                                </td>
                                                <td>
                                                    <span><a href="${pageContext.request.contextPath}/assignModule/${tempBatch.batchID}" class="btn btn-success">
                                                         <i class="material-icons">&#xea20;</i>
                                                    </a>
                                                    </span>
                                                </td>
                                <td>
                                        ${tempBatch.moduleListSize }
                                </td>
                                                <td>
                                                    <c:if test="${tempBatch.moduleListSize>0 }">

                                                    <span><a href="${pageContext.request.contextPath}/modulelist/${tempBatch.batchID}" class="btn btn-outline-info">
                                                            <i class="material-icons">&#xe88e;</i>
                                                    </a>
                                                    </span>
                                                    </c:if>
                                                    <c:if test="${tempBatch.moduleListSize==0}">
                                                    <span >
<%--                                                        <a onclick="alert('Cannot Schedule For this Module....');" class="btn btn-outline-danger">--%>
                                                        <a onclick=" alertify.alert('Cannot View', 'No Modules has been Assigned to Batch : ${tempBatch.batchCode} ..!');" class="btn btn-outline-danger">
                                                         <i class="material-icons">&#xe88e;</i>
                                                    </a>
                                                    </span>
                                                    </c:if>
                                                </td>
                            </tr>
                        </c:forEach>

                        </tbody>
                    </table>

                </div>

            </div>
        </div>
    </div>
</div>
<c:if test="${batches.size() == 0 }">
    <div class="container mt-2">
        <div class="row">
            <div class="col-sm-12">

                <div class="alert alert-primary" style="text-align: center">
                    No Data Found
                </div>
            </div>
        </div>
    </div>
</c:if>

</body>
</html>

<script>
    window.onload = function (){
        const success = document.getElementById("success").innerHTML;
        const fail = document.getElementById("fail").innerHTML;

        console.log(success);
        if(success !== ""){
            swal('Done', success, "success");
        }
        if(fail !== ""){
            swal("Oops", fail, "error");        }
    }



</script>