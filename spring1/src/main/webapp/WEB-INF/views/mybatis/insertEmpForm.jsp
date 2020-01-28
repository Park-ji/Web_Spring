<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
%>
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
	<h1>/mybatis/insertEmpForm.jsp 입니다.</h1>
	<form action="<%=path%>/myBatis/insertemp" method="post">
		<table border="1">
			<tr>
				<td>사번</td>
				<td><input type="text" name="employee_id"></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="first_name"></td>
			</tr>
			<tr>
				<td>성</td>
				<td><input type="text" name="last_name"></td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><input type="text" name="email"></td>
			</tr>
			<tr>
				<td>직종코드</td>
				<td><select name="job_id">
						<c:forEach items="${ jobIdList }" var="jobId">
							<option>${ jobId }</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td>부서번호</td>
				<td><select name="department_id">
						<c:forEach items="${ deptIdList }" var="deptId">
							<option>${ deptId }</option>
						</c:forEach>
				</select></td>
			</tr>
		</table>
		<input type="submit" value="등록하기">
	</form>
</body>
</html>