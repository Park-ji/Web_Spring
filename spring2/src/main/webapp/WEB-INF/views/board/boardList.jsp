<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% String path = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="<%= path %>/resources/jquery-3.2.1.min.js"></script>
<script>
$(document).ready(function(){

});
</script>
</head>
<body>
<h1> /board/boardList.jsp </h1>
<h1> 게시판 목록 </h1>

<table>
<tr><th>번호</th><th>제목</th><th>작성자</th><th>조회수</th></tr>
<c:forEach items="${boardlist }" var="vo">
<tr><td>${vo.seq }</td><td><a href="<%=path %>/boarddetail?seq=${vo.seq }">${vo.title }</a></td><td>${vo.writer }</td><td>${vo.viewcount }</td></tr>
</c:forEach>
</table>
</body>
</html>