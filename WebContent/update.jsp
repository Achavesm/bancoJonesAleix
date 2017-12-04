<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="language" value="${not empty param.language ? param.language : not empty language ?  language : 'es' }" scope="session"/>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="resources/lang"/> 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
	<title><fmt:message key="title.update"/></title>
	<%@ include file="resources.html"%>
	
<style type="text/css">
	input {
		margin-top:5px;
	}
	
</style>
</head>
<body>
	<%@ include file="menu.html"%>
	<div>
		<form action="UpdateServlet" method="POST">
			<fmt:message key="name"/><br><input type="text" name="nameUpd"><br>
			<fmt:message key="surname"/><br><input type="text" name="surnameUpd"><br>
			DNI: <br><input type="text" name="dniUpd"><br>
			<fmt:message key="password"/><br><input type="password" id="password" name="passUpd"><br>
			<fmt:message key="date"/><br><input type="text" name="birthdayUpd"><br>
			<fmt:message key="sex"/><br><input type="text" name="sexUpd"><br> 
			<fmt:message key="adress"/><br><input type="text" name="addressUpd"><br>
			<fmt:message key="telephone"/><br><input type="text" name="phoneUpd"><br>		
			<input type="submit" value=<fmt:message key="update"/>>
		</form>
	</div>
</body>
</html>