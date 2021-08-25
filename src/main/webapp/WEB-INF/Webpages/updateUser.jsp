<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/register.css">
    <title>Update User </title>
    <script>
        function Validate() {
            var pasword1 = document.getElementById("pass1");
            var password2 = document.getElementById("pass2");

            if (pasword1.value.trim() !== password2.value.trim()) {
                alert("Please re submit the Password correclty");
                return false;
            }
            return true

        }


    </script>

    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body style="background-color: #000000">
<div class="header">
    <h1 class="header1"> Timetabler 766</h1>
</div>
<ul class="nav_link" style="margin-bottom: 0">
    <li><a class="nav-link" href="${pageContext.request.contextPath}/admin"> Home</a></li>
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
               <c:if test="${userinfo.role.equals('STUDENT')}">

                <p>Batch(If Enrolled):
                   <c:if test="${userinfo.batch.batchCode == null}">
                       <div class="alert-light" style="border-radius: 10px 10px"> Student is Not Enrolled

                       </div>
                   </c:if>
                        ${userinfo.batch.batchCode} </p>
                   
               </c:if>
<%--            <p>Add Timetable System users here</p>--%>
        </div>
        <div class="col-md-9 register-right">

            <div class="tab-content" id="myTabContent">
                <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
                    <h3 class="register-heading">Update User</h3>

                    <form:form action="/modifyUser" method="POST"   modelAttribute="user">


                    <div class="row register-form">
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
                        <div class="col-md-6">
                            <div class="form-group">
                                <form:label path="firstname" >First Name: </form:label>
                                <form:input type="text" path="firstname" cssClass="form-control"
                                          value="${userinfo.firstname}"  placeholder="First Name *" required="required"/>
                                <form:errors path="firstname" cssStyle="color: red"/>

                            </div>
                            <div class="form-group">
                                <form:label path="lastname" >Last Name: </form:label>
                                <form:input type="text" path="lastname" cssClass="form-control"
                                          value="${userinfo.lastname}"  placeholder="Last Name *" required="required"/>
                                <form:errors path="lastname" cssStyle="color: red"/>

                            </div>
<%--                            <div class="form-group">--%>
<%--                                    &lt;%&ndash;&ndash;%&gt;--%>
<%--                                <form:input type="password" path="password" cssClass="form-control"--%>
<%--                                            value="${userinfo.password}"     placeholder="Password *" id="pass1" required="required"/>--%>
<%--                            </div>--%>

<%--                            <div class="form-group">--%>
<%--                                <input type="password" class="form-control" placeholder="Confirm Password *" id="pass2"--%>
<%--                                         required="required" value=""/>--%>

<%--                            </div>--%>

                        </div>
                        <div class="col-md-6">

                            <div class="form-group">
                                <form:label path="email" >Email Address: </form:label>
                                <form:input value="${userinfo.email}" type="email" path="email" cssClass="form-control" placeholder="Email *"
                                            required="required"/>
                                <form:errors path="email" cssStyle="color: red"/>

                            </div>
                            <div class="form-group">
                                <form:input value="${userinfo.userId}" type="hidden" path="userId" cssClass="form-control" placeholder="Email *"
                                            required="required"/>

                            </div>

                            <div class="form-group">
                                <form:label path="mobile" >Contact Number: </form:label>
                                <form:input type="text" maxlength="10" path="mobile" cssClass="form-control"
                                            value="${userinfo.mobile}"   placeholder="Your Phone  *" required="required"/>
                                <form:errors path="mobile" cssStyle="color: red"/>

                            </div>



                            <div class="form-group">
                                <form:label path="username" >User Name: </form:label>
                                <form:input type="text" path="username" cssClass="form-control"
                                            value="${userinfo.username}"    placeholder="User Name *" required="required"/>
                                <form:errors path="username" cssStyle="color: red"/>

                            </div>

                            <input type="submit" class="btnRegister"  value="Update"/>
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
