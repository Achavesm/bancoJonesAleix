<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="language" value="${not empty param.language ? param.language : not empty language ?  language : 'es' }" scope="session"/>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="resources/lang"/> 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Insertar transacción</title>
	<%@ include file="resources.html"%>
</head>
<body>
	<%@ include file="menu.html"%>
	<div>
		<form action="InsertTransactionServlet" method="POST">
			Origen: <input type="text" name="origen"><br>
			Destino: <input type="text" name="destino"><br>
			Cantidad: <input type="text" name="importe"><br>
			<input type="submit" value="Insertar nueva transacción">
		</form>
	</div>
</body>
</html>