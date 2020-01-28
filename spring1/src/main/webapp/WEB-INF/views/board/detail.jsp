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
<h1>게시글 세부목록입니다.</h1>
번호 : ${vo.seq }<br>
제목 : ${vo.title }<br>
작성자 : ${vo.writer }<br>
작성시간 : ${vo.time }<br>
조회수 : ${vo.viewcount }<br>
내용 : ${vo.contents }<br>
</body>
</html>