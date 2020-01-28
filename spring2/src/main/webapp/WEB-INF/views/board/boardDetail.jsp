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
	
	$("#deletebtn").on('click',function(){
		location.href = "/mybatis/boarddelete?seq="+$('#seq').val();
	});

});
</script>
</head>
<body>
<h1> 게시글 세부 내용 조회 </h1>
<form action="<%=path%>/boardupdate">
번호 : <input type=text  value=${boarddetail.seq } name="seq" id="seq" readonly="readonly"><br>
제목 : <input type=text  value=${boarddetail.title } readonly="readonly"><br>
내용 : <textarea rows="5" cols="10"  readonly="readonly">${boarddetail.contents }</textarea><br>
작성자 : <input type=text  value=${boarddetail.writer } readonly="readonly"><br>
작성시간 : <input type=text  value=${boarddetail.time } readonly="readonly"><br>
조회수 : ${boarddetail.viewcount }<br>
<input type="submit" value="수정">
<input type="button" id="deletebtn"  value="삭제">
</form>
</body>
</html>