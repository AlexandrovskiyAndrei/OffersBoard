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

	<sf:form method="post" action="${pageContext.request.contextPath}/docreate" modelAttribute="offer">
		<table class="formtable">
			<tr><td class="label">Name: </td><td><input class="control" type=text path="name" name="name"><br/><sf:errors path="name" cssClass="errors"></sf:errors></td></tr>
			<tr><td class="label">Email: </td><td><input class="control" type=text path="email" name="email"><br/><sf:errors path="email" cssClass="errors"></sf:errors></td></tr>
			<tr><td class="label">Offer: </td><td><textarea class="control" rows="10" cols="50" path="text" name="text"></textarea><br/><sf:errors path="text" cssClass="errors"></sf:errors></td></tr>
			<tr><td class="label"></td><td><input class="control" value="Create advert" type=submit></td></tr>
		</table>
	</sf:form>

</body>
</html>