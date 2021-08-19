<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: janithdabare
  Date: 5/14/21
  Time: 19:40
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

    <script>

    var ALERT_TITLE = "Oops!";
    var ALERT_BUTTON_TEXT = "Ok";

    if(document.getElementById) {
        window.alert = function(txt) {
            createCustomAlert(txt);
        }
    }

    function createCustomAlert(txt) {
        d = document;

        if(d.getElementById("modalContainer")) return;

        mObj = d.getElementsByTagName("body")[0].appendChild(d.createElement("div"));
        mObj.id = "modalContainer";
        mObj.style.height = d.documentElement.scrollHeight + "px";

        alertObj = mObj.appendChild(d.createElement("div"));
        alertObj.id = "alertBox";
        if(d.all && !window.opera) alertObj.style.top = document.documentElement.scrollTop + "px";
        alertObj.style.left = (d.documentElement.scrollWidth - alertObj.offsetWidth)/2 + "px";
        alertObj.style.visiblity="visible";

        h1 = alertObj.appendChild(d.createElement("h1"));
        h1.appendChild(d.createTextNode(ALERT_TITLE));

        msg = alertObj.appendChild(d.createElement("p"));
        //msg.appendChild(d.createTextNode(txt));
        msg.innerHTML = txt;

        btn = alertObj.appendChild(d.createElement("a"));
        btn.id = "closeBtn";
        btn.appendChild(d.createTextNode(ALERT_BUTTON_TEXT));
        btn.href = "#";
        btn.focus();
        btn.onclick = function() { removeCustomAlert();return false; }

        alertObj.style.display = "block";

    }

    function removeCustomAlert() {
        document.getElementsByTagName("body")[0].removeChild(document.getElementById("modalContainer"));
    }
    function ful(){
        alert('Alert this pages');
    }
</script>
</head>
<body style="background : -webkit-linear-gradient(right,#c4e5ec, #5484c7);">

<div class="header">
    <h1 class="head" >Timetable 766</h1>
</div>
<%--<ul>--%>
<%--    <li><a  href="${pageContext.request.contextPath}/admin">home</a></li>--%>

<%--</ul>--%>
<nav class="fill">
    <ul>
        <li> <a class="nav-link" href="${pageContext.request.contextPath}/admin">Home</a></li>
        <li> <a class="nav-link" href="${pageContext.request.contextPath}/addRoom">Add Room</a></li>
        <li> <a class="nav-link" href="${pageContext.request.contextPath}/getAllSchedules">View Schedule</a></li>

        <li  style="float:right"> <form method="post" action="${pageContext.request.contextPath}/logout"> <button type="submit" class="fa fa-sign-out nav-link" > Logout</button></form> </li>
    </ul>
</nav>
<div class="row justify-content-center  headingg">
    <h3>
        Please Select a Batch to Schedule the  time table
    </h3>
</div>

<%--<table class="content-table">--%>

<%--    <thead><tr>--%>
<%--        <th>Module Name</th>--%>
<%--        <th> Lecturer </th>--%>
<%--        <th> Batches Enrolled </th>--%>
<%--        <th> Schedule a Time table </th>--%>

<%--    </tr>--%>
<%--    </thead>--%>
<%--    <tbody>--%>

<%--    <c:forEach var="tempBatch" items="${modules}">--%>

<%--        <tr>--%>
<%--            <td>${tempBatch.moduleName}</td>--%>
<%--            <td>${tempBatch.lecUser.firstname}</td>--%>
<%--            <td>${tempBatch.batchList.size()}</td>--%>
<%--            <td>--%>
<%--                <span><a href="${pageContext.request.contextPath}/admin/addTimetable/${tempBatch.module_id}" class="btn btn-success">--%>
<%--                     <i class="material-icons">&#xe8b5;</i>--%>
<%--                </a>--%>
<%--                </span>--%>
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
                            <h4   class="title">Modules <span></span></h4>
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
                            <th>Module Name</th>
                                    <th> Lecturer </th>
                                    <th> Batches Enrolled </th>
                                    <th> Schedule a Time table </th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="tempBatch" items="${modules}">
                            <tr>

                                <td>${tempBatch.moduleName}</td>
                                                <td>
                                                    <c:if test="${tempBatch.lecUser.firstname == null}">
                                                        <div class="alert-dark" style="border-radius: 20px 20px 20px 20px ; text-align: center" > No Lecturer Assigned
                                                            <i class="material-icons">&#xe001;</i>
                                                        </div>
                                                    </c:if>
                                                        ${tempBatch.lecUser.firstname}</td>
                                                <td>${tempBatch.batchList.size()}</td>
                                                <td>
                                                    <c:if test="${tempBatch.batchList.size()>0 && tempBatch.lecUser != null}">
                                                    <span ><a href="${pageContext.request.contextPath}/admin/addTimetable/${tempBatch.module_id}" class="btn btn-outline-success ">
                                                         <i class="material-icons">&#xe614;</i>
                                                    </a>
                                                    </span>
                                                    </c:if>
                                                    <c:if test="${tempBatch.batchList.size()==0 || tempBatch.lecUser == null}">
                                                    <span >
<%--                                                        <a onclick="alert('Cannot Schedule For this Module....');" class="btn btn-outline-danger">--%>
                                                        <a onclick=" alertify.alert('Oops', 'Cannot Schedule For this Module..!');" class="btn btn-outline-danger">
                                                         <i class="material-icons">&#xe614;</i>
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
</body>
</html>
