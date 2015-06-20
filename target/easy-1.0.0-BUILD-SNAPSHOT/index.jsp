<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@include file="WEB-INF/jsp/comand.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="<c:url value="/resources/css/style.css" />">
<title>EasyRegister - User login</title>
</head>
<body>
	<form method="post" action="login" class="login12">
		<p>
			<label for="login">Логин:</label> 
			<input type="text" name="loggin" id="login">
			<script>
  					document.getElementsByName('loggin')[0].focus();
			</script>
		</p>
		<p>
			<label for="password">Пароль:</label> <input type="password"
				name="password" id="password">
		</p>
	
		
		<p class="login-submit">
			<button type="submit" class="login-button">Войти</button>
		</p>
		<p class="login44" >- admin / admin by default</p>
		<p class="login2" > ${error}</p>
	</form>
</body>
</html>