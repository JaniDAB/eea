<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <h1 class="header1" > Timetabler 766 </h1>
</div>
<ul class="nav_link" style="margin-bottom: 0">
    <li><a class="nav-link" href="${pageContext.request.contextPath}/admin">Home</a></li>
    <li><a class="nav-link" href="${pageContext.request.contextPath}/admin/listBatches">View Batches</a></li>
</ul>

<!------ Include the above in your HEAD tag ---------->

<div class=" row justify-content-center  successmessage" style="color: #55efc4">
    ${successful}
        ${fail}
</div>
<div class="container register" style="max-width: 100%;">
    <div class="row">
        <div class="col-md-3 register-left">
            <img src="https://img.icons8.com/dotty/80/ffffff/add-book.png"/>
<%--                     <img src="https://img.icons8.com/dotty/80/ffffff/elective.png"/>--%>
            <%--            <img src="https://image.ibb.co/n7oTvU/logo_white.png" alt=""/>--%>
            <h3> Add Batch here</h3>
            <p>Batch Name, Description can be added</p>
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
                            <div class="form-group" >
                                    <%--                                <input   type="text" class="form-control" placeholder="First Name *"  required="required" value="" />--%>
                             <form:label path="batchCode" >Enter Batch Code: Ex(HF1231SEeng) </form:label>
                                <form:input   type="text" path="batchCode" cssClass="form-control" placeholder="For Ex: HF1231SEeng" required="required"/>
                            <form:errors path="batchCode" cssClass="align-content-center" cssStyle="color: red"/>
                            </div>

<%--                            <div class="form-group">--%>
<%--                                <div class="maxl">--%>
<%--                                    <label class="radio inline">--%>

<%--                                        <form:radiobutton path="" value="Male"/> Male--%>
<%--                                        <form:radiobutton path="gender" value="Female"/> Female--%>
<%--                                    </label>--%>
<%--                                </div>--%>
<%--                            </div>--%>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
                                    <%--                                <input type="" class="form-control" placeholder="Your Email *"  required="required" value="" />--%>
                                        <form:label path="description" >Enter Description:</form:label>
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
