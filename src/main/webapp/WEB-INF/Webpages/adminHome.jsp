<%--
  Created by IntelliJ IDEA.
  User: janithdabare
  Date: 4/29/21
  Time: 18:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin Home Page</title>
    <link rel="stylesheet"  href="${pageContext.request.contextPath}/css/adminHome.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<%--        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">--%>

</head>
<body style="background-color: #000000">
<div class="header">
    <h1 class="header1"> Timetable System </h1>
</div>
<%--<div class="header">--%>
<%--    <h1 class="header1" > Timetable System </h1>--%>
</div>
<ul class="nav_link">
    <li><a  class="fa fa-sign-out"  href="${pageContext.request.contextPath}/login">Log out</a></li>

</ul>


<%--<img src="${pageContext.request.contextPath}/images/timetable.png" width="100%" height="87%">--%>

<section class="hero-section">
    <div class="card-grid">
        <a class="card" href="${pageContext.request.contextPath}/addModule">
            <div class="card__background" style="background-image: url(https://i.ibb.co/dfk8FVr/M.jpg)"></div>
            <div class="card__content">
<%--                <p class="card__category">Category</p>--%>
                <h3 class="card__heading">Module Operations</h3>
            </div>
        </a>
        <a class="card" href="${pageContext.request.contextPath}/addBatch">
            <div class="card__background" style="background-image: url(https://i.ibb.co/FY5LqBc/image.png)"></div>
            <div class="card__content">
<%--                <p class="card__category">Category</p>--%>
                <h3 class="card__heading">Batch Operation's</h3>
            </div>
        </a>
        <a class="card" href="${pageContext.request.contextPath}/add">
            <div class="card__background" style="background-image: url(https://i.ibb.co/hFvmzXt/image.png)"></div>
            <div class="card__content">
<%--                <p class="card__category">Category</p>--%>
                <h3 class="card__heading">Academic Users  Operation's</h3>
            </div>
        </a>
            </li>
            <a class="card" href="${pageContext.request.contextPath}/addTimetable">
                <div class="card__background" style="background-image: url(https://images.unsplash.com/photo-1557004396-66e4174d7bf6?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=800&q=60)"></div>
                <div class="card__content">

                    <h3 class="card__heading">Scheduling Operations</h3>
                </div>
            </a>
    </div>
</section>
</body>
</html>
