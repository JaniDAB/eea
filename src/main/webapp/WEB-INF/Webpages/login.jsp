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
    <h1 class="header1" > Timetable System </h1>
</div>
<ul class="nav_link">


</ul>

<%--<c:if test="${pageContext.request.getParameter('error') == null}">--%>
<%--    <div class="alert alert-danger p-2 text-center">--%>
<%--        <p>--%>
<%--            <b> Username Or Password is Invalid</b>--%>
<%--        </p>--%>
<%--    </div>--%>
<%--</c:if>--%>
<form  action="${pageContext.request.contextPath}/loginservelet" class="box" method="POST" onsubmit=" return Validate()" >
    <h1> Login </h1>

    <input type="text" id="username" name="username" placeholder="email"  >
    <input type="password" id="password" name="password" placeholder="password" >

    <input type="hidden" name="role" value="User"/>
    <input type="submit" value="login" onclick="Validate()">

</form>

</body>
</html>
