<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@include file= "head.jsp" %>
<title>JavaScriptの練習</title>
</head>
<body>
<h1 class="text-primary">練習フォーム</h1>
<form id="myForm">
  <div class="form-row align-items-center">
    <div class="col-auto my-1">
      <label class="mr-sm-2 sr-only" for="inlineFormCustomSelect">Preference</label>
      <select class="custom-select mr-sm-2" id="selectedOption">
        <option selected>Choose...</option>
        <option value="option1">One</option>
        <option value="option2">Two</option>
        <option value="option3">Three</option>
      </select>
    </div>
    <br>
    <div class="col-auto my-1">
      <button type="submit" class="btn btn-primary">Submit</button>
    </div>
  </div>
</form>
<%@include file= "foot.jsp" %>
<script src="js/inputTest.js"></script>
</body>
</html>