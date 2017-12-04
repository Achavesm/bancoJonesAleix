<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="language" value="${not empty param.language ? param.language : not empty language ?  language : 'es' }" scope="session"/>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="resources/lang"/> 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Banco Jones - Insertar cuenta</title>
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
		<form action="InsertAccountServlet" method="POST">
			IBAN: <input type="text" name="ibanIns"><br>
			Saldo: <input type="text" name="balanceIns"><br>
			<input type="submit" value="Insertar nueva cuenta">
		</form>
	</div>
</body>
</html>