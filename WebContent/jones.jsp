<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="language" value="${not empty param.language ? param.language : not empty language ?  language : 'es' }" scope="session"/>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="resources/lang"/> 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title><fmt:message key="title.login"/></title>
	<%@ include file="resources.html"%>
	
<style>
	div {
		position: relative;
		margin-top: 10px;
	}
	
	input {
		margin-top: 5px;
	}
	
</style>
</head>
<body>
	<%@ include file="menu.html"%>
	<div>
		<form action="ControllerServlet" method="POST">
			<input type="hidden" name="action" value="login">
			DNI: <br><input type="text" name="dni"><br> 
			<fmt:message key="password"/><br><input type="password" name="pass"><br> 
			<input type="submit" value="Validar">
		</form>
	</div>	
</body>
</html>