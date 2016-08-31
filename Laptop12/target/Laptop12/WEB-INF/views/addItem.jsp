<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Item</title>
<style>
body{
background-image: url(resources/images/login1.jpg);
background-size:100%100%;
background-repeat: no-repeat;
}

</style>
</head>
<body>
<%@include file="LogoutHeader.jsp" %>

<table align="center">

<form:form action="addProduct" commandName="item" enctype="multipart/form-data">
<tr><td>Name</td><td><form:input path="itemName" required="required" placeholder="name"></form:input><form:errors path="itemName" style="color:red"></form:errors></td><tr></tr><tr></tr><br>
<tr><td>Description</td><td><form:input path="description" required="required" placeholder="Description"></form:input><form:errors path="description" style="color:red"></form:errors></td><tr></tr><tr></tr><br>

<tr><td>Price</td><td><form:input path="price" required="required" placeholder="price"></form:input><form:errors path="price" style="color:red"></form:errors></td><tr></tr><tr></tr><br>
<tr><td>Category</td><td><form:select path="category"></<br>
<form:option value="i3">i3</form:option><br>
<form:option value="i5">i5</form:option><br>
<form:option value="i7">i7</form:option><br>
</form:select>
<tr><td><input type="file"  name="file"/></td></tr><tr></tr><tr></tr><br>
<tr><td><input type="submit" value="AddProducts"/></td></tr><tr></tr><tr></tr><br>
</form:form>
</table>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<%@include file="footer.jsp" %>
</body>
</html>