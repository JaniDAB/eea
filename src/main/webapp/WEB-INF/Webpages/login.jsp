<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: janithdabare
  Date: 4/27/21
  Time: 13:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <title>login page</title>
    <link rel="stylesheet"  href="${pageContext.request.contextPath}/css/login.css">
    <base href="/">
    <script>

        function Validate(){
            var email = document.getElementById("email");
            var   password = document.getElementById("password");

            if(email.value.trim() =="" || password.value.trim() ==""){
                window.alert("No Empty Values are  allowed");
                return  false;
            }else
            {
                return  true;
            }

        }

    </script>

</head>
<body>

<div class="header">
    <h1 class="h11"> Timetabler 766 </h1>
</div>
<ul class="nav_link">


</ul>

<%--<c:if test="${pageContext.request.getParameter('error') != null}">--%>
<%--    <div>--%>
<%--        <h3 class="invalid" style="color: #a7bbc7">--%>
<%--           Username Or Password is Invalid--%>
<%--        </h3>--%>
<%--    </div>--%>
<%--</c:if>--%>
<%--<form  action="${pageContext.request.contextPath}/loginservelet" class="box" method="POST" onsubmit=" return Validate()" >--%>
<%--    <h1> Login </h1>--%>

<%--    <input type="text" id="username" name="username" placeholder="email"  >--%>
<%--    <input type="password" id="password" name="password" placeholder="password" >--%>

<%--    <input type="hidden" name="role" value="User"/>--%>
<%--    <input type="submit" value="login" onclick="Validate()">--%>

<%--</form>--%>

<div class="container" id="container">

    <div class="form-container sign-in-container">

        <form  action="${pageContext.request.contextPath}/loginservelet" class="box" method="POST" onsubmit=" return Validate()" >

            <h1>Sign in</h1>
            <div class="social-container">
<%--                <a href="#" class="social"><i class="fab fa-facebook-f"></i></a>--%>
<%--                <a href="#" class="social"><i class="fab fa-google-plus-g"></i></a>--%>
<%--                <a href="#" class="social"><i class="fab fa-linkedin-in"></i></a>--%>
            </div>
<%--            <span>or use your account</span>--%>
            <input type="text" id="username" name="username" placeholder="User Name" />
            <input type="password"  id="password" name="password" placeholder="Password" />
            <input type="hidden" name="role" value="User"/>
            <button type="submit" value="login" onclick="Validate()"> Login </button>
            <c:if test="${pageContext.request.getParameter('error') != null}">

                        <div class="row">
                            <div class="col-sm-12">

                                <div class="alert alert-danger" style="text-align: center">
                                    Invalid Credentials.. Please Try again.
                                </div>
                            </div>
                        </div>


            </c:if>
        </form>

    </div>
    <div class="overlay-container">
        <div class="overlay">

            <div class="overlay-panel overlay-right">
                <h1>Welcome Back!</h1>
                <p>Enter your Credentials and start journey with us</p>
                <img src="https://img.icons8.com/nolan/300/room.png"/>

            <%--                <button class="ghost" id="signUp">Sign Up</button>--%>
            </div>
        </div>
    </div>
</div>



</body>
</html>
