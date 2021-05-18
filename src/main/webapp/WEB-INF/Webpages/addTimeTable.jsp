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
</head>
<body>

<div class="header">
    <h1 class="header1"> Timetable System </h1>
</div>
<ul class="nav_link" style="margin-bottom: 0">
    <li><a class="nav-link" href="${pageContext.request.contextPath}/admin">Admin Home</a></li>
    <li><a  class="nav-link" href="${pageContext.request.contextPath}/addRoom">Add a Room</a></li>
</ul>

<!------ Include the above in your HEAD tag ---------->
<div class="row justify-content-center alert-light  successmessage" role="alert" style="color: #1b1e21">
    ${successful}
    ${error}
</div>
<div class="container register" style="max-width: 100%;">
    <div class="row">
        <div class="col-md-3 register-left">
            <h1>Schedule Time table For ${batchinfo.batchCode}</h1>
            <img src="https://img.icons8.com/wired/100/000000/timetable.png" alt="icons8-business-group-64" border="0">


<%--            <p> Assigning a Batch to a User can be done here</p>--%>

        </div>
        <div class="col-md-9 register-right">

            <div class="tab-content" id="myTabContent">
                <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
                    <h3 class="register-heading">Scheduling A Timetable</h3>

                    <form:form action="/admin/addTimetable" method="POST" modelAttribute="timetable">

                    <div class="row register-form">
                        <div class="col-md-6">

                            <div class="form-group">
                                <form:label path="date">Enter the Date:</form:label>
                                <form:input type="date" path="date" cssClass="form-control"
                                            placeholder=" Start Time *"
                                            required="required"/>
                            </div>

                            <div class="form-group">
                                <form:label path="startTime">Enter the Start Time:</form:label>
                                <form:input type="time" path="startTime" cssClass="form-control"
                                            required="required"/>
                            </div>

                            <div class="form-group">
                                <form:label path="endTIme">Enter the End time:</form:label>
                                <form:input type="time" path="endTIme" cssClass="form-control"
                                            placeholder="End Time *"
                                            required="required"/>

                            </div>


                        </div>

                        <div class="col-md-6">

                            <div class="form-group">
                                <form:label path="classRoom"> Select the Room from Below  List: </form:label>
                                <form:select path="classRoom" cssClass="form-control" aria-required="true">
                                    <c:forEach var="roomList" items="${roomList}" >
                                        <form:option value="${roomList.roomId}">
                                            ${roomList.roomId} : ${roomList.roomType}
                                        </form:option>
                                    </c:forEach>
                                </form:select>
                            </div>

                            <div class="form-group">
                                <form:label path="module"> Select the Module from Below  List: </form:label>
                                <form:select path="module" cssClass="form-control" aria-required="true">
                                    <c:forEach var="module" items="${moduleList}" >
                                        <form:option value="${module.module_id}">
                                            ${module.moduleName}
                                        </form:option>
                                    </c:forEach>
                                </form:select>
                            </div>
                            <div class="form-group">
                                <form:label path="batch"> Batch </form:label>
                                <form:input type="hidden" path="batch" cssClass="form-control"
                                            value="${batchinfo.batchID}" readonly="true"
                                            required="required"/>
                                <input   type="text" class="form-control"   required="required" value="${batchinfo.batchCode}" readonly="readonly" />

                                    <%--                                <form:select path="batch" cssClass="form-control" aria-required="true">--%>
                                    <%--                                    <c:forEach var="batch" items="${batchList}" >--%>
                                    <%--                                        <form:option value="${batch.batchID}">--%>
                                    <%--                                            ${batch.batchCode}--%>
                                    <%--                                        </form:option>--%>
                                    <%--                                    </c:forEach>--%>
                                    <%--                                </form:select>--%>
                            </div>


                            <input type="submit" class="btnRegister"  value="Submit"/>
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