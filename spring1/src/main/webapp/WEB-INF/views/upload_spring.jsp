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
<h1>파일 전송 폼</h1>
<!-- @RequestMapping("/upload.file") -->
<form action="/mvc/upload.file" method="post" enctype="multipart/form-data">
전송한 사람 : <input type=text  name="name" value="사람"><br>
설명 : <input type=text  name="description" value="파일 설명"><br>
파일 1 : <input type=file name="file1"><br>
파일 2 : <input type=file name="file2"><br>
<input type=submit  value="전송">
</form>

</body>
</html>