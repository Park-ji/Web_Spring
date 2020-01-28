<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="/mvc/resources/jquery-3.2.1.min.js"></script>
<script>
$(document).ready(function(){

});
</script>
</head>
<body>
<!-- el문의 getter메서드 사용? getFile1() = .file1 -->
<h3> 파일 1 : ${uploadVO.file1.getOriginalFilename() } 파일</h3>
<h3> 파일 2 : ${uploadVO.file2.getOriginalFilename() } 파일</h3>
<h1> 업로드 완료되었습니다. </h1>
</body>
</html>