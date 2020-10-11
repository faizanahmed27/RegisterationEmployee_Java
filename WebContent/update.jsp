<%@page import="login.service.AddUserService"%>
<%@page import="login.service.AddUserService"%>
<%@page import="resgistration.auth.pojo.UserPojo"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
   <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Page</title>
</head>
<body>
<h1><center>Update Page</center></h1>
<form action="UpdateServlet" method="post">

<table>
<tr>

<td>ID:</td>
<td><input type="text" name="id" value="<%=request.getAttribute("id")%>"/></td> <!--   this "id" coming from Update Servlet class from setAttribute-->
</tr>

<tr>
<td>User: Name</td>
<td><input type="text" name="uname" value="<%=request.getAttribute("name")%>" /></td> <!--   this "name" coming from Update Servlet class from setAttribute -->
</tr>

<tr>
<td>Address:</td>
<td><input type="text" name="add" value="<%=request.getAttribute("addr")%>" /></td> <!--   this "addr" coming from Update Servlet class from setAttribute -->
</tr>

<tr>
<td>Mobile No:</td>
<td><input type="text" name="mob" value="<%=request.getAttribute("mob")%>" /></td>	<!--  this "mob" coming from Update Servlet class from setAttribute --> 
</tr>



</table>
<br><input type="submit" value="Edit&Save"></br>

</form>


</body>
</html>