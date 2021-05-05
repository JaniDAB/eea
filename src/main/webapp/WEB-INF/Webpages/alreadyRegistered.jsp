<%--
  Created by IntelliJ IDEA.
  User: janithdabare
  Date: 5/1/21
  Time: 11:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Already Registered</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/newcss.css">

</head>
<body>

<div class="container">
    <h3>The Entered Email Address is already</h3>
    <h1> REGISTERED</h1>
    <p>could you please ReEnter a Unregistered Email</p>
    <a href="${pageContext.request.contextPath}/add">Go back To Add user</a>
</div>
</body>
</html>
