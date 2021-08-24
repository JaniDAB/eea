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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/viewUser.css">
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

</head>
<body style="background : -webkit-linear-gradient(right,#c4e5ec, #5484c7);">
<div class="header">
    <h1 class="head" >TimeTabler 766</h1>
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

<c:if test="${deleted !=  null }">
    <div class="container mt-2">
        <div class="row">
            <div class="col-sm-12">

                <div class="alert alert-success" style="text-align: center">
                        ${deleted}
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

<%--<table class="content-table">--%>

<%--    <thead><tr>--%>
<%--        <th>Module Code </th>--%>
<%--        <th> Module Name </th>--%>
<%--        <th>  Batches Enrolled  </th>--%>
<%--        <th>  Module Lecturer </th>--%>
<%--        <th>  Update </th>--%>
<%--        <th>  Lecturer Assign </th>--%>
<%--        <th>   DeAssign </th>--%>



<%--    </tr>--%>
<%--    </thead>--%>
<%--    <tbody>--%>

<%--    <c:forEach var="tempModules" items="${modules}">--%>

<%--        <tr>--%>
<%--            <td>${tempModules.moduleCode}</td>--%>
<%--            <td>${tempModules.moduleName}</td>--%>
<%--            <td>--%>
<%--                <c:if test="${tempModules.batchList.size()==0}">--%>
<%--                    <div class="alert-warning" style="border-radius: 20px 20px 20px 20px"> No Batches Enrolled--%>
<%--                        <i class="material-icons">&#xe001;</i>--%>
<%--                    </div>--%>
<%--                </c:if>--%>
<%--                <c:forEach items="${tempModules.batchList}" var="batchlist">--%>
<%--                    ${batchlist.batchCode} <br>--%>
<%--                </c:forEach>--%>
<%--            </td>--%>
<%--            <td>--%>
<%--                <c:if test="${tempModules.lecUser.firstname == null}">--%>
<%--                    <div class="alert-warning" style="border-radius: 20px 20px 20px 20px"> No Lecturer--%>
<%--                        <i class="material-icons">&#xe001;</i>--%>
<%--                    </div>--%>
<%--                </c:if>--%>
<%--                    ${tempModules.lecUser.firstname}</td>--%>
<%--            <td>--%>
<%--         <a href="${pageContext.request.contextPath}/updateModuleForm/${tempModules.module_id}" class="btn btn-danger">--%>
<%--             <i class="material-icons">&#xe3c9;</i>--%>
<%--         </a>--%>

<%--            </td>--%>
<%--            <td>--%>
<%--               <a href="${pageContext.request.contextPath}/assignModuleForm/${tempModules.module_id}" class="btn btn-success ">--%>
<%--                   <i class="material-icons">&#xea4d;</i>--%>
<%--               </a>--%>
<%--            </td>--%>
<%--            <td>--%>
<%--                <a href="${pageContext.request.contextPath}/deAssign/${tempModules.module_id}" class="btn btn-secondary ">--%>
<%--                    <i class="material-icons">&#xe7ad;</i>--%>
<%--                </a>--%>
<%--            </td>--%>

<%--        </tr>--%>
<%--    </c:forEach>--%>
<%--    </tbody>--%>
<%--</table>--%>
<div class="container">
    <div class="row">
        <div class="col-md-offset-1 col-md-10 ss">
            <div class="panel">
                <div class="panel-heading">
                    <div class="row">
                        <div class="col col-sm-3 col-xs-12">
                            <h4   class="title">Module <span>List</span></h4>
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
                                    <th>Module Code </th>
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
                                    <td>${tempModules.moduleCode}</td>
                                    <td>${tempModules.moduleName}</td>
                                    <td>
                                        <c:if test="${tempModules.batchList.size()==0}">
                                            <div class="alert-dark" style="border-radius: 20px 20px 20px 20px"> Not Enrolled
                                                <i class="material-icons">&#xe001;</i>
                                                <br>
                                            </div>
                                        </c:if>
                                        <c:forEach items="${tempModules.batchList}" var="batchlist">
                                            ${batchlist.batchCode}* <br> <br>
                                        </c:forEach>
                                    </td>
                                    <td>
                                        <c:if test="${tempModules.lecUser.firstname == null}">
                                            <div class="alert-warning" style="border-radius: 20px 20px 20px 20px"> No Lecturer
                                                <i class="material-icons">&#xe001;</i>
                                            </div>
                                        </c:if>
                                            ${tempModules.lecUser.firstname}</td>
                                    <td>
                                 <a href="${pageContext.request.contextPath}/updateModuleForm/${tempModules.module_id}" class="btn btn-danger">
                                     <i class="material-icons">&#xe3c9;</i>
                                 </a>

                                    </td>
                                    <td>
                                       <a href="${pageContext.request.contextPath}/assignModuleForm/${tempModules.module_id}" class="btn btn-success ">
                                           <i class="material-icons">&#xea4d;</i>
                                       </a>
                                    </td>
                                    <td>
                                        <a href="${pageContext.request.contextPath}/deAssign/${tempModules.module_id}" class="btn btn-secondary ">
                                            <i class="material-icons">&#xe7ad;</i>
                                        </a>
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
