<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: janithdabare
  Date: 5/9/21
  Time: 12:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Assing Lecturers</title>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/register.css">
</head>
<body>


<div class="header">
    <h1 class="header1"> Timetable System </h1>
</div>
<ul class="nav_link" style="margin-bottom: 0">
    <li><a class="nav-link" href="${pageContext.request.contextPath}/admin">Admin Home</a></li>
</ul>

<!------ Include the above in your HEAD tag ---------->

<div class="container register" style="max-width: 100%;">
    <div class="row">
        <div class="col-md-3 register-left">

            <img src="https://i.ibb.co/6bkWbL7/icons8-business-group-64.png" alt="icons8-business-group-64" border="0">
            <h3>Assign Lecturer To a Module</h3>
            <p> Assigning a Lecturer to a Module can be done here</p>
        </div>
        <div class="col-md-9 register-right">

            <div class="tab-content" id="myTabContent">
                <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
                    <h3 class="register-heading">Lecturer Assignment</h3>

                    <form:form action="/assignLecturer" method="POST" modelAttribute="assignModule">

                    <div class="row register-form">
                        <div class="col-md-6">
                            <div class="form-group">
                                <form:input type="text" path="moduleName" cssClass="form-control"
                                            value="${moduleInfos.moduleName}" placeholder="First Name *" readonly="true"
                                            required="required"/>
                            </div>
<%--                            <div class="form-group">--%>
<%--                                <form:input type="text" path="lastname" cssClass="form-control"--%>
<%--                                            value="${userinfos.lastname}" placeholder="Last Name *"--%>
<%--                                            readonly="true" required="required"/>--%>

<%--                            </div>--%>
                            <div class="form-group">
                                <form:input type="hidden" path="module_id" cssClass="form-control"
                                            value="${moduleInfos.module_id}" placeholder="Last Name *"
                                            readonly="true" required="required"/>

                            </div>
                        </div>

                        <div class="col-md-6">
<%--                            <div class="form-group">--%>
<%--                                <form:input type="text" path="username" cssClass="form-control"--%>
<%--                                           value="${userinfos.username}" placeholder="User Name *" readonly="true"--%>
<%--                                            required="required"/>--%>


<%--                            </div>--%>
                            <div class="form-group">
                                <form:select path="lecUser" cssClass="form-control" aria-required="true">
                                    <c:forEach var="user" items="${lecturerList}" >
                                        <form:option value="${user.userId}">
                                            ${user.firstname} ${user.lastname}
                                        </form:option>
                                    </c:forEach>
                                </form:select>
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
