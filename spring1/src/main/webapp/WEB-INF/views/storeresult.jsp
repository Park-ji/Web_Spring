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
<!-- el문 getter메소드 생각!! -->
<h1> ${bakeryVO.bakeryname} 등록 확인 페이지</h1>
- 첨부파일 : ${bakeryVO.bakeryimage.originalFilename }<br>
<img src="<%=path %>/resources/bakery/${bakeryVO.bakeryimage.originalFilename }">
</body>
</html>