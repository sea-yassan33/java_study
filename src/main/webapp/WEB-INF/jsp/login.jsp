<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- bootstrap -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.min.css" integrity="sha384-fFxL8wXRpg9gVqGpY+URMtLr3fLL0WBbo4NBQ+IWwMDYjIjI5VQ46XlJm5+BUlXJ" crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body>
	<div class="mx-auto" style="width: 300px;">
		<h1 class="mb-3" style="text-align: center">管理者ログイン画面</h1>
		<form action="/CustomerManagement/LoginServlet" method="post">
		  <div class="mb-3">
		    <label for="adminID" class="form-label">管理者ID</label>
		    <input type="text" class="form-control" id="adminID" name="admin_id">
		  </div>
		  <div class="mb-3">
		    <label for="pass" class="form-label">パスワード</label>
		    <input type="password" class="form-control" id="pass" name="password">
		  </div>
		  <button type="submit" class="btn btn-primary">ログイン</button>
		</form>
	</div>
	
	<!-- jQuery読み込み -->
	<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
	<!-- Propper.js読み込み -->
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
	<!-- BootstrapのJavascript読み込み -->
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
</body>
</html>