<%@page import="login.service.AddUserService"%>
<%@page import="resgistration.auth.pojo.UserPojo"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List Page</title>
<link href="https://use.fontawesome.com/releases/v5.0.6/css/all.css"
	rel="stylesheet">
	



</head>
<body>
	<h1>
		<center>Records List</center>
	</h1>
	<form action="ListServlet" method="get">

		<%
			List<UserPojo> list = AddUserService.getAllUser();
			request.getAttribute("list");
		%>

		<table border=1 width="100%">


			<tr>
			
				<th>ID</th>
				<th>Name</th>
				<th>Address</th>
				<th>Mobile No</th>
				<th colspan=2>Action</th>

			</tr>

			<%
				for (UserPojo upojo : list) {
			%>

		
			<td><%=upojo.getId()%></td>
			<td><%=upojo.getName()%></td>
			<td><%=upojo.getAddress()%></td>
			<td><%=upojo.getMob()%></td>
			
			


			<td><a href="DeleteServlet?id=<%=upojo.getId()%>"><center>
						<i class="fas fa-trash-alt"></i>
					</center></a></td>
			<td><a href="UpdateServlet?id=<%=upojo.getId()%>"><center>
						<i class="fas fa-edit"></i>
					</center></a></td>

			</tr>
			<%
				}
			%>

		</table>

		<br />
		<a href="register.jsp">Add New User</a>

	</form>

</body>
</html>