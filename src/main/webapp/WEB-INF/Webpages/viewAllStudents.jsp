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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/viewSheduleList.css">
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>

</head>
<body style="background : -webkit-linear-gradient(right,#c4e5ec, #5484c7);">

<div class="header">
    <h1>Timetabler 766</h1>
</div>

<%--<ul>--%>
<%--    <li><a  href="${pageContext.request.contextPath}/admin">Home</a></li>--%>
<%--    <li><a href="${pageContext.request.contextPath}/admin/users/allLectruer">View Lecturers</a></li>--%>

<%--    <li style="float:right"><a class="fa fa-sign-out" href="${pageContext.request.contextPath}/logout">Log out</a></li>--%>


<%--</ul>--%>

<nav class="fill">
    <ul>
        <li><a   class="nav-link" href="${pageContext.request.contextPath}/admin">Home</a></li>
            <li><a   class="nav-link" href="${pageContext.request.contextPath}/admin/users/allLectruer">View Lecturers</a></li>
        <li  style="float:right">  <form action="${pageContext.request.contextPath}/admin/searchUser" method="get" class="d-flex">
            <input class="form-control" style="width: 200px; border-radius: 25px 25px 25px 25px" type="search"  name="searchByName" placeholder="Search..(UserName)" required="required" aria-label="Search">
            <button class="btn btn-primary" type="submit"><i class="fa fa-search"></i></button>

        <li/>
        <li  style="float:right"> <form method="post" action="${pageContext.request.contextPath}/logout"> <button type="submit" class="fa fa-sign-out nav-link" > Logout</button></form> </li>

    </ul>
</nav>
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
                            <h4  routerLink="/list-users" class="title">Students <span></span></h4>
                        </div>
                        <div class="col-sm-9 col-xs-12 text-right">
                            <c:if test="${deAssigned !=  null }">
                                <div class="container mt-2">
                                    <div class="row">
                                        <div class="col-sm-12">

                                            <div class="alert alert-success" style="text-align: center">
                                                    ${deAssigned}
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </c:if>
                            <c:if test="${deleted !=  null }">
                                <div class="container mt-2">
                                    <div class="row">
                                        <div class="col-sm-12">

                                            <div class="alert alert-danger" style="text-align: center">
                                                    ${deleted} <i class="fa fa-trash" aria-hidden="true"></i>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </c:if>
                            <c:if test="${error !=  null }">
                                <div class="container mt-2">
                                    <div class="row">
                                        <div class="col-sm-12">

                                            <div class="alert alert-danger" style="text-align: center">
                                                    ${error}
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </c:if>
                            <c:if test="${errord !=  null }">
                                <div class="container mt-2">
                                    <div class="row">
                                        <div class="col-sm-12">

                                            <div class="alert alert-danger" style="text-align: center">
                                                    ${errord}
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </c:if>
                            <div class="btn_group">

                            </div>
                        </div>


                    </div>
                </div>
                <div class="panel-body table-responsive">
                    <table class="table">
                        <thead>
                        <tr>
                            <th> First Name</th>
                            <th> Last Name</th>
                            <th>Email</th>
                            <th>gender</th>
                            <th>*****Date**** of Birth</th>
                            <th> User Name</th>
                            <th>Batch</th>
                            <th>phone Number</th>
                            <th>Edit</th>
                            <th>Assign/De-Assign Batch</th>
                            <th>Delete </th>

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
                                <td><c:if test="${tempUser.batch.batchCode == null}">
                                    <div class="alert-warning" style="border-radius: 15px 15px"> N/A
                                        <i class="material-icons">&#xe001;</i>
                                    </div>
                                </c:if>
                                        ${tempUser.batch.batchCode}</td>
                                <td>${tempUser.mobile}</td>
                                <td>
                                    <a href="${pageContext.request.contextPath}/showFormUpdate/${tempUser.userId}" class="btn btn-primary">
                                        <i class="material-icons">&#xe3c9;</i>
                                    </a>

                                </td>
                                <td>
                                    <a href="${pageContext.request.contextPath}/assignBatch/${tempUser.userId}" class="btn btn-success">
                                        <i class="material-icons">&#xea4d;</i> </a>
                                    <a href="${pageContext.request.contextPath}/admin/deAssignBatch/${tempUser.userId}" class="btn btn-secondary">
                                        <i class="material-icons">&#xe7ad;</i>
                                    </a>

                                </td>
                                <td><a href="${pageContext.request.contextPath}/deleteUser/${tempUser.userId}" onclick="return confirm('Remove Student : ${tempUser.firstname}')" class="btn btn-outline-danger">
                                    <i class="material-icons">&#xe872;</i></a></td>


                            </tr>
                        </c:forEach>

                        </tbody>

                    </table>

                    <c:if test="${users.size() == 0 }">
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
                </div>

            </div>
        </div>
    </div>
</div>

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
            swal('Sorry', fail, "error");
        }
    }
</script>