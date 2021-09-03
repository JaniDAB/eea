<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: janithdabare
  Date: 5/9/21
  Time: 11:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Module</title>
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
    <h1 class="header1" > Timetabler 766 </h1>
</div>
<ul class="nav_link" style="margin-bottom: 0">
    <li><a  class="nav-link" href="${pageContext.request.contextPath}/admin">Home</a></li>
    <li><a  class="nav-link" href="${pageContext.request.contextPath}/admin/listModules">View Modules</a></li>
</ul>

<!------ Include the above in your HEAD tag ---------->

<div class="container register" style="max-width: 100%;">
    <div class="row">
        <div class="col-md-3 register-left">
                                 <img src="https://img.icons8.com/dotty/80/ffffff/elective.png"/>
            <h3> Update Module here</h3>
            <p>Module Name can be Updated</p>
        </div>
        <div class="col-md-9 register-right">

            <div class="tab-content" id="myTabContent">
                <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
                    <h3 class="register-heading">Update Module</h3>

                    <form:form action="${pageContext.request.contextPath}/modifyModule" method="POST"  modelAttribute="moduleupdate" >

                    <div>
                        <p style="display: none" id="success">${successful}</p>
                    </div>

                    <div>
                        <p style="display: none" id="fail">${fail}</p>
                    </div>
                    <div class="row register-form">
                        <div class="col-md-6">
                            <div class="form-group" >
                                <form:label path="module_id"> Module Code</form:label>
                            <%--                                <input   type="text" class="form-control" placeholder="First Name *"  required="required" value="" />--%>
                                <form:input   value="${moduleInfo.moduleCode}" type="text" path="moduleCode" cssClass="form-control" placeholder="Module ID  *" readonly="true" required="required"/>
                            </div>
                            <form:input   value="${moduleInfo.module_id}" type="hidden" path="module_id"   cssClass="form-control" placeholder="Module ID  *" readonly="true" required="required"/>

                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
                                <form:label path="moduleName"> Module Name: </form:label>
                            <%--                                <input type="" class="form-control" placeholder="Your Email *"  required="required" value="" />--%>
                                <form:input  type="text"   value ="${moduleInfo.moduleName}" path="moduleName" cssClass="form-control" placeholder="Module Name *"   required="required"/>

                            </div>


                            <input type="submit" class="btnRegister"   value="Update Module"/>
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
<script>
    window.onload = function (){
        const success = document.getElementById("success").innerHTML;
        const fail = document.getElementById("fail").innerHTML;

        console.log(success);
        if(success !== ""){
            alertify.alert('Done', success);
        }
        if(fail !== ""){
            swal('Sorry', fail, "error");
        }
    }
</script>