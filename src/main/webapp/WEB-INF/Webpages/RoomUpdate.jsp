<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: janithdabare
  Date: 5/11/21
  Time: 18:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Class Room</title>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/addRoom.css">
</head>
<body>

<div class="header">
    <h1 class="header1" > Timetabler 766</h1>
</div>
<ul class="nav_link" style="margin-bottom: 0">
    <li><a class="nav-link" href="${pageContext.request.contextPath}/admin">Home</a></li>

</ul>

<!------ Include the above in your HEAD tag ---------->

<%--<div class="row justify-content-center  successmessage" role="alert" style="color: #55efc4">--%>
<%--    ${Updated}--%>
<%--        ${error}--%>
<%--</div>--%>

<div class="container register" style="max-width: 100%;">
    <div class="row">
        <div class="col-md-3 register-left">
            <img src="https://img.icons8.com/nolan/300/room.png"/>
            <%--                     <img src="https://img.icons8.com/dotty/80/ffffff/elective.png"/>--%>
            <%--            <img src="https://image.ibb.co/n7oTvU/logo_white.png" alt=""/>--%>
            <h3>Update Class Room  ${roominfo.roomId}</h3>
            <p>  Class Room Capacity, Room Type can be Updated</p>
            <%--            <input type="submit" name="" value=""/><br/>--%>
        </div>
        <div class="col-md-9 register-right">
            <%--            <ul class="nav nav-tabs nav-justified" id="myTab" role="tablist">--%>
            <%--                <li class="nav-item">--%>
            <%--                    <a class="nav-link active" id="home-tab" data-toggle="tab" href="#home" role="tab" aria-controls="home" aria-selected="true">Employee</a>--%>
            <%--                </li>--%>
            <%--                <li class="nav-item">--%>
            <%--                    <a class="nav-link" id="profile-tab" data-toggle="tab" href="#profile" role="tab" aria-controls="profile" aria-selected="false">Hirer</a>--%>
            <%--                </li>--%>
            <%--            </ul>--%>

            <div class="tab-content" id="myTabContent">
                <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
                    <h3 class="register-heading">Update Room ${roominfo.roomId}</h3>

                    <form:form action="${pageContext.request.contextPath}/admin/updateRoom" method="POST"  modelAttribute="editRoom" >

                    <div class="row register-form">
                        <c:if test="${Updated !=  null }">
                            <div class="container mt-2">
                                <div class="row">
                                    <div class="col-sm-12">

                                        <div class="alert alert-success" style="text-align: center">
                                                ${Updated}
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </c:if>
                        <c:if test="${error !=  null }">
                            <div class="container mt-2">
                                <div class="row">
                                    <div class="col-sm-12">

                                        <div class="alert alert-warning" style="text-align: center">
                                                ${error}
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </c:if>
                        <div class="col-md-6">
                            <div class="form-group" >
                                    <%--                                <input   type="text" class="form-control" placeholder="First Name *"  required="required" value="" />--%>
<%--                                <form:label path="roomId">Enter ID:</form:label><br>--%>
                                <form:input   type="hidden" path="roomId" cssClass="form-control" value="${roominfo.roomId}" placeholder=" Type as L(number)CR(number)" required="required"/>

                                <form:errors path="roomId" cssStyle="color: red" />
                            </div>
                            <div class="form-group">
                                <div class="maxl">
                                    <label class="radio inline">
                                        <form:label path="roomType"> Select Room Type :</form:label><br>
                                        <form:radiobutton path="roomType" value="Lecturer Hall"/> Lecturer Hall
                                        <form:radiobutton path="roomType" value="Conference Hall"/> Conference Hall
                                        <form:radiobutton path="roomType" value="Lab"/> Lab

                                    </label>
                                </div>
                            </div>

                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
                                <form:label path="roomCapacity">Enter Room Capacity:</form:label><br>
                                    <%--                       <input type="" class="form-control" placeholder="Your Email *"  required="required" value="" max="50"  />&ndash;%&gt;--%>
                                <form:input  type="number"  path="roomCapacity" cssClass="form-control" placeholder="Room Capacity*"  max="50" min="10"   value="${roominfo.roomCapacity}" required="required"/>
                                    <%--<form:errors path="roomCapacity" cssStyle="color: red"/>--%>

                            </div>


                            <input type="submit" class="btnRegister"   value="Update Room"/>
                        </div>
                    </div>
                    </form>
                </div>
                </form:form>
            </div>
        </div>
    </div>

</div>
</body>
</html>
