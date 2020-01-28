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
<h1> 베이커리 상품 등록 폼 </h1>
<form action="<%=path %>/store.bakery" method="post" enctype="multipart/form-data">
베이커리 이름 : <input type="text" name="bakeryname"><br>
베이커리 가격 : <input type="text" name="price"><br>
<!-- number 타입으로 지정하면? 서버로 넘어갈때 int형으로 넘어가는 것이 X -->
베이커리 수량 : <input type="text" name="balance"><br>
베이커리 파일 : <input type="file" name="bakeryimage"><br>
<input type="submit" value="등록">
</form>

</body>
</html>