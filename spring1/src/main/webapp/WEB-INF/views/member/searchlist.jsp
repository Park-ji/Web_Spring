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
<h1>${item }에 ${word }를 포함하는 회원 리스트를 출력합니다.</h1>

<c:if test="${item=='ID' }"><!-- el태그문에서는 String '=='로 비교가능 -->
<c:forEach items="${listmodel }" var="member">
<c:if test="${member.id.contains(word) }"><!-- word값을 포함 -->
${member.id }<br>
</c:if>
</c:forEach>
</c:if>

<c:if test="${item=='이름' }"><!-- el태그문에서는 String '=='로 비교가능 -->
<c:forEach items="${listmodel }" var="member">
<c:if test="${member.name.contains(word) }"><!-- word값을 포함 -->
${member.id }<br>
</c:if>
</c:forEach>
</c:if>

</body>
</html>