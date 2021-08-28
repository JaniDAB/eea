<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: janithdabare
  Date: 5/12/21
  Time: 00:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Scheduling Time table</title>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/timetable.css">
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>

    <script>
        $(function () {
            var dtToday = new Date();

            var month = dtToday.getMonth() + 1;
            var day = dtToday.getDate();
            var year = dtToday.getFullYear();
            if (month < 10)
                month = '0' + month.toString();
            if (day < 10)
                day = '0' + day.toString();

            var maxDate = year + '-' + month + '-' + day;

            // alert(maxDate);
            $('#txtDate').attr('min', maxDate);
        });

        $(function () {
            var dtToday = new Date();

            var month = dtToday.getMonth();
            var day = dtToday.getDate();
            var year = dtToday.getFullYear() + 1;
            if (month < 10)
                month = '0' + month.toString();
            if (day < 10)
                day = '0' + day.toString();

            var minDate = year + '-' + month + '-' + day;

            // alert(maxDate);
            $('#txtDate').attr('max', minDate);
        });
    </script>
</head>
<body>

<div class="header">
    <h1 class="header1"> Timetable System </h1>
</div>
<ul class="nav_link" style="margin-bottom: 0">
    <li><a class="nav-link" href="${pageContext.request.contextPath}/admin"> Home</a></li>
    <li><a class="nav-link" href="${pageContext.request.contextPath}/addRoom">Add a Room</a></li>
    <li><a class="nav-link" href="${pageContext.request.contextPath}/getAllSchedules">View Schedule</a></li>

</ul>

<!------ Include the above in your HEAD tag ---------->

<div class="container register" style="max-width: 100%;">
    <div class="row">
        <div class="col-md-3 register-left">
            <img src="https://img.icons8.com/nolan/300/room.png"/>
            <%--                     <img src="https://img.icons8.com/dotty/80/ffffff/elective.png"/>--%>
            <%--            <img src="https://image.ibb.co/n7oTvU/logo_white.png" alt=""/>--%>
            <h3>Schedule a Class for</h3>
            <p>Module Name :${moduleInfo.moduleName} <br> Module Code :${moduleInfo.moduleCode} </p>

            <%--            <p> Assigning a Batch to a User can be done here</p>--%>

        </div>
        <div class="col-md-9 register-right">

            <div class="tab-content" id="myTabContent">
                <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
                    <h3 class="register-heading">Scheduling A Timetable</h3>

                    <form:form action="/admin/addTimetable" method="POST" modelAttribute="timetable">

                    <div class="row register-form">
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
                        <c:if test="${successful !=  null }">
                            <div class="container mt-2">
                                <div class="row">
                                    <div class="col-sm-12">

                                        <div class="alert alert-success" style="text-align: center">
                                                ${successful}
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </c:if>
                        <div>
                            <p style="display: none" id="success">${successful}</p>
                        </div>

                        <div class="col-md-6">

                            <div class="form-group">
                                <form:label path="date">Enter the Date:</form:label>
                                <form:input type="date" path="date" cssClass="form-control"
                                            id="txtDate" placeholder="MM/DD/YYYY"
                                            required="required"/>
                            </div>
                            <div class="form-group">
                                <form:label path="startTime">Enter the Start Time: From 8:00 AM To 17:00 PM</form:label>
<%--                                <form:input type="time" path="startTime" cssClass="form-control" min="08:00" max="16:00"--%>
<%--                                            placeholder="HH:MM" required="required"/>--%>
                                <form:input type="time" path="startTime" cssClass="form-control" min="08:00" max="16:00"
                                                              placeholder="HH:MM" required="required"/>
                                <form:errors path="startTime" cssStyle="color: red"/>

                            </div>

                            <div class="form-group">
                                <form:label path="endTIme">Enter the End time:  From 8:00 AM To 17:00 PM</form:label>
                                <form:input type="time" path="endTIme" cssClass="form-control" min="08:00" max="17:00"
                                            placeholder="HH:MM"
                                            required="required"/>
                                <form:errors path="endTIme" cssStyle="color: red"/>


                            </div>


                        </div>

                        <div class="col-md-6">

                            <div class="form-group">
                                <form:label path="classRoom"> Select the Room from Below List: </form:label>
                                <form:select path="classRoom" cssClass="form-control" aria-required="true"
                                             required="required">
                                    <c:forEach var="roomList" items="${roomList}">
                                        <form:option value="${roomList.roomId}">
                                            ${roomList.roomId} : ${roomList.roomType}
                                        </form:option>
                                    </c:forEach>
                                </form:select>
                                <form:errors path="classRoom" cssStyle="color: red"/>
                            </div>


                            <div class="form-group">
                                <form:label path="batchList"> Select the Batch from Below List: </form:label>
                                <form:select multiple="true" path="batchList" cssClass="form-control"
                                             aria-required="true" required="required">
                                    <c:forEach var="batch" items="${batchList}">
                                        <form:option value="${batch.batchID}">
                                            ${batch.batchCode}
                                        </form:option>
                                    </c:forEach>
                                </form:select>
                            </div>
                            <div class="form-group">
                                <form:label path="module"> Module </form:label>
                                <form:input type="hidden" path="module" cssClass="form-control"
                                            value="${moduleInfo.module_id}" readonly="true"
                                            required="required"/>
                                <input type="text" class="form-control" required="required"
                                       value="${moduleInfo.moduleName}" readonly="readonly"/>

                                    <%--                                <form:select path="batch" cssClass="form-control" aria-required="true">--%>
                                    <%--                                    <c:forEach var="batch" items="${batchList}" >--%>
                                    <%--                                        <form:option value="${batch.batchID}">--%>
                                    <%--                                            ${batch.batchCode}--%>
                                    <%--                                        </form:option>--%>
                                    <%--                                    </c:forEach>--%>
                                    <%--                                </form:select>--%>
                            </div>


                            <input type="submit" class="btnRegister" value="Submit"/>
                        </div>
                    </div>

                </div>
                </form:form>
            </div>
        </div>
    </div>

</div>
</body>
</html>
<%--<script>--%>
<%--    window.onload = function (){--%>
<%--        const success = document.getElementById("success").innerHTML;--%>

<%--        if(success != null){--%>
<%--            swal('Successfull', success, "success");--%>
<%--        }--%>


<%--    }--%>



<%--</script>--%>