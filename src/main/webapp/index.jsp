<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>deserialize-pwn-me</title>
</head>
<body>
	<div id=container>
		<h1>deserialize-pwn-me</h1>
		
		<form action="index">
		<p>
			<textarea rows="5" cols="50" name="input"></textarea>
		</p>
		<p>
			<input type="submit" value="Gogogo">
		</p>
		</form>

		<c:choose>
			<c:when test="${not empty error}">

				<div>${error}</div>
			</c:when>
			<c:otherwise>
				<div>${success}</div>
				<c:if test="${not empty object}">
					<p>${object}</p>
				</c:if>
			</c:otherwise>
		</c:choose>
	</div>
</body>
</html>