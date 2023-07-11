<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1 style="color:red">${fail}</h1>
<h1>Enter Your Details</h1>
<form action="Signup" method="post" >
		<table>
			<tr>
				<th><label for="name">Name :</label></th>
				<th><input type="text" placeholder="Name" name="name">
				</th>
			</tr>

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
				<th><button>Signup</button></th>
			</tr>
			<tr>
			<th><a href="Login.jsp"><button>Back</button></a>
			</th>
			</tr>
 
		</table>
	</form>
	<!-- <a href="Login.jsp"> Back</a> -->
</body>
</html>