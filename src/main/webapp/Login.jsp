<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
<link>
</head>
<body>
<h1 style="color:green">${pass}</h1>
<h1 style="color:red">${fail}</h1>
<h1>Welcome to ToDo app</h1>
	<form action="Login" method="post">
		<table>
			<tr>
				<th><label for="email">E-mail :</label></th>
				<th><input type="email" placeholder="E-mail" name="email">
				</th>
			</tr>

			<tr>
				<th><label for="password">Password :</label></th>
				<th><input type="password" placeholder="Password" name="password"></th>
			</tr>
			
			<tr>
				<th><button type="reset">Cancel</button></th>
				<th><button>Login</button></th>
			</tr>
 
		</table>
	</form>
	<a href="Signup.jsp"> <button>Create new Account</button></a>
</body>
</html>