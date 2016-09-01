<!DOCTYPE html>
<html lang="en">
<head>
 <% 
 response.setHeader("pragma", "no-cache");
 response.setHeader("Cache-control", "no-cache, no-store, must-revalidate");
 response.setHeader("Expires", "0");
 %>
  <title>Single Product Info</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <head>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
  <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
  <script>document.write('<base href="' + document.location + '" />');</script>
    <link href="./resources/css/bootstrap.min.css" rel="stylesheet" media="screen">
    <link href="./resources/css/style.css" rel="stylesheet" media="screen">
    <script data-require="angular.js@1.0.x" src="http://code.angularjs.org/1.0.7/angular.min.js" data-semver="1.0.7"></script>

  <style>
    /* Remove the navbar's default margin-bottom and rounded borders */ 
    .navbar {
      margin-bottom: 0;
      border-radius: 0;
    }    
    /* Add a gray background color and some padding to the footer */
    footer {
      background-color: #f2f2f2;
      padding: 25px;
    }
	.carousel-inner > .item > img,
  .carousel-inner > .item > a > img {
      width: 70%;
      margin: auto;
  </style>
</head>
<body>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" href="/laptop12/"><span class="glyphicon glyphicon-home"></span></a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
       
        
        
        <li><a href="logout">Logout</a></li>
		  <li>&nbsp; &nbsp; &nbsp; &nbsp;</li>
		  <!--  <li> <button type="button" class="btn btn-primary btn-s" style="background-color:red">Shoe Clue's</button></li> -->
		    <li>&nbsp; &nbsp; &nbsp; &nbsp;</li>
		
		  
      </ul>
    </div>
  </div>
</nav>
<!-- <div>
<center><img src="resources/images/customer.jpg" style="width:300px;height: 300px"></center>
</div> -->
<div class="container">
<div>
    <hr></hr>
    <table class="table table-striped">
    <tr>
    <th>ItemId</th>
    <th>Name</th>
    <th>Description</th>
    <th>Category</th>
    <th>Price</th>
    <th>Images</th>
    </tr> <tr>
    <form action="updateThisItem" method="post">
             <td> ${item.itemId}</td>
              <td> ${item.itemName}</td>
               <td> ${item.description} </td>
                <td> "${item.category} </td>
                 <td> ${item.price} </td>
           
           <td><img src="resources/images/${item.itemId}.jpg" style="width:100px ;height:100px"></td>
           
           <td><a href="addToCart?id=${item.itemId}">addto cart</a></td>
           </form>
        </tr>    
    </table>
</div>
</div>
<br><br><br><br><br><br><br><br>
<%@include file="footer.jsp" %>
 
</body>
</html>
