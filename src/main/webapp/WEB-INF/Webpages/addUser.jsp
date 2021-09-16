<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <title>Register </title>

    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/register.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script>
    $(function(){
        var dtToday = new Date();

        var month = dtToday.getMonth() + 1;
        var day = dtToday.getDate();
        var year = dtToday.getFullYear()-10;
        if(month < 10)
            month = '0' + month.toString();
        if(day < 10)
            day = '0' + day.toString();

        var maxDate = year + '-' + month + '-' + day;

        // alert(maxDate);
        $('#txtDate').attr('max', maxDate);
    });

    $(function(){
        var dtToday = new Date();

        var month = dtToday.getMonth() + 1;
        var day = dtToday.getDate();
        var year = dtToday.getFullYear()-30;
        if(month < 10)
            month = '0' + month.toString();
        if(day < 10)
            day = '0' + day.toString();

        var minDate = year + '-' + month + '-' + day;

        // alert(maxDate);
        $('#txtDate').attr('min', minDate);
    });
</script>
</head>
<body style="background-color: #000000">
<div class="header">
    <h1 class="header1"> Timetabler 766 </h1>
</div>
<ul class="nav_link">
    <li><a class="nav-link" href="${pageContext.request.contextPath}/admin">Home</a></li>
    <li><a class="nav-link" href="${pageContext.request.contextPath}/admin/users">View All Users</a></li>
    <li><a  class="nav-link" href="${pageContext.request.contextPath}/admin/users/allStudents">View  Students & Assign Batch</a></li>
    <li><a   class="nav-link" href="${pageContext.request.contextPath}/admin/users/allLectruer">View  Lecturers</a></li>
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
            <h3> Users Registration</h3>
            <p>Add Timetable System users here</p>
<%--            <input type="submit" name="" value="Login"/><br/>--%>
        </div>
        <div class="col-md-9 register-right">

            <div class="tab-content" id="myTabContent">
                <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
                    <h3 class="register-heading">Register A Academic User</h3>

                    <form:form action="/registration" method="POST"  modelAttribute="user">

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
                        <c:if test="${fail !=  null }">
                            <div class="container mt-2">
                                <div class="row">
                                    <div class="col-sm-12">

                                        <div class="alert alert-danger" style="text-align: center">
                                                ${fail}
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </c:if>

                        <div class="col-md-6">
                            <div class="form-group">
                                <form:label path="firstname" >Enter First Name: </form:label>
                                <form:input type="text" path="firstname" cssClass="form-control"
                                            placeholder="First Name *" required="required"/>
                                <form:errors path="firstname" cssStyle="color: red"/>

                            </div>
                            <div class="form-group">
                                <form:label path="lastname" >Enter Last Name: </form:label>
                                <form:input type="text" path="lastname" cssClass="form-control"
                                            placeholder="Last Name *" required="required"/>
                                <form:errors path="lastname" cssStyle="color: red"/>

                            </div>
                            <div class="form-group">
                                <form:label path="mobile" >Enter Mobile Number: </form:label>
                                <form:input type="tel" maxlength="10" path="mobile" cssClass="form-control"
                                           placeholder="Your Phone  *" required="required"/>
                                <form:errors path="mobile" cssStyle="color: red"/>

                            </div>


                            <div class="form-group">
                                <div class="maxl">
                                    <label class="radio inline">
                                        <form:label path="gender"> Gender :</form:label>
                                        <form:radiobutton path="gender" value="Male"/> Male
                                        <form:radiobutton path="gender" value="Female"/> Female
                                    </label>
                                </div>
                                <form:errors path="gender" cssStyle="color: red"/>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
                                <form:label path="email" >Enter Email Address: </form:label>
                                <form:input type="email" path="email" cssClass="form-control" placeholder="Email *"
                                            required="required"/>
                                <form:errors path="email" cssStyle="color: red"/>
                            </div>
                            <div class="form-group">
                                <form:label path="dateOfBirth" >Enter Date of Birth: </form:label>
                                <form:input type="date" path="dateOfBirth" cssClass="form-control"
                                            id="txtDate"    placeholder="Date of Birth *" required="required"/>
                                <form:errors path="dateOfBirth" cssStyle="color: red"/>
                            </div>

                            <div class="form-group">

                                <form:select path="role" cssClass="form-control" aria-required="true">
                                    <form:label path="username" >Select User Type: </form:label>
                                    <option class="hidden" selected disabled>User Type</option>
                                    <option value="STUDENT">Student</option>
                                    <option value="LECTURER">Lecturer</option>
                                </form:select>
                                <form:errors path="role" cssStyle="color: red"/>

                            </div>


                            <div class="form-group">
                                <spring:bind path="username">
                                    <form:label path="username" >Enter User Name: </form:label>
                                    <form:input type="text" path="username" cssClass="form-control"
                                            placeholder="User Name *" />
                                    <form:errors path="username" cssStyle="color: red"/>
                                </spring:bind>
                            </div>
                            <input type="submit" class="btnRegister"  value="Register"/>
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
