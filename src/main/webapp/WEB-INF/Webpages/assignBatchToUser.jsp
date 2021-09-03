<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: janithdabare
  Date: 5/9/21
  Time: 01:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Assigning a Batch</title>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/register.css">
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
</head>
<body>

<div class="header">
    <h1 class="header1"> Timetabler 766 </h1>
</div>
<ul class="nav_link" style="margin-bottom: 0">
    <li><a  class="nav-link" href="${pageContext.request.contextPath}/admin">Home</a></li>
</ul>

<!------ Include the above in your HEAD tag ---------->

<div class="container register" style="max-width: 100%;">
    <div class="row">
        <div class="col-md-3 register-left">
            <h1> ${userinfos.firstname} ${userinfos.lastname}</h1>
            <img src="https://i.ibb.co/6bkWbL7/icons8-business-group-64.png" alt="icons8-business-group-64" border="0">
            <h3>Assign Batch To a Student</h3>

            <p> Assigning a Batch to a User can be done here</p>
            <div>
                <p style="display: none" id="success">${successful}</p>
            </div>

            <div>
                <p style="display: none" id="fail">${fail}</p>
            </div>
        </div>
        <div class="col-md-9 register-right">

            <div class="tab-content" id="myTabContent">
                <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
                    <h3 class="register-heading">Batch Assignment</h3>

                    <form:form action="/assignStudentBatch" method="POST" modelAttribute="user">

                    <div class="row register-form">
                        <div class="col-md-6">
                            <div class="form-group">
                                <form:label path="firstname"> Student User name :</form:label>
                                <form:input type="text" path="firstname" cssClass="form-control"
                                            value="${userinfos.username}" placeholder="User Name *" readonly="true"
                                            required="required"/>
                            </div>

                            <div class="form-group">
                                <form:input type="hidden" path="userId" cssClass="form-control"
                                            value="${userinfos.userId}" placeholder="Last Name *"
                                            readonly="true" required="required"/>

                            </div>
                        </div>

                        <div class="col-md-6">

                            <div class="form-group">
                                <form:label path="batch"> Select the Batch from Below  List: </form:label>
                                <form:select path="batch" cssClass="form-control" aria-required="true">
                                    <c:forEach var="batchlist" items="${batchlist}" >
                                <form:option value="${batchlist.batchID}">
                                    ${batchlist.batchCode} ${batchlist.description}
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
<script>
    window.onload = function (){
        const success = document.getElementById("success").innerHTML;
        console.log(success);
        if(success !== ""){
            alertify.alert('Success', success);
        }
    }
</script>