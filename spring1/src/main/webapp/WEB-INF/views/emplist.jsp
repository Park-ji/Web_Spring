<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>


<!--  
/로 시작? port번호까지 생략
'/mvc/resources/jquery-3.2.1.min.js'라고 사용해야함
-->

<!-- 매번 컨텍스트명이 바뀔때마다 바꾸기 귀찮? 
context명 얻어오기 : request.getContextPath()
현재 context명 : mvc
-->
<!-- <script src="jquery-3.2.1.min.js"></script> -->
<script src='<%=request.getContextPath()+"/resources/jquery-3.2.1.min.js" %>'></script>
<!-- tip: src를 ""가 아닌 ''로 사용하면 안의 경로의 "를 따로 건들지 않아도 됨 -->
<script>
$(document).ready(function(){

});
</script>
</head>
<body>
<img src = "/mvc/resources/images/google.png"/>
<h1>emplist.jsp 파일입니다.</h1>
<table>
<tr><th>사번</th><th>이름</th><th>급여</th><th>입사일</th></tr>

<c:forEach  items="${list}"  var="empvo">
<tr><td>${empvo.id }</td><td>${empvo.name }</td><td>${empvo.salary}</td><td>${empvo.hiredate} </td></tr>
<!-- 
테이블 안에 안넣고 그냥 ${empvo}라고 해서 다 출력해도 가능
단, EmpVO파일에 toString메소드 오버라이딩해야함
 -->
</c:forEach>

</table>
</body>
</html>