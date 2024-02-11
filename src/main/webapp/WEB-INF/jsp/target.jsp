<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@include file= "head.jsp" %>
<title>ターゲットページ</title>
</head>
<body>
	<h2>Selected Option:</h2>
    <p><%= request.getParameter("selected") %></p>
<%@include file= "foot.jsp" %>
</body>
</html>