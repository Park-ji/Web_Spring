<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="jquery-3.2.1.min.js"></script>
<script>
$(document).ready(function(){

});
</script>
</head>
<body>
<h1>hello.jsp 파일입니다.</h1>
<h2><%= request.getAttribute("model") %></h2>
<!-- Spring에서는 el문을 많이 사용함 -->
<h2>${model }</h2>
<h2>${requestScope.model }</h2>
<!-- 위의 두문장은 같은 내용 -->
</body>
</html>