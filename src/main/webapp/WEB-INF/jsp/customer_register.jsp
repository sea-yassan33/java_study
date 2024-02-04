<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@include file= "head.jsp" %>
<title>顧客登録</title>
</head>
<body>
	<div class="mx-auto" style="width: 300px;">
		<h1 class="mb-3" style="text-align: center">顧客登録画面</h1>
		<form action="/SampleEnv/CustomerRegisterServlet" method="post">
		  <div class="mb-3">
		    <label for="customerName" class="form-label">お客様名</label>
		    <input type="text" class="form-control" id="customerName" name="customer_name" required>
		  </div>
		  <div class="mb-3">
		    <label for="address" class="form-label">住所</label>
		    <input type="text" class="form-control" id="address" name="customer_address" required>
		  </div>
		  <button type="submit" class="btn btn-primary">登録する</button>
		</form>
		<a href="<%=request.getContextPath() %>/CustomerLoginServlet" onclick="window.history.back(); return false;" class="btn btn-primary mt-3">顧客一覧画面へ</a>
	</div>
<%@include file= "foot.jsp" %>
</body>
</html>