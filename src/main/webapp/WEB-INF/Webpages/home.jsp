<%--
  Created by IntelliJ IDEA.
  User: janithdabare
  Date: 4/30/21
  Time: 12:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
    <link rel="stylesheet"  href="${pageContext.request.contextPath}/css/home.css">
<%--    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">--%>
</head>
<body>

<div class="header">
    <h1 class="header1" > Timetabler 766</h1>
</div>
<ul class="nav_link">
    <li><a href="${pageContext.request.contextPath}/add">Home</a></li>

</ul>
<img src="${pageContext.request.contextPath}/images/timetable.png" width="100%" height="87%">

</body>
</html>
