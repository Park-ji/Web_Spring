<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script>
	$(document).ready(function() {

	});
</script>
</head>
<body>
	<h1>/mybatis/empList.jsp</h1>

	<c:forEach items="${ emplist }" var="vo">
		<h4>${ vo.employee_id } : ${ vo.last_name } : ${ vo.hire_date }</h4>
	</c:forEach>
</body>
</html>