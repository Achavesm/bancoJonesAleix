<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="beans.Cliente"%>
<%@ page import="beans.Account"%>
<%@ page import="beans.Transaccion"%>
<%@ page import="dao.TransaccionDAO"%>
<%@ page import="java.util.List"%>
<c:set var="language" value="${not empty param.language ? param.language : not empty language ?  language : 'es' }" scope="session"/>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="resources/lang"/>
<%
	String iban = (String) request.getParameter("account");	
	List<Transaccion> listTransactions = TransaccionesDAO.listaTransacciones(iban);
	System.out.println(listTransactions.size());
	String spageid=request.getParameter("page")==null?"1":request.getParameter("page");
	int size = 10;
	int pagina = Integer.parseInt(spageid);	
	int ini = pagina==1?pagina-1:(pagina-1)*size;;
	int fin = pagina*size;
	List<Transaccion> sublist = null;	
	int maxPage = listTransactions.size()/size;
	if (listTransactions.size()%size != 0) {
		maxPage++;
	}
	if (pagina != maxPage) {
		sublist = listTransactions.subList(ini, fin);	
	} else {		
		sublist = listTransactions.subList(ini, listTransactions.size());
	}
%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
	<title>Lista de transacciones</title>
	<%@ include file="resources.html"%>
<style>
	table {
		border:1px solid black;
		border-collapse:inherit;
	}	
		
	th, td {
		border:1px solid black;
		padding: 10px;
		text-align:center;
	}
</style>
</head>

<body>
		<%@ include file="menu.html"%>
	<h2>Transacciones</h2>
	<div>		
	<table><thead><tr><th>ID</th><th>Fecha</th><th>Cantidad</th><th>Origen</th><th>Destino</th></tr></thead>
	<%
		for (Transaccion t : sublist) {
			long id = t.getId();
			String fecha = t.getFecha();
			double importe = t.getImporte();
			String origen = t.getOrigen();
			String destino = t.getDestino();
			%> <tbody><tr><td><%=id %> </td><td><%=fecha %></td><td><%=importe %></td><td><%=origen %></td><td><%=destino %></td></tr></tbody> <%
		}
	%>
	</table>
	</div>
	<form method="POST" action="insertarTransaccion.jsp">
		<input type="submit" value="Nueva transacción">
</form>
<%
	for (int i = 1; i <= maxPage; i++) {
        %>
        	<a href="listaTransacciones.jsp?account=<%=iban %>&page=<%=i%>"><%=i%></a>
        <%
	}
%>
</body>
</html>