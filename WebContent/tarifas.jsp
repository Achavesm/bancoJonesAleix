<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="language" value="${not empty param.language ? param.language : not empty language ?  language : 'es' }" scope="session"/>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="resources/lang"/> 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
	<title><fmt:message key="title.rate"/></title>
	<%@ include file="resources.html"%>
</head>

<body>
	<%@ include file="menu.html"%>
	<img src="https://media.giphy.com/media/3o7btQ0NH6Kl8CxCfK/giphy.gif"></img>
</body>
</html>