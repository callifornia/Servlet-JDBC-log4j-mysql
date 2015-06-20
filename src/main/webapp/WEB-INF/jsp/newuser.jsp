<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@include file = "comand.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="<c:url value="/resources/css/style.css" />">
<title>EasyRegister - User register</title>
</head>
<body>
<table align="center" class="mainTable">
		<tr valign="top">
			<td align="right">
				<p class="login4" align="right">login as: ${login}</p> <a
				href="logout" class="logout2">Logout</a><br>
			</td>
		</tr>
		<tr valign="top">
			<td valign="top" align="center">
			
				<p class="login33" align="center">Register user</p>
				<form action="register" method="post" class="editForm" >
				<table class = "editTable">
					<tr>
						<td class = "firstRow" valign="top" align="left"> 
							<p>login:</p>
						</td>
						<td class = "secondRow" valign="top" align="left">
							<input type="text" value="${user.login}"  name = "login" class = "inputEdit">
							<script>
  								document.getElementsByName('login')[0].focus();
							</script>
						</td>
						<td class = "thirdRow" valign="top" align="left"> 
							<p class="Error"> ${error.errorLogin} </p>
						</td>
					</tr>
					<tr>
						<td class = "firstRow" valign="top" align="left"> 
							<p>password:</p>
						</td>
						<td class = "secondRow" valign="top" align="left">
							<input type="password" value="${user.password}" name = "password" class = "inputEdit">
						</td>
						<td class = "thirdRow" valign="top" align="left"> 
							<p class="Error"> ${error.errorPsw} </p>
						</td>
					</tr>
					<tr>
						<td class = "firstRow" valign="top" align="left"> 
							<p>roles:</p>
						</td>
						<td class = "secondRow" valign="top" align="left">
						<select name="roles" class = "select">
							<option class="test" value="user" ${user.roles == 'user' || user.roles == '' ? 'selected' : ''}> user</option>
						  	<option value="admin" ${user.roles == 'admin' ? 'selected' : ''}>admin</option>
						</select>
							
						</td>
					</tr>
					<tr>
						<td class = "firstRow" valign="top" align="left"> 
							<p>name:</p>
						</td>
						<td class = "secondRow" valign="top" align="left">
							<input type="text" value="${user.name}" name = "name" class = "inputEdit">
						</td>
						<td class = "thirdRow" valign="top" align="left"> 
							<p class="Error">  ${error.errorName} </p>
						</td>
					</tr>
					<tr>
						<td class = "firstRow" valign="top" align="left"> 
							<p>Last Name:</p>
						</td>
						<td class = "secondRow" valign="top" align="left">
							<input type="text" value="${user.lastName}" name = "lastName" class = "inputEdit">
						</td>
						<td class = "thirdRow" valign="top" align="left"> 
							<p class="Error">  ${error.errorLastName}</p>
						</td>
					</tr>
					<tr>
						<td class = "firstRow" valign="top" align="left"> 
							<p>Phone:</p>
						</td>
						<td class = "secondRow" valign="top" align="left">
							<input type="text" value="${user.phone}" name = "phone" class = "inputEdit">
						</td>
						<td class = "thirdRow" valign="top" align="left"> 
							<p class="Error">  ${error.errorPhone}</p>
						</td>
					</tr>
					<tr>
						<td class = "firstRow" valign="top" align="left"> 
							<p>email:</p>
						</td>
						<td class = "secondRow" valign="top" align="left">
							<input type="text" value="${user.email}" name = "email" class = "inputEdit">
						</td>
						<td class = "thirdRow" valign="top" align="left"> 
							<p class="Error">  ${error.errorEmail}</p>
						</td>
					</tr>
					<tr>
						<td class = "firstRow" style = "vertical-align: middle;" valign="top" align="left"> 
							<p>adress:</p>
						</td>
						<td class = "secondRow" valign="top" align="left">
							<textarea rows="6" cols="33" type="text" name = "adress" class = "inputTextArea" >
							${user.adress}</textarea>
						</td>
						<td class = "thirdRow" valign="top" align="left"> 
							<p class="Error">  ${error.errorAdress}</p>
						</td>
					</tr>
				</table>
					<a href="javascript:;" onclick="parentNode.submit();" class="myButton">Save</a>
					<a href="../secure/search" class="myButton1">Cancel</a>
				</form>
			</td>
		</tr>
	</table>
</body>
</html>