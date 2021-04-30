

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" href="css/register.css">
        <title>Register </title>
        <script>
              function Validate(){
                var pasword1 = document.getElementById("pass1");
                var   password2 = document.getElementById("pass2");
                
                if (pasword1.value.trim() !== password2.value.trim()){
               alert("Please re submit the Password correclty");
               return false;
                }
               return true
                
            }

            
        </script>

        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    </head>
    <body style="background-color: #000000">
    <div class="header">
        <h1 class="header1" > Timetable System </h1>
    </div>
    <ul class="nav_link" style="margin-bottom: 0">
        <li><a href="index.html">Home</a></li>
    </ul>
<%--         <div class="header">--%>
<%--             <h1  class="he">E Grocery</h1>--%>
<%--         </div>--%>
<%--        <img src="pics/registerpic.png" > --%>

<%--        <div class="registrationform">--%>
<%--         --%>
<%--            <h1> Registration</h1>--%>
<%--            <form action="UserControl" method="GET" onsubmit=" return Validate()" >--%>
<%--                <input type="hidden" name="command" value="ADD" >  --%>
<%--                <div>--%>
<%--                    <input type="text" name="fname" required="Required" autofocus="autofocus">--%>
<%--                    <label> First Name</label>--%>
<%--                </div>--%>
<%--                <div>--%>
<%--                    <input type="text" name="lname" required="Required" autofocus="autofocus" >--%>
<%--                    <label> Last Name</label>--%>
<%--                </div>--%>
<%--                <div>--%>
<%--                    <input type="text" name="username" required="Required"   autofocus="autofocus">--%>
<%--                    <label> Username</label>--%>
<%--                </div>--%>
<%--               --%>
<%--                <div>--%>
<%--                    <input type="text" name="address" required="Required" autofocus="autofocus">--%>
<%--                    <label>Address </label>--%>
<%--                </div>--%>
<%--                 <div>--%>
<%--                    <input type="number" name="phoneNumber"  required="Required"  autofocus="autofocus">--%>
<%--                    <label> Contact Number</label>--%>
<%--                </div>--%>
<%--                --%>
<%--                 <div>--%>
<%--                     <input type="email" name="email" required="Required" autofocus="autofocus" >--%>
<%--                    <label> E mail</label>--%>
<%--                </div>--%>
<%--                 <div>--%>
<%--                     <input type="password" name="password1" id="pass1" required="Required"  autofocus="autofocus">--%>
<%--                    <label> Password</label>--%>
<%--                </div>--%>
<%--                --%>
<%--                 <div>--%>
<%--                     <input type="password" name="password"   id="pass2" required="Required"  autofocus="autofocus">--%>
<%--                    <label>Confirm Password</label>--%>
<%--                </div>--%>
<%--                <input type="submit" value="Register" onclick="Validate()">--%>
<%--            </form>--%>
<%--        </div>--%>

<!------ Include the above in your HEAD tag ---------->

<div class="container register" style="max-width: 100%;">
    <div class="row">
        <div class="col-md-3 register-left">
            <img src="https://image.ibb.co/n7oTvU/logo_white.png" alt=""/>
            <h3> Users Registration</h3>
            <p>Add Timetable users  from here</p>
            <input type="submit" name="" value="Login"/><br/>
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
                    <h3 class="register-heading">Register User</h3>

                    <form : form action="/" method="POST" onsubmit=" return Validate()" modelAttribute="user" >


                    <div class="row register-form">
                        <div class="col-md-6">
                            <div class="form-group" >
                                <input type="text" class="form-control" placeholder="First Name *"  required="required" value="" />
                            </div>
                            <div class="form-group">
                                <input type="text" class="form-control" placeholder="Last Name *"  required="required" value="" />
                            </div>
                            <div class="form-group">
                                <input type="password" class="form-control" placeholder="Password *" id="pass1" required="required" value="" />
                            </div>
                            <div class="form-group">
                                <input type="password" class="form-control"  placeholder="Confirm Password *"   id="pass2"required="required" value="" />
                            </div>
                            <div class="form-group">
                                <div class="maxl">
                                    <label class="radio inline">
                                        <input type="radio" name="gender" value="male" checked>
                                        <span> Male </span>
                                    </label>
                                    <label class="radio inline">
                                        <input type="radio" name="gender" value="female">
                                        <span>Female </span>
                                    </label>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
                                <input type="email" class="form-control" placeholder="Your Email *"  required="required" value="" />
                            </div>
                            <div class="form-group">
                                <input type="text" minlength="10" maxlength="10" name="txtEmpPhone" class="form-control" placeholder="Your Phone *"   required="required"value="" />
                            </div>
                            <div class="form-group" >
                                <select class="form-control" aria-required="true" >
                                    <option class="hidden"  selected disabled>User Type</option>
                                    <option>Student</option>
                                    <option>Lecturer</option>
                                </select>
                            </div>
                            <div class="form-group">
                                <input type="text" class="form-control" placeholder="User Name *"  required="required" value="" />
                            </div>
                            <input type="submit" class="btnRegister"  onclick="Validate()" value="Register"/>
                        </div>
                    </div>
                        </form>
                </div>
<%--                <div class="tab-pane fade show" id="profile" role="tabpanel" aria-labelledby="profile-tab">--%>
<%--                    <h3  class="register-heading">Apply as a Hirer</h3>--%>
<%--                    <div class="row register-form">--%>
<%--                        <div class="col-md-6">--%>
<%--                            <div class="form-group">--%>
<%--                                <input type="text" class="form-control" placeholder="First Name *" value="" />--%>
<%--                            </div>--%>
<%--                            <div class="form-group">--%>
<%--                                <input type="text" class="form-control" placeholder="Last Name *" value="" />--%>
<%--                            </div>--%>
<%--                            <div class="form-group">--%>
<%--                                <input type="email" class="form-control" placeholder="Email *" value="" />--%>
<%--                            </div>--%>
<%--                            <div class="form-group">--%>
<%--                                <input type="text" maxlength="10" minlength="10" class="form-control" placeholder="Phone *" value="" />--%>
<%--                            </div>--%>


<%--                        </div>--%>
<%--                        <div class="col-md-6">--%>
<%--                            <div class="form-group">--%>
<%--                                <input type="password" class="form-control" placeholder="Password *" value="" />--%>
<%--                            </div>--%>
<%--                            <div class="form-group">--%>
<%--                                <input type="password" class="form-control" placeholder="Confirm Password *" value="" />--%>
<%--                            </div>--%>
<%--                            <div class="form-group">--%>
<%--                                <select class="form-control">--%>
<%--                                    <option class="hidden"  selected disabled>Please select your Sequrity Question</option>--%>
<%--                                    <option>What is your Birthdate?</option>--%>
<%--                                    <option>What is Your old Phone Number</option>--%>
<%--                                    <option>What is your Pet Name?</option>--%>
<%--                                </select>--%>
<%--                            </div>--%>
<%--                            <div class="form-group">--%>
<%--                                <input type="text" class="form-control" placeholder="`Answer *" value="" />--%>
<%--                            </div>--%>
<%--                            <input type="submit" class="btnRegister"  value="Register"/>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                </div>--%>
            </div>
        </div>
    </div>

</div>
    </body>
</html>
