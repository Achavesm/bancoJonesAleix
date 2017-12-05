<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="beans.Cliente"%>
<%@ page import="beans.Account"%>
<%@ page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:set var="language" value="${not empty param.language ? param.language : not empty language ?  language : 'es' }" scope="session"/>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="resources/lang"/> 
<%
	Cliente c = null;
	String sessionID = null;
	List<Account> accounts = null;
	if (session.getAttribute("clientSession") == null) {
		response.sendRedirect("jones.jsp");
	} else {
		c = (Cliente) session.getAttribute("clientSession");
		accounts = c.getAccounts();
	}
	
	Cookie[] cookies = request.getCookies();
	if (cookies != null) {
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("JSESSIONID")) {
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
	<%@ include file="resources.html"%>
	<title>Insert title here</title>
<style>
	table {
		border: 1px solid grey;
		border-collapse: collapse;
	}
	th{
		border: 1px solid grey;
		border-collapse: collapse;
	}
	td{
		border: 1px solid grey;
		border-collapse: collapse;
	}
</style>
</head>
<body>
		<%@ include file="menu.html"%>
		<h2> Cuentas del usuario <%=c.getNombre() %></h2>
	
	<div class="container" id="accounts">		
	<table class='table'><thead><tr><th>IBAN</th><th>Saldo</th><th></th></tr></thead>
	<%
		for (Account account : accounts) {
			String iban = account.getIban();
			double balance = account.getSaldo();
			%> <tbody><tr><td> <%=iban %> </td><td> <%=balance %></td><td style="width:170px;"><button onclick="location.href='ControllerServlet?iban=<%=iban %>&action=deleteAccount'">Eliminar Cuenta</button></td><td style="width:150px;"><button onclick="location.href='ControllerServlet?iban=<%=iban %>&action=detailsAccount'">Transacciones</button></td></tr></tbody> <%
		}
	%>
	</table>
	</div>
	<br>
	<br>
	<form method="POST" action=<%=response.encodeURL("insertAccount.jsp")%>>
		<input type="submit" value="Añadir nueva cuenta">
	</form>
</body>
</html>