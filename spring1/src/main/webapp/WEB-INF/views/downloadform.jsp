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
<c:forEach items="${filelist }" var="file">
<!-- /는 포트명까지만 생략되므로 컨텍스트명 명시! -->
<a href="/mvc/downloadresult?filename=${file }">${file }</a><br><!-- file의 이름 -->
</c:forEach>
</body>
</html>