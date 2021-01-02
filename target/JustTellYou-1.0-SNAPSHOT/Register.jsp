<%-- 
    Document   : Register
    Created on : Oct 18, 2020, 9:13:09 PM
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <title>Register</title>
        <!-- Bootstrap -->
        <link href="css/bootstrap-4.4.1.css" rel="stylesheet">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

    </head>

    <body style="padding-top: 70px" >

        <form action="Register" method="GET"><b>
                <h1 class="col-xl-3 text-center"><strong>Register</strong></h1>
                <div class="col-xl-12"><hr></div>
                <div class="form-group col-xl-5">
                    <label for="exampleInputEmail1" >UserName</label>
                    <input type="text" class="form-control" name="Username" placeholder="UserName"required>
                </div>

                <div class="form-group col-xl-5">
                    <label for="exampleInputPassword1">Password</label>
                    <input type="password" class="form-control" name="Password" placeholder="Password"required>
                </div>

                <div class="form-group col-xl-5">
                    <label for="exampleInputPassword1">First Name</label>
                    <input type="text" class="form-control" name="Fname" placeholder="First Name"required>
                </div>
                <div class="form-group col-xl-5">
                    <label for="exampleInputPassword1">Last Name</label>
                    <input type="text" class="form-control" name="Lname" placeholder="Last Name"required>
                </div>
                <div class="form-group col-xl-5">
                    <label for="exampleInputEmail1" >Email address</label>
                    <input type="email" class="form-control" name="Email" placeholder="Enter email"required>
                </div> 
            </b>
            &nbsp;&nbsp;&nbsp;&nbsp;<button type="submit" class="btn btn-dark ">Register</button></a>

        <p style="color: red" > ${message}</p>

    </form>
    <nav class="navbar fixed-top navbar-expand-lg navbar-light bg-light"> <a class="navbar-brand" href="Index"><b>Just Tell You</b></a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent1" aria-controls="navbarSupportedContent1" aria-expanded="false" aria-label="Toggle navigation"> <span class="navbar-toggler-icon"></span> </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent1">
            <ul class="navbar-nav mr-auto">

<!--                <li class="nav-item dropdown"> <a class="nav-link dropdown-toggle"  id="navbarDropdown1" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> Categories </a>
                <c:forEach items="${cat}" var="c">
                    <a class="dropdown-item" href="Categories?Categories=${c.catID}">${c.catName}</a> 
                </c:forEach>
                </li>-->


            </ul>
            <form class="form-inline my-2 my-lg-0"action="Search" method="GET">
                <input class="form-control mr-sm-2" type="search" name="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-dark my-2 my-sm-0" type="submit">Search</button>
            </form>

            <a class="nav-link" class="navbar-nav mr-auto" href="Login.jsp" > Sign in</a>
        </div>

    </nav> 
    <script src="../Index/js/jquery-3.4.1.min.js"></script>

    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="../Index/js/popper.min.js"></script> 
    <script src="../Index/js/bootstrap-4.4.1.js"></script>
</body>
</html>
