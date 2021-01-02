<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <title>Customer Login</title>
        <!-- Bootstrap -->
        <link href="css/bootstrap-4.4.1.css" rel="stylesheet">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

    </head>

    <body style="padding-top: 70px" >


        <form action="Login" method="POST">
            <div style="padding: 30px" >
            <h1 class="col-xl-3 text-center"><strong>User Login</strong></h1>
            <div class="col-xl-12"><hr></div>
            <div class="form-group col-xl-5">
                <label for="exampleInputEmail1" ><b>User Name</b></label>
                <input type="text" class="form-control" name="Username" id="exampleInputEmail1" required>
            </div>
            <div class="form-group col-xl-5">
                <label for="exampleInputPassword1"><b>Password</b></label>
                <input type="password" class="form-control" name="Password" id="exampleInputPassword1" required>
            </div>
            <p  style ="color: red" > ${message}</p>
            &nbsp;&nbsp;&nbsp;&nbsp;<button type="submit" class="btn btn-dark ">Sign in</button>
            
            </div>
        </form>




    </nav>
    &nbsp;  
    <nav class="navbar fixed-top navbar-expand-lg navbar-light bg-light"> <a class="navbar-brand" href="Index"><b>Just Tell You</b></a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent1" aria-controls="navbarSupportedContent1" aria-expanded="false" aria-label="Toggle navigation"> <span class="navbar-toggler-icon"></span> </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent1">
            <ul class="navbar-nav mr-auto">

                <li class="nav-item dropdown"> <a class="nav-link dropdown-toggle"  id ="navbarDropdown1" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> Categories </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdown1"> 
                        <c:forEach items="${r}" var="c">
                            <a class="dropdown-item" href="Categories?Categories=${c.catID}">${c.catName}</a> 
                        </c:forEach>

                    </div>
                </li>


            </ul>
            <form class="form-inline my-2 my-lg-0"action="Search" method="GET">
                <input class="form-control mr-sm-2" type="search" name="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-dark my-2 my-sm-0" type="submit">Search</button>
            </form>
            <a class="nav-link" class="navbar-nav mr-auto" href="Register.jsp" > Register</a>
        </div>
    </nav> 




    <!-- body code goes here -->


    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) --> 
    <script src="../Index/js/jquery-3.4.1.min.js"></script>

    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="../Index/js/popper.min.js"></script> 
    <script src="../Index/js/bootstrap-4.4.1.js"></script>
</body>
</html>