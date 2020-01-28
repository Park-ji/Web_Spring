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
<h1> 게시글 수정 페이지 </h1>
<form action="<%=path%>/boardupdate" method="post">
번호 : <input type=text  value=${boarddetail.seq } readonly="readonly" name="seq"><br>
제목 : <input type=text  value=${boarddetail.title } name="title"><br>
내용 : <textarea rows="5" cols="10"  name="contents">${boarddetail.contents }</textarea><br>
작성자 : <input type=text  value=${boarddetail.writer } readonly="readonly"><br>
작성시간 : <input type=text  value=${boarddetail.time } readonly="readonly"><br>
조회수 : <input type=text  vlaue=${boarddetail.viewcount } readonly="readonly"><br>
<input type="submit" value="수정 완료">
</body>
</html>