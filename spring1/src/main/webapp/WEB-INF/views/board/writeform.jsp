<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% String path = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="<%=path %>/resources/jquery-3.2.1.min.js"></script>
<script>
$(document).ready(function(){

});
</script>
</head>
<body>
<h1>게시글 쓰기 화면입니다.</h1>
<form action ="<%=path %>/write.board" method="post">
제목 : <input type="text" name="title"><br>
내용 : <textarea rows="15" cols="30" name="contents"></textarea><br>
작성자 : <input type="text" name="writer"><br>
암호 : <input type="password" name="password"><br>
<input type="submit" value="작성완료">
</form>
</body>
</html>