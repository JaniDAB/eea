<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: janithdabare
  Date: 5/14/21
  Time: 09:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/register.css">
</head>
<body>

<div class="header">
    <h1 class="header1"> Timetabler 766</h1>
</div>
<ul class="nav_link" style="margin-bottom: 0">
    <li><a class="nav-link" href="${pageContext.request.contextPath}/admin">Home</a></li>
</ul>

<!------ Include the above in your HEAD tag ---------->

<div class="container register" style="max-width: 100%;">
    <div class="row">
        <div class="col-md-3 register-left">
            <h1> </h1>
            <img src="https://i.ibb.co/6bkWbL7/icons8-business-group-64.png" alt="icons8-business-group-64" border="0">
            <h3>Assign Modules To a Batch</h3>

            <p> Assigning Modules to a Batch can be done here</p>
        </div>
        <div class="col-md-9 register-right">

            <div class="tab-content" id="myTabContent">
                <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
                    <h3 class="register-heading">Modules Assignment</h3>

                    <form:form action="/assignModulesToBatch" method="POST" modelAttribute="assignModule">

                    <div class="row register-form">
                        <div class="col-md-6">
                            <div class="form-group">
                                <form:label path="batchCode"> Batch Code :</form:label>
                                <form:input type="text" path="batchCode" cssClass="form-control"
                                            value="${batchinfo.batchCode}" placeholder="User Name *" readonly="true"
                                            required="required"/>
                            </div>
                            <form:input type="hidden" path="batchID" cssClass="form-control"
                                        value="${batchinfo.batchID}" placeholder="User Name *" readonly="true"
                                        required="required"/>

                        </div>

                        <div class="col-md-6">

                            <div class="form-group">
                                <form:label path="moduleList" > Select the Modules from Below  List: </form:label>
                                <form:select  multiple="true" path="moduleList" cssClass="form-select"  aria-required="true" >
                                    <c:forEach var="moduelList" items="${moduleList}" >
                                        <form:option value="${moduelList.module_id}">
                                            ${moduelList.moduleName}
                                        </form:option>
                                    </c:forEach>
                                </form:select>
                            </div>

                            <input type="submit" class="btnRegister"  value="Assign"/>
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
