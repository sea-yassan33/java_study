<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="dto.Customer" %>
<% List<Customer> customer_list = (List<Customer>)request.getAttribute("customer"); %>

<!DOCTYPE html>
<html>
<head>

<%@include file= "head.jsp" %>
<title>顧客一覧画面</title>
</head>
<body>
	<div class="mx-auto text-center" style="width: 70%;">
		<h2 class="text-center mb-3">顧客一覧</h2>
		<table class="table table-striped">
			<thead>
				<tr>
					<th scope="col">顧客ID</th>
					<th scope="col">お客様名</th>
					<th scope="col">住所</th><th scope="col">登録日</th>
					<th scope="col">更新日</th>
				</tr>
			</thead>
			<tbody>
			<% for(Customer cus : customer_list){ %>
				<tr>
					<td><%= cus.getCustomer_id() %></td>
					<td><%= cus.getName() %></td>
					<td><%= cus.getAddress() %></td>
					<td><%= cus.getRegistered_time() %></td>
					<td><%= cus.getUpdated_time() %></td>
				</tr>
			<% } %>
			</tbody>
		</table>
		<a href="<%=request.getContextPath() %>/CustomerRegisterServlet">顧客登録画面へ</a>
	</div>
	
<%@include file= "foot.jsp" %>
</body>
</html>