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

		<c:if test="${not empty message}">
			<div>${message}</div>
			<c:if test="${not empty exception}">
				<div>Output: ${exception}</div>
			</c:if>
		</c:if>

		<form action="index">
			<input type="submit" value="Back" />
		</form>
	</div>



</body>
</html>