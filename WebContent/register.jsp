<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Page</title>
</head>
<body>
	<form action="AddUser" method="POST"> 
		<table>


			<tr>
				<td>ID:</td>
				<td><input type="text" name="id"></td>
			</tr>

			<tr>
				<td>User Name:</td>
				<td><input type="text" name="uname"></td>
			</tr>

			<tr>
				<td>Address:</td>
				<td><input type="text" name="add"></td>
			</tr>

			<td>Mobile No:</td>
			<td><input type="text" name="mob"></td>
			<tr>
				<td>
				<td><button type="submit" name="submit" value="submit">Save</button></td>
				</td>
			</tr>
		</table>
		<a href="ListServlet">View Records</a>
	</form>

</body>
</html>