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
로그인 결과는 다음과 같습니다. <br>
<!-- el문에서 getter메서드 사용방법? get빼고 앞의 문자를 소문자로 바꿔서 사용 
model.getId() = model.id -->
<%-- <h1>${model.id}${result  }</h1> --%>
<h1>${loginVO.id}${result  }</h1>
</body>
</html>


























