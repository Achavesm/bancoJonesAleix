<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="language" value="${not empty param.language ? param.language : not empty language ?  language : 'es' }" scope="session"/>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="resources/lang"/> 

<%@ page import="beans.Cliente" %>
<%
	Cliente c = null;
	String user = null;
	String dni = null;
	String sessionID = null;
	if (session.getAttribute("clientSession") == null) {
		response.sendRedirect("jones.jsp");
	} else {
		c = (Cliente)session.getAttribute("clientSession");
		user = c.getNombre();
		dni = c.getDni();
	}
	Cookie[] cookies = request.getCookies();
	if (cookies != null) {
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("JSESSIONID") ) {
				sessionID = cookie.getValue();
			}
		}
	} else {
		sessionID = "No hay cookies";
	}
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
	<title><fmt:message key="title.profile"/></title>
	<%@ include file="resources.html"%>
</head>
<body>
	<%@ include file="menu.html"%>
	
	<h3>hola <%=user %>, con dni <%=dni %> <%=sessionID %></h3>
	<form method="POST" action="<%=response.encodeURL("ControllerServlet")%>">
		<input type="hidden" name="action" value="logout">
		<input type="submit" value="cerrar sesion">
	</form>
	<br>
	<form method="POST" action="<%=response.encodeURL("ControllerServlet")%>">
		<input type="hidden" name="action" value="listAccounts">
		<input type="submit" value="Cuentas">
	</form>
</body>
</html>