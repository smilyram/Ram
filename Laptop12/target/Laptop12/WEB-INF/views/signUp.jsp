<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
body{
background-image: url(resources/images/login1.jpg);
background-size:100%100%;
background-repeat: no-repeat;
}
</style>
<script type="text/javascript">
function check(mobile,email) {
	var mob = /^[7-9]{1}[0-9]{9}$/;
	var reg = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
	var txt = document.getElementById("mobile");
	var text = document.getElementById("email"); 
	if (mob.test(txt.value) == false || reg.test(text.value) == false) {
	    alert("Please enter valid mobile number");
	    alert('Invalid Email Address');
	    txt.focus();
	    return false;
	}
	return true;
}
</script>
</head>
<body>
<%@include file="header.jsp" %>
<table align="center">
<form:form action="register" commandName="customerObj" onsubmit="return check(mobile);"  method="POST">
<tr><td>UserName :</td><td><form:input path="name" placeholder="username"></form:input><form:errors path="name" style="color:red"></form:errors></td></tr><br><br>
<tr><td>Password :</td> <td><form:password path="password" placeholder="password"></form:password><form:errors path="password" style="color:red"></form:errors></td></tr><br>
<tr><td>Email :</td><td><form:input path="email" placeholder="email" id="email"></form:input><form:errors path="email" style="color:red"></form:errors></td></tr><br>
<tr><td>Mobile :</td><td> <form:input path="mobile" placeholder="mobile" id="mobile"></form:input><form:errors path="mobile" style="color:red"></form:errors></td></tr><br>
<tr><td align="right"><input type="submit" value="Register" /></td></tr>
</form:form>
</table>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<%@include file="footer.jsp" %>
</body>
</html>