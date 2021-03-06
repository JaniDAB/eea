<%--
  Created by IntelliJ IDEA.
  User: janithdabare
  Date: 5/3/21
  Time: 19:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student Home Page</title>
    <link rel="stylesheet"  href="${pageContext.request.contextPath}/css/adminHome.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

</head>
<body style="background-color: #000000">
<div class="header">
    <h1 class="header1"> Timetabler 766 </h1>
</div>

<%--<div class="header">--%>
<%--    <h1 class="header1" > Timetable System </h1>--%>
<%--</div>--%>
<ul class="nav_link">

    <li  style="float:right"> <form method="post" action="${pageContext.request.contextPath}/logout"> <button type="submit" class="fa fa-sign-out nav-link" > Logout</button></form> </li>

</ul>


<%--<img src="${pageContext.request.contextPath}/images/timetable.png" width="100%" height="87%">--%>

<section class="hero-section">
    <div class="card-grid">
<%--        <a class="card" href="${pageContext.request.contextPath}/add">--%>
<%--            <div class="card__background" style="background-image: url(https://i.ibb.co/dfk8FVr/M.jpg)"></div>--%>
<%--            <div class="card__content">--%>
<%--                &lt;%&ndash;                <p class="card__category">Category</p>&ndash;%&gt;--%>
<%--                <h3 class="card__heading">Add Modules</h3>--%>
<%--            </div>--%>
<%--        </a>--%>
        <a class="card" href="${pageContext.request.contextPath}/student/timetable/${student.batch.batchID}" style="padding-left: 10px">
            <div class="card__background" style="background-image: url(http://i.ibb.co/2nLr8js/schedule.png)"></div>
            <div class="card__content">
                <%--                <p class="card__category">Category</p>--%>
                <h3 class="card__heading">View Time Table</h3>
            </div>
        </a>
        <a class="card" href="${pageContext.request.contextPath}/student/getUpdateForm/${student.userId}">
            <div class="card__background" style="background-image: url(https://i.ibb.co/hFvmzXt/image.png)"></div>
            <div class="card__content">
                <%--                <p class="card__category">Category</p>--%>
                <h3 class="card__heading">My Account</h3>
            </div>
        </a>
            <%--            <a class="card" href="#">--%>
            <%--                <div class="card__background" style="background-image: url(https://images.unsplash.com/photo-1557004396-66e4174d7bf6?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=800&q=60)"></div>--%>
            <%--                <div class="card__content">--%>
            <%--                    <p class="card__category">Category</p>--%>
            <%--                    <h3 class="card__heading">Example Card Heading</h3>--%>
            <%--                </div>--%>
            <%--            </a>--%>

</section>
</body>
</html>
