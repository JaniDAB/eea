<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: janithdabare
  Date: 5/5/21
  Time: 12:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/register.css">
    <title>Add Module</title>
</head>
<body>

<div class="header">
    <h1 class="header1" > Timetabler 766 </h1>
</div>
<ul class="nav_link" style="margin-bottom: 0">
    <li><a class="nav-link" href="${pageContext.request.contextPath}/admin">Home</a></li>
    <li><a  class="nav-link" href="${pageContext.request.contextPath}/admin/listModules">View Modules</a></li>
</ul>

<!------ Include the above in your HEAD tag ---------->

<div class="container register" style="max-width: 100%;">
    <div class="row">
        <div class="col-md-3 register-left">
            <%--            <img src="https://img.icons8.com/dotty/80/ffffff/add-book.png"/>--%>
               <img src="https://img.icons8.com/dotty/80/ffffff/elective.png"/>
            <%--            <img src="https://image.ibb.co/n7oTvU/logo_white.png" alt=""/>--%>
            <h3> Add Module here</h3>
            <p>Module Name can be added</p>
        </div>
        <div class="col-md-9 register-right">

            <div class="tab-content" id="myTabContent">
                <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
                    <h3 class="register-heading"> Add Module</h3>

                    <form:form action="/admin/addModule" method="POST"  modelAttribute="module" >


<%--                     <div class="row register-form">--%>
<%--                        <div class="col-md-8">--%>
<%--                            <div class="form-group" >--%>
<%--                                <form:input   type="text" path="moduleName" cssClass="form-control" placeholder="Module *" required="required"/>--%>
<%--                                <form:errors path="moduleName" cssClass="align-content-center" cssStyle="color: red"/>--%>

<%--                            </div>--%>
<%--                        </div>--%>

<%--                         <div class="col-md-8" >--%>
<%--                        <input type="submit" class="btnRegister"   value="Add Module"/>--%>

<%--                     </div>--%>
<%--                    </div>--%>

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
                                <form:label path="moduleCode" >Enter Module Code: Ex(COSE60636)</form:label>
                                <form:input   type="text" path="moduleCode" cssClass="form-control" placeholder="For Ex: COSE60636" required="required"/>
                                <form:errors path="moduleCode" cssClass="align-content-center" cssStyle="color: red"/>
                            </div>


                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
                                <form:label path="moduleName" >Enter Module Name:</form:label>
                                <form:input  type="text"  path="moduleName" cssClass="form-control" placeholder="Name *"  required="required"/>
                                        <form:errors path="moduleName" cssClass="align-content-center" cssStyle="color: red"/>

                            </div>


                            <input type="submit" class="btnRegister"   value="Add Module"/>
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
