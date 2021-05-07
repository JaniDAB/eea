<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: janithdabare
  Date: 5/3/21
  Time: 22:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add A Module</title>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/register.css">
</head>
<body>
<div class="header">
    <h1 class="header1" > Timetable System </h1>
</div>
<ul class="nav_link" style="margin-bottom: 0">
    <li><a href="${pageContext.request.contextPath}/admin">Home</a></li>
</ul>

<!------ Include the above in your HEAD tag ---------->

<div class="container register" style="max-width: 100%;">
    <div class="row">
        <div class="col-md-3 register-left">
            <img src="https://img.icons8.com/dotty/80/ffffff/add-book.png"/>
<%--                     <img src="https://img.icons8.com/dotty/80/ffffff/elective.png"/>--%>
            <%--            <img src="https://image.ibb.co/n7oTvU/logo_white.png" alt=""/>--%>
            <h3> Add Batch here</h3>
            <p>Batch Name, Description can be added</p>
            <input type="submit" name="" value="Login"/><br/>
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
                    <h3 class="register-heading">Add A Batch</h3>

                    <form:form action="${pageContext.request.contextPath}/admin/addBatch" method="POST"  modelAttribute="batch" >


                    <div class="row register-form">
                        <div class="col-md-6">
                            <div class="form-group" >
                                    <%--                                <input   type="text" class="form-control" placeholder="First Name *"  required="required" value="" />--%>
                                <form:input   type="text" path="batchCode" cssClass="form-control" placeholder="Batch code *" required="required"/>
                            </div>

                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
                                    <%--                                <input type="" class="form-control" placeholder="Your Email *"  required="required" value="" />--%>
                                <form:input  type="text"  path="description" cssClass="form-control" placeholder="Batch Description *"  required="required"/>

                            </div>


                            <input type="submit" class="btnRegister"   value="Add Batch"/>
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
