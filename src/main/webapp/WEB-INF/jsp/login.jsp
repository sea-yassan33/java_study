<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@include file= "head.jsp" %>
<title>Insert title here</title>
</head>
<body>
	<div class="mx-auto" style="width: 300px;">
		<h1 class="mb-3" style="text-align: center">管理者ログイン画面</h1>
		<form action="/SampleEnv/LoginServlet" method="post">
		  <div class="mb-3">
		    <label for="adminID" class="form-label">管理者ID-test</label>
		    <input type="text" class="form-control" id="adminID" name="admin_id">
		  </div>
		  <div class="mb-3">
		    <label for="pass" class="form-label">パスワード</label>
		    <input type="password" class="form-control" id="pass" name="password">
		  </div>
		  <button type="submit" class="btn btn-primary">ログイン</button>
		</form>
	</div>
<%@include file= "foot.jsp" %>
</body>
</html>