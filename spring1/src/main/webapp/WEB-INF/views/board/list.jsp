<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%String path = request.getContextPath(); %>
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
<h1>게시글 목록입니다.</h1>
<table>
<tr><th>번호</th><th>제목</th><th>작성자</th></tr>
<c:forEach  items="${list}"  var="boardvo">
<tr><td>${boardvo.seq }</td><td><a href="/mvc/detail.board?seq=${boardvo.seq}">${boardvo.title }</a></td><td>${boardvo.writer}</td></tr>
</c:forEach>
</table>
</body>
</html>