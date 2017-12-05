<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="language" value="${not empty param.language ? param.language : not empty language ?  language : 'es' }" scope="session"/>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="resources/lang"/> 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
	<title><fmt:message key="title.register"/></title>
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
		<form action="ControllerServlet" method="POST">
			<input type="hidden" name="action" value="register">
			<fmt:message key="name"/><br><input type="text" name="nameReg"><br>
			<fmt:message key="surname"/><br><input type="text" name="surnameReg"><br>
			DNI: <br><input type="text" name="dniReg"><br>
			<fmt:message key="password"/><br><input type="password" id="password" name="passReg"><br>
			<fmt:message key="date"/><br><input type="text" name="birthdayReg"><br>
			<fmt:message key="sex"/><br><input type="text" name="sexReg"><br> 
			<fmt:message key="adress"/><br><input type="text" name="addressReg"><br>
			<fmt:message key="telephone"/><br><input type="text" name="phoneReg"><br>			
			<input type="submit" value=<fmt:message key="register"/>>
		</form>
	</div>
</body>
</html>



<!-- Confirma tu contraseña: <input type="password" placeholder="Introduce de nuevo tu contraseña" name="pass2Reg"><br> -->
