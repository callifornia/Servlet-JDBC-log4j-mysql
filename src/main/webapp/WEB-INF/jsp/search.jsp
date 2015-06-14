<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@include file="comand.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd" >
	
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="<c:url value="/resources/css/style.css" />">
<title>EasyRegister - User search</title>
</head>
<body>
<table align="center" class= "mainTable">
	<tr>
		<td align="right">
			<p class="login4" align="right">login as: ${login} </p>
			<a href="logout" class = "logout2">Logout</a><br>
		</td>
	</tr>
	<tr>
		<td valign="top">
		
			<form action="users" method = "post" class="login">
			<p class="login3" align="center">Search by login</p>
			<p>
				<label for="login">Login:</label> 
				<input type="text" name="login" id="login">
				<script>
  					document.getElementsByName('login')[0].focus();
				</script>
			</p>
			<p class="login-submit">
				<button type="submit" class="login-button">Войти</button>
			</p>
			<p  align="center"> - Press "Enter" to find all users</p>
				<p class="login2" >${error}</p>
			</form>
		</td>
	</tr>
</table>
</body>
</html>