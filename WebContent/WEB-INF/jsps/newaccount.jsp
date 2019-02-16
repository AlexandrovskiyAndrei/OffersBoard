<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link href="${pageContext.request.contextPath}/static/css/main.css" rel="stylesheet" type="text/css" />

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Create new account</h2>

	<sf:form method="post" action="${pageContext.request.contextPath}/createaccount" modelAttribute="user">
		<table class="formtable">
			<tr><td class="label">Username: </td><td><input class="control" type=text path="username" name="username"><br/><sf:errors path="username" cssClass="errors"></sf:errors></td></tr>
			<tr><td class="label">Email: </td><td><input class="control" type=text path="email" name="email"><br/><sf:errors path="email" cssClass="errors"></sf:errors></td></tr>
			<tr><td class="label">Password: </td><td><input class="control" type="password" path="password" name="password"><br/><sf:errors path="password" cssClass="errors"></sf:errors></td></tr>
			<tr><td class="label">Confirm password: </td><td><input class="control" type="password" name="confirmpass"><br/></td></tr>
			<tr><td class="label"></td><td><input class="control" value="Create account" type=submit></td></tr>
		</table>
	</sf:form>

</body>
</html>