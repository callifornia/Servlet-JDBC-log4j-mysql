<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@include file="comand.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="<c:url value="/resources/css/style.css" />">
<title>EasyRegister - Users</title>
</head>
<body>

	<table align="center" class="mainTable">
		<tr valign="top">
			<td align="right">
				<p class="login4" align="right">login as: ${login}</p> 
				<a href="logout" class="logout2">Logout</a><br>
			</td>
		</tr>
		<tr valign="top">
			<td valign="top"><font color="red">${error}</font>
				<p class="login33" align="center">Users</p>
				
				<table class ="usersTable" align="center">
				<tr>
					<td colspan="9"><a href="search">search page | </a> <a href="register">add user</a></td>
				</tr>
						<tr class = "userTableHeader">
							<td>Id</td>
							<td>Login</td>
							<td>Role</td>
							<td>Name</td>
							<td>Last name</td>
							<td>Phone</td>
							<td>Mail</td>
							<td>Adress</td>
							<td colspan="2">Action</td>
						</tr>
							<c:forEach var="user" items="${users}">
							<td>${user.userId}</td>
							<td>${user.login}</td>
							<td>${user.roles}</td>
							<td>${user.name}</td>
							<td>${user.lastName}</td>
							<td>${user.phone}</td>
							<td>${user.email}</td>
							<td>${user.adress}</td>
							<td><a href="edit?id=${user.userId}">Edit</a></td>
							<td><a href="delete?id=${user.userId}">Delete</a></td>
						</tr>
						</c:forEach>
					</table>
				</form>
			</td>
		</tr>
	</table>
</body>
</html>