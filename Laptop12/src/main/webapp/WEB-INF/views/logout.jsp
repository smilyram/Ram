<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Logout</title>
<style>
body{
	background-image: url(resources/images/thaku.jpg);
background-size:100%100%;
background-repeat: no-repeat;
}
</style>
</head>
<body background="thanku.jpg">
<% 
session.invalidate();
%>

</body>
<%@include file="LogoutHeader.jsp" %>
 <h1 style="text-align: center;">Thank You, visit Again</h1> 
<!-- <img src="resources/images/thanku.jpg" style="width:100%;height:75%"> -->
 <!-- <div>
    <h4 >Copy Rights @ NIIT LTD</h4>
    </div> -->
</html>