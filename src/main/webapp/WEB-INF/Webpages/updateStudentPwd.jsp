<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/register.css">
    <title>Update My Account </title>

    <script>
        function Validate() {
            var pasword1 = document.getElementById("pass1");
            var password2 = document.getElementById("pass2");

            if (pasword1.value.trim() !== password2.value.trim()) {
                swal("Password Doesnt Match", "Please Re-Enter the Password!", "error");
                return false;
            }
            return true

        }


    </script>

    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>

</head>
<body style="background-color: #000000">
<div class="header">
    <h1 class="header1"> Timetabler 766 </h1>
</div>
<ul class="nav_link" style="margin-bottom: 0">
    <li><a class="nav-link" href="${pageContext.request.contextPath}/student"> Home</a></li>
</ul>

<!------ Include the above in your HEAD tag ---------->
<div class="container register" style="max-width: 100%;">
    <div class="row">
        <div class="col-md-3 register-left">
            <%--            <img src="https://img.icons8.com/dotty/80/ffffff/add-book.png"/>--%>
            <%--       add module     <img src="https://img.icons8.com/dotty/80/ffffff/elective.png"/>--%>
            <%--            <img src="https://image.ibb.co/n7oTvU/logo_white.png" alt=""/>--%>
            <%--    Add users--%>
            <img src="https://i.ibb.co/6bkWbL7/icons8-business-group-64.png" alt="icons8-business-group-64" border="0">
            <h3>${userinfo.firstname} ${userinfo.lastname} </h3>
                <p> Email : ${userinfo.email} </p>
            <p> Enrolled Batch: ${userinfo.batch.batchCode} </p>

            <%--            <p>Add Timetable System users here</p>--%>

        </div>
        <div class="col-md-9 register-right">

            <div class="tab-content" id="myTabContent">
                <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
                    <h3 class="register-heading">Update Password</h3>

                    <form:form action="${pageContext.request.contextPath}/student/updatePassword" method="POST"
                               onsubmit="return Validate()" modelAttribute="UpdatePassword">


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

                                        <div class="alert alert-danger" style="text-align: center">
                                                ${error}
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </c:if>

                        <div class="col-md-6">

                            <div class="form-group">
                                <form:input type="password" path="password" cssClass="form-control"
                                            placeholder="New Password *" id="pass1" required="required"/>
                            </div>

                        </div>
                        <div class="col-md-6">

                            <div class="form-group">
                                <input type="password" class="form-control" placeholder="Confirm Password *" id="pass2"
                                       required="required" value=""/>
                            </div>
                            <div class="form-group">
                                <form:input value="${userinfo.userId}" type="hidden" path="userId"
                                            cssClass="form-control"
                                            required="required"/>

                            </div>


                            <input type="submit" class="btnRegister" onclick="Validate()"  value="Update"/>
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
