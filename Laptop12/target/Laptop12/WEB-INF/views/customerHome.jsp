<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
body{
	background-image: url(resources/images/back.jpg);
background-size:100%100%;
background-repeat: no-repeat;
}
</style>
</head>
<body>
Im in customer home
<%@inclde file="ViewProductDetails.jsp"%>
${item}
<a href="logout">LOGOUT</a>
</body>
</html>